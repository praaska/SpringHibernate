package org.haritha.learning.jpa.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.haritha.learning.jpa.dao.JpaLoginDao;
import org.springframework.beans.factory.annotation.Autowired;

public class JpaLoginDaoImpl implements JpaLoginDao {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
    @PersistenceContext 
	private EntityManager entityManager;
	@Override
	public boolean isValidUser(String username, String password) {
		System.out.println("In login Dao");
		entityManagerFactory=Persistence.createEntityManagerFactory("Eclipselink_JPA");
		entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		boolean userFound=false;
		String SQL_Query="select l from Login l where l.username=:username and l.password=:password";
		Query query=entityManager.createQuery(SQL_Query);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List list=query.getResultList();
		if((list!=null) && (list.size()>0))
		{
			userFound=true;
		}
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		entityManagerFactory.close();
		return userFound;
		
		
	}

}

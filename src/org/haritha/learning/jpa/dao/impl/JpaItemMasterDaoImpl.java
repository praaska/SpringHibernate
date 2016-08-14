package org.haritha.learning.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.haritha.learning.dto.ItemMaster;
import org.haritha.learning.jpa.dao.JpaItemMasterDao;
import org.springframework.beans.factory.annotation.Autowired;

public class JpaItemMasterDaoImpl implements JpaItemMasterDao {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}



	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
    @PersistenceContext(name="Eclipselink_JPA")
    private EntityManager entityManager;


	static Logger log=Logger.getLogger(JpaItemMasterDaoImpl.class.getName());
	
	public JpaItemMasterDaoImpl(){
		
	}
	/*public JpaItemMasterDaoImpl(EntityManagerFactory entityManagerFactory){
		JpaItemMasterDaoImpl.entityManagerFactory=entityManagerFactory;
	}*/

	

	@Override
	public void add(ItemMaster item) {
		System.out.println("In jpa add method");
		entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(item);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}
}

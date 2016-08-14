package org.haritha.learning.hibernate.dao.impl;

import java.util.List;

import org.haritha.learning.hibernate.dao.LoginDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoginDaoImpl implements LoginDao{

	
	private SessionFactory sessionFactory;
	
	public LoginDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean isValidUser(String username, String password) {
		System.out.println("in valid user Dao");
		Session session=sessionFactory.openSession();
		boolean userFound=false;
		String SQL_Query="from Login where username=:username and password=:password";
		Query query=session.createQuery(SQL_Query);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List list=query.list();
		if((list!=null) && (list.size()>0))
		{
			userFound=true;
		}
		session.close();
		return userFound;
	}

}

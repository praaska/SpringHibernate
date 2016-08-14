package org.haritha.learning.hibernate.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.haritha.learning.dto.ItemMaster;
import org.haritha.learning.hibernate.dao.ItemMasterDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ItemMasterDaoImpl implements ItemMasterDao {
	
	private static SessionFactory sessionFactory;
	static Logger log=Logger.getLogger(ItemMasterDaoImpl.class.getName());
	
	public ItemMasterDaoImpl()
	{
		
	}
	public ItemMasterDaoImpl(SessionFactory sessionFactory)
	{
		ItemMasterDaoImpl.sessionFactory=sessionFactory;
	}

	/*public static Session getItemSession(){
		
		if( sessionFactory.getCurrentSession() ==null){
			
		      return sessionFactory.openSession();
		}else{
			return sessionFactory.getCurrentSession();
		}
		
	}
	*/
	@Override
	public List<ItemMaster> list() {
        Session session = sessionFactory.openSession();
		//Session session = ItemMasterDaoImpl.getItemSession();
		
        Transaction transaction  = session.beginTransaction();
        List<ItemMaster> items = null;
        try {
            log.info("IN LIST" +session);
            
            items = (List<ItemMaster>)session.createQuery("from ItemMaster order by item_code").list();
         
            System.out.println("items="+items.size());
            
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }
        catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        if(session !=null){
        	System.out.println(" In List Session Close");
        	session.close();
        }
       return items;
	}
	
	public List<String> getDropdownlist()
	{
		Session session = sessionFactory.openSession();
		
		Transaction transaction  = session.beginTransaction();
		List<String> dropdownlist=null;
		 try {
	            log.info("IN Dropdown LIST" +session);
	            
	            dropdownlist = (List<String>)session.createQuery("select item_name from ItemMaster order by item_name").list();
	         
	            System.out.println("items="+dropdownlist.size());
	            
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            transaction.rollback();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            transaction.rollback();
	        }
	        if(session !=null){
	        	System.out.println(" In dropdown List Session Close");
	        	session.close();
	        }
	       return dropdownlist;
		
	}
	
	
	@Override
	public void add(ItemMaster item) {
		
		Session session=sessionFactory.openSession();
		System.out.println("Inside add session is"+session.isOpen());
		//Session session=ItemMasterDaoImpl.getItemSession();
		
		
		Transaction transaction = null;
		try {
			transaction= session.beginTransaction();
			session.save(item);
		} catch (HibernateException e) {
		   e.printStackTrace();
		   transaction.rollback();
		}
		
		if(session !=null){
        	log.info(" In add Session Close");
        	transaction.commit();
        	log.info("Inside add after commit session is"+session.isOpen());
        	session.close();
        }
	}
	@Override
	public void update(ItemMaster Item) {
		
		Session session=sessionFactory.openSession();
		log.info("Inside update session is"+session.isOpen());
		//Session session = ItemMasterDaoImpl.getItemSession();
		System.out.println("InUpdate");
		System.out.println(Item.getItem_code());
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(Item);
		} catch (HibernateException e) {
		   e.printStackTrace();
		   session.getTransaction().rollback();
		}
		//session.getTransaction().commit();
		if(session !=null){
			log.info(" In update Session Close");
        	transaction.commit();
        	log.info("Inside update after commit session is"+session.isOpen());
        	session.close();
        }
	}
	@Override
	public ItemMaster getItem(long id) {
		Session session=sessionFactory.openSession();
		//Session session = ItemMasterDaoImpl.getItemSession();
		ItemMaster item=null;
		try
		{
			log.info("In Get Item");
		session.beginTransaction();
		item=(ItemMaster)session.get(ItemMaster.class, id);
		}
		catch (HibernateException e) {
	    e.printStackTrace();
		session.getTransaction().rollback();
	   }
		
		//session.getTransaction().commit();
		if(session !=null){
			log.info(" In getItem Session Close");
        	//transaction.commit();
        	session.close();
        }
		return item;
	}
	@Override
	public void delete(long id) {
		Session session=sessionFactory.openSession();
		log.info("Inside delete session is"+session.isOpen());
		//Session session = ItemMasterDaoImpl.getItemSession();
		Transaction transaction = session.beginTransaction();
		ItemMaster item=(ItemMaster)session.get(ItemMaster.class, id);
		if(null!=item){
		session.delete(item);
		}
		//session.getTransaction().commit();
		if(session !=null){
			log.info(" In delete Session Close");
        	transaction.commit();
        	log.info("Inside delete after commit session is"+session.isOpen());
        	session.close();
        }
	}
	@Override
	public List<ItemMaster> getlistforsearch(String itemname) {
		
		Session session = sessionFactory.openSession();
		
		
        Transaction transaction  = session.beginTransaction();
        List<ItemMaster> items = null;
        try {
            log.info("IN Search LIST" +session);
            System.out.println("Item is"+itemname);
            String SQL_Query="from ItemMaster where item_name=:itemname";
            Query query=session.createQuery(SQL_Query);
            query.setParameter("itemname", itemname);
            items=(List<ItemMaster>)query.list();
            
            System.out.println("items="+items.size());
            
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }
        catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        if(session !=null){
        	System.out.println(" In Search List Session Close");
        	session.close();
        }
       return items;
	}

}

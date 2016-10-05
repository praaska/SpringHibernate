package org.haritha.learning.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    @PersistenceContext
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
		entityManagerFactory=Persistence.createEntityManagerFactory("Eclipselink_JPA");
		entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(item);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}



	@Override
	public List<ItemMaster> list() {
		System.out.println("In jpa list method");
		entityManagerFactory=Persistence.createEntityManagerFactory("Eclipselink_JPA");
		entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		 List<ItemMaster> items = null;
		 items = (List<ItemMaster>)entityManager.createQuery("select i from ItemMaster i order by i.item_code").getResultList();
         
         System.out.println("items="+items.size());
         if(entityManager !=null){
         	System.out.println(" In List Session Close");
         	entityManager.close();
         	entityManagerFactory.close();
         }
		return items;
	}



	@Override
	public void update(ItemMaster Item) {
		System.out.println("In jpa update method");
		entityManagerFactory=Persistence.createEntityManagerFactory("Eclipselink_JPA");
		entityManager=entityManagerFactory.createEntityManager();
		ItemMaster item=null;
		entityManager.getTransaction().begin();
		item=(ItemMaster)entityManager.find(ItemMaster.class,Item.getItem_code());
		item.setItem_name(Item.getItem_name());
		item.setPrice(Item.getPrice());
		item.setQuantity(Item.getQuantity());
		entityManager.persist(item);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}



	@Override
	public ItemMaster getItem(long id) {
		System.out.println("In jpa getItem method");
		entityManagerFactory=Persistence.createEntityManagerFactory("Eclipselink_JPA");
		entityManager=entityManagerFactory.createEntityManager();
		ItemMaster item=null;
		entityManager.getTransaction().begin();
		item=(ItemMaster)entityManager.find(ItemMaster.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return item;
	}



	@Override
	public void delete(long id) {
		System.out.println("In jpa delete method");
		entityManagerFactory=Persistence.createEntityManagerFactory("Eclipselink_JPA");
		entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		ItemMaster item=(ItemMaster)entityManager.find(ItemMaster.class, id);
		if(null!=item){
		entityManager.remove(item);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		
	}



	@Override
	public List<String> getDropdownlist() {
		System.out.println("In jpa getDropdownlist method");
		entityManagerFactory=Persistence.createEntityManagerFactory("Eclipselink_JPA");
		entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<String> dropdownlist=null;
		 dropdownlist = (List<String>)entityManager.createQuery("select i.item_name from ItemMaster i order by i.item_name").getResultList();
         
         System.out.println("items="+dropdownlist.size());
         if(null!=entityManager){
        	 entityManager.getTransaction().commit();
     		entityManager.close();
     		entityManagerFactory.close();
     		
         }
		return dropdownlist;
	}



	@Override
	public List<ItemMaster> getlistforsearch(String itemname) {
		System.out.println("In jpa getlistforsearch method");
		entityManagerFactory=Persistence.createEntityManagerFactory("Eclipselink_JPA");
		entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		 List<ItemMaster> items = null;
		 String SQL_Query="select i from ItemMaster i where i.item_name=:itemname";
		 Query query=entityManager.createQuery(SQL_Query);
		 query.setParameter("itemname", itemname);
         items=(List<ItemMaster>)query.getResultList();
         entityManager.getTransaction().commit();
 		entityManager.close();
 		entityManagerFactory.close();
 		
		return items;
		
	}
}

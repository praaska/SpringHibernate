package org.haritha.learning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.haritha.learning.command.ItemMasterBean;
import org.haritha.learning.dto.ItemMaster;
import org.haritha.learning.hibernate.dao.ItemMasterDao;
import org.haritha.learning.jdbc.dao.JdbcItemMasterDao;
import org.haritha.learning.jpa.dao.JpaItemMasterDao;
import org.haritha.learning.service.ItemMasterService;
import org.springframework.transaction.annotation.Transactional;

public class ItemMasterServiceImpl implements ItemMasterService{

private ItemMasterDao itemMasterDao;
private JpaItemMasterDao jpaItemMasterDao;
private JdbcItemMasterDao jdbcItemMasterDao;

public JdbcItemMasterDao getJdbcItemMasterDao() {
	return jdbcItemMasterDao;
}

public void setJdbcItemMasterDao(JdbcItemMasterDao jdbcItemMasterDao) {
	this.jdbcItemMasterDao = jdbcItemMasterDao;
}

public JpaItemMasterDao getJpaItemMasterDao() {
	return jpaItemMasterDao;
}

public void setJpaItemMasterDao(JpaItemMasterDao jpaItemMasterDao) {
	this.jpaItemMasterDao = jpaItemMasterDao;
}

public ItemMasterDao getItemMasterDao() {
	return itemMasterDao;
}

/**
 * @param itemMasterDao the itemMasterDao to set
 */
public void setItemMasterDao(ItemMasterDao itemMasterDao) {
	this.itemMasterDao = itemMasterDao;
}

	@Override
	public int update(ItemMasterBean item) {
		ItemMaster itemMaster = new ItemMaster();
		itemMaster.setItem_code(item.getItem_code());
		itemMaster.setItem_name(item.getItem_name());
		itemMaster.setPrice(item.getPrice());
		itemMaster.setQuantity(item.getQuantity());
		//itemMasterDao.update(itemMaster);
		//jpaItemMasterDao.update(itemMaster);
		return jdbcItemMasterDao.update(itemMaster);

	}

	@Override
	public List<ItemMasterBean> list() {
		List<ItemMasterBean> itemBeanList =new ArrayList<ItemMasterBean>();
		//List<ItemMaster> itemList=itemMasterDao.list();
		//List<ItemMaster> itemList=jpaItemMasterDao.list();
		List<ItemMaster> itemList=jdbcItemMasterDao.list();
		
		ItemMasterBean itemMasterBean=null;
		for(ItemMaster itemMaster:itemList)
		{
			System.out.println("order is"+itemMaster.getItem_code());
			itemMasterBean=new ItemMasterBean();
	        itemMasterBean.setItem_code(itemMaster.getItem_code());
			itemMasterBean.setItem_name(itemMaster.getItem_name());
			itemMasterBean.setPrice(itemMaster.getPrice());
			itemMasterBean.setQuantity(itemMaster.getQuantity());
			itemBeanList.add(itemMasterBean);
		}
		return itemBeanList;
	}

	@Override
	public List<ItemMasterBean> getlistforsearch(String itemname) {
		List<ItemMasterBean> itemBeanSearchList=new ArrayList<ItemMasterBean>();
		//List<ItemMaster> itemList=itemMasterDao.getlistforsearch(itemname);
		//List<ItemMaster> itemList=jpaItemMasterDao.getlistforsearch(itemname);
		List<ItemMaster> itemList=jdbcItemMasterDao.getlistforsearch(itemname);
		ItemMasterBean itemMasterBean=null;
		for(ItemMaster itemMaster:itemList)
		{
			itemMasterBean=new ItemMasterBean();
			itemMasterBean.setItem_code(itemMaster.getItem_code());
			itemMasterBean.setItem_name(itemMaster.getItem_name());
			itemMasterBean.setPrice(itemMaster.getPrice());
			itemMasterBean.setQuantity(itemMaster.getQuantity());
			itemBeanSearchList.add(itemMasterBean);
			
		}
		return itemBeanSearchList;
	}
	@Override
	public int add(ItemMasterBean item) {
		System.out.println("In jpa service method");
		System.out.println(item.getItem_name());
		ItemMaster itemMaster = new ItemMaster();
		itemMaster.setItem_code(item.getItem_code());
		itemMaster.setItem_name(item.getItem_name());
		itemMaster.setPrice(item.getPrice());
		itemMaster.setQuantity(item.getQuantity());
		//itemMasterDao.add(itemMaster);
		//jpaItemMasterDao.add(itemMaster);
		return jdbcItemMasterDao.add(itemMaster);
		
		

	}
	@Transactional
	public void transactionTest(ItemMasterBean item){
		System.out.println("In jpa service method");
				ItemMaster itemMaster = new ItemMaster();
		itemMaster.setItem_code(item.getItem_code());
		itemMaster.setItem_name(item.getItem_name());
		itemMaster.setPrice(item.getPrice());
		itemMaster.setQuantity(item.getQuantity());
		//itemMasterDao.add(itemMaster);
		//jpaItemMasterDao.add(itemMaster);
		jdbcItemMasterDao.add(itemMaster);
		String s=null;
		System.out.println(s.toString());
		
		jdbcItemMasterDao.insertEmployee();
		

	}
	
	

	@Override
	public ItemMasterBean getItem(long id) {
		//ItemMaster itemMaster =itemMasterDao.getItem(id);
		//ItemMaster itemMaster =jpaItemMasterDao.getItem(id);
		ItemMaster itemMaster =jdbcItemMasterDao.getItem(id);
		ItemMasterBean itemMasterBean = new ItemMasterBean();
		itemMasterBean.setItem_code(itemMaster.getItem_code());
		itemMasterBean.setItem_name(itemMaster.getItem_name());
		itemMasterBean.setPrice(itemMaster.getPrice());
		itemMasterBean.setQuantity(itemMaster.getQuantity());
		return itemMasterBean;
	}

	@Override
	public int delete(long id) {
		
		//itemMasterDao.delete(id);
		//jpaItemMasterDao.delete(id);
		return jdbcItemMasterDao.delete(id);
		
	}

	@Override
	public List<String> getDropdownlist() {
		//List<String> dropdown=itemMasterDao.getDropdownlist();
		//List<String> dropdown=jpaItemMasterDao.getDropdownlist();
		List<String> dropdown=jdbcItemMasterDao.getDropdownlist();
		return dropdown;
	}

	
     
}

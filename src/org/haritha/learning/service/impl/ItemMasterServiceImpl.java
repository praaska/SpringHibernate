package org.haritha.learning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.haritha.learning.command.ItemMasterBean;
import org.haritha.learning.dto.ItemMaster;
import org.haritha.learning.hibernate.dao.ItemMasterDao;
import org.haritha.learning.jpa.dao.JpaItemMasterDao;
import org.haritha.learning.service.ItemMasterService;

public class ItemMasterServiceImpl implements ItemMasterService{

private ItemMasterDao itemMasterDao;
private JpaItemMasterDao jpaItemMasterDao;

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
	public void update(ItemMasterBean item) {
		ItemMaster itemMaster = new ItemMaster();
		itemMaster.setItem_code(item.getItem_code());
		itemMaster.setItem_name(item.getItem_name());
		itemMaster.setPrice(item.getPrice());
		itemMaster.setQuantity(item.getQuantity());
		itemMasterDao.update(itemMaster);

	}

	@Override
	public List<ItemMasterBean> list() {
		List<ItemMasterBean> itemBeanList =new ArrayList<ItemMasterBean>();
		List<ItemMaster> itemList=itemMasterDao.list();
		
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
		List<ItemMaster> itemList=itemMasterDao.getlistforsearch(itemname);
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
	public void add(ItemMasterBean item) {
		System.out.println("In jpa service method");
		ItemMaster itemMaster = new ItemMaster();
		itemMaster.setItem_code(item.getItem_code());
		itemMaster.setItem_name(item.getItem_name());
		itemMaster.setPrice(item.getPrice());
		itemMaster.setQuantity(item.getQuantity());
		//itemMasterDao.add(itemMaster);
		jpaItemMasterDao.add(itemMaster);

	}

	@Override
	public ItemMasterBean getItem(long id) {
		ItemMaster itemMaster =itemMasterDao.getItem(id);
		ItemMasterBean itemMasterBean = new ItemMasterBean();
		itemMasterBean.setItem_code(itemMaster.getItem_code());
		itemMasterBean.setItem_name(itemMaster.getItem_name());
		itemMasterBean.setPrice(itemMaster.getPrice());
		itemMasterBean.setQuantity(itemMaster.getQuantity());
		return itemMasterBean;
	}

	@Override
	public void delete(long id) {
		
		itemMasterDao.delete(id);
		
	}

	@Override
	public List<String> getDropdownlist() {
		List<String> dropdown=itemMasterDao.getDropdownlist();
		
		return dropdown;
	}

	
     
}

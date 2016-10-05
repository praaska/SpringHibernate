package org.haritha.learning.service;

import java.util.List;

import org.haritha.learning.command.ItemMasterBean;
import org.haritha.learning.dto.ItemMaster;

public interface ItemMasterService {
	public int update(ItemMasterBean item);
	public List<ItemMasterBean> list();
	public int add(ItemMasterBean item);
	public ItemMasterBean getItem(long id);
	public int delete(long id);
	public List<String> getDropdownlist();
	public List<ItemMasterBean> getlistforsearch(String itemname);
	public void transactionTest(ItemMasterBean item);

	
}

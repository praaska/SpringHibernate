package org.haritha.learning.service;

import java.util.List;

import org.haritha.learning.command.ItemMasterBean;
import org.haritha.learning.dto.ItemMaster;

public interface ItemMasterService {
	public void update(ItemMasterBean item);
	public List<ItemMasterBean> list();
	public void add(ItemMasterBean item);
	public ItemMasterBean getItem(long id);
	public void delete(long id);
	public List<String> getDropdownlist();
	public List<ItemMasterBean> getlistforsearch(String itemname);

	
}

package org.haritha.learning.hibernate.dao;

import java.util.List;

import org.haritha.learning.dto.ItemMaster;

public interface ItemMasterDao {
	public List<ItemMaster> list();
	public void add(ItemMaster item);
	public void update(ItemMaster Item);
	public ItemMaster getItem(long id);
	public void delete(long id);
	public List<String> getDropdownlist();
	public List<ItemMaster> getlistforsearch(String itemname);

}

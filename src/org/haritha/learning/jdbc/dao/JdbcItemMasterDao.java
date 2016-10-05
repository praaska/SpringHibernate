package org.haritha.learning.jdbc.dao;

import java.util.List;

import org.haritha.learning.command.ItemMasterBean;
import org.haritha.learning.dto.ItemMaster;

public interface JdbcItemMasterDao {
	public List<ItemMaster> list();
	public int add(ItemMaster item);
	public int update(ItemMaster Item);
	public ItemMaster getItem(long id);
	public int delete(long id);
	public List<String> getDropdownlist();
	public List<ItemMaster> getlistforsearch(String itemname);
	public void insertEmployee();
	

}

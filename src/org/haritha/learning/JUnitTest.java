package org.haritha.learning;

import static org.junit.Assert.fail;

import java.util.List;

import junit.framework.Assert;

import org.haritha.learning.command.ItemMasterBean;
import org.haritha.learning.service.ItemMasterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:test-inventory-servlet-jdbc.xml")
public class JUnitTest {
	@Autowired
	private ItemMasterService itemMasterService;
	ItemMasterBean itemMasterBean;
	 
	@Before
	public void setUp(){
		System.out.println("Inside Before method "+itemMasterService.toString());
		itemMasterBean=new ItemMasterBean();
		
		itemMasterBean.setItem_name("wirelessmob");
		itemMasterBean.setPrice(16000);
		itemMasterBean.setQuantity(1);
	}
	

	@Test
	 public void testAdd(){
		 int result=itemMasterService.add(itemMasterBean);
		 System.out.println("result="+result);
		 Assert.assertEquals(1,result );
		 
	 }
	@Test
	 public void testUpdate(){
		itemMasterBean=new ItemMasterBean();
		itemMasterBean.setItem_code(41);
		itemMasterBean.setItem_name("h20wirelessmob");
		itemMasterBean.setPrice(8000);
		itemMasterBean.setQuantity(2);
		 int result=itemMasterService.update(itemMasterBean);
		 System.out.println("result="+result);
		 Assert.assertEquals(1,result );
		 
	 }
	@Test
	 public void testDelete(){
		int id=42;
		 int result=itemMasterService.delete(id);
		 System.out.println("result="+result);
		 Assert.assertEquals(1,result );
		 
	 }
	
	@Test
	 public void testgetItem(){
		int id=18;
		itemMasterBean=itemMasterService.getItem(id);
		String itemname=itemMasterBean.getItem_name();
		 System.out.println("itemname="+itemname);
		 Assert.assertEquals("aaa",itemname );
		 
	 }
	@Test
	 public void testlist(){
		List<ItemMasterBean> itemList=itemMasterService.list();
		Assert.assertNotNull(itemList);
		 System.out.println("list size="+itemList.size());
		 Assert.assertEquals(23,itemList.size() );
		 
	 }
	
	@Test
	 public void testListForSearch(){
		String itemname="xyz";
		List<ItemMasterBean> itemList=itemMasterService.getlistforsearch(itemname);
		Assert.assertNotNull(itemList);
		 System.out.println("list size="+itemList.size());
		 Assert.assertEquals(1,itemList.size() );
		 
	 }
	@Test
	 public void testGetDropdownList(){
		
		List<String> itemList=itemMasterService.getDropdownlist();
		Assert.assertNotNull(itemList);
		 System.out.println("list size="+itemList.size());
		 Assert.assertEquals(23,itemList.size() );
		 
	 }
	


}

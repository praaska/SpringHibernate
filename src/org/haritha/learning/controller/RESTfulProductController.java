package org.haritha.learning.controller;

import java.util.List;

import org.haritha.learning.command.ItemMasterBean;
import org.haritha.learning.dto.ItemMaster;
import org.haritha.learning.service.ItemMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/productController")
public class RESTfulProductController {
	@Autowired
	private ItemMasterService itemMasterService;
	@RequestMapping(value="/list")
	public ModelAndView list()
	{
		List<ItemMasterBean> itemList=itemMasterService.list();
		ModelAndView model=new ModelAndView("ItemMasterAdd");
		model.addObject("itemList", itemList);
		model.addObject("itemlist","list");
		return model;
		
	}
	@RequestMapping(value="/search")
	public ModelAndView dropdownlist()
	{
		List<String> dropdownList=itemMasterService.getDropdownlist();
		ModelAndView model=new ModelAndView("ItemMasterAdd");
		model.addObject("dropdownList", dropdownList);
		model.addObject("searchModelAttr","search");
		return model;
		
	}
	
	@RequestMapping(value="/addLoadForm")
	public ModelAndView add()
	{
		ModelAndView model=new ModelAndView("ItemMasterAdd");
		ItemMaster item=new ItemMaster();
		model.addObject("item", item);
		List<ItemMasterBean> itemList=itemMasterService.list();
		model.addObject("itemList", itemList);
		return model;
		
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ItemMasterBean edit(@PathVariable("id") long id)
	{
		System.out.println("ID="+id);
		
		ItemMasterBean item=itemMasterService.getItem(id);
		
		return item;
		
	}
	@RequestMapping(value="/delete")
	public ModelAndView delete(@RequestParam(value="id",required=true)Long id)
	{
		ModelAndView model=new ModelAndView("ItemMasterAdd");
		itemMasterService.delete(id);
		List<ItemMasterBean> itemList=itemMasterService.list();
		model.addObject("itemList", itemList);
		return model;
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("item") ItemMasterBean item)
	{
		System.out.println("Item Name :"+item.getItem_name());
		System.out.println("Item Code :"+item.getItem_code());
		if(null!=item)
			System.out.println("in controller add method");
		System.out.println("in controller after add method");
		ModelAndView model=new ModelAndView("ItemMasterAdd");
			//itemMasterService.add(item);
		try{
		itemMasterService.transactionTest(item);
		}
		catch(Exception e){
			model.addObject("errorMessage", "Page cannot be displayed due to technical issues");
			return model;
			
		}
			
		item=new ItemMasterBean();
		model.addObject("item",item);
		List<ItemMasterBean> itemList=itemMasterService.list();
		model.addObject("itemList", itemList);
		return model;
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("item") ItemMasterBean item)
	{
		System.out.println(item.getItem_code());
		
		if(null!=item)
			itemMasterService.update(item);
		ModelAndView model=new ModelAndView("ItemMasterAdd");
		item=new ItemMasterBean();
	//	model.addObject("item",item);
		List<ItemMasterBean> itemList=itemMasterService.list();
		model.addObject("itemList", itemList);
		model.addObject("updatelistattr","update");
		return model;
	}
	
	@RequestMapping(value="/searchlist",method=RequestMethod.POST)
	public ModelAndView getlistforsearch(@RequestParam("itemname")String itemname)
	{
		
		System.out.println("In controller"+itemname);
		
			List<ItemMasterBean> searchitemList=itemMasterService.getlistforsearch(itemname);
			List<String> dropdownList=itemMasterService.getDropdownlist();
			
			
		ModelAndView model=new ModelAndView("ItemMasterAdd");
		model.addObject("searchitemList", searchitemList);
		model.addObject("dropdownList", dropdownList);
		model.addObject("searchitemlist","searchlist");
		
		return model;
	}

}

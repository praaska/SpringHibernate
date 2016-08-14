package org.haritha.learning.command;

public class ItemMasterBean {
	
	private long item_code;
	private String item_name;
	private double price;
	private int quantity;
	
	
	/**
	 * @return the item_code
	 */
	
	public String getItem_name() {
		return item_name;
	}
	/**
	 * @return the item_code
	 */
	public long getItem_code() {
		return item_code;
	}
	/**
	 * @param item_code the item_code to set
	 */
	public void setItem_code(long item_code) {
		this.item_code = item_code;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}

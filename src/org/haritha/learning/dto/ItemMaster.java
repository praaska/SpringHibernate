package org.haritha.learning.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ItemsMaster")
public class ItemMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long item_code;
	private String item_name;
	private double price;
	private int quantity;
	@Temporal(TemporalType.DATE)
	@Column(name="CreatedOn")
	private Date createdon;
	@Id
	@GeneratedValue
	@Column(name="item_code")
	public long getItem_code() {
		return item_code;
	}
	public void setItem_code(long item_code) {
		this.item_code = item_code;
	}
	@Column(name="item_name")
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	@Column(name="price")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Column(name="quantity")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	
	

}

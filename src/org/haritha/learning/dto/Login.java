package org.haritha.learning.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AdminAccount")
public class Login {
	

	private String username;
	private String password;
	
	private int id;
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	@Column(name="username")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	

}

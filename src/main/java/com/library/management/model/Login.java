package com.library.management.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "library")
public class Login implements Serializable{

	private static final long serialVersionUID = -5147730267132460675L;
	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
	
	@Id
	@Column(name = "user_name")
	public String userName;
	
	@Column(name = "password")
	public String password;

	public Login(String userName) {
		super();
		this.userName = userName;
	}
	
	public Login() {}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

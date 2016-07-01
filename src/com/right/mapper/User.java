package com.right.mapper;

import org.apache.log4j.Logger;

import com.chen.HelloLog4j;

public class User {

//	 id ,address,loginname,mobilephone,name,password
	private Integer id;
	private String name;
	private String loginname;
	private String password;
	

	private String email;
	
	private String address;
	private String mobilephone;
	
	private Integer status;
	private Role role;
	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {

		this.password = password;
	}



	


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {

		this.name = name;
	}



	public String getLoginname() {

		return loginname;
	}



	public void setLoginname(String loginname) {

		this.loginname = loginname;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getMobilephone() {
		return mobilephone;
	}



	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}



	public User() {
		// TODO Auto-generated constructor stub
	}

}

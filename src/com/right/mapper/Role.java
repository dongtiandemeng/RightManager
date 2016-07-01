package com.right.mapper;

import java.util.List;

public class Role {
	private Integer id;
	private String name;
	private String description;
	
	private List<Menu> listMenu; 
	


	public List<Menu> getListMenu() {
		return listMenu;
	}

	public void setListMenu(List<Menu> listMenu) {
		this.listMenu = listMenu;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Role() {
		// TODO Auto-generated constructor stub
	}

}

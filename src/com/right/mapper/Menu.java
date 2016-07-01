package com.right.mapper;

import java.util.List;

import org.apache.log4j.Logger;

import com.chen.HelloLog4j;

public class Menu {
	private Integer id;
	private String name;
	private String url;
	private String ico;
	private Integer parent_id;
	private static Logger logger = Logger.getLogger(Menu.class);
	private Menu parent_menu;
	
	private Integer role_id;
	private Integer menu_id;
	public Integer getRole_id() {
		return role_id;
	}
	
	private List<Menu> unCheckedMenu;
	
	public List<Menu> getUnCheckedMenu() {
		return unCheckedMenu;
	}

	public void setUnCheckedMenu(List<Menu> unCheckedMenu) {
		this.unCheckedMenu = unCheckedMenu;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public Menu getParent_menu() {
		return parent_menu;
	}
	public void setParent_menu(Menu parent_menu) {
		this.parent_menu = parent_menu;
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
//		logger.info("Menu name");
//		logger.info(name);
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIco() {
		return ico;
	}
	public void setIco(String ico) {
		this.ico = ico;

	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
//		logger.info("Menu parent_id");
//		logger.info(parent_id);		
		this.parent_id = parent_id;
		
	}
	public Menu() {
		// TODO Auto-generated constructor stub
	}

}

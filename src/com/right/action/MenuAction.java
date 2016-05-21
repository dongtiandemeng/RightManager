package com.right.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.right.dao.MenuDAO;

public class MenuAction extends ActionSupport{

	private List<Map<String,Object>> menuList;
	private List<Map<String,Object>> parentMenuList;
	
	private Map<String,Object> menu;
	
	public List<Map<String, Object>> getParentMenuList() {
		return parentMenuList;
	}

	public void setParentMenuList(List<Map<String, Object>> parentMenuList) {
		this.parentMenuList = parentMenuList;
	}

	public Integer getId() {
//		System.out.println("getId="+id);
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
//		System.out.println("setId="+id);
	}

	public String getName() {
//		System.out.println("getName="+name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
//		System.out.println("setName="+name);
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
		this.parent_id = parent_id;
		System.out.println("parent_id");
		System.out.println(parent_id);
	}

	private Integer id;
	private String name;
	private String url;
	private String ico;
	private Integer parent_id;
	
	public List<Map<String, Object>> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Map<String, Object>> menuList) {
		this.menuList = menuList;
	}

	public MenuAction() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String execute() throws Exception {
		try {
			MenuDAO dao = new MenuDAO();
			menuList = dao.getMenuList();
			System.out.println("MenuAction");
			return 	SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	public String insert(){
		MenuDAO dao = new MenuDAO();
		parentMenuList = dao.getParentMenuList();
		return "insert";
	}
	
	public String save(){
	
		System.out.println("save");
		//隐含字段的parent_id没有过来
		System.out.println(id);
		System.out.println(name);
		System.out.println(ico);
		System.out.println(url);
		System.out.println(parent_id);
		

		
		Map<String, Object> menu = new HashMap<String, Object>();
		menu.put("id", id);
		menu.put("name", name);
		menu.put("ico",ico);
		menu.put("url", url);
		menu.put("parent_id", parent_id);
		MenuDAO ma = new MenuDAO();
		ma.save(menu);
		System.out.println("save end");
		return "ok";
	}
	
	public String modify(){
	
//		String menu_id = request.getParameter("id");

		//获取父菜单的信息
//		System.out.println("modify");
//		System.out.println(String.valueOf(id));
		
//		String tempId = String.valueOf(id);
		MenuDAO ma = new MenuDAO();
		parentMenuList = ma.getParentMenuList();
//		Map<String,Object> menu = ma.getMenuByID(menu_id);
		//不知道这个id对还是不对
		menu= ma.getMenuByID(id+"");
		System.out.println("modify end");
		return "modify";
	}

	public Map<String, Object> getMenu() {
		return menu;
	}

	public void setMenu(Map<String, Object> menu) {
		this.menu = menu;
	}
	
}

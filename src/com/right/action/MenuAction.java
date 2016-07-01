package com.right.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.chen.HelloLog4j;
import com.opensymphony.xwork2.ActionSupport;
import com.right.common.MySqlSession;
import com.right.dao.MenuDAO;
import com.right.mapper.Menu;

public class MenuAction extends ActionSupport{
//	private List<Map<String,Object>> menuList;
	private List<Menu> menuList;
//	private List<Map<String,Object>> parentMenuList;
	private List<Menu> parentMenuList;
	
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;

	}

	public List<Menu> getParentMenuList() {
		return parentMenuList;
	}

	public void setParentMenuList(List<Menu> parentMenuList) {
		this.parentMenuList = parentMenuList;
	}

//	private Map<String,Object> menu;
	private Menu menu;
//	
//	public List<Map<String, Object>> getParentMenuList() {
//		return parentMenuList;
//	}
//
//	public void setParentMenuList(List<Map<String, Object>> parentMenuList) {
//		this.parentMenuList = parentMenuList;
//	}

	public Integer getId() {
//		System.out.println("getId="+id);
		return id;
	}

	public void setId(Integer id) {
		this.id = id;

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
	
	
//	public List<Map<String, Object>> getMenuList() {
//		return menuList;
//	}
//
//	public void setMenuList(List<Map<String, Object>> menuList) {
//		this.menuList = menuList;
//	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public MenuAction() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String execute() throws Exception {
		try {
			MenuDAO dao = new MenuDAO();
//			menuList = dao.getMenuList();
			menuList = dao.getMenuList();

			return 	SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	public String insert() throws Exception{
		MenuDAO dao = new MenuDAO();
		parentMenuList = dao.getParentMenuList();
		return "insert";
	}
	
	public String save() throws Exception{
	
//		System.out.println("save");
//		//隐含字段的parent_id没有过来
//		System.out.println(id);
//		System.out.println(name);
//		System.out.println(ico);
//		System.out.println(url);
//		System.out.println(parent_id);
		

		
//		Map<String, Object> menu = new HashMap<String, Object>();
//		menu.put("id", id);
//		menu.put("name", name);
//		menu.put("ico",ico);
//		menu.put("url", url);
//		menu.put("parent_id", parent_id);

		try {
			MenuDAO ma = new MenuDAO();
			if(menu.getParent_id() == -1)
				menu.setParent_id(null);
			
//			logger.error("MenuAction save menu"+menu);
			ma.save(menu);
			MySqlSession.commit();
			
//			System.out.println("save end");
			return "ok";
		} catch (Exception ex) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			MySqlSession.rollback();
			throw ex;
		}
		
//		批量保存
//		try {
//			MenuDAO ma = new MenuDAO();
//			List<Menu> list = new ArrayList<Menu>();
//			list.add(menu);
//			list.add(menu);
//			list.add(menu);
//			ma.batchSave(list);
//			
//			MySqlSession.commit();
//			return "ok";
//		} catch (Exception ex) {
//			// TODO Auto-generated catch block
//			ex.printStackTrace();
//			MySqlSession.rollback();
//			throw ex;
//		}
	}
	
	
	
	public String modify() throws Exception{
	
		try {
			//		String menu_id = request.getParameter("id");
			
					//获取父菜单的信息
			//		System.out.println("modify");
			//		System.out.println(String.valueOf(id));
					
			//		String tempId = String.valueOf(id);
					MenuDAO ma = new MenuDAO();
					parentMenuList = ma.getParentMenuList();
//					for(Menu menu:parentMenuList){
//						logger.info("parent menu name"+menu.getName());
//					}
			//		Map<String,Object> menu = ma.getMenuByID(menu_id);
					//不知道这个id对还是不对
			
					menu= ma.getMenuByID(id);
			//		logger.error("url"+menu.getUrl());
			//		logger.error("ico"+menu.getIco());
					
					
			//		System.out.println("modify end");
					
					return "modify";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}

//	public Map<String, Object> getMenu() {
//		return menu;
//	}
//
//	public void setMenu(Map<String, Object> menu) {
//		this.menu = menu;
//	}
	
	
	private static Logger logger = Logger.getLogger(MenuAction.class);  
	
	/**
	 * 在修改页面，点击保存，执行更新操作
	 * 
	 */
	public String update() throws Exception{
//		logger.error("MenuAction update");
		try {
			MenuDAO ma = new MenuDAO();
			if(menu.getParent_id()!=null){				
				if(menu.getParent_id() == -1){					
					menu.setParent_id(null);
				}
			}

			ma.update(menu);
			
			MySqlSession.commit();

			return "ok";
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			MySqlSession.rollback();
			throw ex;
		}
	}
	
	public String delete ()throws Exception{
		try {
			MenuDAO ma = new MenuDAO();
			ma.delete(id);
			MySqlSession.commit();
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySqlSession.rollback();
			throw e;
		}
		
	}
	
	public String redirectMenuDelete(){
		return "delete";
	}
	public String batchDelete() {
		
		try {
			MenuDAO ma = new MenuDAO();
//			logger.error("batchDelete ids"+ids.toString());
//			ma.batchDelete(ids);
//			logger.error("batchDelete chk_id"+chk_id.toString());
			ma.batchDelete(chk_id);		
			MySqlSession.commit();
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySqlSession.rollback();
			
		}
		return "";
	}
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		

		this.ids = ids;


	}

	private List<Integer> ids =new ArrayList<Integer>();
	
	private List<Integer> chk_id;


	public List<Integer> getChk_id() {
		return chk_id;
	}

	public void setChk_id(List<Integer> chk_id) {
		this.chk_id = chk_id;
	}  
     
 
}

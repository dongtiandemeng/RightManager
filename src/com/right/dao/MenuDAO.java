package com.right.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdk.nashorn.internal.runtime.ECMAException;

public class MenuDAO {
	public static final String url = "jdbc:mysql://172.16.123.161/rightdb";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "123456";

	public Connection conn = null;

	/**
	 * 获得菜单信息
	 */
	public List<Map<String, Object>> getMenuList() throws Exception {
		try {
			List<Map<String, Object>> menuList = new ArrayList<Map<String, Object>>();
			// 连接数据库
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			// 提交查询语句
			String sql = "select * from t_base_menu ";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Map<String, Object> menu = new HashMap<String, Object>();
				menu.put("id", rs.getInt("ID"));
				menu.put("name", rs.getString("NAME"));
				menu.put("url", rs.getString("URL"));
				menu.put("ico", rs.getString("ICO"));
				menuList.add(menu);
			}
			con.close();
			return menuList;
		} catch (Exception ex) {
			throw ex;
		}
		
	}

	/**
	 * 获得菜单信息
	 */
	public Map<String, Object> getMenuByID(String id) {
		try {
			Map<String, Object> menu = null;
			// 连接数据库
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			// 提交查询语句
			String sql = "select * from t_base_menu where id=" + id;
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				menu = new HashMap<String, Object>();
				menu.put("id", rs.getInt("ID"));
				menu.put("name", rs.getString("NAME"));
				menu.put("url", rs.getString("URL"));
				menu.put("ico", rs.getString("ICO"));
				menu.put("parent_id", rs.getString("PARENT_ID"));
			}
			con.close();
			return menu;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 获得父菜单信息
	 */
	public List<Map<String, Object>> getParentMenuList() {
		try {
			List<Map<String, Object>> menuList = new ArrayList<Map<String, Object>>();
			// 连接数据库
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			// 提交查询语句
			String sql = "select * from t_base_menu where parent_id is null";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Map<String, Object> menu = new HashMap<String, Object>();
				menu.put("id", rs.getInt("ID"));
				menu.put("name", rs.getString("NAME"));
				menuList.add(menu);
			}
			con.close();
			return menuList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 保存菜单信息
	 */
	public void save(Map<String, Object> menu) {
		try {
			// 连接数据库
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			// 提交查询语句
			String sql = "insert into t_base_menu(name,ico,url,parent_id) values(?,?,?,?)";
			String msql = "update t_base_menu set name=?,ico=?,url=?,parent_id=? where id=?";
			if (menu.get("id") == null) {
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, menu.get("name").toString());
				st.setString(2, menu.get("ico").toString());
				st.setString(3, menu.get("url").toString());
				if (menu.get("parent_id").toString().equals("-1"))
					st.setObject(4, null);
				else
					st.setInt(4,
							Integer.parseInt(menu.get("parent_id").toString()));
				st.executeUpdate();
			} else {
				//modify
				PreparedStatement st2 = con.prepareStatement(msql);
				st2.setString(1, menu.get("name").toString());
				st2.setString(2, menu.get("ico").toString());
				st2.setString(3, menu.get("url").toString());
				if (menu.get("parent_id").toString().equals("-1"))
					st2.setObject(4, null);
				else
					st2.setInt(4,
							Integer.parseInt(menu.get("parent_id").toString()));
				st2.setString(5, menu.get("id").toString());
				st2.executeUpdate();
			}
			con.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

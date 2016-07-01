package com.right.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.right.common.MySqlSession;
import com.right.mapper.Dict;
import com.right.mapper.DictMapper;
import com.right.mapper.DictType;
import com.right.mapper.Menu;
import com.right.mapper.Role;
import com.right.mapper.RoleMapper;

public class RoleDao {

	public RoleDao() {
		// TODO Auto-generated constructor stub
	}

	public List<Role> selectRole(){
		SqlSession session = MySqlSession.getSqlSeesion();
		RoleMapper obj = session.getMapper(RoleMapper.class);
		return obj.selectRole();
	}
	
	public List<Menu> selectAllMenu(){
		SqlSession session = MySqlSession.getSqlSeesion();
		RoleMapper obj = session.getMapper(RoleMapper.class);
		return obj.selectAllMenu();
	}
	
	public List<Menu> selectRestMenu(Integer id){
		SqlSession session = MySqlSession.getSqlSeesion();
		RoleMapper obj = session.getMapper(RoleMapper.class);
		return obj.selectRestMenu(id);
	}
	
	public Integer save (Role role) throws Exception{
		try {
			SqlSession session = MySqlSession.getSqlSeesion();
			RoleMapper obj = session.getMapper(RoleMapper.class);
			obj.save(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role.getId();
	}
	
	public void addRoleMenu(Integer role_id,List<Integer> menu_ids){
		try {
			SqlSession session = MySqlSession.getSqlSeesion();
			RoleMapper obj = session.getMapper(RoleMapper.class);
			List<Menu> menus = new ArrayList<Menu>();
			for (Integer integer : menu_ids) {
//				Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//				map.put(role_id, integer);
//				maps.add(map);//是一个menu，而不是一个map
				Menu menu = new Menu();
				menu.setMenu_id(integer);
				menu.setRole_id(role_id);
				menus.add(menu);
			}
			obj.addRoleMenu(menus);//如何取出里面的数据呢？
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Role getRoleByID(Integer id) throws Exception{
		try {
			SqlSession session = MySqlSession.getSqlSeesion();
			RoleMapper obj = session.getMapper(RoleMapper.class);
			 return obj.selectRoleByID(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	

	
	public void update(Role role) throws Exception{
		try {
			SqlSession session = MySqlSession.getSqlSeesion();
			RoleMapper obj = session.getMapper(RoleMapper.class);
			obj.update(role);
			/**
			 *  删除t_base_role_menu中role_id 
			 */
			
			obj.deleteRoleMenu(role.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 批量删除
	 */
	public void batchDelete(List<Integer> ids)throws Exception{
		try {
			SqlSession session = MySqlSession.getSqlSeesion();
			RoleMapper obj = session.getMapper(RoleMapper.class);
			obj.batchDelete(ids);
			
			obj.batchDelteRoleAndMenu(ids);//删除掉t_base_role_menu之间的关联
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
}

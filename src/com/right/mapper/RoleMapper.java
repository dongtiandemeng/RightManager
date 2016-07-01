package com.right.mapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
	public List<Role> selectRole();
	public List<Menu> selectAllMenu();
	public void save(Role role);
	public void  addRoleMenu(List<Menu> roleMenu);//封装一个集合更改多选的t_base_role_menu 
	public Role selectRoleByID(Integer id);
	//这里要通过一个RoleId查所有Menu，在修改
//	public List<Menu> selectAllMenuByRoleId(Integer id);
	public void deleteRoleMenu(Integer id);
	public List<Menu> selectRestMenu(Integer id);//修改操作中主要是查询那些没有被选中的菜单的名称

	public void update(Role role);
	public void batchDelete(List<Integer> ids);
	
	public void batchDelteRoleAndMenu(List<Integer> ids);

}

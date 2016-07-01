package com.right.mapper;

import java.util.List;

public interface UserMapper {
	public User validateUser(String username,String password);
	public List<Role> selectAllRole();
	public List<User> selectUser();
	public void save(User user);
	public void insertUserRole(Integer user_id,Integer role_id);//插入
	public User selectRoleAndUserByUserId(Integer id);//修改的查询
	public Integer selectUserRoleById(User user);//作为一个标记，是决定选择原来有数据的更改或者原先没有数据的直接插入
	public void  updateUserRole(User user);//更新表t_base_user_role ，原先有数据的更改
	public void  insertUserRoleNoData(User user);//插入表t_base_user_role，原先没有数据的直接插入
//	public User selectUserByID(Integer id);
	public void update(User user);//更新表t_base_user
	
	public void batchDeleteUserAndRole(List<Integer> ids);
	public void batchDelete(List<Integer> ids);
}

package com.right.mapper;

import java.util.List;

public interface MenuMapper {

	public List<Menu> selectAllMenu();
	public List<Menu> selectParentMenu();
	public Menu selectMenuByID(Integer id);
	public void save(Menu menu);
	public void batchSave(List<Menu>menus);
	public void update(Menu menu);
	public void delete(Integer id);
	public void batchDelete(List<Integer>ids);
}

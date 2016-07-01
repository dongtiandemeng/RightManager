package com.right.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.right.action.DictTypeAction;
import com.right.common.MySqlSession;
import com.right.mapper.DictMapper;
import com.right.mapper.DictType;
import com.right.mapper.DictTypeMapper;
import com.right.mapper.Menu;
import com.right.mapper.MenuMapper;

public class DictTypeDao {
	private static Logger logger = Logger.getLogger(DictTypeAction.class);  
	public DictTypeDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<DictType> selectDictType(){
		SqlSession session = MySqlSession.getSqlSeesion();
		DictTypeMapper obj = session.getMapper(DictTypeMapper.class);
		return obj.selectDictType();
	}
	
	public List<Menu> getParentMenuList() throws Exception{
		SqlSession session = MySqlSession.getSqlSeesion();
		MenuMapper obj = session.getMapper(MenuMapper.class);
		return obj.selectParentMenu();
	}
	
	public void save (DictType dictType) throws Exception {
		SqlSession session = MySqlSession.getSqlSeesion();
		DictTypeMapper obj = session.getMapper(DictTypeMapper.class);
		obj.save(dictType);
	}
	
	public DictType getDictTypeByID(Integer id){
		SqlSession session = MySqlSession.getSqlSeesion();
		DictTypeMapper obj = session.getMapper(DictTypeMapper.class);
		return obj.selectDictTypeByID(id);
	}
	
	public void update(DictType dictType){
		try {
			SqlSession session = MySqlSession.getSqlSeesion();
			DictTypeMapper obj = session.getMapper(DictTypeMapper.class);
			obj.update(dictType);
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
			DictTypeMapper obj = session.getMapper(DictTypeMapper.class);
			obj.batchDelete(ids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

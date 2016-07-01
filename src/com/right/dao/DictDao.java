package com.right.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.right.common.MySqlSession;
import com.right.mapper.Dict;
import com.right.mapper.DictMapper;
import com.right.mapper.DictType;

public class DictDao {

	public DictDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Dict> selectDict(){
		SqlSession session = MySqlSession.getSqlSeesion();
		DictMapper obj = session.getMapper(DictMapper.class);
		return obj.selectDict();
	}
	
	public List<DictType> selectAllDictionaryType(){
		SqlSession session = MySqlSession.getSqlSeesion();
		DictMapper obj = session.getMapper(DictMapper.class);
		return obj.selectAllDictionaryType();
	}
	
	public void save (Dict dict) throws Exception{
		try {
			SqlSession session = MySqlSession.getSqlSeesion();
			DictMapper obj = session.getMapper(DictMapper.class);
			obj.save(dict);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Dict getDictByID(Integer id) throws Exception{
		SqlSession session = MySqlSession.getSqlSeesion();
		DictMapper obj = session.getMapper(DictMapper.class);
		 return obj.selectDictByID(id);
	}
	public void update(Dict dict) throws Exception{
		try {
			SqlSession session = MySqlSession.getSqlSeesion();
			DictMapper obj = session.getMapper(DictMapper.class);
			obj.update(dict);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询要删除的items集合，返回一个Dict集合
	 * @return 
	 */
	public List<Dict> selectDeleteItemsById(List<Integer> ids){
		SqlSession session = MySqlSession.getSqlSeesion();
		DictMapper obj = session.getMapper(DictMapper.class);
		return obj.selectDeleteItemsById(ids);
	}
	public void delete(Integer id) throws Exception{
		try {
			SqlSession session = MySqlSession.getSqlSeesion();
			DictMapper obj = session.getMapper(DictMapper.class);
			obj.delete(id);
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
			DictMapper obj = session.getMapper(DictMapper.class);
			obj.batchDelete(ids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

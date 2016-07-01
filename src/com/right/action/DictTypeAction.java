package com.right.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.chen.HelloLog4j;
import com.opensymphony.xwork2.ActionSupport;
import com.right.common.MySqlSession;
import com.right.dao.DictDao;
import com.right.dao.DictTypeDao;
import com.right.dao.MenuDAO;
import com.right.mapper.Dict;
import com.right.mapper.DictType;

public class DictTypeAction extends ActionSupport{
	/**
	 * 
	 */
	private static Logger logger = Logger.getLogger(DictTypeAction.class);  
	private static final long serialVersionUID = 1L;
	private List<DictType> dictTypeList;
	private DictType dictType;
	private Integer id;
	
	private List<Integer> chk_id;
	

	public List<Integer> getChk_id() {
		return chk_id;
	}

	public void setChk_id(List<Integer> chk_id) {
		this.chk_id = chk_id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public DictType getDictType() {
		return dictType;
	}
	public void setDictType(DictType dictType) {
		this.dictType = dictType;
	}
	public List<DictType> getDictTypeList() {
//		logger.error("DictTypeAction dictTypeList");
//		logger.error(dictTypeList);
//		for (DictType dictType : dictTypeList) {
//			logger.error("DictTypeAction dicType"+dictType.getName());
//		}

		return dictTypeList;
	}
	public void setDictTypeList(List<DictType> dictTypeList) {
		this.dictTypeList = dictTypeList;
	}
	public DictTypeAction() {
		// TODO Auto-generated constructor stub
	}
	
	public String execute(){

		try {
			DictTypeDao dtDao = new DictTypeDao();
			dictTypeList = dtDao.selectDictType();
			MySqlSession.commit();
			
			return SUCCESS;
//			for (Dict dict : dicts) {
//				logger.error("dict"+dict.getName());
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySqlSession.rollback();
		}
		
		return null;
	}
	
	/**
	 * 只是跳转页面而已
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception{
//		DictTypeDao dtDao = new DictTypeDao();
//		dtDao.save(dictType);
//		MySqlSession.commit();
		return "insert";
	}
	
	public String save() throws Exception{
		DictTypeDao dtDao = new DictTypeDao();
		dtDao.save(dictType);
		MySqlSession.commit();
		return "ok";
	}
	
	public String modify() throws Exception{
		DictTypeDao dtDao = new DictTypeDao();
		dictType = dtDao.getDictTypeByID(id);	
		MySqlSession.commit();
		return "modify";
	}
	
	public String update() throws Exception{
//		logger.error("MenuAction update");
		try {
			DictTypeDao dtDao = new DictTypeDao();
			dtDao.update(dictType);
			MySqlSession.commit();
			return "ok";
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			MySqlSession.rollback();
			throw ex;
		}
	}
	
	/**
	 * 跳转到DictType_delete.jsp页面，感觉有点多余啊
	 * @return
	 */
	public String redirectDictTypeDelete(){
		return "delete";
	}
	
	public String delete() throws Exception{
		DictTypeDao dtDao = new DictTypeDao();
		dtDao.batchDelete(chk_id);
		MySqlSession.commit();
		return "ok";

	}

}

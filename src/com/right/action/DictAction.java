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

public class DictAction extends ActionSupport{
	/**
	 * 
	 */
	private static Logger logger = Logger.getLogger(DictAction.class);  
	private static final long serialVersionUID = 1L;
	private List<Dict> dictList;
	private Dict dict;
	
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
	private List<DictType> dictTypeList;

	public List<DictType> getDictTypeList() {
		return dictTypeList;
	}

	public void setDictTypeList(List<DictType> dictTypeList) {
		this.dictTypeList = dictTypeList;
	}

	public Dict getDict() {
		return dict;
	}

	public void setDict(Dict dict) {
		this.dict = dict;

		
	}

	public List<Dict> getDictList() {
		return dictList;
	}

	public void setDictList(List<Dict> dictList) {

		this.dictList = dictList;
	}

	public DictAction() {
		// TODO Auto-generated constructor stub
	}
	
	public String execute(){
		try {
			DictDao dDao = new DictDao();
			dictList = dDao.selectDict();
			MySqlSession.commit();
			
			return SUCCESS;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySqlSession.rollback();
		}
		
		return null;
	}
	
	public String insert(){
		
		try {
			DictDao dDao = new DictDao();
			dictTypeList = dDao.selectAllDictionaryType();

			return "insert";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySqlSession.rollback();
		}
		
		return null;
	}
	
	public String save() throws Exception{
		

		if(("-1").equals(dict.getDictionaryType_code())){
			dict.setDictionaryType(null);
		}
		DictDao dDao  = new DictDao();
		

		dDao.save(dict);
		MySqlSession.commit();
		return "ok";
	}
	
	
	public String modify() throws Exception{
		DictDao dDao = new DictDao();
		dict=dDao.getDictByID(id);
		
		dictTypeList = dDao.selectAllDictionaryType();
		return "modify";
	}
	public String update() throws Exception{
		if(("-1").equals(dict.getDictionaryType_code())){
			dict.setDictionaryType(null);
		}
		
		DictDao dDao = new DictDao();
		dDao.update(dict);
		

		MySqlSession.commit();
		return "ok";
	}

	/**
	 * 显示要删除的item，传一个id的array到数据库进行查询
	 * @return
	 */
//	public String selectDeleteItemsById(){
////		logger.error(" DictAction selectDeleteItemsById chk_id");
////		logger.error(chk_id);
////		DictDao dDao = new DictDao();
////		dictList = dDao.selectDeleteItemsById(chk_id);
////		logger.error(" DictAction selectDeleteItemsById dictList="+dictList.size());
//
//		
//		return "delete";
//	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	
	/**
	 * 跳转到Dict_delete.jsp页面，感觉有点多余啊
	 * @return
	 */
	public String redirectDictDelete(){
		return "delete";
	}
	public String delete() throws Exception{
		DictDao dDao = new DictDao();
		dDao.batchDelete(chk_id);
		MySqlSession.commit();
		return "ok";

	}
	

	
}

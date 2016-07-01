package com.right.mapper;

import java.util.List;

import org.apache.log4j.Logger;



public class DictType {
	private static Logger logger = Logger.getLogger(DictType.class);  
	private Integer id;
	private String code;
	private String name;
	private List<Dict> dicts;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {

		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;

	}
	public List<Dict> getDicts() {

		return dicts;
	}
	public void setDicts(List<Dict> dicts) {
		this.dicts = dicts;

	}
	public DictType() {
		// TODO Auto-generated constructor stub
	}

}

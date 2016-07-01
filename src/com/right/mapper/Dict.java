package com.right.mapper;

import org.apache.log4j.Logger;



public class Dict {
	private static Logger logger = Logger.getLogger(Dict.class); 
	private Integer id;
	private String code;
	private String name;
	private String dictionaryType_code;
	
	DictType dictionaryType;
	

	public DictType getDictionaryType() {
		return dictionaryType;
	}

	public void setDictionaryType(DictType dictionaryType) {
		this.dictionaryType = dictionaryType;


	}

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

	public String getDictionaryType_code() {
		return dictionaryType_code;
	}

	public void setDictionaryType_code(String dictionaryType_code) {
		this.dictionaryType_code = dictionaryType_code;
	}

	public Dict() {
		// TODO Auto-generated constructor stub
	}

}

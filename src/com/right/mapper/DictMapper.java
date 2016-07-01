package com.right.mapper;

import java.util.List;


public interface DictMapper {
	public List<Dict> selectDict();
	public List<DictType> selectAllDictionaryType();
	public void save(Dict dict);
	public Dict selectDictByID(Integer id);
	public void update(Dict dict);
	public List<Dict> selectDeleteItemsById(List<Integer> ids);
	public void delete(Integer id);
	public void batchDelete(List<Integer> ids);
	
	
}

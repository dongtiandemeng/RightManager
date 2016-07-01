package com.right.mapper;

import java.util.List;

public interface DictTypeMapper {
	public List<DictType> selectDictType();
	public void save(DictType dictType);
	public DictType selectDictTypeByID(Integer id);
	public void update(DictType dictType);
	public void batchDelete(List<Integer> ids);
}

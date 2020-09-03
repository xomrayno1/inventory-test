package com.tampro.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.tampro.dto.Paging;

public interface BaseDAO<E> {
	
	List<E> findAll(String queryStr, Map<String , Object> mapParams,Paging paging);
	E findById(Class<E> object , Serializable id);
	List<E> findByProperty(String property, Object value);
	void save(E instance);
	void update(E instance);
	void delete(E instance);
	
	

}

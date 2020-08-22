package com.tampro.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.tampro.dao.BaseDAO;
import com.tampro.dto.Paging;

public class BaseDAOImpl<E>  implements BaseDAO<E>{

	public List<E> findAll(String queryStr, Map<String, Object> mapParams, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	public E findById(Class<E> object, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<E> findByProperty(String property, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(E instance) {
		// TODO Auto-generated method stub
		
	}

	public int insert(E instance) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(E instance) {
		// TODO Auto-generated method stub
		
	}

}

package com.tampro.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.BaseDAO;
import com.tampro.dto.Paging;
import com.tampro.entity.Role;

@Repository
@Transactional(rollbackFor = Exception.class)
public class BaseDAOImpl<E>  implements BaseDAO<E>{

	//final static Logger LOGGER = Logger.getLogger(BaseDAOImpl.class); 
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	

	public List<E> findAll(String queryStr, Map<String , Object> mapParams,Paging paging) {
		// TODO Auto-generated method stub
	//	LOGGER.info("find all record from db");
		System.out.println("find all record from db");
		
		StringBuilder builder  = new StringBuilder();
		StringBuilder countQuery = new StringBuilder();
		countQuery.append("select count(*) from ").append(getGenericName()).append(" as model where model.activeFlag = 1 ");
		builder.append(" from ").append(getGenericName()).append(" as model where model.activeFlag = 1");
		if(queryStr!=null && !queryStr.isEmpty()) {
			builder.append(queryStr);
			countQuery.append(queryStr);
		}
		Query query = sessionFactory.getCurrentSession().createQuery(builder.toString());
		Query countQ = sessionFactory.getCurrentSession().createQuery(countQuery.toString());
		if(mapParams!=null && !mapParams.isEmpty()) {
			for(String key : mapParams.keySet()) {
				query.setParameter(key,mapParams.get(key));
				countQ.setParameter(key, mapParams.get(key));
			}
		}
		System.out.println("Query :"+builder.toString());
		System.out.println("Count Query :"+countQuery.toString());
		if(paging != null) {
			query.setFirstResult(paging.getOffset());
			query.setMaxResults(paging.getRecordPerPage());
			long totalRecord =(long) countQ.uniqueResult();
			paging.setTotalRows(totalRecord);
		}
		return query.getResultList();
	}

	public E findById(Class<E> object, Serializable id) {
		// TODO Auto-generated method stub
		System.out.println("find by Id record from db");		
		return sessionFactory.getCurrentSession().get(object, id);
	}

	public List<E> findByProperty(String property, Object value) { //lấy list bằng thuộc tính : vd by id , by name
		// TODO Auto-generated method stub
		System.out.println("find by property from db");
		
		StringBuilder builder  = new StringBuilder();
		builder.append(" from ").append(getGenericName().toString()).append(" as model where model.activeFlag = 1 and model.")
		.append(property).append(" =:"+property);
		System.out.println("Query :"+builder.toString());
		
		Query<E> query = sessionFactory.getCurrentSession().createQuery(builder.toString());
		query.setParameter(property, value);
		System.out.println(query.toString());		
		return query.getResultList();
	}

	public void save(E instance) {
		// TODO Auto-generated method stub
		System.out.println("save from db");
		sessionFactory.getCurrentSession().persist(instance);
	}

	public void update(E instance) {
		// TODO Auto-generated method stub
		System.out.println("update from db");
		sessionFactory.getCurrentSession().merge(instance);
	}

	public void delete(E instance) {
		// TODO Auto-generated method stub
		System.out.println("delete from db");
		sessionFactory.getCurrentSession().delete(instance);
	}
	
	public String getGenericName() { // Trả về class hiện tại đag sử dụng
		String s = getClass().getGenericSuperclass().toString();
		Pattern pattern = Pattern.compile("\\<(.*?)\\>"); // tạo pattern
		Matcher m = pattern.matcher(s); // check xem s có hợp lệ hay k , trả về Matcher
		String generic="null"; 
		if(m.find()) { // kiểm tra 
			generic = m.group(1);
		}
		return generic;
	}



}

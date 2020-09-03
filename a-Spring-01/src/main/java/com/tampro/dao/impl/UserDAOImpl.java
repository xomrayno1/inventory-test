package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.UserDAO;
import com.tampro.entity.Users;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDAOImpl  extends BaseDAOImpl<Users> implements UserDAO<Users>{

	
	
	

}

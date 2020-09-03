package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.UserRoleDAO;
import com.tampro.entity.UsersRole;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserRoleDAOImpl  extends BaseDAOImpl<UsersRole> implements UserRoleDAO<UsersRole>{

}

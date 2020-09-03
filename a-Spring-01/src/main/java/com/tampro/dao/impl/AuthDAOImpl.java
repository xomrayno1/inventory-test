package com.tampro.dao.impl;

import org.springframework.stereotype.Repository;

import com.tampro.dao.AuthDAO;
import com.tampro.entity.Auth;

@Repository
public class AuthDAOImpl extends BaseDAOImpl<Auth> implements AuthDAO<Auth> {

}

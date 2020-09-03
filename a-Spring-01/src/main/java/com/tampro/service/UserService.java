package com.tampro.service;

import java.util.List;

import com.tampro.dto.UsersDTO;

public interface UserService {
		
	public List<UsersDTO> findByProperty(String property, Object value);
	

}

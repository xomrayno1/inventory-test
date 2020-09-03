package com.tampro.service;

import java.util.List;

import com.tampro.dto.RoleDTO;

public interface RoleService {
	
	
	public List<RoleDTO> findByProperty(String property, Object value);
	

	
	
	
}

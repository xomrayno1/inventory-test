package com.tampro.service;

import java.util.List;

import com.tampro.dto.MenuDTO;

public interface MenuService {
	
	public List<MenuDTO> findByProperty(String property, Object value);

}

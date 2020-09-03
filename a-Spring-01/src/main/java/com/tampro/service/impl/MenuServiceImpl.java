package com.tampro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.MenuDAO;
import com.tampro.dto.MenuDTO;
import com.tampro.entity.Menu;
import com.tampro.service.MenuService;
import com.tampro.utils.ConvertToDTO;
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	MenuDAO<Menu> menuDao;

	@Override
	public List<MenuDTO> findByProperty(String property, Object value) {
		List<MenuDTO>  menuDTOs = new ArrayList<MenuDTO>();
		List<Menu> menus = menuDao.findByProperty(property, value);
		
		for(Menu menu : menus) {
			MenuDTO menuDTO = ConvertToDTO.convertMenuEntityToMenuDTO(menu);
			menuDTOs.add(menuDTO);
		}
		
		return menuDTOs;
	}

	

}

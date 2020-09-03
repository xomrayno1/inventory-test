package com.tampro.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.AuthDAO;
import com.tampro.dao.RoleDAO;
import com.tampro.dto.AuthDTO;
import com.tampro.dto.RoleDTO;
import com.tampro.entity.Auth;
import com.tampro.entity.Role;
import com.tampro.service.RoleService;
import com.tampro.utils.ConvertToDTO;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO<Role> roleDao;
	@Autowired
	AuthDAO<Auth> authDao;
	

	@Override
	public List<RoleDTO> findByProperty(String property, Object value) {
		// TODO Auto-generated method stub
		// lay ra danh sach tu db
		List<Role> listRole = roleDao.findByProperty(property, value);
		// tao danh sach dto
		List<RoleDTO> listRoleDTO = new ArrayList<RoleDTO>();
		// chuyen doi
		for (Role role : listRole) {
			RoleDTO roleDTO = ConvertToDTO.convertRoleEntityToRoleDTO(role);
			listRoleDTO.add(roleDTO);
		}
		return listRoleDTO;
	}




}

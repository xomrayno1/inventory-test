package com.tampro.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.AuthDAO;
import com.tampro.dao.RoleDAO;
import com.tampro.dto.AuthDTO;
import com.tampro.entity.Auth;
import com.tampro.entity.Role;
import com.tampro.service.AuthService;
import com.tampro.utils.ConvertToDTO;
@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	AuthDAO<Auth> authDao;
	@Autowired
	RoleDAO<Role> roleDao;
	
	
	@Override
	public Set<AuthDTO> findAuthByIdRole(int idRole) {
		// TODO Auto-generated method stub
		Role role = roleDao.findById(Role.class,idRole);
		List<Auth> listAuths = authDao.findByProperty("role", role);
		Set<AuthDTO> authDTOs = new HashSet<AuthDTO>();
		for(Auth auth : listAuths) {
			AuthDTO authDTO = ConvertToDTO.convertAuthEntityToAuthDTO(auth);
			authDTOs.add(authDTO);
		}
		return authDTOs;
	}

	

}

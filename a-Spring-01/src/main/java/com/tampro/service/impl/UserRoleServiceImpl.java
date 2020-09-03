package com.tampro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.UserRoleDAO;
import com.tampro.dto.UsersRoleDTO;
import com.tampro.entity.UsersRole;
import com.tampro.service.UserRoleService;
import com.tampro.utils.ConvertToDTO;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleDAO<UsersRole> userRoleDao;

	@Override
	public List<UsersRoleDTO> findByProperty(String property, Object value) {
		// TODO Auto-generated method stub
		// lay ra danh sach tu db
		List<UsersRole> listUsersRole = userRoleDao.findByProperty(property, value);
		// tao danh sach dto
		List<UsersRoleDTO> listUsersRoleDTO = new ArrayList<UsersRoleDTO>();
		// chuyen doi
		for (UsersRole usersRole : listUsersRole) {
			UsersRoleDTO usersRoleDTO = ConvertToDTO.convertUserRoleEntityToUserRoleDTO(usersRole);
			listUsersRoleDTO.add(usersRoleDTO);
		}
		return listUsersRoleDTO;
	}

}

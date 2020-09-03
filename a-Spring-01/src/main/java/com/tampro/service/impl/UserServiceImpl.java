package com.tampro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.UserDAO;
import com.tampro.dto.UsersDTO;
import com.tampro.entity.Users;
import com.tampro.service.UserService;
import com.tampro.utils.ConvertToDTO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO<Users> userDAO;

	@Override
	public List<UsersDTO> findByProperty(String property, Object value){
		// TODO Auto-generated method stub
		//lay ra danh sach tu db
		List<Users> list = userDAO.findByProperty(property, value);
		// tao danh sach dto
		List<UsersDTO> listUsersDTO = new ArrayList<UsersDTO>();
		//chuyen doi
		for(Users users : list) {
			UsersDTO usersDTO = ConvertToDTO.convertUserEntityToUserDTO(users);			
			listUsersDTO.add(usersDTO);
		}		
		return listUsersDTO;
	}

	

}

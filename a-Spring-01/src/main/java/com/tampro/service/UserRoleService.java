package com.tampro.service;

import java.util.List;

import com.tampro.dto.UsersRoleDTO;

public interface UserRoleService {

	public List<UsersRoleDTO> findByProperty(String property, Object value);
}

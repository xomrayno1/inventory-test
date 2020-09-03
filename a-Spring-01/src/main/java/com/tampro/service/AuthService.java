package com.tampro.service;

import java.util.Set;

import com.tampro.dto.AuthDTO;

public interface AuthService {
	
	Set<AuthDTO> findAuthByIdRole(int idRole);

}

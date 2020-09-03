package com.tampro.validate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tampro.dto.UsersDTO;
import com.tampro.service.UserService;

@Component
public class LoginValidator  implements Validator{

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz == UsersDTO.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UsersDTO usersDTO = (UsersDTO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "msg.err.required");		
		ValidationUtils.rejectIfEmpty(errors, "password", "msg.err.required");
		if(!StringUtils.isEmpty(usersDTO.getUserName()) && !StringUtils.isEmpty(usersDTO.getPassword())) {
			List<UsersDTO> listUserDTO = userService.findByProperty("userName", usersDTO.getUserName());
			if(usersDTO !=null && listUserDTO != null) {
				if(!listUserDTO.get(0).getPassword().equals(usersDTO.getPassword())) {
					errors.rejectValue("password", "msg.wrong.password");
				}
			}else {
				errors.rejectValue("userName", "msg.wrong.username");
			}
			
		}
	}

}

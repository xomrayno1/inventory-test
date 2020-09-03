package com.tampro.validate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tampro.dto.CategoryDTO;
import com.tampro.service.ProductService;

@Component
public class CategoryValidator implements Validator {
	@Autowired
	private ProductService productService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == CategoryDTO.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		CategoryDTO categoryDTO = (CategoryDTO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "msg.err.required");
		ValidationUtils.rejectIfEmpty(errors, "name", "msg.err.required");
		ValidationUtils.rejectIfEmpty(errors, "description", "msg.err.required");
		if (categoryDTO.getCode() != null) {
			List<CategoryDTO> results = productService.findCategory("code", categoryDTO.getCode());
			if (results != null && !results.isEmpty()) {
				if (categoryDTO.getId() != null && categoryDTO.getId() != 0) { // update
					if (results.get(0).getId() != categoryDTO.getId()) {
						errors.rejectValue("code", "msg.code.exist");
					}
				} else {
					errors.rejectValue("code", "msg.code.exist");
				}
			}
				
		}
	}

}

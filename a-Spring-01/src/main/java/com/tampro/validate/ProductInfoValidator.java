package com.tampro.validate;

import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tampro.dto.ProductInfoDTO;
import com.tampro.service.ProductInfoService;

@Component
public class ProductInfoValidator implements Validator{
	@Autowired
	private ProductInfoService productInfoService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == ProductInfoDTO.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ProductInfoDTO productInfoDTO = (ProductInfoDTO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "msg.err.required");
		ValidationUtils.rejectIfEmpty(errors, "name", "msg.err.required");
		ValidationUtils.rejectIfEmpty(errors, "description", "msg.err.required");
		ValidationUtils.rejectIfEmpty(errors, "multipartFile", "msg.err.required");
		if (productInfoDTO.getCode() != null) {
			List<ProductInfoDTO> results = productInfoService.findProductInfo("code", productInfoDTO.getCode());
			if (results != null && !results.isEmpty()) {
				if (productInfoDTO.getId() != null && productInfoDTO.getId() != 0) { // update
					if (results.get(0).getId() != productInfoDTO.getId()) {
						errors.rejectValue("code", "msg.code.exist");
					}
				} else {
					errors.rejectValue("code", "msg.code.exist");
				}
			}
				
		}
		if(!productInfoDTO.getMultipartFile().getOriginalFilename().isEmpty()) {
			String extension = FilenameUtils.getExtension(productInfoDTO.getMultipartFile().getOriginalFilename());
			if(!extension.equals("jpg") && !extension.equals("png")) {
				errors.rejectValue("multipartFile", "msg.file.extension.error");
			}
		}
	}

}

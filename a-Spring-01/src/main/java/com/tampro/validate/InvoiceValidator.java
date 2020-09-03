package com.tampro.validate;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tampro.dto.InvoiceDTO;
import com.tampro.service.InvoiceService;

@Component
public class InvoiceValidator  implements Validator{
	@Autowired
	InvoiceService invoiceService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == InvoiceDTO.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		InvoiceDTO invoiceDTO = (InvoiceDTO) target;
		ValidationUtils.rejectIfEmpty(errors, "code", "msg.err.required");
		ValidationUtils.rejectIfEmpty(errors, "qty", "msg.err.required");
		ValidationUtils.rejectIfEmpty(errors, "price", "msg.err.required");
		
		if(invoiceDTO != null) {
			if (invoiceDTO.getCode() != null) {
				List<InvoiceDTO> results = invoiceService.find("code", invoiceDTO.getCode());
				if (results != null && !results.isEmpty()) {
					if (invoiceDTO.getId() != null && invoiceDTO.getId() != 0) { // update
						if (results.get(0).getId() != invoiceDTO.getId()) {
							errors.rejectValue("code", "msg.code.exist");
						}
					} else {
						errors.rejectValue("code", "msg.code.exist");
					}
				}
			}
			if (invoiceDTO.getQty() <= 0) {
				errors.rejectValue("qty", "msg.wrong.format");
			}
			if(invoiceDTO.getPrice() != null) {
				if (invoiceDTO.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
					errors.rejectValue("price", "msg.wrong.format");
				}
			}
			if (invoiceDTO.getFromDate() != null && invoiceDTO.getToDate() != null) {
				if (invoiceDTO.getFromDate().after(invoiceDTO.getToDate())) {
					errors.rejectValue("fromDate", "msg.wrong.date");
				}
			}
		}
	}
 
}

package com.tampro.service;

import java.util.List;

import com.tampro.dto.InvoiceDTO;
import com.tampro.dto.Paging;

public interface InvoiceService {
	
	void save(InvoiceDTO invoiceDTO);
	void update(InvoiceDTO invoiceDTO);
	List<InvoiceDTO> find(String property, Object object);
	List<InvoiceDTO> getList(InvoiceDTO invoiceDTO , Paging paging);

}

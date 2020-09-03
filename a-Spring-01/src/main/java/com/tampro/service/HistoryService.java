package com.tampro.service;

import java.util.List;

import com.tampro.dto.HistoryDTO;
import com.tampro.dto.InvoiceDTO;
import com.tampro.dto.Paging;

public interface HistoryService {
	
	List<HistoryDTO> getAllProductsInStock(HistoryDTO historyDTO,Paging paging);
	void save(InvoiceDTO invoice,String action);

}

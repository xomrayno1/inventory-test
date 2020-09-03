package com.tampro.service;

import java.util.List;

import com.tampro.dto.InvoiceDTO;
import com.tampro.dto.Paging;
import com.tampro.dto.ProductsInStockDTO;

public interface ProductInStockService {
	

	List<ProductsInStockDTO> getAllProductsInStock(ProductsInStockDTO productsInStockDTO,Paging paging);
	void saveOrUpdate(InvoiceDTO invoiceDTO);

}

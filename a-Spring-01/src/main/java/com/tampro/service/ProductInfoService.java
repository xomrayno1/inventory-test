package com.tampro.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tampro.dto.Paging;
import com.tampro.dto.ProductInfoDTO;

public interface ProductInfoService {
	
	void saveProductInfo(ProductInfoDTO productInfo) throws Exception;
	void updateProductInfo(ProductInfoDTO productInfo) throws Exception;
	void deleteProductInfo(ProductInfoDTO productInfo) throws Exception;
	List<ProductInfoDTO> findProductInfo(String property,Object value);
	List<ProductInfoDTO> getAllProductInfo(ProductInfoDTO productInfoDTO,Paging paging);
	ProductInfoDTO findByIdProductInfo(int id);
	
	void processUploadFile(MultipartFile multipartFile,String fileName);

}

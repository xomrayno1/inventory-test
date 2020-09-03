package com.tampro.service;

import java.util.List;

import com.tampro.dto.CategoryDTO;
import com.tampro.dto.Paging;

public interface ProductService {
	void saveCategory(CategoryDTO category) throws Exception;
	void updateCategory(CategoryDTO category) throws Exception;
	void deleteCategory(CategoryDTO category) throws Exception;
	List<CategoryDTO> findCategory(String property,Object value);
	List<CategoryDTO> getAllCategory(CategoryDTO categoryDTO,Paging paging);
	CategoryDTO findByIdCategory(int id);
	
}

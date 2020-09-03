package com.tampro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tampro.dao.CategoryDAO;
import com.tampro.dto.CategoryDTO;
import com.tampro.dto.Paging;
import com.tampro.entity.Category;
import com.tampro.service.ProductService;
import com.tampro.utils.ConvertToDTO;

@Service
public class ProductServiceImpl  implements ProductService{ 

	
	@Autowired
	private CategoryDAO<Category> categoryDAO;

	@Override
	public void saveCategory(CategoryDTO categorydto) throws Exception{
		System.out.println("insert category"+categorydto.toString());
		Category category = new Category();
		category.setDescription(categorydto.getDescription());
		category.setName(categorydto.getName());
		category.setCode(categorydto.getCode());
		category.setActiveFlag(1);
		category.setCreateDate(new Date());
		category.setUpdateDate(new Date());
		
		categoryDAO.save(category);
	}

	@Override
	public void updateCategory(CategoryDTO categorydto) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("update category"+categorydto.toString());
		Category category = new Category();
		category.setUpdateDate(new Date());
		category.setActiveFlag(categorydto.getActiveFlag());
		category.setCode(categorydto.getCode());
		category.setCreateDate(categorydto.getCreateDate());
		category.setDescription(categorydto.getDescription());
		category.setId(categorydto.getId());
		category.setName(categorydto.getName());
		categoryDAO.update(category);
	}

	@Override
	public void deleteCategory(CategoryDTO categorydto) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("delete "+categorydto);
		Category category = new Category();
		category.setActiveFlag(0);
		category.setUpdateDate(new Date());
		category.setCode(categorydto.getCode());
		category.setCreateDate(categorydto.getCreateDate());
		category.setDescription(categorydto.getDescription());
		category.setId(categorydto.getId());
		category.setName(categorydto.getName());
		categoryDAO.update(category);
	}

	@Override
	public List<CategoryDTO> findCategory(String property, Object value) {
		// TODO Auto-generated method stub
		System.out.println("property :"+property + " value : "+ value);
		List<Category> categories = categoryDAO.findByProperty(property, value);
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		for(Category category : categories) {
			CategoryDTO categoryDTO = ConvertToDTO.convertCategoryEntityToCategoryDTO(category);
			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;
	}

	@Override
	public List<CategoryDTO> getAllCategory(CategoryDTO categoryDTO,Paging paging) {
		StringBuilder builder = new StringBuilder();
		Map<String, Object> mapParams = new HashMap<String, Object>();
		if(categoryDTO !=null) {
			if(categoryDTO.getId() != null && categoryDTO.getId() != 0) {
				builder.append(" and  model.id=:id");
				mapParams.put("id", categoryDTO.getId());
			}
			if(categoryDTO.getCode() != null && !StringUtils.isEmpty(categoryDTO.getCode())) {
				builder.append(" and  model.code=:code");
				mapParams.put("code", categoryDTO.getCode());
			}
			if(categoryDTO.getName() != null && !StringUtils.isEmpty(categoryDTO.getName())) {
				builder.append(" and  model.name like :name");
				mapParams.put("name", "%"+categoryDTO.getName()+"%");
			}
		}
		
		List<CategoryDTO> dtos = new ArrayList<CategoryDTO>();
		for(Category  category : categoryDAO.findAll(builder.toString(),mapParams,paging)){
			CategoryDTO categoryDTOs = ConvertToDTO.convertCategoryEntityToCategoryDTO(category);
			dtos.add(categoryDTOs);
		}
		return dtos;
	}

	@Override
	public CategoryDTO findByIdCategory(int id) {
		// TODO Auto-generated method stub
		Category category = categoryDAO.findById(Category.class, id);
		CategoryDTO categoryDTO = ConvertToDTO.convertCategoryEntityToCategoryDTO(category);
		return categoryDTO;
	}

	
	
	
}

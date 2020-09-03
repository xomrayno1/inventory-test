package com.tampro.utils;

import com.tampro.dto.CategoryDTO;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.dto.ProductsInStockDTO;
import com.tampro.entity.Category;
import com.tampro.entity.ProductInfo;
import com.tampro.entity.ProductsInStock;

public class ConvertToEntity {
	
	public static Category convertCategoryDTOToCategoryEntity(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setActiveFlag(categoryDTO.getActiveFlag());
		category.setCode(categoryDTO.getCode());
		category.setCreateDate(categoryDTO.getCreateDate());
		category.setDescription(categoryDTO.getDescription());
		category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());
		category.setUpdateDate(categoryDTO.getUpdateDate());
		return category;
	}
	public static ProductInfo convertProductInfoDTOToProductInfoEntity(ProductInfoDTO productInfoDTO) {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setActiveFlag(productInfoDTO.getActiveFlag());
		Category category =  convertCategoryDTOToCategoryEntity(productInfoDTO.getCategoryDTO());
		productInfo.setCategory(category);
		productInfo.setCode(productInfoDTO.getCode());
		productInfo.setCreateDate(productInfoDTO.getCreateDate());
		productInfo.setDescription(productInfoDTO.getDescription());
		productInfo.setId(productInfoDTO.getId());
		productInfo.setImgUrl(productInfoDTO.getImgUrl());
		productInfo.setName(productInfoDTO.getName());
		productInfo.setUpdateDate(productInfoDTO.getUpdateDate());
		return productInfo;
	}
	public static ProductsInStock convertProductsInStockDTOToProductsInStockEntity(ProductsInStockDTO productsInStockDTO) {
		ProductsInStock productsInStock = new ProductsInStock();
		productsInStock.setActiveFlag(productsInStockDTO.getActiveFlag());
		productsInStock.setCreateDate(productsInStockDTO.getCreateDate());
		productsInStock.setId(productsInStockDTO.getId());
		productsInStock.setPrice(productsInStockDTO.getPrice());
		ProductInfo productInfo = convertProductInfoDTOToProductInfoEntity(productsInStockDTO.getProductInfoDTO());
		productsInStock.setProductInfo(productInfo);
		productsInStock.setQty(productsInStockDTO.getQty());
		productsInStock.setUpdateDate(productsInStockDTO.getUpdateDate());
		return productsInStock;
	}
	
	

}

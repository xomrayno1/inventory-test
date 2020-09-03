package com.tampro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tampro.dao.ProductInStockDAO;
import com.tampro.dao.ProductInfoDAO;
import com.tampro.dto.InvoiceDTO;
import com.tampro.dto.Paging;
import com.tampro.dto.ProductsInStockDTO;
import com.tampro.entity.ProductInfo;
import com.tampro.entity.ProductsInStock;
import com.tampro.service.ProductInStockService;
import com.tampro.utils.ConvertToDTO;
/*
 * SaveOrUpdate
 * Hàng tồn kho
 */

@Service
public class ProductInStockServiceImpl  implements ProductInStockService{
	@Autowired
	ProductInStockDAO<ProductsInStock> productInStockDAO;
	@Autowired
	ProductInfoDAO<ProductInfo> productInfoDAO;


	@Override
	public List<ProductsInStockDTO> getAllProductsInStock(ProductsInStockDTO productsInStockDTO, Paging paging) {
		// TODO Auto-generated method stub
		Map<String, Object> mapParams = new HashMap<String, Object>();
		StringBuilder queryStr = new StringBuilder("");
		if(productsInStockDTO.getProductInfoDTO() != null) {
			if( !StringUtils.isEmpty(productsInStockDTO.getProductInfoDTO().getCategoryDTO().getName())) {
				queryStr.append(" and model.productInfo.category.name like :cate ");
				mapParams.put("cate", productsInStockDTO.getProductInfoDTO().getCategoryDTO().getName());
			}
			if(productsInStockDTO.getProductInfoDTO().getCode() != null && !StringUtils.isEmpty(productsInStockDTO.getProductInfoDTO().getCode())) {
				queryStr.append(" and model.productInfo.code=:code ");
				mapParams.put("code", productsInStockDTO.getProductInfoDTO().getCode());
			}
			if(productsInStockDTO.getProductInfoDTO().getName() != null  && !StringUtils.isEmpty(productsInStockDTO.getProductInfoDTO().getName())) {
				queryStr.append(" and model.productInfo.name like :name ");
				mapParams.put("name","%"+ productsInStockDTO.getProductInfoDTO().getName() +"%");
			}
		}		
		List<ProductsInStock> productsInStocks =  productInStockDAO.findAll(queryStr.toString(), mapParams, paging);
		List<ProductsInStockDTO> productsInStockDTOs = new ArrayList<ProductsInStockDTO>();
		for(ProductsInStock  inStock : productsInStocks) {
			ProductsInStockDTO inStockDTO = ConvertToDTO.convertProductsInStockEntityToProductsInStockDTO(inStock);
			productsInStockDTOs.add(inStockDTO);
		}
		return productsInStockDTOs;
	}



	@Override
	public void saveOrUpdate(InvoiceDTO invoiceDTO) {
		if(invoiceDTO.getProductInfoDTO() != null) {
			
			int id = invoiceDTO.getProductInfoDTO().getId();
			System.out.println("id :"+ id);
			List<ProductsInStock> productsInStocks = productInStockDAO.findByProperty("productInfo.id", id); // ?? error
			ProductsInStock productsInStock = null;
 			if(productsInStocks != null && !productsInStocks.isEmpty()) {
 				System.out.println("if 1");
 				productsInStock = productsInStocks.get(0);
 				if(invoiceDTO.getType() == 2) {
 					productsInStock.setQty(productsInStock.getQty() - invoiceDTO.getQty());
 				}else {
 					productsInStock.setQty(productsInStock.getQty() + invoiceDTO.getQty());
 					productsInStock.setPrice(invoiceDTO.getPrice());
 				}
 				productsInStock.setUpdateDate(new Date());
 				productInStockDAO.update(productsInStock);
			}else if(invoiceDTO.getType() == 1){
				System.out.println("if 2");
				productsInStock = new ProductsInStock();
				productsInStock.setActiveFlag(1);
				productsInStock.setCreateDate(new Date());
				productsInStock.setPrice(invoiceDTO.getPrice());
				ProductInfo productInfo = new  ProductInfo();
				productInfo.setId(invoiceDTO.getProductInfoDTO().getId());
				productsInStock.setProductInfo(productInfo);
				productsInStock.setQty(invoiceDTO.getQty());
				productsInStock.setUpdateDate(new Date());
				productInStockDAO.save(productsInStock);
				
			}
		}
		
	}
	
}

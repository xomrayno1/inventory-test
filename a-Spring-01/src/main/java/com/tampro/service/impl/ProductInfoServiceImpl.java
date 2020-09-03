package com.tampro.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tampro.dao.CategoryDAO;
import com.tampro.dao.ProductInfoDAO;
import com.tampro.dto.Paging;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.entity.Category;
import com.tampro.entity.ProductInfo;
import com.tampro.service.ProductInfoService;
import com.tampro.utils.ConvertToDTO;

@Service
public class ProductInfoServiceImpl  implements ProductInfoService{

	@Autowired
	ProductInfoDAO<ProductInfo> productInfoDao;
	@Autowired
	CategoryDAO<Category> categoryDao;
	
	@Override
	public void saveProductInfo(ProductInfoDTO productInfoDTO) throws Exception {
		// TODO Auto-generated method stub
		ProductInfo info = new ProductInfo();
		info.setActiveFlag(1);
		Category category =  categoryDao.findById(Category.class, productInfoDTO.getCateId());
		info.setCategory(category);
		info.setCode(productInfoDTO.getCode());
		info.setCreateDate(new Date());
		info.setDescription(productInfoDTO.getDescription());
		//info.setHistories(productInfoDTO.getHistories()); set
		String fileName = System.currentTimeMillis()+"_"+productInfoDTO.getMultipartFile().getOriginalFilename();
		processUploadFile(productInfoDTO.getMultipartFile(),fileName);
		info.setImgUrl("/images/"+fileName);
		//info.setInvoices(productInfoDTO.getInvoices()); set
		info.setName(productInfoDTO.getName());
		//info.setProductInStocks(productInfoDTO.getProductInStocks()); set
		info.setUpdateDate(new Date());
		productInfoDao.save(info);
	}

	@Override
	public void updateProductInfo(ProductInfoDTO productInfoDTO) throws Exception {
		// TODO Auto-generated method stub
		ProductInfo info = new ProductInfo();
		info.setActiveFlag(productInfoDTO.getActiveFlag());
		Category category =  categoryDao.findById(Category.class, productInfoDTO.getCateId());
		info.setCategory(category);
		info.setCode(productInfoDTO.getCode());
		info.setCreateDate(productInfoDTO.getCreateDate());
		info.setDescription(productInfoDTO.getDescription());
		
		info.setId(productInfoDTO.getId());
		System.out.println(productInfoDTO.getMultipartFile().getOriginalFilename().isEmpty());
		if(!productInfoDTO.getMultipartFile().getOriginalFilename().isEmpty()) {
			String fileName = System.currentTimeMillis()+"_"+productInfoDTO.getMultipartFile().getOriginalFilename();
			processUploadFile(productInfoDTO.getMultipartFile(),fileName);
			info.setImgUrl("/images/"+fileName);
		}else {
			info.setImgUrl(productInfoDTO.getImgUrl());
		}
		info.setName(productInfoDTO.getName());
		info.setUpdateDate(new Date());
		productInfoDao.update(info);
	}

	@Override
	public void deleteProductInfo(ProductInfoDTO productInfoDTO) throws Exception {
		// TODO Auto-generated method stub
		ProductInfo info = new ProductInfo();
		info.setActiveFlag(0);
		Category category =  categoryDao.findById(Category.class, productInfoDTO.getCateId());
		info.setCategory(category);
		info.setCode(productInfoDTO.getCode());
		info.setCreateDate(productInfoDTO.getCreateDate());
		info.setDescription(productInfoDTO.getDescription());
		//info.setHistories(productInfoDTO.getHistories()); set
		info.setId(productInfoDTO.getId());
		info.setImgUrl(productInfoDTO.getImgUrl());
		//info.setInvoices(productInfoDTO.getInvoices()); set
		info.setName(productInfoDTO.getName());
		//info.setProductInStocks(productInfoDTO.getProductInStocks()); set
		info.setUpdateDate(new Date());
		productInfoDao.update(info);
	}

	@Override
	public List<ProductInfoDTO> findProductInfo(String property, Object value) {
		// TODO Auto-generated method stub	
		List<ProductInfo> products = productInfoDao.findByProperty(property, value);
		List<ProductInfoDTO> productDTOs = new ArrayList<ProductInfoDTO>();
		for(ProductInfo productInfo : products) {
			ProductInfoDTO infoDTO = ConvertToDTO.convertProductInfoEntityToProductInfoDTO(productInfo);
			productDTOs.add(infoDTO);
		}
		return productDTOs;
	}

	@Override
	public List<ProductInfoDTO> getAllProductInfo(ProductInfoDTO productInfoDTO, Paging paging) {
		StringBuilder queryStr = new StringBuilder("");
		Map<String,Object> mapParams = new HashMap<>();
		if(productInfoDTO != null) {
			if( productInfoDTO.getId() != null && productInfoDTO.getId() !=0) {
				queryStr.append(" and model.id=:id ");
				mapParams.put("id", productInfoDTO.getId());
			}
			if(productInfoDTO.getCode() != null && !StringUtils.isEmpty(productInfoDTO.getCode())) {
				queryStr.append(" and model.code=:code ");
				mapParams.put("code", productInfoDTO.getCode());
			}
			if(productInfoDTO.getName() != null  && !StringUtils.isEmpty(productInfoDTO.getName())) {
				queryStr.append(" and model.name like :name ");
				mapParams.put("name","%"+ productInfoDTO.getName() +"%");
			}
		}
		List<ProductInfo> productInfos  = productInfoDao.findAll(queryStr.toString(), mapParams, paging);
		List<ProductInfoDTO> productInfoDTOs = new ArrayList<>();
		for(ProductInfo productInfo : productInfos) {
			ProductInfoDTO infoDTO = ConvertToDTO.convertProductInfoEntityToProductInfoDTO(productInfo);
			productInfoDTOs.add(infoDTO);
		}
		return productInfoDTOs;
	}

	@Override
	public ProductInfoDTO findByIdProductInfo(int id) {
		ProductInfo productInfo =  productInfoDao.findById(ProductInfo.class, id);
		ProductInfoDTO infoDTO = ConvertToDTO.convertProductInfoEntityToProductInfoDTO(productInfo);
		return infoDTO;
	}

	@Override
	public void processUploadFile(MultipartFile multipartFile,String fileName) throws IllegalStateException {
		// TODO Auto-generated method stub
		if(!multipartFile.getOriginalFilename().isEmpty()) {
			File  dir = new File("C:\\Users\\Admin\\eclipse-workspace\\a-Spring-01\\src\\main\\webapp\\static\\images\\");
			System.out.println("fileName1"+dir.toString());
			if(!dir.exists()) {
				dir.mkdirs();
			}	
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\a-Spring-01\\src\\main\\webapp\\static\\images\\",fileName);
			System.out.println("fileName2"+file.toString());
			try {
				multipartFile.transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}

package com.tampro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tampro.dao.HistoryDAO;
import com.tampro.dto.HistoryDTO;
import com.tampro.dto.InvoiceDTO;
import com.tampro.dto.Paging;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.entity.History;
import com.tampro.entity.Invoice;
import com.tampro.entity.ProductInfo;
import com.tampro.service.HistoryService;
import com.tampro.utils.ConvertToDTO;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	HistoryDAO<History> historyDAO;
	
	@Override
	public List<HistoryDTO> getAllProductsInStock(HistoryDTO historyDTO, Paging paging) {
		// TODO Auto-generated method stub
		StringBuilder queryStr = new StringBuilder("");
		Map<String, Object> mapParams = new HashMap<String, Object>();
		if(historyDTO != null) {
			if(historyDTO.getProductInfoDTO() != null) {
				if(!StringUtils.isEmpty(historyDTO.getProductInfoDTO().getCode())) {
					queryStr.append(" and model.productInfo.code =:code " );
					mapParams.put("code", historyDTO.getProductInfoDTO().getCode());
				}
				if(!StringUtils.isEmpty(historyDTO.getProductInfoDTO().getName())) {
					queryStr.append(" and model.productInfo.name like name ");
					mapParams.put("name", "%"+historyDTO.getProductInfoDTO().getName()+"%");
				}
				if(!StringUtils.isEmpty(historyDTO.getProductInfoDTO().getCategoryDTO().getName())) {
					queryStr.append(" and model.productInfo.category.name  like categoryName ");
					mapParams.put("categoryName", "%"+historyDTO.getProductInfoDTO().getCategoryDTO().getName()+"%");
				}
			}
			if(!StringUtils.isEmpty(historyDTO.getActionName())) {
				queryStr.append(" and model.actionName like :actionName ");
				mapParams.put("actionName", "%"+historyDTO.getActionName()+"%");
			}
			if(historyDTO.getType() != 0) {
				queryStr.append(" and model.type =:type ");
				mapParams.put("type", historyDTO.getType());
			}
		}
		List<HistoryDTO> historyDTOs = new ArrayList<HistoryDTO>();
		for(History history : historyDAO.findAll(queryStr.toString(), mapParams, paging)) {
			HistoryDTO dto = ConvertToDTO.convertHistoryEntityToHistoryDTO(history);
			historyDTOs.add(dto);
		}				
		return historyDTOs;
	}

	@Override
	public void save(InvoiceDTO invoice,String action) { // history luu thong tin invoice,action luu edit add invoice tac vu
		// TODO Auto-generated method stub
		History history = new History();
		history.setActionName(action);
		history.setActiveFlag(1);
		history.setCreateDate(new Date());
		history.setPrice(invoice.getPrice());
		ProductInfo productInfo = new ProductInfo();
		productInfo.setId(invoice.getProductId());
		history.setProductInfo(productInfo);
		history.setQty(invoice.getQty());
		history.setType(invoice.getType());
		history.setUpdateDate(new Date());
		historyDAO.save(history);
	}

}

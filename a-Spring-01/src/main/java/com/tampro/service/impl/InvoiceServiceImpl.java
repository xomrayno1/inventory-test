package com.tampro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tampro.dao.InvoiceDAO;
import com.tampro.dto.InvoiceDTO;
import com.tampro.dto.Paging;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.entity.Invoice;
import com.tampro.entity.ProductInfo;
import com.tampro.service.HistoryService;
import com.tampro.service.InvoiceService;
import com.tampro.service.ProductInStockService;
import com.tampro.service.ProductInfoService;
import com.tampro.utils.Constant;
import com.tampro.utils.ConvertToDTO;


@Service
public class InvoiceServiceImpl  implements InvoiceService{
	@Autowired
	InvoiceDAO<Invoice> invoiceDAO;
	@Autowired
	HistoryService historyService;
	@Autowired
	ProductInStockService productInStockService;
	@Autowired
	ProductInfoService productInfoService;
	
	@Override
	public void save(InvoiceDTO invoiceDTO) {
		// TODO Auto-generated method stub
		ProductInfoDTO  productInfodto = productInfoService.findByIdProductInfo(invoiceDTO.getProductId());
		ProductInfo productInfo = new ProductInfo();
		productInfo.setId(invoiceDTO.getProductId());
		Invoice invoice = new Invoice();
		invoice.setActiveFlag(1);
		invoice.setCode(invoiceDTO.getCode());
		invoice.setCreateDate(new Date());
		invoice.setPrice(invoiceDTO.getPrice());
		invoice.setProductInfo(productInfo);
		invoice.setQty(invoiceDTO.getQty());
		invoice.setType(invoiceDTO.getType());
		invoice.setUpdateDate(new Date());		
		
		invoiceDTO.setProductInfoDTO(productInfodto);
		invoiceDTO.setActiveFlag(1);
		invoiceDTO.setCreateDate(new Date());
		invoiceDTO.setUpdateDate(new Date());
		
		
		invoiceDAO.save(invoice);
		productInStockService.saveOrUpdate(invoiceDTO);
		historyService.save(invoiceDTO, Constant.ACTION_ADD);
	}

	@Override
	public void update(InvoiceDTO invoiceDTO) {
		int originQty = invoiceDAO.findById(Invoice.class, invoiceDTO.getId()).getQty();
		invoiceDTO.setUpdateDate(new Date());
		
		
		
		//invoiceDAO.update(instance);
	}

	@Override
	public List<InvoiceDTO> find(String property, Object object) {
		// TODO Auto-generated method stub
		List<InvoiceDTO> listInvoiceDTOs = new  ArrayList<InvoiceDTO>();
		List<Invoice> listInvoices = invoiceDAO.findByProperty(property, object);
		for(Invoice invoice : listInvoices) {
			InvoiceDTO invoicedto = ConvertToDTO.convertInvoiceEntityToInvoiceDTO(invoice);
			listInvoiceDTOs.add(invoicedto);
		}
		return  listInvoiceDTOs;
	}

	@Override
	public List<InvoiceDTO> getList(InvoiceDTO invoiceDTO, Paging paging) {
		// TODO Auto-generated method stub
		StringBuilder queryStr = new StringBuilder("");
		Map<String,Object> mapParams = new HashMap<String, Object>();
		if(invoiceDTO != null) {
			if (invoiceDTO.getType() != 0) {
				queryStr.append(" and model.type=:type");
				mapParams.put("type", invoiceDTO.getType());
			}
			if (!StringUtils.isEmpty(invoiceDTO.getCode())) {
				queryStr.append(" and model.code =:code ");
				mapParams.put("code", invoiceDTO.getCode());
			}
			if(invoiceDTO.getFromDate()!=null) {
				queryStr.append(" and model.updateDate >= :fromDate");
				mapParams.put("fromDate", invoiceDTO.getFromDate());
			}
			if(invoiceDTO.getToDate()!=null) {
				queryStr.append(" and model.updateDate <= :toDate");
				mapParams.put("toDate", invoiceDTO.getToDate());
			}
		}
		
		List<InvoiceDTO> listInvoiceDTOs = new  ArrayList<InvoiceDTO>();
		List<Invoice> listInvoices = invoiceDAO.findAll(queryStr.toString(), mapParams, paging);
		for(Invoice invoice : listInvoices) {
			InvoiceDTO invoicedto = ConvertToDTO.convertInvoiceEntityToInvoiceDTO(invoice);
			listInvoiceDTOs.add(invoicedto);
		}
		return listInvoiceDTOs;
	}

}

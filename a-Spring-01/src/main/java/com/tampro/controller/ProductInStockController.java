package com.tampro.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tampro.dto.Paging;
import com.tampro.dto.ProductsInStockDTO;
import com.tampro.service.ProductInStockService;
import com.tampro.service.ProductInfoService;
import com.tampro.utils.Constant;

/*
 * Controller sản phẩm tồn kho
 */
@Controller
public class ProductInStockController {

	
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	ProductInStockService productInStockService;
	

	@RequestMapping(value= {"/product-in-stock/list","/product-in-stock/list/"})
	public String redirect() {
		return "redirect:/product-in-stock/list/1";
	}

	@RequestMapping("/product-in-stock/list/{page}")
	public String showProductInfoList(Model model,HttpSession session,@ModelAttribute("searchForm") ProductsInStockDTO productsInStockDTO,@PathVariable("page") int page) {
		Paging paging = new Paging(5);
		paging.setIndexPage(page);
		if(session.getAttribute(Constant.MSG_SUCCESS) != null) {
			model.addAttribute(Constant.MSG_SUCCESS,session.getAttribute(Constant.MSG_SUCCESS));
			session.removeAttribute(Constant.MSG_SUCCESS);
		}
		if(session.getAttribute(Constant.MSG_ERROR) != null) {
			model.addAttribute(Constant.MSG_ERROR,session.getAttribute(Constant.MSG_ERROR));
			session.removeAttribute(Constant.MSG_ERROR);
		}
		List<ProductsInStockDTO> productInStockDTOs = productInStockService.getAllProductsInStock(productsInStockDTO, paging);
		model.addAttribute("productInStockDTOs", productInStockDTOs);
		model.addAttribute("pageInfo", paging);
		return "productInStock-list";
	}

}

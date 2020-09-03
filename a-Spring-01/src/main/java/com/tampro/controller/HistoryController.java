package com.tampro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tampro.dto.HistoryDTO;
import com.tampro.dto.Paging;
import com.tampro.service.HistoryService;
import com.tampro.service.ProductInStockService;
import com.tampro.service.ProductInfoService;
import com.tampro.utils.Constant;

@Controller
public class HistoryController {
	

	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	ProductInStockService productInStockService;
	@Autowired
	HistoryService historyService;

	@RequestMapping(value= {"/history/list","/history/list/"})
	public String redirect() {
		return "redirect:/history/list/1";
	}

	@RequestMapping("/history/list/{page}")
	public String showProductInfoList(Model model,HttpSession session,@ModelAttribute("searchForm") HistoryDTO historyDTO,@PathVariable("page") int page) {
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
		List<HistoryDTO> historyDTOs = historyService.getAllProductsInStock(historyDTO, paging);
		Map<String,String> mapType = new HashMap<>();
		mapType.put(String.valueOf(Constant.TYPE_ALL), "All");
		mapType.put(String.valueOf(Constant.TYPE_GOODS_RECEIPT), "Goods Receipt");
		mapType.put(String.valueOf(Constant.TYPE_GOODS_ISSUES), "Goods Issues");
		model.addAttribute("mapType",mapType);
		model.addAttribute("historyDTOs", historyDTOs);
		model.addAttribute("pageInfo", paging);
		return "history-list";
	}


}

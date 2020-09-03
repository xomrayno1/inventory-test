package com.tampro.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.tampro.dto.InvoiceDTO;
import com.tampro.dto.Paging;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.service.InvoiceService;
import com.tampro.service.ProductInfoService;
import com.tampro.service.ProductService;
import com.tampro.utils.Constant;
import com.tampro.utils.GoodsReceiptReport;
import com.tampro.validate.InvoiceValidator;



@Controller
public class GoodsReceiptController {
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private InvoiceValidator invoiceValidator;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductInfoService productInfoService;
	
	static final Logger log = Logger.getLogger(GoodsReceiptController.class);
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		if(binder.getTarget()==null) {
			return;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
		if(binder.getTarget().getClass()== InvoiceDTO.class) {
			binder.setValidator(invoiceValidator);
		}
	}
	@RequestMapping(value= {"/goods-receipt/list","/goods-receipt/list/"})	
	public String redirect() {
		return "redirect:/goods-receipt/list/1";
	}
	
	@RequestMapping(value="/goods-receipt/list/{page}")
	public String showInvoiceList(Model model,HttpSession session , @ModelAttribute("searchForm") InvoiceDTO invoice,@PathVariable("page") int page) {
		Paging paging = new Paging(5);
		paging.setIndexPage(page);
		if(invoice==null) {
			invoice = new InvoiceDTO();
		}
		invoice.setType(Constant.TYPE_GOODS_RECEIPT);
		List<InvoiceDTO> invoices = invoiceService.getList(invoice,paging);
		if(session.getAttribute(Constant.MSG_SUCCESS)!=null ) {
			model.addAttribute(Constant.MSG_SUCCESS, session.getAttribute(Constant.MSG_SUCCESS));
			session.removeAttribute(Constant.MSG_SUCCESS);
		}
		if(session.getAttribute(Constant.MSG_ERROR)!=null ) {
			model.addAttribute(Constant.MSG_ERROR, session.getAttribute(Constant.MSG_ERROR));
			session.removeAttribute(Constant.MSG_ERROR);
		}
		model.addAttribute("pageInfo", paging);
		model.addAttribute("invoices", invoices);
		return "goods-receipt-list";
		
	}
	@GetMapping("/goods-receipt/add")
	public String add(Model model) {
		model.addAttribute("titlePage", "Add Invoice");
		model.addAttribute("modelForm", new InvoiceDTO());
		model.addAttribute("viewOnly", false);
		model.addAttribute("mapProduct", initMapProduct());
		return "goods-receipt-action";
	}
	@GetMapping("/goods-receipt/edit/{id}")
	public String edit(Model model , @PathVariable("id") int id) {
		log.info("Edit invoice with id="+id);
		InvoiceDTO invoice = invoiceService.find("id",id).get(0);
		if(invoice!=null) {
			model.addAttribute("titlePage", "Edit Invoice");
			model.addAttribute("modelForm", invoice);
			model.addAttribute("viewOnly", false);
			model.addAttribute("mapProduct", initMapProduct());
			return "goods-receipt-action";
		}
		return "redirect:/goods-receipt/list";
	}
	@GetMapping("/goods-receipt/view/{id}")
	public String view(Model model , @PathVariable("id") int id) {
		log.info("View invoice with id="+id);
		InvoiceDTO invoice = invoiceService.find("id",id).get(0);
		if(invoice!=null) {
			model.addAttribute("titlePage", "View Invoice");
			model.addAttribute("modelForm", invoice);
			model.addAttribute("viewOnly", true);
			return "invoice-action";
		}
		return "redirect:/goods-receipt/list";
	}
	@PostMapping("/goods-receipt/save")
	public String save(Model model,@ModelAttribute("modelForm") @Validated InvoiceDTO invoice,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			if(invoice.getId()!=null) {
				model.addAttribute("titlePage", "Edit Invoice");
			}else {
				model.addAttribute("titlePage", "Add Invoice");
			}
			model.addAttribute("mapProduct", initMapProduct());
			model.addAttribute("modelForm", invoice);
			model.addAttribute("viewOnly", false);
			return "goods-receipt-action";
			
		}
		invoice.setType(Constant.TYPE_GOODS_RECEIPT);
		if(invoice.getId()!=null && invoice.getId()!=0) {
			try {
				invoiceService.update(invoice);
				session.setAttribute(Constant.MSG_SUCCESS, "Update success!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e.getMessage());
				session.setAttribute(Constant.MSG_ERROR, "Update has error");
			}
			
		}else {
				try {
					invoiceService.save(invoice);
					session.setAttribute(Constant.MSG_SUCCESS, "Insert success!!!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					session.setAttribute(Constant.MSG_ERROR, "Insert has error!!!");
				}
		}
		return "redirect:/goods-receipt/list";
		
	}
	@GetMapping("/goods-receipt/export")
	public ModelAndView exportReport() {
		ModelAndView modelAndView = new ModelAndView();
		InvoiceDTO invoice = new InvoiceDTO();
		invoice.setType(Constant.TYPE_GOODS_RECEIPT);
		List<InvoiceDTO> invoices = invoiceService.getList(invoice, null);
		modelAndView.addObject(Constant.KEY_GOODS_RECEIPT_REPORT, invoices);
		modelAndView.setView((View) new GoodsReceiptReport());
		return modelAndView;
	}
	

	private Map<String,String> initMapProduct(){
		List<ProductInfoDTO> productInfos = productInfoService.getAllProductInfo(null, null);
		Map<String, String> mapProduct = new HashMap<>();
		for(ProductInfoDTO productInfo : productInfos) {
			mapProduct.put(productInfo.getId().toString(),productInfo.getName());
		}
		
		return mapProduct;
	}
}

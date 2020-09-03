package com.tampro.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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

import com.tampro.dto.CategoryDTO;
import com.tampro.dto.Paging;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.service.ProductInfoService;
import com.tampro.service.ProductService;
import com.tampro.utils.Constant;
import com.tampro.validate.ProductInfoValidator;

@Controller
public class ProductInfoController {
	

	@Autowired
	ProductService productService;
	@Autowired
	private ProductInfoValidator productInfoValidator;
	@Autowired
	ProductInfoService productInfoService;
	
	@InitBinder
	private void initBinder(WebDataBinder dataBinder) {
		if(dataBinder.getTarget() == null) {
			return;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //custom date
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));  // add vao databinder
									         // CustomDateEditor(DateFormat dateFormat, boolean allowEmpty) cho phep rong~
		if(dataBinder.getTarget().getClass() == ProductInfoDTO.class) {
			dataBinder.setValidator(productInfoValidator);
		}
	}
	@RequestMapping(value= {"/product-info/list","/product-info/list/"})
	public String redirect() {
		return "redirect:/product-info/list/1";
	}

	@RequestMapping("/product-info/list/{page}")
	public String showProductInfoList(Model model,HttpSession session,@ModelAttribute("searchForm") ProductInfoDTO productInfoDTO,@PathVariable("page") int page) {
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
		List<ProductInfoDTO> productInfoDTOs = productInfoService.getAllProductInfo(productInfoDTO,paging);
		model.addAttribute("productInfoDTOs", productInfoDTOs);
		model.addAttribute("pageInfo", paging);
		return "productInfo-list";
	}
	@GetMapping("/product-info/add")
	public String addProductInfo(Model model) {
		model.addAttribute("titlePage","Add ProductInfo");
		model.addAttribute("modelForm",new ProductInfoDTO());
		List<CategoryDTO> categories = productService.getAllCategory(null, null);
		Map<String, String> map = new HashMap<String, String>();
		for(CategoryDTO item : categories) {
			map.put(item.getId().toString(), item.getName());
		}
		model.addAttribute("mapCategory",map);
		model.addAttribute("viewOnly",false);
		return "productInfo-action";
	}
	@GetMapping("/product-info/edit/{id}")
	public String editProductInfo(Model model,@PathVariable("id") int id) {
		ProductInfoDTO productInfoDTO = productInfoService.findByIdProductInfo(id);
		if(productInfoDTO != null) {
			List<CategoryDTO> categories = productService.getAllCategory(null, null);
			Map<String, String> map = new HashMap<String, String>();
			for(CategoryDTO item : categories) {
				map.put(item.getId().toString(), item.getName());
			}
			
			model.addAttribute("mapCategory",map);
			model.addAttribute("titlePage", "Edit ProductInfo");
			model.addAttribute("modelForm",productInfoDTO);
			model.addAttribute("viewOnly",false);
			return "productInfo-action";
		}
		return "redirect:/product-info/list";
	}
	@GetMapping("/product-info/view/{id}")
	public String viewProductInfo(Model model,@PathVariable("id") int id) {
		ProductInfoDTO productInfoDTO = productInfoService.findByIdProductInfo(id);
		if(productInfoDTO != null) {
			model.addAttribute("titlePage", "View ProductInfo");
			model.addAttribute("modelForm",productInfoDTO);
			model.addAttribute("viewOnly",true);
			return "productInfo-action";
		}
		return "redirect:/product-info/list";
	}
	@PostMapping("/product-info/save")
	public String saveProductInfo(Model model,@ModelAttribute("modelForm") @Validated ProductInfoDTO productInfoDTO,BindingResult result,HttpSession session) {
		
		if(result.hasErrors()) {
			if(productInfoDTO.getId() != null) {
				model.addAttribute("titlePage", "Edit ProductInfo");
			}else {
				model.addAttribute("titlePage", "Save ProductInfo");
			}
			List<CategoryDTO> categories = productService.getAllCategory(null, null);
			Map<String, String> map = new HashMap<String, String>();
			for(CategoryDTO item : categories) {
				map.put(item.getId().toString(), item.getName());
			}
			model.addAttribute("mapCategory",map);
			model.addAttribute("modelForm",productInfoDTO);
			model.addAttribute("viewOnly",false);
			return "productInfo-action";
		}
		
		if(productInfoDTO.getId() != null && productInfoDTO.getId() != 0) { 
			try {
				productInfoService.updateProductInfo(productInfoDTO);
				session.setAttribute(Constant.MSG_SUCCESS, "Update success!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Update has error!");
				System.out.println("Update has error !");
			}
			
		}else { 
			try {
				productInfoService.saveProductInfo(productInfoDTO);
				session.setAttribute(Constant.MSG_SUCCESS, "Insert success!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Insert has error!");
			}			
		}
		return "redirect:/product-info/list";
	}
	@GetMapping("/product-info/delete/{id}")
	public String deleteProductInfo(Model model,@PathVariable("id") int id,HttpSession session) {
		ProductInfoDTO ProductInfoDTO = productInfoService.findByIdProductInfo(id);
		if(ProductInfoDTO != null) {
			try {
				productInfoService.deleteProductInfo(ProductInfoDTO);
				session.setAttribute(Constant.MSG_SUCCESS, "Delete success!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Delete has error!");
			}
		}
		return "redirect:/product-info/list";
	}

}

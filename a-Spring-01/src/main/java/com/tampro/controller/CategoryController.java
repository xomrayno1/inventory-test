package com.tampro.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.tampro.service.ProductService;
import com.tampro.utils.Constant;
import com.tampro.validate.CategoryValidator;

@Controller
public class CategoryController {

	@Autowired
	ProductService productService;
	@Autowired
	private CategoryValidator categoryValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder dataBinder) {
		if(dataBinder.getTarget() == null) {
			return;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //custom date
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));  // add vao databinder
									         // CustomDateEditor(DateFormat dateFormat, boolean allowEmpty) cho phep rong~
		if(dataBinder.getTarget().getClass() == CategoryDTO.class) {
			dataBinder.setValidator(categoryValidator);
		}
	}
	@RequestMapping(value= {"/category/list","/category/list/"})
	public String redirect() {
		return "redirect:/category/list/1";
	}

	@RequestMapping("/category/list/{page}")
	public String showCategoryList(Model model,HttpSession session,@ModelAttribute("searchForm") CategoryDTO categoryDTO,@PathVariable("page") int page) {
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
		List<CategoryDTO> categories = productService.getAllCategory(categoryDTO,paging);
		model.addAttribute("categories", categories);
		model.addAttribute("pageInfo", paging);
		return "category-list";
	}
	@GetMapping("/category/add")
	public String addCategory(Model model) {
		model.addAttribute("titlePage","Add Category");
		model.addAttribute("modelForm",new CategoryDTO());
		model.addAttribute("viewOnly",false);
		return "category-action";
	}
	@GetMapping("/category/edit/{id}")
	public String editCategory(Model model,@PathVariable("id") int id) {
		CategoryDTO categoryDTO = productService.findByIdCategory(id);
		if(categoryDTO != null) {
			model.addAttribute("titlePage", "Edit Category");
			model.addAttribute("modelForm",categoryDTO);
			model.addAttribute("viewOnly",false);
			return "category-action";
		}
		return "redirect:/category/list";
	}
	@GetMapping("/category/view/{id}")
	public String viewCategory(Model model,@PathVariable("id") int id) {
		CategoryDTO categoryDTO = productService.findByIdCategory(id);
		if(categoryDTO != null) {
			model.addAttribute("titlePage", "View Category");
			model.addAttribute("modelForm",categoryDTO);
			model.addAttribute("viewOnly",true);
			return "category-action";
		}
		return "redirect:/category/list";
	}
	@PostMapping("/category/save")
	public String saveCategory(Model model,@ModelAttribute("modelForm") @Validated CategoryDTO categoryDTO,BindingResult result,HttpSession session) {
		
		if(result.hasErrors()) {
			if(categoryDTO.getId() != null) {
				model.addAttribute("titlePage", "Edit Category");
			}else {
				model.addAttribute("titlePage", "Save Category");
			}
			model.addAttribute("modelForm",categoryDTO);
			model.addAttribute("viewOnly",false);
			return "category-action";
		}
		if(categoryDTO.getId() != null && categoryDTO.getId() != 0) { 
			try {
				productService.updateCategory(categoryDTO);
				session.setAttribute(Constant.MSG_SUCCESS, "Update success!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Update has error!");
			}
			
		}else { 
			try {
				productService.saveCategory(categoryDTO);
				session.setAttribute(Constant.MSG_SUCCESS, "Insert success!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Insert has error!");
			}			
		}
		return "redirect:/category/list";
	}
	@GetMapping("/category/delete/{id}")
	public String deleteCategory(Model model,@PathVariable("id") int id,HttpSession session) {
		CategoryDTO categoryDTO = productService.findByIdCategory(id);
		if(categoryDTO != null) {
			try {
				productService.deleteCategory(categoryDTO);
				session.setAttribute(Constant.MSG_SUCCESS, "Delete success!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Delete has error!");
			}
		}
		return "redirect:/category/list";
	}
}

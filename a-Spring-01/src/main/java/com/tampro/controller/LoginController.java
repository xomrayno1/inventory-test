package com.tampro.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tampro.dto.AuthDTO;
import com.tampro.dto.MenuDTO;
import com.tampro.dto.RoleDTO;
import com.tampro.dto.UsersDTO;
import com.tampro.dto.UsersRoleDTO;
import com.tampro.entity.Auth;
import com.tampro.entity.Menu;
import com.tampro.service.MenuService;
import com.tampro.service.RoleService;
import com.tampro.service.UserRoleService;
import com.tampro.service.UserService;
import com.tampro.utils.Constant;
import com.tampro.validate.LoginValidator;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private MenuService menuService;	
	@Autowired
	private LoginValidator loginValidator;
	@InitBinder // ham khoi tao
	private void initBinder(WebDataBinder dataBinder) {
		if(dataBinder.getTarget()==null) {
			return;
		}
		if(dataBinder.getTarget().getClass() == UsersDTO.class) { //kiem tra du lieu tu form submit len , kiem tra form co phai la usersdto class ko
			dataBinder.setValidator(loginValidator);
		}
	}	
	@GetMapping(value = {"/login"})
	public String login(Model model) {
		model.addAttribute("loginForm",new UsersDTO());
		return "login";
	}
	@PostMapping("/processLogin")
	public String processLogin(Model model, @ModelAttribute("loginForm") @Validated UsersDTO usersDTO,
			BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return "login";
		}
		

		UsersDTO userDTO = userService.findByProperty("userName",usersDTO.getUserName()).get(0);
		UsersRoleDTO usersRoleDTO = (UsersRoleDTO) userDTO.getUserRoles().iterator().next();
		RoleDTO roleDTO = roleService.findByProperty("id", usersRoleDTO.getRole_id()).get(0);
		List<MenuDTO> listMenuDTO = new ArrayList<MenuDTO>();
		List<MenuDTO> listChildMenu = new ArrayList<MenuDTO>();
		for(Object object : roleDTO.getAuths()) {
			AuthDTO authDTO = (AuthDTO) object;
			MenuDTO menuDTO = menuService.findByProperty("id", authDTO.getMenu_id()).get(0);
			if(authDTO.getActiveFlag() == 1 && authDTO.getPermission() == 1 && menuDTO.getParentId() == 0 &&
					menuDTO.getActiveFlag()  == 1 && menuDTO.getOrderIndex() != -1) {
				menuDTO.setIdMenu(menuDTO.getUrl().replace("/", "")+"Id");
				listMenuDTO.add(menuDTO);
			}else if(authDTO.getActiveFlag() == 1 && authDTO.getPermission() == 1 && menuDTO.getParentId() != 0 &&
					menuDTO.getActiveFlag()  == 1 && menuDTO.getOrderIndex() != -1) {
				menuDTO.setIdMenu(menuDTO.getUrl().replace("/", "")+"Id");
				listChildMenu.add(menuDTO);
			}
		}
		for(MenuDTO menuDTO : listMenuDTO) {
			List<MenuDTO> listChild = new ArrayList<MenuDTO>();
			for(MenuDTO item : listChildMenu) {
				if(menuDTO.getId() == item.getParentId()) {
					listChild.add(item);
				}
			}
			menuDTO.setChild(listChild);
		}
		sortMenu(listMenuDTO);
		for(MenuDTO menuDTO : listMenuDTO) {
			sortMenu(menuDTO.getChild());
		}
		session.setAttribute(Constant.MENU_SESSION_STRING, listMenuDTO);
		session.setAttribute(Constant.USER_INFO,userDTO);
		return "redirect:/index";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute(Constant.USER_INFO);
		session.removeAttribute(Constant.MENU_SESSION_STRING);
		return "redirect:/login";
	}
	
	public void sortMenu(List<MenuDTO> menuDTOs) {
		Collections.sort(menuDTOs,new Comparator<MenuDTO>() {

			@Override
			public int compare(MenuDTO o1, MenuDTO o2) {
				// TODO Auto-generated method stub
				return o1.getOrderIndex() - o2.getOrderIndex();
			}
			
		});
	}
	
}

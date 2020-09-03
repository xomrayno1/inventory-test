package com.tampro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tampro.service.RoleService;

@Controller
public class HomeController {
	
	@Autowired
	RoleService roleService;

	
	@RequestMapping(value = {"/","/index"})
	public String home() {

		return "index";
	}
	
	

}

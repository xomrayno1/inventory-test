package com.tampro.security;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tampro.dto.AuthDTO;
import com.tampro.dto.MenuDTO;
import com.tampro.dto.UsersDTO;
import com.tampro.dto.UsersRoleDTO;
import com.tampro.service.AuthService;
import com.tampro.service.MenuService;
import com.tampro.utils.Constant;

public class FilterSystem implements HandlerInterceptor {
	@Autowired
	AuthService authService;
	@Autowired
	MenuService menuService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Request URI" + request.getRequestURI());
		UsersDTO usersDTO = (UsersDTO) request.getSession().getAttribute(Constant.USER_INFO);
		if (usersDTO == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		} else {
			String url = request.getServletPath();
			if (!hasPermission(url, usersDTO)) {
				response.sendRedirect(request.getContextPath() + "/access/denied");
				return false;
			}
		}
		return true;
	}

	private boolean hasPermission(String url, UsersDTO usersDTO) { // check xem cái url đang vào  có đạt cái permission với role của users ko 

		if (url.contains("/index") || url.contains("/access-denied") || url.contains("/logout")) {
			return true;
		}

		UsersRoleDTO usersRoleDTO = (UsersRoleDTO) usersDTO.getUserRoles().iterator().next();
		Set<AuthDTO> authDTOs = authService.findAuthByIdRole(usersRoleDTO.getRole_id());
		for (Object object : authDTOs) {
			AuthDTO authDTO = (AuthDTO) object;
			MenuDTO menuDTO = (MenuDTO) menuService.findByProperty("id", authDTO.getMenu_id()).get(0);
			if (url.contains(menuDTO.getUrl())) {
				return authDTO.getPermission() == 1;
			}
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}

package com.tampro.utils;

import java.util.HashSet;
import java.util.Set;

import com.tampro.dto.AuthDTO;
import com.tampro.dto.CategoryDTO;
import com.tampro.dto.HistoryDTO;
import com.tampro.dto.InvoiceDTO;
import com.tampro.dto.MenuDTO;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.dto.ProductsInStockDTO;
import com.tampro.dto.RoleDTO;
import com.tampro.dto.UsersDTO;
import com.tampro.dto.UsersRoleDTO;
import com.tampro.entity.Auth;
import com.tampro.entity.Category;
import com.tampro.entity.History;
import com.tampro.entity.Invoice;
import com.tampro.entity.Menu;
import com.tampro.entity.ProductInfo;
import com.tampro.entity.ProductsInStock;
import com.tampro.entity.Role;
import com.tampro.entity.Users;
import com.tampro.entity.UsersRole;

public class ConvertToDTO {
	public static UsersDTO convertUserEntityToUserDTO(Users users) {

		UsersDTO usersDTO = new UsersDTO();
		usersDTO.setActiveFlag(users.getActiveFlag());
		usersDTO.setCreateDate(users.getCreateDate());
		usersDTO.setEmail(users.getEmail());
		usersDTO.setId(users.getId());
		usersDTO.setName(users.getName());
		usersDTO.setPassword(users.getPassword());
		usersDTO.setUpdateDate(users.getUpdateDate());
		usersDTO.setUserName(users.getUserName());
		Set<UsersRoleDTO> usersRoleDTOs = new HashSet<>();
		for (UsersRole usersRole : users.getUserRoles()) {
			UsersRoleDTO usersRoleDTO = convertUserRoleEntityToUserRoleDTO(usersRole);
			usersRoleDTOs.add(usersRoleDTO);
		}
		usersDTO.setUserRoles(usersRoleDTOs);

		return usersDTO;
	}

	public static UsersRoleDTO convertUserRoleEntityToUserRoleDTO(UsersRole userRole) {
		// TODO Auto-generated method stub
		UsersRoleDTO usersRoleDTO = new UsersRoleDTO();
		usersRoleDTO.setActiveFlag(userRole.getActiveFlag());
		usersRoleDTO.setCreateDate(userRole.getCreateDate());
		usersRoleDTO.setId(userRole.getId());
		usersRoleDTO.setRole_id(userRole.getRole().getId());
		usersRoleDTO.setUpdateDate(userRole.getUpdateDate());
		usersRoleDTO.setUsers_id(userRole.getUsers().getId());
		return usersRoleDTO;
	}

	public static RoleDTO convertRoleEntityToRoleDTO(Role role) {
		// TODO Auto-generated method stub
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setActiveFlag(role.getActiveFlag());
		Set<AuthDTO> authDTOs = new HashSet<AuthDTO>();
		for (Auth auth : role.getAuths()) {
			AuthDTO authDTO = convertAuthEntityToAuthDTO(auth);
			authDTOs.add(authDTO);
		}
		roleDTO.setAuths(authDTOs);
		roleDTO.setCreateDate(role.getCreateDate());
		roleDTO.setDescription(role.getDescription());
		roleDTO.setId(role.getId());
		roleDTO.setRoleName(role.getRoleName());
		roleDTO.setUpdateDate(role.getUpdateDate());
		Set<UsersRoleDTO> userRoles = new HashSet<>();
		for (UsersRole usersRole : role.getUserRoles()) {
			UsersRoleDTO usersRoleDTO = convertUserRoleEntityToUserRoleDTO(usersRole);
			userRoles.add(usersRoleDTO);
		}
		roleDTO.setUserRoles(userRoles);
		return roleDTO;
	}

	public static MenuDTO convertMenuEntityToMenuDTO(Menu menu) {
		MenuDTO menuDTO = new MenuDTO();
		menuDTO.setActiveFlag(menu.getActiveFlag());
		menuDTO.setAuths(menu.getAuths());
		menuDTO.setCreateDate(menu.getCreateDate());
		menuDTO.setId(menu.getId());
		menuDTO.setName(menu.getName());
		menuDTO.setOrderIndex(menu.getOrderIndex());
		menuDTO.setParentId(menu.getParentId());
		menuDTO.setUpdateDate(menu.getUpdateDate());
		menuDTO.setUrl(menu.getUrl());
		return menuDTO;
	}

	public static AuthDTO convertAuthEntityToAuthDTO(Auth auth) {
		AuthDTO authDTO = new AuthDTO();
		authDTO.setActiveFlag(auth.getActiveFlag());
		authDTO.setCreateDate(auth.getCreateDate());
		authDTO.setId(auth.getId());
		authDTO.setMenu_id(auth.getMenu().getId());
		authDTO.setPermission(auth.getPermission());			
		authDTO.setRole_id(auth.getRole().getId());
		authDTO.setUpdateDate(auth.getUpdateDate());
		return authDTO;
	}
	public static ProductInfoDTO convertProductInfoEntityToProductInfoDTO(ProductInfo productInfo) {
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		productInfoDTO.setName(productInfo.getName());
		productInfoDTO.setId(productInfo.getId());
		productInfoDTO.setActiveFlag(productInfo.getActiveFlag());
		productInfoDTO.setImgUrl(productInfo.getImgUrl());
		productInfoDTO.setCateId(productInfo.getCategory().getId());
		CategoryDTO categoryDTO = convertCategoryEntityToCategoryDTO(productInfo.getCategory());
		productInfoDTO.setCategoryDTO(categoryDTO);	
		productInfoDTO.setCode(productInfo.getCode());
		productInfoDTO.setCreateDate(productInfo.getCreateDate());
		productInfoDTO.setDescription(productInfo.getDescription());
		productInfoDTO.setUpdateDate(productInfo.getUpdateDate());
		return productInfoDTO;
		
	}
	public static CategoryDTO convertCategoryEntityToCategoryDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setActiveFlag(category.getActiveFlag());
		categoryDTO.setCode(category.getCode());
		categoryDTO.setCreateDate(category.getCreateDate());
		categoryDTO.setDescription(category.getDescription());
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		categoryDTO.setUpdateDate(category.getUpdateDate());
		return categoryDTO;
	}
	public static ProductsInStockDTO convertProductsInStockEntityToProductsInStockDTO(ProductsInStock productInfoStock) {
		ProductsInStockDTO productsInStockDTO = new ProductsInStockDTO();
		productsInStockDTO.setActiveFlag(productInfoStock.getActiveFlag());
		productsInStockDTO.setCreateDate(productInfoStock.getCreateDate());
		productsInStockDTO.setId(productInfoStock.getId());
		productsInStockDTO.setPrice(productInfoStock.getPrice());
		ProductInfoDTO productInfoDTO = convertProductInfoEntityToProductInfoDTO(productInfoStock.getProductInfo());
		productsInStockDTO.setProductInfoDTO(productInfoDTO);
		productsInStockDTO.setQty(productInfoStock.getQty());
		productsInStockDTO.setUpdateDate(productInfoStock.getUpdateDate());
		return productsInStockDTO;
		
	}
	public static InvoiceDTO convertInvoiceEntityToInvoiceDTO(Invoice invoice) {
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		invoiceDTO.setActiveFlag(invoice.getActiveFlag());
		invoiceDTO.setCode(invoice.getCode());
		invoiceDTO.setCreateDate(invoice.getCreateDate());
		//invoiceDTO.setFromDate();
		invoiceDTO.setId(invoice.getId());
		invoiceDTO.setPrice(invoice.getPrice());
		invoiceDTO.setProductId(invoice.getId());
		ProductInfoDTO productInfoDTO = convertProductInfoEntityToProductInfoDTO(invoice.getProductInfo());
		invoiceDTO.setProductInfoDTO(productInfoDTO);
		invoiceDTO.setQty(invoice.getQty());
		//invoiceDTO.setToDate();
		invoiceDTO.setType(invoice.getType());
		invoiceDTO.setUpdateDate(invoice.getUpdateDate());
		return invoiceDTO;
		
	}
	public static HistoryDTO convertHistoryEntityToHistoryDTO(History history) {
		HistoryDTO historyDTO = new HistoryDTO();
		historyDTO.setActionName(history.getActionName());
		historyDTO.setActiveFlag(history.getActiveFlag());
		historyDTO.setCreateDate(history.getCreateDate());
		historyDTO.setId(history.getId());
		historyDTO.setPrice(history.getPrice());
		ProductInfoDTO productInfoDTO = convertProductInfoEntityToProductInfoDTO(history.getProductInfo());
		historyDTO.setProductInfoDTO(productInfoDTO);
		historyDTO.setQty(history.getQty());
		historyDTO.setType(history.getType());
		historyDTO.setUpdateDate(history.getUpdateDate());
		return historyDTO;
	}
}

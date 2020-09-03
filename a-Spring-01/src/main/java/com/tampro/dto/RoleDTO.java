package com.tampro.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class RoleDTO {
	private Integer id;
	private String roleName;
	private String description;
	private int activeFlag;
	private Date createDate;
	private Date updateDate;
	private Set auths = new HashSet(0);
	private Set userRoles = new HashSet(0);
	
	
	public RoleDTO() {
		
	}
	
	public RoleDTO(String roleName) {
		
		this.roleName = roleName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Set getAuths() {
		return auths;
	}
	public void setAuths(Set auths) {
		this.auths = auths;
	}
	public Set getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

	
	
	
	
}






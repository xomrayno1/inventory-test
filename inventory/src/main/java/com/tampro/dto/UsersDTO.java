package com.tampro.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UsersDTO {
	private Integer id;
	private String userName;
	private String password;
	private String email;
	private String name;
	private int activeFlag;
	private Date createDate;
	private Date updateDate;
	private Set userRoles = new HashSet(0);
	private Integer roleID;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Set getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	
	
	
	
}

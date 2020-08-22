package com.tampro.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MenuDTO {

	private Integer id;
	private int parentId;
	private String url;
	private String name;
	private int orderIndex;
	private int activeFlag;
	private Date createDate;
	private Date updateDate;
	private Set auths = new HashSet(0);
	private List<MenuDTO> child;
	private String idMenu;
	private Map<Integer,Integer> mapAuth;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
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
	public List<MenuDTO> getChild() {
		return child;
	}
	public void setChild(List<MenuDTO> child) {
		this.child = child;
	}
	public String getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}
	public Map<Integer, Integer> getMapAuth() {
		return mapAuth;
	}
	public void setMapAuth(Map<Integer, Integer> mapAuth) {
		this.mapAuth = mapAuth;
	}
	
	
	
	
}

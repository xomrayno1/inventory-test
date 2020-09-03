package com.tampro.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Menu implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int parentId;
	private String url;
	private String name;
	private int orderIndex;
	private int activeFlag;
	
	private Date createDate;
	private Date updateDate;
	@OneToMany(mappedBy = "menu")

	private Set<Auth> auths = new HashSet<Auth>();

	
	public Menu() {
		
	}
	public Menu(int id) {
		this.id = id;
	}
	public Menu(String name,int orderIndex,int parentId,String url) {
		this.orderIndex = orderIndex;
		this.name = name;
		this.parentId = parentId;
		this.url = url;
	}
	
	public Menu(String name) {
		super();
		this.name = name;
	}
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
	public Set<Auth> getAuths() {
		return auths;
	}
	public void setAuths(Set<Auth> auths) {
		this.auths = auths;
	}



}

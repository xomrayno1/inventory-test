package com.tampro.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CategoryDTO {
	private Integer id;
	private String name;
	private String code;
	private String description;
	private int activeFlag;
	private Date createDate;
	private Date updateDate;
	
	public CategoryDTO() {
		
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name = "+name + " Code= "+code+" description= "+description;
	}
	
	
}

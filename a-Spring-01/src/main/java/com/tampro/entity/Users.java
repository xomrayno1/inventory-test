package com.tampro.entity;

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
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String userName;
	private String password;
	private String email;
	private String name;
	private int activeFlag;
	private Date createDate;
	private Date updateDate;
	@OneToMany(mappedBy = "users")
	
	private Set<UsersRole> userRoles = new HashSet<UsersRole>();
	
	public Users() {
		
	}
	public Users(String userName, String password, String email, String name) {
		
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.name = name;
	}
	public Users(String userName, String password, String email, String name, Set<UsersRole> userRoles) {
		
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.name = name;
		this.userRoles = userRoles;
	}

	public Users(String userName, String password, String email, String name, int activeFlag, Date createDate,
			Date updateDate) {
		
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.name = name;
		this.activeFlag = activeFlag;
		this.createDate = createDate;
		this.updateDate = updateDate;
		
	}
	public Users(String userName, String password, String email, String name, int activeFlag, Date createDate,
			Date updateDate, Set<UsersRole> userRoles) {
		
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.name = name;
		this.activeFlag = activeFlag;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userRoles = userRoles;
	}
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
	public Set<UsersRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UsersRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + ", name="
				+ name + ", activeFlag=" + activeFlag + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", userRoles=" + userRoles + "]";
	}

	
	

}

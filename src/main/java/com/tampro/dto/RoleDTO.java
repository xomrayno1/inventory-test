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

}

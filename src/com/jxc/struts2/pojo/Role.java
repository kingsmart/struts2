package com.jxc.struts2.pojo;

import java.util.List;

public class Role{
	private Integer id;
	private String name;
	private String descript;
	private List<UserRole> userRoles;
	private List<RoleResource> roleResources;
	
	public List<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public List<RoleResource> getRoleResources() {
		return roleResources;
	}
	public void setRoleResources(List<RoleResource> roleResources) {
		this.roleResources = roleResources;
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
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	
}

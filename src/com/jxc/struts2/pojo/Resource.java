package com.jxc.struts2.pojo;

import java.util.List;

public class Resource {
	private Integer id;
	private String resourceName;
	private String resourceURL;
	private List<RoleResource> roleResources;
	private List<Role> roles;
	
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<RoleResource> getRoleResources() {
		return roleResources;
	}
	public void setRoleResources(List<RoleResource> roleResources) {
		this.roleResources = roleResources;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResourceURL() {
		return resourceURL;
	}
	public void setResourceURL(String resourceURL) {
		this.resourceURL = resourceURL;
	}
}

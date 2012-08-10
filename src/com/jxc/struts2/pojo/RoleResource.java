package com.jxc.struts2.pojo;

public class RoleResource {
	private Integer id;
	private Role role;
	private Resource resource;
public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	//	private Integer roleId;
//	private Integer resourceId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public Integer getRoleId() {
//		return roleId;
//	}
//	public void setRoleId(Integer roleId) {
//		this.roleId = roleId;
//	}
//	public Integer getResourceId() {
//		return resourceId;
//	}
//	public void setResourceId(Integer resourceId) {
//		this.resourceId = resourceId;
//	}
	
}

package com.jxc.struts2.pojo;

public class UserRole {
	private Integer id;
	private User user;
	private Role role;
public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	//	private Integer userId;
//	private Integer roleId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public Integer getUserId() {
//		return userId;
//	}
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//	public Integer getRoleId() {
//		return roleId;
//	}
//	public void setRoleId(Integer roleId) {
//		this.roleId = roleId;
//	}
	
}

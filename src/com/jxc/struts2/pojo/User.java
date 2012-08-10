package com.jxc.struts2.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {
	private Integer id;
	private String name;
	private String password;
	private Integer state;
	private String descript;
	private List<UserRole> userRoles;
	private List<Role> roles;
	
	
	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	//获取用户权限集合,权限使用GrantedAuthority接口表示，框架中有它的实现类//GrantedAuthorityImpl,只需要把角色的名称放入即可
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list=new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			list.add(new GrantedAuthorityImpl(role.getName()));
		}
		return list;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return name;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return state==0?false:true;
	}

}

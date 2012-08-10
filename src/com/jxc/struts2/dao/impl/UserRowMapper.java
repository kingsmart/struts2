package com.jxc.struts2.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.jxc.struts2.pojo.Role;
import com.jxc.struts2.pojo.User;

public class UserRowMapper implements RowMapper {
	private List<Role> roles;

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User();
		user.setId(new Integer(rs.getInt("id")));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setState(new Integer(rs.getInt("state")));
		user.setDescript(rs.getString("descript"));
		//调用上面的方法获取用户所有的权限
		user.setRoles(roles);//getRolesByUserID(rs.getString("username"))
		return user;
	}
	
	public UserRowMapper(List<Role> roles){
		this.roles = roles;
	}

}

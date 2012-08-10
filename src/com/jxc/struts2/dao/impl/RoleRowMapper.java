package com.jxc.struts2.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.jxc.struts2.pojo.Role;

public class RoleRowMapper implements RowMapper{
	@Override  
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {  
		Role role=new Role();
		role.setId(new Integer(rs.getInt(1)));
		role.setName(rs.getString(2));
		role.setDescript(rs.getString(3));
		return role;
    }  


}

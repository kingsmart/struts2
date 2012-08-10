package com.jxc.struts2.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.jxc.struts2.pojo.Resource;
import com.jxc.struts2.pojo.Role;

public class ResourceRowMapper extends JdbcDaoSupport implements RowMapper {
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Resource resource=new Resource();
		resource.setId(new Integer(rs.getInt(1)));
		resource.setResourceName((rs.getString(2)));
		resource.setResourceURL(rs.getString(3));
		resource.setRoles((List<Role>)getRoleByResourceId(rs.getInt(1)));
		return resource;
	}
	
	private List<Role> getRoleByResourceId(int id){
		String sql="SELECT r.id,r.name,r.descript FROM role r,role_resource rr WHERE rr.role_id=r.id AND rr.resource_id=?";
		return this.getJdbcTemplate().query(sql,new Object[]{id},new RoleRowMapper());
	}
}

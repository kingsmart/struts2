package com.jxc.struts2.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.jxc.struts2.dao.ResourceDao;
import com.jxc.struts2.pojo.Resource;

public class ResourceDaoImpl extends JdbcDaoSupport implements ResourceDao {

	@Override
	public List<Resource> getAllResource() {
		List<Resource> list=null;
		String sql="SELECT * from resource";
		list=this.getJdbcTemplate().query(sql,new ResourceRowMapper());
		return list;
	}

	
}

package com.jxc.struts2.dao.impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.jxc.struts2.dao.UserDao;
import com.jxc.struts2.pojo.Role;
import com.jxc.struts2.pojo.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	private Logger logger=Logger.getLogger(UserDaoImpl.class);
	private List<Role> getRolesByUserID(String username){
		String sql="SELECT r.id,r.name,r.descript FROM USER u,role r,user_role ur WHERE u.id=ur.user_id AND r.id=ur.role_id AND u.name=?";
		return getJdbcTemplate().query(sql, new String[] {username}, new RoleRowMapper());
	}
	
	
	public User findUserByName(final String name) {
		String sql="select id,name,password,state,descript FROM user where name=?";
		User user=null;
		try{
			user=(User)this.getJdbcTemplate().queryForObject(sql, new Object[]{name},new UserRowMapper(getRolesByUserID(name)));
			user.setRoles(getRolesByUserID(name));
		}catch(Exception ex){
			if(logger.isInfoEnabled()){
				logger.info("用户名不存在!");
			}
		}
		return user;
	}

}

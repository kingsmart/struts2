package com.jxc.struts2.services.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jxc.struts2.dao.UserDao;
import com.jxc.struts2.pojo.User;
import com.jxc.struts2.services.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException,DataAccessException {
		User user=userDao.findUserByName(username);
		if(user==null){
			throw new UsernameNotFoundException("用户名"+username+"不存在");
		}
		//因为User已经实现了UserDetails接口，所以直接返回user即可
		return user;
	}

}

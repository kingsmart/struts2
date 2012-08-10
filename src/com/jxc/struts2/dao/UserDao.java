package com.jxc.struts2.dao;

import com.jxc.struts2.pojo.User;

public interface UserDao {
	public User findUserByName(String name);
}

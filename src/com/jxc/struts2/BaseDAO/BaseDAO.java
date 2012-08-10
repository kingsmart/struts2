package com.jxc.struts2.BaseDAO;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jxc.struts2.pojo.UserInfo;

public class BaseDAO extends HibernateDaoSupport{
	
	//插入的方法
	public void save(UserInfo user){
		this.getHibernateTemplate().save(user);
	}

}

package com.jxc.struts2.BaseDAO;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jxc.struts2.pojo.UserInfo;

public class BaseDAO extends HibernateDaoSupport{
	
	//����ķ���
	public void save(UserInfo user){
		this.getHibernateTemplate().save(user);
	}

}

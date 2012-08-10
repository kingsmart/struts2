package com.jxc.struts2.dao;

import java.util.List;

import com.jxc.struts2.BaseDAO.BaseDAO;

public class UserInfoDAO extends BaseDAO{
	
	//登陆验证
	public boolean checkUserLogin(String userName,String userpwd){
		String hql="from UserInfo where uname=? and upwd=?";
		List list=this.getHibernateTemplate().find(hql,new String[]{userName,userpwd});
		if(list.size()>0){
			return true;
		}
		return false;
	}
	
	//得到所有的用户
	 public List getAllUser(){
		 String hql="from UserInfo";
		 return this.getHibernateTemplate().find(hql);
	 }
	
	
}

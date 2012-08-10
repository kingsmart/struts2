package com.jxc.struts2.services;

import java.util.List;

import com.jxc.struts2.dao.UserInfoDAO;
import com.jxc.struts2.pojo.UserInfo;

public class UserInfoService{
	   private UserInfoDAO userDAO;
	   public UserInfoDAO getUserDAO() {
			return userDAO;
		}
		public void setUserDAO(UserInfoDAO userDAO) {
			this.userDAO = userDAO;
		}
		
	//验证登陆	
	public boolean checkUserLogin(String userName,String userpwd){		
		if(this.getUserDAO().checkUserLogin(userName, userpwd)){
			return true;
		}
		if(this.getUserDAO().getAllUser() == null || this.getUserDAO().getAllUser().size()==0){
			UserInfo  user = new UserInfo();
			user.setUname(userName);
			user.setUpwd(userpwd);
			this.getUserDAO().save(user);
			return true;
		}
		return false;
	}
	
//	得到所有的用户
	 public List getAllUser(){
		 return this.getUserDAO().getAllUser();
	 }
	 
}

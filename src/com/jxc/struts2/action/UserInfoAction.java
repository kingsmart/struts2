/**
 * author:jzp
 * date:2012年08月10日
 */
package com.jxc.struts2.action;

//import org.apache.struts.action.ActionServlet;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.jxc.struts2.dao.UserInfoDAO;
import com.jxc.struts2.pojo.User;
import com.jxc.struts2.pojo.UserInfo;
import com.jxc.struts2.services.UserInfoService;
import com.jxc.struts2.services.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport{

	private UserDetails user;
	public void setUserSerivce(UserService userSerivce) {
		this.userSerivce = userSerivce;
	}

	private UserService userSerivce;
	
	@Override
	public String execute() throws Exception {
		
		SecurityContext secCtx = SecurityContextHolder.getContext();
		Authentication auth = secCtx.getAuthentication();
		user = (UserDetails)auth.getPrincipal();
		
		
		// TODO Auto-generated method stub	
		
		System.out.println("用户名:"+user.getUsername());
		System.out.println("密码:"+user.getPassword());
		
//		if(this.userSerivce.checkUserLogin(user.getUsername(),user.getPassword())){
//			ActionContext context= ActionContext.getContext();
//			context.getSession().put("userList", this.getUserSERVICE().getAllUser());
			
			return "success";
//		}
//		return "error";
		
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
}

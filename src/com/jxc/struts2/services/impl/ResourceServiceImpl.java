package com.jxc.struts2.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;


import com.jxc.struts2.dao.ResourceDao;
import com.jxc.struts2.pojo.Resource;
import com.jxc.struts2.pojo.Role;
import com.jxc.struts2.services.ResourceService;
import com.jxc.tool.AntUrlPathMatcher;
import com.jxc.tool.UrlMatcher;

public class ResourceServiceImpl implements ResourceService {
	private static final Logger logger = 
			Logger.getLogger(ResourceServiceImpl.class);
	
	private ResourceDao resourceDao;
	
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	
	public ResourceServiceImpl(ResourceDao resourceDao) {
        this.resourceDao = resourceDao;
    }
	
	private static Map<String,Collection<ConfigAttribute>> resourceMap = null;
	
	/**
	* 自定义方法，将List<Role>集合转换为框架需要的Collection<ConfigAttribute>集合
	* @param roles
	* @return
	*/
	private Collection<ConfigAttribute> listToCollection(List<Role> roles){
		List<ConfigAttribute> list=new ArrayList<ConfigAttribute>();
		for (Role role : roles) {
			list.add(new SecurityConfig(role.getName()));
		}
		return list;
	}
	
	/**
	* 自定义方法，这个类放入到Spring容器后，指定init为初始化方法，从数据库中读取资源
	* @throws Exception
	*/
	public void init()throws Exception {
		this.resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		//通过数据库中的信息设置，resouce和role
		for (Resource item:resourceDao.getAllResource()){
			resourceMap.put(item.getResourceURL(),listToCollection(item.getRoles()));
		}
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	/**
	* 接口中规定的方法，获取所有权限配置属性
	*/
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
		for (Map.Entry<String, Collection<ConfigAttribute>> entry : resourceMap.entrySet()) {
			allAttributes.addAll(entry.getValue());
		}
		return allAttributes;
	}

	
	/**
	* 接口中规定的方法，用户获取正在访问的资源所对应的权限结合
	*/
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		String url = ((FilterInvocation) object).getRequestUrl();
		if (logger.isDebugEnabled()) {
			logger.debug("getAttributes方法:正在访问的URL为:"+url);
		}
		Iterator<String> it = resourceMap.keySet().iterator();
		while (it.hasNext()) {
			String resURL = it.next();
			//使用AntUrlPathMatcher来比较，也可以使用其它方式来比较，可以根据需要来修改
			//一旦匹配上，立即返回
			if (urlMatcher.pathMatchesUrl(resURL,url)) {
				Collection<ConfigAttribute> returnCollection = resourceMap.get(resURL);
				return returnCollection;
			}
		}
		//没有匹配上，则返回null
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}

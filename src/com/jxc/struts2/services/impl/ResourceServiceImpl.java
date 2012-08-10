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
	* �Զ��巽������List<Role>����ת��Ϊ�����Ҫ��Collection<ConfigAttribute>����
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
	* �Զ��巽�����������뵽Spring������ָ��initΪ��ʼ�������������ݿ��ж�ȡ��Դ
	* @throws Exception
	*/
	public void init()throws Exception {
		this.resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		//ͨ�����ݿ��е���Ϣ���ã�resouce��role
		for (Resource item:resourceDao.getAllResource()){
			resourceMap.put(item.getResourceURL(),listToCollection(item.getRoles()));
		}
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	/**
	* �ӿ��й涨�ķ�������ȡ����Ȩ����������
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
	* �ӿ��й涨�ķ������û���ȡ���ڷ��ʵ���Դ����Ӧ��Ȩ�޽��
	*/
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		String url = ((FilterInvocation) object).getRequestUrl();
		if (logger.isDebugEnabled()) {
			logger.debug("getAttributes����:���ڷ��ʵ�URLΪ:"+url);
		}
		Iterator<String> it = resourceMap.keySet().iterator();
		while (it.hasNext()) {
			String resURL = it.next();
			//ʹ��AntUrlPathMatcher���Ƚϣ�Ҳ����ʹ��������ʽ���Ƚϣ����Ը�����Ҫ���޸�
			//һ��ƥ���ϣ���������
			if (urlMatcher.pathMatchesUrl(resURL,url)) {
				Collection<ConfigAttribute> returnCollection = resourceMap.get(resURL);
				return returnCollection;
			}
		}
		//û��ƥ���ϣ��򷵻�null
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}

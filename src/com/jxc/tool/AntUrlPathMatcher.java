package com.jxc.tool;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class AntUrlPathMatcher implements UrlMatcher {
	  private boolean requiresLowerCaseUrl;
	  
	  private PathMatcher pathMatcher;

	  public AntUrlPathMatcher()
	  {
	    this(true);
	  }
	
	  public AntUrlPathMatcher(boolean requiresLowerCaseUrl)
	  {
	    this.requiresLowerCaseUrl = true;
	    this.pathMatcher = new AntPathMatcher();
	
	    this.requiresLowerCaseUrl = requiresLowerCaseUrl;
	  }
	
	  public Object compile(String path) {
	    if (this.requiresLowerCaseUrl) {
	      return path.toLowerCase();
	    }
	
	    return path;
	  }
	
	  public void setRequiresLowerCaseUrl(boolean requiresLowerCaseUrl) {
	    this.requiresLowerCaseUrl = requiresLowerCaseUrl;
	  }
	
	  public boolean pathMatchesUrl(Object path, String url) {
	    if (("/**".equals(path)) || ("**".equals(path))) {
	      return true;
	    }
	    return this.pathMatcher.match((String)path, url);
	  }
	
	  public String getUniversalMatchPattern() {
	    return "/**";
	  }
	
	  public boolean requiresLowerCaseUrl() {
	    return this.requiresLowerCaseUrl;
	  }
	
	  public String toString() {
	    return super.getClass().getName() + "[requiresLowerCase='" + this.requiresLowerCaseUrl + "']";
	  }


}


/*
AntUrlPathMatcher��urlת��ΪСд

RegexUrlPathMatcherĬ�ϲ�����Сдת������AntUrlPathMatcherĬ��Ҫ����Сдת��

 

Ĭ��ʹ�õ�URLƥ�����������AntUrlPathMatcher����������http://ant.apache.org/��Ŀ����һ�ּ��׶���·��ƥ����ԡ�

��Ϊ�����ṩ������ͨ�����

ͨ�����?

ʾ����/admin/g?t.jsp

ƥ������һ���ַ���/admin/g?t.jsp����ƥ��/admin/get.jsp��/admin/got.jsp����/admin/gxt.do������ƥ��/admin/xxx.jsp��

ͨ�����*

ʾ����/adminindex.jsp����ƥ��/admin/index.jsp��/user/index.jsp�����ǲ���ƥ��/index.jsp��/user/test/index.jsp��

ͨ�����**

ʾ����index.jsp

����ƥ���������ַ������Կ�ԽĿ¼������ƥ��/index.jsp��/admin/index.jsp��/user/admin/index.jsp��/a/b/c/d/index.jsp
*/

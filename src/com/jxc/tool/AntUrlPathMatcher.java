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
AntUrlPathMatcher将url转换为小写

RegexUrlPathMatcher默认不进行小写转换，而AntUrlPathMatcher默认要进行小写转换

 

默认使用的URL匹配器就是这个AntUrlPathMatcher，它来自于http://ant.apache.org/项目，是一种简单易懂的路径匹配策略。

它为我们提供了三种通配符。

通配符：?

示例：/admin/g?t.jsp

匹配任意一个字符，/admin/g?t.jsp可以匹配/admin/get.jsp和/admin/got.jsp或是/admin/gxt.do。不能匹配/admin/xxx.jsp。

通配符：*

示例：/adminindex.jsp可以匹配/admin/index.jsp和/user/index.jsp，但是不能匹配/index.jsp和/user/test/index.jsp。

通配符：**

示例：index.jsp

可以匹配任意多个字符，可以跨越目录，可以匹配/index.jsp，/admin/index.jsp，/user/admin/index.jsp和/a/b/c/d/index.jsp
*/

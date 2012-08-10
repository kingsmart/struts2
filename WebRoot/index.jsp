<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  </head>
  
  <body>
  <c:if test="${param.error == true}">
  	<div class="error">
		µÇÂ½Ê§°Ü
	</div>
 </c:if>
    <form action="<c:url value='j_spring_security_check'/>" method="post">
    userName:<input type="text" name="j_username" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}"/>
    userPwd:<input type="password" name="j_password"/><br/>
    <input type="submit" value="Ìá  ½»">
    </form>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    
    <title>登录成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  </head>
  
  <body>
  <form action="">
   <h1>成功</h1>
   
   
	<security:authorize ifAllGranted="ROLE_ADMIN">
	
	 <a href="#" onclick="window.open('content.jsp');">显示保密内容</a>
	
	</security:authorize>

   <br/>
   
   	欢迎您:<security:authentication property="principal.username"/>
   <table border="2">   
 
	<s:iterator id="tech" status="nv" value="{'spring','hibernate','struts2','ajax','JPA'}">
		<tr <s:if test="#nv.last">style="background-color:red;"</s:if>>
			<td>
				<s:property value="tech"></s:property>
			</td>
		</tr>
	</s:iterator>
   </table>
  </form>
   
  </body>
</html>
 
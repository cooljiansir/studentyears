<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%! public String getIpAddr(HttpServletRequest request) {
     String ip = request.getHeader("x-forwarded-for");
     if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getHeader("Proxy-Client-IP");
     }
     if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getHeader("WL-Proxy-Client-IP");
     }
     if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getHeader("X-Real-IP");
     }
     if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getRemoteAddr();
     }
     return ip;
	}   
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'welcome.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	欢迎${username }！
    	<%=session.getAttribute("user") %>
    	<form name="adminloginForm" method="post" action="test.do">
   			<td align="center"><%=getIpAddr(request)%>"</td> 
		</form>
  </body>
</html>

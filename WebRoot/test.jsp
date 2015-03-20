<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%   
String incode = (String)request.getParameter("code");   
String rightcode = (String)session.getAttribute("numrand");//汉字验证码的话则是hanzirand   
if (incode != null && rightcode != null)   
if (rightcode.equals(incode))   
{   
out.println("验证码输入正确!");   
}   
else  
{   
out.println("验证码错误，请重新输入!");   
}   
  
%>

<script language="JavaScript">
function reloadcode(){
var verify=document.getElementById('safecode');
verify.setAttribute('src','image.jsp?'+Math.random());
//这里必须加入随机数不然地址相同我发重新加载
}

</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
    <form action="test.jsp" method="post">   
		<!--请输入验证码：<img src="image.jsp" />//如果是要用汉字验证码的就换成hanzi.jsp   -->
		<img src="image.jsp"    id="safecode" border="0" onclick="reloadcode()"  style="cursor:hand;padding:2px 8px 0pt 3px;"  />
      
		<input type="text" name="code">   
		<input type="submit" value="验证"></form>
  </body>
</html>

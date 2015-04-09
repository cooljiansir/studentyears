<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <title>jQuery与Struts2的整合</title>
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <style type="text/css">
    body{font-size:13px}
    .divFrame{width:250px;border:solid 1px #666}
    .divFrame .divTitle{padding:5px;background-color:#eee}
    .divFrame .divContent{padding:8px}
    .divFrame .divContent .clsShow{font-size:14px}
    .btn{border:#666 1px solid;padding:2px;width:50px;
    filter:progid:DXImageTransform.Microsoft
    .Gradient(GradientType=0,StartColorStr=#ffffff,
    EndColorStr=#ECE9D8);}
    form{padding:0px;margin:0px}
    }
    </style>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
       $(function()
       {
           $("#Button1").click(function(){ 
              var mName=encodeURI($("#mname").val());
              var mPass=encodeURI($("#mpass").val());
              $.ajax(
              {
                  url:"ajax",
                  dataType:"jsp",
                  data:{mname:mName,
                       mpass:mPass},
                  success:function(strValue)
                  {
                     alert(strValue);
                     if(strValue=="true"){
                         $("#divTip").html("操作提示，登录成功！");
                     }else
                     {
                         $("#divTip").html("用户名或密码错误！");
                     }
                  }
              })
           })
       })
    </script>

  </head>
  <body>
    <div class="divFrame">
    <div class="divTitle">用户登录
    </div>
    <div class="divContent">
        <div id="divTip"></div>
        <div id="box">
            <form id="myForm">
               名称：<input type="text" id="mname" name="mname"/><br/>
               密码：<input type="password" id="mpass" name="mpass"/><br/>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <input id="Button1" type="button" class="btn" value="登录"/>
               &nbsp;
               <input id="Button2" type="reset" class="btn" value="取消"/>
            </form>
        </div>
    </div>
    </div>
    <br/>

    本网页显示的是通过$.ajax()方法向struts2.action传递数据，<br/>其中action中execute()方法返回为空，<br/>并通过【ServletActionContext.getResponse().getWriter().print(result);】 方法将数据传到jQuery中。

  </body>

</html>

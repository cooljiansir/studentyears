$(document).ready( function() {
	//使用 Ajax 的方式 判断登录
	$("#btn_login").click( function() {
		var url = 'json/jslogin.action';
		//var url = 'jslogin.action';                yekeyi
		//获取表单值，并以json的数据形式保存到params中
		var params = {
			username:$("#username").val(),
			password:$("#password").val()
		};
		//使用$.post方式	
		$.post(
			url,		//服务器要接受的url
			params,		//传递的参数		
			function cbf(data){	//服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据
			//alert(data);
			 var member = eval("("+data+")");    //包数据解析为json 格式
			//alert(member);
			if(member.name == "success"){
				alert("登录成功");
				 location.href="welclogin.jspome.jsp";
				}
			 else if(member.name == "error"){
				alert("用户名或密码错误");
				}
				else 
				alert("网络错误");										
			}, 
			'json'	//数据传递的类型  json
		);
	});
});
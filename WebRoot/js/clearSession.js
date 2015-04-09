$(document).ready( function() {
	//使用 Ajax 的方式 判断登录
	$("#logout").click( function() {
		var url = 'json/clearsession.action';
		//var url = 'jslogin.action';                yekeyi
		//获取表单值，并以json的数据形式保存到params中
		var params = {
			clear:"true"
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
				//alert("登录成功");
				location.href="index.jsp";
				}
			 else if(member.name == "error"){
				alert("clearsession error");
				}
				else 
				alert("clearsession 网络错误");										
			}, 
			'json'	//数据传递的类型  json
		);
	});
});
$(document).ready( function() {
	//alert($("#hiddenorderid").val()); 

	var url = 'json/personPictureShow.action';
	//var url = 'jslogin.action';                yekeyi
	//获取表单值，并以json的数据形式保存到params中
	var params = {
		user:$("#hiddenUserCenterUser").val()
	};
	//使用$.post方式	
	$.post(
		url,		//服务器要接受的url
		params,		//传递的参数		
		function cbf(data){	//服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据
			alert(data);
			var targets = "<img src=\"images/head3.jpg\"/>";

			var members = eval("("+data+")");    //包数据解析为json 格式
			//alert(member);
			alert(members[0].picturepath);

			document.getElementById("usercenterContainer").innerHTML =  targets;
		}, 
		'json'	//数据传递的类型  json
	);
});
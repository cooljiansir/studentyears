$(document).ready( function() {
		var url1 = 'json/querycollege.action';
		//var url = 'jslogin.action';                yekeyi
		//获取表单值，并以json的数据形式保存到params中
		var params1 = {
			location:"true"
		};
		//使用$.post方式	
		$.post(
			url1,		//服务器要接受的url
			params1,		//传递的参数		
			function cbf1(data){	//服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据
				var targets = "";
				var member = eval("("+data+")");    //包数据解析为json 格式
				//alert(member);
				//alert(member.length);
				var temp = "<img src=\"images/a.png\"/>";
				temp += member[0].name;
				temp += "<input type=\"hidden\" id=\"hiddencollege\" value=\""+member[0].name+"\"/>";
				document.getElementById("college_herf").innerHTML =  temp;
				for( var i = 0; i < member.length; i++) {
				     var members = member[i].name;  
				     targets += "<h5>"+members+"</h5>";
				}
				document.getElementById("college_downmenu").innerHTML =  targets;								
			}, 
			'json'	//数据传递的类型  json
		);
		
		var url2 = 'json/querycampus.action';
		//var url = 'jslogin.action';                yekeyi
		//获取表单值，并以json的数据形式保存到params中
		var params2 = {
			college:"中国科学院大学"
		};
		//使用$.post方式	
		$.post(
			url2,		//服务器要接受的url
			params2,		//传递的参数		
			function cbf2(data){	//服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据
				var targets = "";
				var member = eval("("+data+")");    //包数据解析为json 格式
				//alert($("#hiddencollege").val());
				//alert(member.length);
				document.getElementById("campus_herf").innerHTML =  member[0].name;
				for( var i = 0; i < member.length; i++) {
				     var members = member[i].name;  
				     targets += "<h5>"+members+"</h5>";
				}
				document.getElementById("campus_downmenu").innerHTML =  targets;								
			}, 
			'json'	//数据传递的类型  json
		);
});
$(document).ready( function() {
	//使用 Ajax 的方式 判断登录
	$("#test").click( function() {
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
				var target = "<div class=\"col-xs-6 col-sm-3 itemdiv\">";
				target += "<img src=\"" + "upload_image_folder/1451607278@qq.com/1451607278@qq.com16" + "/image0.jpg\" class=\"itemimg\"/>";
				target += "<div class=\"price\">￥"+"329"+"</div>"
				target += "<div class=\"pname\">"+"帅气时尚马甲"+"</div>";
				target += "<div class=\"loc\">"+"中科院大学 ● 怀柔校区"+"</div>";
				target += "</div>";
				document.getElementById("main").innerHTML =  target;
				var member = eval("("+data+")");    //包数据解析为json 格式
				//alert(member);
				if(member.name == "success"){
					//alert("登录成功");
					 //location.href="index.jsp";
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
	$("#searchinput").keyup(function(event){
		//alert("this is te"); 
		if(event.keyCode==13){
			var url = 'json/searchAll.action';
			//var url = 'jslogin.action';                yekeyi
			//获取表单值，并以json的数据形式保存到params中
			var params = {
				search:$("#searchinput").val()
			};
			//使用$.post方式	
			$.post(
				url,		//服务器要接受的url
				params,		//传递的参数		
				function cbf(data){	//服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据
				//alert(data);
					var targets = "";
					var member = eval("("+data+")");    //包数据解析为json 格式
					//alert(member);
					//alert(member.length);
					for( var i = 0; i < member.length; i++) {
					     var members = member[i];  
					     var target = "<div class=\"col-xs-6 col-sm-3 itemdiv\">";
					     target += "<a href=\"showdetail?goodsorderid="+members.goodsorderid+"\"><img src=\"" + members.picturepackage + "/image0.jpg\" class=\"itemimg\"/></a>";
					     target += "<div class=\"price\">￥"+members.price+"</div>"
					     target += "<div class=\"pname\">"+members.title+"</div>";
					     target += "<div class=\"loc\">"+members.college+"●"+ members.campus+"</div>";
					     target += "</div>";
					     
					     targets += target;
					}

					document.getElementById("main").innerHTML =  targets;
				}, 
				'json'	//数据传递的类型  json
			);}
	}); 
});
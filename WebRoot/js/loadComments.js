$(document).ready( function() {
	//alert($("#hiddenorderid").val()); 

	var url = 'json/showcomment.action';
	//var url = 'jslogin.action';                yekeyi
	//获取表单值，并以json的数据形式保存到params中
	var params = {
		goodsorderid:$("#hiddenorderid").val()
	};
	//使用$.post方式	
	$.post(
		url,		//服务器要接受的url
		params,		//传递的参数		
		function cbf(data){	//服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据
		//alert(data);
			var targets = "<div class=\"row\">";
			targets += "<div class=\"gleft\">";
			targets += "<div class=\"imgdiv\"><img src=\""+$("#hiddenheadpath").val()+"\" /></div>";
			targets += "<div class=\"imgrdiv\">";
			targets += $("#hiddenuserid").val();
			targets += "<div class=\"msg\">"+$("#hiddendescription").val()+"</div>";
			targets += "</div></div></div>";
			var member = eval("("+data+")");    //包数据解析为json 格式
			//alert(member);
			//alert(member.length);
			for( var i = 0; i < member.length; i++) {
			     var members = member[i];  
/*					 alert(members.goodsorderid);  
				     alert(members.title);  
				     alert(members.picturepackage);  */
			     if(members.commentator == $("#hiddenuserid").val())
			     {
					 var target = "<div class=\"row\">";
					 target += "<div class=\"gleft\">";
					 target += "<div class=\"imgdiv\"><img src=\""+members.picturepath+"\" /></div>";
					 target += "<div class=\"imgrdiv\">";
					 target += members.commentator;
					 target += "<div class=\"msg\">"+members.commentcontent+"</div>";
					 target += "</div></div></div>";
				     
				     targets += target;
			     }
			     else
			     {
					 var target = "<div class=\"row\">";
					 target += "<div class=\"gright\">";
					 target += "<div class=\"imgdiv\"><img src=\""+members.picturepath+"\" /></div>";
					 target += "<div class=\"imgrdiv\">";	
					 target += members.commentator;
					 target += "<div class=\"msg\">"+members.commentcontent+"</div>";
					 target += "</div></div></div>";
				     
				     targets += target;
			     }
			}

			document.getElementById("main2").innerHTML =  targets;
		}, 
		'json'	//数据传递的类型  json
	);
	$("#makecomment").click(function(){
		//alert($("#hiddenorderid").val()); 
		//alert($("#commentator").val());
		if($("#commentator").val() == "null")
		{
			//alert($("#commentator").val()); 
			alert("请先登录"); 
			return;
		}
		var url = 'json/makecomment.action';
		//var url = 'jslogin.action';                yekeyi
		//获取表单值，并以json的数据形式保存到params中
		var params = {
			goodsorderid:$("#hiddenorderid").val(),
			commentator:$("#commentator").val(),
			commentcontent:$("#commentcontent").val()
		};
		//使用$.post方式	
		$.post(
			url,		//服务器要接受的url
			params,		//传递的参数		
			function cbf(data){	//服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据
			alert($("#hiddenheadpath").val());
				var targets = "<div class=\"row\">";
				targets += "<div class=\"gleft\">";
				targets += "<div class=\"imgdiv\"><img src=\""+$("#hiddenheadpath").val()+"\" /></div>";
				targets += "<div class=\"imgrdiv\">";
				targets += $("#hiddenuserid").val();
				targets += "<div class=\"msg\">"+$("#hiddendescription").val()+"</div>";
				targets += "</div></div></div>";
				var member = eval("("+data+")");    //包数据解析为json 格式
				//alert(member);
				//alert(member.length);
				for( var i = 0; i < member.length; i++) {
				     var members = member[i];  
	/*					     alert(members.goodsorderid);  
					     alert(members.title);  
					     alert(members.picturepackage);  */
				     if(members.commentator == $("#hiddenuserid").val())
				     {
						 var target = "<div class=\"row\">";
						 target += "<div class=\"gleft\">";
						 target += "<div class=\"imgdiv\"><img src=\""+members.picturepath+"\" /></div>";
						 target += "<div class=\"imgrdiv\">";
						 target += members.commentator;
						 target += "<div class=\"msg\">"+members.commentcontent+"</div>";
						 target += "</div></div></div>";
					     
					     targets += target;
				     }
				     else
				     {
						 var target = "<div class=\"row\">";
						 target += "<div class=\"gright\">";
						 target += "<div class=\"imgdiv\"><img src=\""+members.picturepath+"\" /></div>";
						 target += "<div class=\"imgrdiv\">";
						 target += members.commentator;
						 target += "<div class=\"msg\">"+members.commentcontent+"</div>";
						 target += "</div></div></div>";
					     
					     targets += target;
				     }
				}
				document.getElementById("main2").innerHTML =  targets;
			}, 
			'json'	//数据传递的类型  json
		);
	}); 
});
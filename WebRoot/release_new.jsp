<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>


<!DOCTYPE html>
<html lang="fr_FR">
<head>
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
	
	<title>Student years</title>

	<meta charset="utf-8">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/headerfooter.css" rel="stylesheet">
	<script src="js/jquery.min.js" ></script>
	<script src="js/bootstrap.min.js" ></script>
	<script src="js/dropzone.js" ></script>
	<script type="text/javascript" src="js/clearSession.js"></script>
	<script type="text/javascript" src="js/collegequery.js"></script>
	<style >
		body{background: #f7faf9;}
		#releaseForm{border: 1px #e7e7e7 solid; padding: 40px 40px 40px 40px;background: white}
		.formlogo{width:150px;}
		.ginputfile{border:2px #e7e7e7 solid;border-radius: 50px; width: 100px;height: 100px;background: url(images/fileuploader.png) no-repeat center;background-size: 80px 80px;float: left;}
		.ginputfile:hover{border:2px #D06C5C solid;border-radius: 50px; width: 100px;height: 100px;background: url(images/fileuploader2.png) no-repeat center;background-size: 80px 80px;}
		.ginputfile input[type="file"]{opacity: 0;width: 100%;height: 100%;border: 1px solid red;}
		#previewdiv{height: 100px;border: 0px red solid;float: left;}
		#previewdiv img{width:100px;height: 100px;margin: 0 10px 0 10px;}
		#fileuploadrow{height: 120px;}
		.gdivider{border-top: 1px solid #e7e7e7;margin: 10px 0 10px 0;}
		.gpview{display: inline-block;height: 130px;}
	</style>
	

</head>
<body>
	<nav  id="navbarf"  class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div id="navbar" >
			<a href="index.jsp"><img src="images/logo_.png" id="toplogo"/> </a> 
			<div class="float-right" id="gnavbar-right">
				<div >
						<div class="float-right">
						<div id="releaseBut" >
							<a href="release_new.jsp"><img src="images/releaseBut.png"/>
								发布商品</a>
						</div>
						<input type="text" placeholder="搜索商品/分类" id="searchinput"/>
					</div>
				</div>
				<div >
					<div id="gnavbarmenu">
					<a class="hoverdown" href="#" id="college_herf"><img src="images/a.png"/>
					</a>
						<div class="downmenu">
							<div id="college_downmenu">
							</div>
						</div>
						> 
						<a href="#" class="hoverdown" id="campus_herf"></a> |
						<div class="downmenu">
							<div id="campus_downmenu">
							</div>
						</div>
<%
      if (session.getAttribute("username") == null) { //判断是否为新用户
      
%>
			<a href="#" id="registerBut">注册</a> |
			<a href="#" id="loginBut">登陆</a> 
<%
      }else{
%>
			<a href="#" class="hoverdown"><%=session.getAttribute("username")%></a>
			<div class="downmenu">
				<div>
					<h5>用户中心</h5>
					<h5>我的发布</h5>
					<h5>我的收藏</h5>
					<h5>通知</h5>
					<h5>退出</h5>
				</div>
			</div>
			<a href="#" id="logout">退出</a>
<%
      }
%>
						|
						<a href="aboutus.jsp">关于我们</a>
				</div>
				</div>
			</div>
			
        </div><!--/.nav-collapse -->
      </div>
    </nav>
	
	
	<div class="container">
		<div class="col-md-offset-2 col-md-8 block-center">
			<form class="form-horizontal" action="multiupload.action" method="post" id="releaseForm" enctype="multipart/form-data">
				<div class="form-group">
					<label class="col-sm-2 control-label">上传图片</label>
					<input name="image" type="file" multiple />
					<div class="col-sm-10" id="fileuploadrow">
						<div id="previewdiv">
<!--
							<div class="gpview">
								<img src="images/product1.jpg"/>
								<div class="progress">
									<div class="progress-bar">
								  </div>
								</div>
							</div>
							<div class="gpview">
								<img src="images/product1.jpg"/>
								<div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
								  </div>
								</div>
							</div>-->

						</div>
						<div class="ginputfile">
							<input id="fileSelect" name="fileSelect" class="fileSelect" type="file" multiple />
						</div>
					</div>
				</div>
				
			  <div class="row gdivider"></div>
		      
			  <div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">商品名</label>
				<div class="col-sm-10">
				  	<input name="title" class="form-control" id="inputEmail3" placeholder="不多于25字">
				</div>
			  </div>
			
			  <div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">商品描述</label>
				<div class="col-sm-10">
					<textarea name="description" class="form-control" rows="5" placeholder="建议填写物品用途、新旧程度、原价等信息，至少15个字"></textarea>
				</div>
			  </div>
				<div class="row gdivider"></div>
			  <div class="form-group">
				<label class="col-sm-2 control-label">交易地点</label>
				<div class="col-sm-6">
					<select name="tradelocation" class="form-control" >
						<option>中国科学院大学</option>
					</select>
				</div>
				<div class="col-sm-4">
					<select name="littlelocation" class="form-control" >
						<option>怀柔校区</option>
						<option>中关村校区</option>
						<option>玉泉路校区</option>
						<option>奥运村校区</option>
					</select>
				</div>
			  </div>
			  <div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">价格</label>
				<div class="col-sm-5">
					<input name="price" class="form-control" id="inputEmail3" placeholder="">
				</div>
			  </div>
			  <div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">新旧程度</label>
				<div class="col-sm-5">
					<input name="newpercent" class="form-control" id="inputEmail3" placeholder="">
				</div>
			  </div>
		      <div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">分类</label>
				<div class="col-sm-5">
					<select name="category" class="form-control" >
						<option>代步工具</option>
						<option>电子产品</option>
						<option>数码配件</option>
						<option>家用电器</option>
						<option>图书教材</option>
						<option>特色服务</option>
					</select>
				</div>
			  </div>
				
			  <div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">联系电话</label>
				<div class="col-sm-5">
					<input name="tel"  class="form-control" id="inputEmail3" placeholder="">
				</div>
			  </div>
  		      <div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">如何称呼您?</label>
				<div class="col-sm-5">
					<input name="name" class="form-control" id="inputEmail3" placeholder="王博士">
				</div>
			  </div>
			  <div class="form-group">
				<div class="col-sm-offset-2">
				  <div class="checkbox">
					  <input type="checkbox"/>同意<a href="#" id="agreeBut">平台使用协议</a>
				  </div>
				</div>
			  </div>
				<div class="row gdivider"></div>
				
			  <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">发布</button>
				</div>
			  </div>
			</form>
		</div>	
	</div><!-- container end-->
<!-- footer -->
	<div id="footer">
		
<!--		<img src="images/foot.png"/>-->
		<div class="text-center" id="footertext">
			2014-2015, Student Years © by <a href="#">果壳里的宇宙</a>
		</div>
	</div>
	<!-- Modal -->
		<div class="modal fade" id="rulesModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel"> 发布 须知</h4>
			  </div>
			  <div class="modal-body">
				  使用协议
			  </div>
			  <div class="modal-footer"></div>
			  
			</div>
		  </div>
		</div>
<script type="text/javascript"  src="js/studentyears.js"></script>
<script type="text/javascript" >
	$("#agreeBut").click(function(){
		$("#rulesModal").modal('show');
	});
	$("#fileSelect").change(function(){
		console.log("debug");
		if(this.files&&this.files[0]){
			var str = "<div class=\"gpview\"><img /><div class=\"progress\">"+
									"<div class=\"progress-bar\"></div></div></div>";
			$("#previewdiv").append(str);
			var reader = new FileReader();
			reader.onload = function(e){
				$("#previewdiv").find("img:last").attr("src",e.target.result);
			};
			reader.onprogress = function(pe){
				if(pe.lengthComputable){
					var r = Math.floor(100*(pe.total / pe.loaded));
					console.log("progress "+r);
					$("#previewdiv").find(".progress-bar:last").css("width",r+"%");
				}
			};
			reader.onloadend = function(pe){
				$("#previewdiv").find(".progress:last").hide();
			}
			reader.readAsDataURL(this.files[0])
		}
	});
	
</script>
</body>
</html>


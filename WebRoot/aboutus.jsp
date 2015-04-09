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
			<a href="index.jsp"><img src="images/logo_.png" id="toplogo"/>  </a>
			<div class="float-right" id="gnavbar-right">
				<div >
						<div class="float-right">
						<div id="releaseBut" >
							<a href="release.html"><img src="images/releaseBut.png"/>
								发布商品</a>
						</div>
						<input type="text" placeholder="搜索商品/分类" id="searchinput"/>
					</div>
				</div>
				<div >
					<div id="gnavbarmenu">
					<a href="#"><img src="images/a.png"/>中国科学院大学 </a>
						> 
						<a href="#" class="hoverdown">雁栖湖校区</a> |
						<div class="downmenu">
							<div>
								<h5>中关村校区</h5>
								<h5>雁栖湖校区</h5>
								<h5>玉泉路校区</h5>
								<h5>奥运村校区</h5>
							</div>
						</div>
						<a href="#" class="hoverdown"><%=session.getAttribute("username")%></a>
						<input type="hidden" id="hiddenUserCenterUser" value=<%=session.getAttribute("username")%>>
						<div class="downmenu">
							<div>
								<h5>用户中心</h5>
								<h5>我的发布</h5>
								<h5>我的收藏</h5>
								<h5>通知</h5>
								<h5>退出</h5>
							</div>
						</div>
						|
						<a href="#">关于我们</a>
				</div>
				</div>
			</div>
			
        </div><!--/.nav-collapse -->
      </div>
    </nav>
	
	
	<div class="container">
		<div class="col-md-offset-2 col-md-8 block-center">
				如果你懂网站前端、ios、android客户端开发，欢迎你加入我们<br>
				如果你有好的点子，欢迎加入我们<br>
				如果你想做校园代理，欢迎加入我们<br>
				<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">您的电话</label>
				<div class="col-sm-10">
				  	<input name="title" class="form-control" id="inputEmail3" placeholder="不多于25字">
				</div>
			  </div>
			  <div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">学校</label>
				<div class="col-sm-10">
				  	<input name="title" class="form-control" id="inputEmail3" placeholder="不多于25字">
				</div>
			  </div>
			  <div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">校区</label>
				<div class="col-sm-10">
				  	<input name="title" class="form-control" id="inputEmail3" placeholder="不多于25字">
				</div>
			  </div>
				<div class="form-group">
				<label class="col-sm-2 control-label">您感兴趣的方向</label>
				<div class="col-sm-6">
					<select name="littlelocation" class="form-control" >
						<option>技术</option>
						<option>创意</option>
						<option>校园代理</option>
					</select>
				</div>
			  </div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">提交</button>
				</div>
			  </div>
				<div class="col-sm-6">
					我们会在24小时之内回复您<br>
					电话：15110089886<br>
					QQ群号：450202667<br>
				</div>
			  </div>
				
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
<script type="text/javascript"  src="js/studentyears.js"/>
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


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
		#main{background: white;min-height: 300px;}
		.itemdiv{border: 1px solid #e7e7e7;height: 130px;}
		.itemdiv .imgdiv{width: 100px;float: left;}
		.itemdiv .imgdiv img{width:130px;}
		.itemdiv .imgrdiv{border: 1px solid;margin-left: 140px;}
	</style>

</head>
<body>
<nav  id="navbarf"  class="navbar navbar-default navbar-fixed-top">
  <div class="container">
	<div id="navbar" >
		<img src="images/logo_.png" id="toplogo"/>  
		<div class="float-right" id="gnavbar-right">
			<div id="releaseBut" >
				<a href="release.html"><img src="images/releaseBut.png"/>
					发布商品</a>
			</div>
			<input type="text" placeholder="搜索商品/分类" id="searchinput"/>
			<div id="gnavbarmenu">
				<a href="#"><img src="images/a.png"/>中国科学院大学 </a>
					> 
					<a href="#">雁栖湖校区</a> |
					<a href="#" id="registerBut">注册</a> |
					<a href="#" id="loginBut">登陆</a> |
					<a href="#">关于我们</a>
			</div>
		</div>
	</div><!--/.nav-collapse -->
  </div>
</nav>
<div id="main" class="container">
	<div class="col-md-10">
		<div class="itemdiv">
			<div class="imgdiv">
				<img src="images/product3.jpg"/>
			</div>
			<div class="imgrdiv">
				<h5>九五新2015款捷安特ATX620</h5>
				<h4>￥400</h4>
				<h5>本人骑行新手入门，最近收了辆14款770故低价转让骑了没几个月的15款620，捷安特入门级山地车，新款指拨，保养的很好，成色跟新车差不多，在学校代步或者骑着逛森林公园环东湖都挺好的，有意向的同学欢迎过来免费试骑，满意可小刀~</h5>
			</div>
		</div>
	</div>
</div>
	
<div id="footer">
<!--	<img src="images/foot.png"/>-->
	<div class="text-center" id="footertext">
		2014-2015, Student Years © by <a href="#">果壳里的宇宙</a>
	</div>
</div>
</body>
</html>


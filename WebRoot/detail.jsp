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
	<script src="js/studentyears.js"></script>
	<script type="text/javascript" src="js/clearSession.js"></script>
	<script type="text/javascript" src="js/loadComments.js"></script>
	<script type="text/javascript" src="js/loadPicture.js"></script>
	<script type="text/javascript" src="js/collegequery.js"></script>
	
	<style >
		body{background: #f7faf9;}
		#main{background: white;min-height: 300px;}
		#gphotodiv {border: 1px #e7e7e7 solid;margin: 20px 40px 20px 40px;}
		#gphotodiv img{width: 100%;}
		#gname{font-weight: bold;color: #777;font-size:19pt;display: inline-block;}
		#gpricediv{height: 50px;border:0px solid;}
		#addcollect{float: right;margin-top: 30px;}
		#smallimg img{width: 80px;border: 1px solid #e7e7e7;margin:0 10px 0 0;}
		.divider{border-top: 1px solid #e7e7e7;}
		#description{margin: 20px 70px 30px 70px;border: 1px solid #e7e7e7;}
		#main2{background: white;}
		.gleft{float: left;padding-left: 100px;}
		.gleft .imgdiv{width: 100px;float: left;}
		.gleft .imgdiv img{width: 80px;}
		.gleft .imgrdiv {max-width: 700px;margin-left: 110px;}
		.gleft .msg{border: 1px solid #e7e7e7;padding: 10px;}
		.gright{float: right;padding-right: 100px;}
		.gright .imgdiv{width: 100px;float: right;}
		.gright .imgdiv img{width: 80px;}
		.gright .imgldiv {max-width: 700px;margin-right: 110px;}
		.gright .msg{border: 1px solid #e7e7e7;padding: 10px;}
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
			<a href="#"><%=session.getAttribute("username")%></a>
			<a href="#" id="logout">退出</a>
<%
      }
%>|
					<a href="aboutus.jsp">关于我们</a>
			</div>
		</div>
	</div><!--/.nav-collapse -->
  </div>
</nav>
<div id="main" class="container">
	<div class="col-md-6">
		<div id="gphotodiv">
		</div>
	</div>
	<div class="col-md-6">
		<h2 id="gname"><s:property value='#request.title' />9成新 捷安特 自行车</h2><span class="collect" id="addcollect"><a href="favorite.jsp">加入收藏</a></span>
		<div id="gpricediv">
			<h3>价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;￥<s:property value='#request.price' /></h3>
		</div>
		<div class="divider"></div>
		<h4 class="text-center">浏览<s:property value='#request.viewtimes' />   留言7</h4>
		<div class="divider"></div>
		<h4>交易地点 <s:property value='#request.tradelocation' /></h4>
		<h4>卖家 <a href="#"><s:property value='#request.name' /></a></h4>
		<h4>联系电话<s:property value='#request.tel' /></h4>
		<h4>发布时间  <s:property value='#request.date' /></h4>
		<input id="hiddenorderid"  type="hidden" value=<s:property value='#request.goodsorderid' />>
		<input id="hiddenuserid"  type="hidden" value=<s:property value='#request.email' />>
		<input id="hiddendescription"  type="hidden" value=<s:property value='#request.description' />>
		<input id="hiddenpicturepackage" type="hidden" value=<s:property value='#request.picturepackage' />>
		<input id="hiddenheadpath" type="hidden" value=<s:property value='#request.picturepath'/>>
		分享到
		<!-- JiaThis Button BEGIN -->
		<div class="jiathis_style_32x32">
			<a class="jiathis_button_weixin"></a>
			<a class="jiathis_button_qzone"></a>
			<a class="jiathis_button_tsina"></a>
			<a class="jiathis_button_tqq"></a>
			<a class="jiathis_button_renren"></a>
			<a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
		</div>
		<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
		<!-- JiaThis Button END -->
		</br></br></br></br>
		<div id="smallimg">
		</div>
	</div>
</div>
<div class="container" id="main2">
	</div>
		<div class="container">
			<label for="inputPassword3" class="col-sm-2 control-label">发表评论</label>
			<div class="col-sm-10">
				<textarea id="commentcontent" class="form-control" rows="3" placeholder="此处省略一万字"></textarea>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="makecomment" class="btn btn-default">发表</button>
				</div>
			</div>
		</div>
		<input type="hidden" id="commentator" value=<%=session.getAttribute("username")%>>
<div id="footer">
<!--	<img src="images/foot.png"/>-->
	<div class="text-center" id="footertext">
		2014-2015, Student Years © by <a href="#">果壳里的宇宙</a>
	</div>
</div>
</body>
</html>

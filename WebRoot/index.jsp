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
	<script src="js/studentyears.js"></script>
	<script type="text/javascript" src="js/clearSession.js"></script>
	<script type="text/javascript" src="js/loadGoods.js"></script>
	<script type="text/javascript" src="js/collegequery.js"></script>
	<style >
		
		#allkinds{background: #3cc2a5;color: white;padding: 30px 0 0 15px;box-sizing: border-box;}
		.headersize{height: 80px;width: 110px;float:left;}
		.headeritem{padding: 10px 0 0 0;}
		.he1{background: #f8f8f8;}
		.he2{background: white;}
		#orderdiv{background: #f8f8f8;border-top:2px solid #3cc2a5;margin-top:15px; height: 30px;}
		#orderdiv a{color: gray;margin: 3px 0px 0 30px;}
		#orderdiv a.active{color:#D06C5C;}
		.formlogo{width: 100px;}
		#main .itemdiv{margin-top: 40px;}
		#main .itemimg{width: 242.5px;height: 242.5px;margin-bottom: 20px;}
		#main .price{font-size: 14pt; background: #e7e7e7; color: #D06C5C; height: 30px; width: 60px;margin:auto;border-radius: 4px;text-align: center;padding-top: 2px;}
		#main .pname{text-align: center;margin-top: 5px;margin-bottom: 0px;}
		#main .loc{text-align: center;margin-top: 5px;margin-bottom: 10px;}
		
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
			<a href="#"><%=session.getAttribute("username")%></a> |
			<a href="#" id="logout">退出</a>|
			<a href="usercenter.jsp" id="usercenter">用户中心</a>
			<a href="myrelease.jsp" id="favorate">收藏</a>
<%
      }
%>|
						<a href="aboutus.jsp">关于我们</a>
				</div>
				</div>
			</div>
			
        </div><!--/.nav-collapse -->
      </div>
    </nav>
   
    <div class="container" id="header123_">
		<div class="headersize" id="allkinds">
			所有分类<img src="images/b.png"/>
		</div>
		<div class="headersize he1 text-center headeritem">
			<img src="images/i11.png">
			<div >校园代步</div>
		</div>
		<div class="headersize he2 text-center headeritem">
			<img src="images/i21.png">
			<div >数码&amp;配件</br>手机/电脑/相机</div>
		</div>
		<div class="headersize he1 text-center headeritem">
			<img src="images/i31.png">
			<div >运动健身</div>
		</div>
		<div class="headersize he2 text-center headeritem">
			<img src="images/i41.png">
			<div >电器</br>冰箱/洗衣机</div>
		</div>
		<div class="headersize he1 text-center headeritem">
			<img src="images/i51.png">
			<div >生活娱乐</br>乐器/玩具</div>
		</div>
		<div class="headersize he2 text-center headeritem">
			<img src="images/i61.png">
			<div >图书教材</div>
		</div>
		<div class="headersize he1 text-center headeritem">
			<img src="images/i71.png">
			<div >衣服伞帽</div>
		</div>
		<div class="headersize he2 text-center headeritem">
			<img src="images/i81.png">
			<div >租赁</div>
		</div>
		<div class="headersize he1 text-center headeritem">
			<img src="images/i91.png">
			<div >其他</div>
		</div>
	</div> <!-- /container -->
	<div class="container"><!-- /container -->
		<div id="orderdiv">
			<a href="#" class="active">默认</a>
			<a href="#">热度<img src="images/c.png"></a>
			<a href="#">价格<img src="images/e.png"></a>
			<a href="#">发布时间<img src="images/c.png"></a>
		</div>
	</div><!-- /container end -->
	<div class="container" id="filterdowndiv_"><!-- containter -->
		
	</div>
	<div class="container"><!-- containter end -->
		<div  id="main">
			<div class="col-xs-6 col-sm-3 itemdiv">
				<img src="upload_image_folder/1451607278@qq.com/1451607278@qq.com16/image0.jpg" class="itemimg"/>
				<div class="price">￥329</div>
				<div class="pname">帅气时尚马甲</div>
				<div class="loc">中科院大学 ● 怀柔校区</div>
			</div>
			<div class="col-xs-6 col-sm-3 itemdiv">
				<img src="images/product1.jpg" class="itemimg"/>
				<div class="price">￥329</div>
				<div class="pname">神奇运动鞋</div>
				<div class="loc">中科院大学 ● 怀柔校区</div>
				
			</div>
			<div class="col-xs-6 col-sm-3 itemdiv">
				<img src="images/product2.jpg" class="itemimg"/>
				<div class="price">￥329</div>
				<div class="pname">神奇运动鞋</div>
				<div class="loc">中科院大学 ● 怀柔校区</div>
			</div>
			<div class="col-xs-6 col-sm-3 itemdiv">
				<img src="images/product3.jpg" class="itemimg"/>
				<div class="price">￥329</div>
				<div class="pname">神奇运动鞋</div>
				<div class="loc">中科院大学 ● 怀柔校区</div>
			</div>
			<div class="col-xs-6 col-sm-3 itemdiv">
				<img src="images/product3.jpg" class="itemimg"/>
				<div class="price">￥329</div>
				<div class="pname">神奇运动鞋</div>
				<div class="loc">中科院大学 ● 怀柔校区</div>
			</div>
			<div class="col-xs-6 col-sm-3 itemdiv">
				<img src="images/product4.jpg" class="itemimg"/>
				<div class="price">￥329</div>
				<div class="pname">神奇运动鞋</div>
				<div class="loc">中科院大学 ● 怀柔校区</div>
			</div>
			<div class="col-xs-6 col-sm-3 itemdiv">
				<img src="images/product5.jpg" class="itemimg"/>
				<div class="price">￥329</div>
				<div class="pname">神奇运动鞋</div>
				<div class="loc">中科院大学 ● 怀柔校区</div>
			</div>
			<div class="col-xs-6 col-sm-3 itemdiv">
				<img src="images/product6.jpg" class="itemimg"/>
				<div class="price">￥329</div>
				<div class="pname">神奇运动鞋</div>
				<div class="loc">中科院大学 ● 怀柔校区</div>
			</div>
			<div class="col-xs-6 col-sm-3 itemdiv">
				<img src="images/product7.jpg" class="itemimg"/>
				<div class="price">￥329</div>
				<div class="pname">神奇运动鞋</div>
				<div class="loc">中科院大学 ● 怀柔校区</div>
			</div>
			<div class="col-xs-6 col-sm-3 itemdiv">
				<img src="images/product8.jpg" class="itemimg"/>
				<div class="price">￥329</div>
				<div class="pname">神奇运动鞋</div>
				<div class="loc">中科院大学 ● 怀柔校区</div>
			</div>
			<div class="col-xs-6 col-sm-3 itemdiv">
				<img src="images/product9.jpg" class="itemimg"/>
				<div class="price">￥329</div>
				<div class="pname">神奇运动鞋</div>
				<div class="loc">中科院大学 ● 怀柔校区</div>
			</div>
			<div class="col-xs-6 col-sm-3 itemdiv">
				<img src="images/product10.jpg" class="itemimg"/>
				<div class="price">￥329</div>
				<div class="pname">神奇运动鞋</div>
				<div class="loc">中科院大学 ● 怀柔校区</div>
			</div>
		</div>
	</div>
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-sm">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel"> 登 陆 </h4>
			  </div>
			  <div class="modal-body">
				  <div class="text-center">
					  <img class="formlogo" src="images/headlogo.png"/>
				  </div>
				  <form class="form-horizontal" action="login" method="post" namespace="/">
					  <div class="form-group">
						<div class="col-sm-12">
						  <input name="username" type="email" class="form-control" id="inputEmail3" placeholder="邮箱">
						</div>
					  </div>
					  <div class="form-group">
						<div class="col-sm-12">
						  <input name="password" type="password" class="form-control" id="inputPassword3" placeholder="密码">
						</div>
					  </div>
					  <div class="form-group">
						<div class="col-sm-12 text-center">
						  <div class="checkbox">
							<label>
							  <input type="checkbox">记住密码
							</label>
						  </div>
						</div>
					  </div>
					  <div class="form-group">
						<div class="col-sm-12 text-center">
						  <button type="submit" class="btn btn-default">登陆</button>
						</div>
					  </div>
					</form>  
			  </div>
			  <div class="modal-footer"></div>
			  
			</div>
		  </div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-sm">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel"> 注 册 </h4>
			  </div>
			  <div class="modal-body">

				  
				  <div class="text-center">
					  <img class="formlogo" src="images/headlogo.png"/>
				  </div>

				  <form class="form-horizontal" action="regist" method="post" namespace="/">
					  <div class="form-group">
						<div class="col-sm-12">
						  <input name="email" type="email" class="form-control" id="inputEmail3" placeholder="邮箱">
						</div>
					  </div>
					  <div class="form-group">
						<div class="col-sm-12">
						  <input name="password" type="password" class="form-control" id="inputPassword3" placeholder="密码">
						</div>
					  </div>
					  <div class="form-group">
						<div class="col-sm-12">
						  <input name="password-con" type="password" class="form-control" id="inputPassword3" placeholder="确认密码">
						</div>
					  </div>
					  <div class="form-group">
						<div class="col-sm-12">
<!--						  <input type="email" class="form-control" id="inputEmail3" placeholder="学校">-->
							  <select name="college" class="form-control" >
								<option value="0">请选择学校</option>  
								<option value="中国科学院大学">中国科学院大学</option>
							  </select>
						</div>
					  </div>
					  <div class="form-group">
						<div class="col-sm-12">
						  <select name="campus" class="form-control" >
							<option value="0">请选择校区</option>
							<option value="1">怀柔校区</option>
							<option value="2">中关村校区</option>
							<option value="3">玉泉路校区</option>
							<option value="4">奥运村校区</option>
			  			  </select>
						</div>
					  </div>
					  <div class="form-group">
						<div class="col-sm-12 text-center">
						  <button type="submit" class="btn btn-default">注册</button>
						</div>
					  </div>
					</form>
			  </div>
			  <div class="modal-footer"></div>
			  
			</div>
		  </div>
		</div>
		
	</div>
	
<script type="text/javascript"  src="js/studentyears.js"></script>
</body>
</html>


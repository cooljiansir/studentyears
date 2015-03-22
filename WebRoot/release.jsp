<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
	
	<title>Student years</title>

	<meta charset="utf-8">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery.min.js" ></script>
	<script src="js/bootstrap.min.js" ></script>
	<script src="js/dropzone.js" ></script>
	<style >
		body{padding-top: 75px;color: #888}
		#navbarf{background: white;border: none;}
		#navbar {border-bottom: 1.5px solid #e7e7e7; padding: 10px 0 5px 0;}
		#toplogo{height: 50px;margin-top: 0;}
		#toplogotxt{color: #D06C5C;font-weight: 900;font-size: 14pt;}
		#postnav{}
		.divider{border-left: 1px #e7e7e7 solid;}
		#header1{border-bottom: 1.5px solid #e7e7e7;height: 140px;}
		#head1right {border: 1px ;overflow: hidden;}
		#head1right h1{color:#777;}
		#head1right h3{color:#AAA;}
		#header1 img{height: 130px;margin-right: 40px;}
		#typemenu{border-right: #e7e7e7 1px solid;height: 30px;}
		#fadingaway{height: 47px !important; width: 190px;margin:0 0 0 20px !important;padding: 0}
		#searchinput{height: 40px;margin-top: 45px;}
		#searchbut{margin:45px 0 0 -2px;height:40px;}
		#header2 img{height: 30px;width: 30px;}
		#header2{border-bottom: 1.5px solid #e7e7e7;padding: 15px 0 15px 0;height: 60px;}
		#dropdownmenu{margin-top: 5px;}
		#filterdiv{border-right: #e7e7e7 1px solid;height: 30px;}
		#countdiv{height: 30px;}
		#countdiv span{margin-top: 5px;}
		#dropdownfilter{margin-top: 5px;}
		#main .itemdiv{margin-top: 40px;}
		#main .itemimg{width: 242.5px;height: 242.5px;margin-bottom: 20px;}
		#main .price{font-size: 14pt; background: #e7e7e7; color: #D06C5C; height: 30px; width: 60px;margin:auto;border-radius: 4px;text-align: center;padding-top: 2px;}
		#main .loc{text-align: center;margin-top: 20px;margin-bottom: 10px;}
		.text-center{text-align: center}
		.formlogo{width:150px;}
	</style>

</head>
<body>
   <nav  id="navbarf"  class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div id="navbar"  class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
			<li><img id="toplogo" src="images/year.png"/></li>
            <li><a href="#" id="toplogotxt">STUDENTYEARS</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
			<li><a href="#" id="releaseBut"><span id="postnav">上传</span></a></li>  
			<li><a href="../navbar/"><span class="divider"></span></a></li>
            <li><a href="#" id="registerBut">注册</a></li>
			<li><a href="../navbar/"><span class="divider"></span></a></li>
			<li ><a href="#" id="loginBut">登陆 <span class="sr-only">(current)</span></a></li>
			<li><a href="../navbar/"><span class="divider"></span></a></li>
            <li><a href="../navbar-static-top/">关于我们</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <div class="container">
		<div id="header1">
			<div class="col-xs-12 col-sm-6">
				<img id="headerlogo" src="images/headlogo.png" class="pull-left img-responsive" alt="Responsive image"/>
				<div id="head1right">
					<h1>匆匆那年<img id="fadingaway" src="images/fadingaway.png"/></h1>
					<h3>把你不要的给我，把你想要的拿去</h3>
				</div>
			</div>
			<div class="col-xs-12 col-sm-6">
				<input id="searchinput" type="text" class="col-md-10 col-xs-10"/>
				<button id="searchbut" class="btn btn-default">搜一搜</button>
			</div>
		</div>
		
    </div> <!-- /container -->
	<div class="container">
		<div class="col-md-offset-2 col-md-7 block-center">
			 
			
			<form class="form-horizontal " action="#" method="post" id="releaseForm" enctype="multipart/form-data">
			 
    		  <input name="image" type="file" multiple />
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
			  <div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">交易地点</label>
				<div class="col-sm-5">
					<select name="tradelocation" class="form-control" >
						<option>中国科学院大学</option>
					</select>
				</div>
				<div class="col-sm-5">
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
				<div class="col-sm-offset-2">
				  <div class="checkbox">
					  <input type="checkbox"/>同意<a href="#" id="agreeBut">平台使用协议</a>
				  </div>
				</div>
			  </div>
			  <div class="form-group"><!--
				<div class="col-sm-offset-2 col-sm-10">
				  <button id="releaseBut"  class="btn btn-default">发布</button>
				</div>
				--><div class="col-sm-offset-2 col-sm-10">
				  <!--<a id="releaseBut" href="#" name="releaseBut" >发布</a>
				--></div>
				
			  </div>
			</form>
		</div>
		
	</div><!-- container end-->
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
<script type="text/javascript" >
	$("#agreeBut").click(function(){
		$("#rulesModal").modal('show');
	});
	$("#releaseBut").click(function(){
		$("#rulesModal").modal('show');
	});
	/*$("#releaseBut").click(function(){
		console.log("debug");
		//alert("debug");
	});*/
	/*alert("debug");
		$.ajax({     
		    url:'multiupload.action',     
		    type:'post',     
		    data:$('#releaseForm').serialize(),// 你的formid
		    async : true, //默认为true 异步     
		    error:function(){     
		       alert('error');     
		    },     
		    success:function(data){     
		       alert("OK");    
		    }  
		});
	});*/
	
</script>
</body>
</html>


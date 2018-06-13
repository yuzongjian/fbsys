<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>海洋局数据库</title>
	<link rel="shortcut icon" href="images/user.png" />
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/global.css"/>
	<link rel="stylesheet" type="text/css" href="css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="css/nav.css"/>
	<link rel="stylesheet" type="text/css" href="css/error.css"/>

	<style type="text/css">
		.error span img{
			left:70px;
		}
	</style>
</head>
<body>
	<!-- 导航栏 -->
	<div class="nav border-box">
		<div class="user">
			<img src="images/tlogo.jpg">

			<div class="disnone"><a href="javascript:;">注销</a></div>
		</div>
		<span>钟嘉华</span>
		<ul>
			<!-- 海域数据 -->
			<li>
				<a class="list" href="map#"><i class="fa fa-play-circle-o"></i></a>

				<ul>
					<li>海域数据</li>					
				</ul>
			</li>

			<!-- 数据监控 -->
			<li>
				<a class="list" href="statistics#"><img src="images/camera.png"></a>

				<ul>
					<li>数据监控</li>					
				</ul>
			</li>

			<!-- 统计查询 -->
			<li>
				<a class="list" href="visualization#"><i class="fa fa-bar-chart"></i></a>

				<ul>
					<li>统计查询</li>					
				</ul>
			</li>

			<!-- 报警设置 -->
			<li>
				<a class="list" href="alarm#"><i class="fa fa-cog"></i></a>

				<ul>
					<li>报警设置</li>					
				</ul>
			</li>

			<!-- 日志详情 -->
			<li>
				<a class="list" href="log#"><i class="fa fa-file"></i></a>

				<ul>
					<li>日志详情</li>
				</ul>
			</li>

			<!-- 浮标管理 -->
			<li>
				<a class="list" href="buoy#"><i class="fa fa-map-marker"></i></a>

				<ul>
					<li>浮标管理</li>
				</ul>
			</li>

			<!-- 用户管理 -->
			<li>
				<a class="list" href="users#"><i class="fa fa-user"></i></a>

				<ul>
					<li>用户管理</li>
				</ul>
			</li>
		</ul>
		<div class="logo-box">
			<img src="images/user.png">
		</div>
	</div>
	<div class="nav-box">
	</div>

	<div class="error">
		<img src="images/cloud.png"/>
		<span class="ha"><img src="images/a.png"></span>
		<p>抱歉！
		<br>您没有权限访问这个页面</p>
	</div>

	<script src="js/jq.min.js"></script>
	<script type="text/javascript" src="js/jq.min.js"></script>
	<script type="text/javascript" src="js/nav.js"></script>
	<script>
		$(".error").css({'marginTop':($(window).height()-300)/2+'px'});
	</script>
</body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="refresh" content="1800">
	<title>海洋局数据库</title>
	<link rel="shortcut icon" href="images/user.png" />
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/global.css"/>
	<link rel="stylesheet" type="text/css" href="css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="css/bmap.css"/>
	<link rel="stylesheet" type="text/css" href="css/map.css"/>
	<link rel="stylesheet" type="text/css" href="css/nav.css"/>
</head>
<body>
	<div id="container"></div>
	
	<!-- 导航栏 -->
	<div class="nav border-box">
		
		<shiro:authenticated>  
		<div class="user">
			<img src="images/tlogo.jpg">

			<div class="disnone"><a href="logout#">注销</a></div>
		</div>
			<span><shiro:principal/></span>
		</shiro:authenticated>  
		
		<ul>
			<!-- 海域数据 -->
			<li>
				<a class="list active" href="map#"><i class="fa fa-play-circle-o"></i></a>

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

	<div class="btn-box">
		<ul class="btn">
			<li><a href="javascript:;" class="a-btn">风速</a></li>
			<li><a href="javascript:;" class="a-btn">海流</a></li>
			<li><a href="javascript:;" class="a-btn active">水温</a></li>
		</ul>
	</div>

	<div class="bar">
		<ul class="serious">
			<li>76-100</li>
			<li>51-75</li>
			<li>26-50</li>
			<li>0-25</li>
		</ul>

		<ul class="color">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>

		<div class="clear">
		</div>
	</div>

	<!-- 右侧悬浮框 -->
	<div class="detail" id="detail">
		<a id="close" href="javascript:;" title="关闭"><i class="fa fa-close fa-lg"></i></a>
		
		<p id="fubiao">浮标<span id='buoy'></span>号（<span></span>）</p>
		<div class="time">
			<div>
				<a href="javascript:preOrNextTime(1);"><img src="images/leftWhite.png"></a>
				<span id='time'>现在</span>
				<a href="javascript:preOrNextTime(0);"><img src="images/rightWhite.png"></a>
			</div>
		</div>

		<div>
			<div class="detail-box">
				<div class="a-box">
					<a href="javascript:;" class="alert border-box active">详细数据</a>
					<a href="javascript:;" class="alert">状态</a>
				</div>

				<div class="table">
					<div class="detail-data">
						<table>
							<tr>
								<td>最大风速</td>
								<td id='windSpeedMax'></td>
							</tr>
							<tr>
								<td>最大风向</td>
								<td id='windSpeedJito'></td>
							</tr>
							<tr>
								<td>最大波高</td>
								<td id='wHighMax'></td>
							</tr>
							<tr>
								<td>最大波向</td>
								<td id='wTo'></td>
							</tr>
							<tr>
								<td>流速</td>
								<td id='cSpeed1'></td>
							</tr>
							<tr>
								<td>流向</td>
								<td id='cTo1'></td>
							</tr>
							<tr>
								<td>水温</td>
								<td id='wqWattemp'></td>
							</tr>
							<tr>
								<td>气温</td>
								<td id='wAirtemp'></td>
							</tr>
						</table>
					</div>

					<div class="log">
						<table>
							<tr>
								<td>舱门</td>
								<td id='bDoorpolice'></td>
							</tr>
							<tr>
								<td>舱盖</td>
								<td id='bHatch'></td>
							</tr>
							<tr>
								<td>舱进水</td>
								<td id='bWatpolice'></td>
							</tr>
							<tr>
								<td>移位</td>
								<td id='bShift'></td>
							</tr>
							<tr>
								<td>电压</td>
								<td id='bVoltage'></td>
							</tr>
							<tr>
								<td>方位</td>
								<td id='bBearing'></td>
							</tr>
							<tr>
								<td>锚灯</td>
								<td id='bRidlight'></td>
							</tr>
							<tr>
								<td>剩余空间</td>
								<td id='bFree'></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 获取点击的label -->
	<div id="label-contents" class="disnone">
	</div>

	<script type="text/javascript" src="js/apiv1.3.min.js"></script>
	<script type="text/javascript" src="js/AreaRestriction_min.js"></script>
	<script src="js/jq.min.js"></script>
	<script src="js/map.js"></script>
	<script src="js/mapJq.js"></script>
	<script src="js/nav.js"></script>
</body>
</html>
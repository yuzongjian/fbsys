<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path=request.getContextPath(); %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
	<title>浮标管理</title>
	<link rel="shortcut icon" href="images/user.png" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/global.css"/>
	<link rel="stylesheet" type="text/css" href="css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="css/nav.css"/>
	<link rel="stylesheet" type="text/css" href="css/float.css"/>
</head>
<body>
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
				<a class="list active" href="buoy#"><i class="fa fa-map-marker"></i></a>

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

	<!-- 浮标管理 -->
	<div class="container border-box box">
		<p class="border-box">浮标管理</p>

		<div>
			<div class="setting">
				<button class="setting-btn" href="javascript:;"><i class="fa fa-cog"></i><span>设置</span></button>
				<a href="javascript:;" class="refresh disnone">取消</a>

				<div class="setting-box disnone">					
					<a class="increase-btn" href="javascript:;">增加站位号</a>
					<a class="delete-btn" href="javascript:;">删除站位号</a>
				</div>

				<div class="clear">
				</div>
			</div>

			<table id="table">
				<tr>
					<th>站位号</th>
					<th>浮标编号</th>
					<th>经纬度</th>
					<th>操作</th>
				</tr>
				<!-- <tr>
					<td>1</td>
					<td>001</td>
					<td>W19°12' N19°12'</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>2</td>
					<td>002</td>
					<td>W19°12' N19°12'</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>3</td>
					<td>003</td>
					<td>W19°12' N19°12'</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>4</td>
					<td>004</td>
					<td>W19°12' N19°12'</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>5</td>
					<td class="fubiao">005</td>
					<td>W19°12' N19°12'</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>6</td>
					<td>006</td>
					<td>W19°12' N19°12'</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>7</td>
					<td>007</td>
					<td>W19°12' N19°12'</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>8</td>
					<td>008</td>
					<td>W19°12' N19°12'</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>9</td>
					<td>009</td>
					<td>W19°12' N19°12'</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>10</td>
					<td>010</td>
					<td>W19°12' N19°12'</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>11</td>
					<td>011</td>
					<td>W19°12' N19°12'</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>12</td>
					<td>012</td>
					<td>W19°12' N19°12'</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr> -->
			</table>
		</div>
	</div>

	<div class="clear">
	</div>

	<div class="dask disnone">
	</div>
	<div class="increase-float border-box disnone">
		<p><span>增加浮标</span></p>
		<form>
			<p>站位号：<span></span></p>
			<input type="text" class="border-box zhanwei" placeholder="请输入站位号">
			<input type="text" class="border-box fubiao-num" placeholder="请输入浮标编号">
			<input type="text" class="border-box location jing" placeholder="请输入经度">
			<span class="jing-ex"></span>
			<input type="text" class="border-box location wei margintop" placeholder="请输入纬度">
			<span class="wei-ex"></span>
			<textarea class="border-box on text margintop" rows="8" placeholder="请输入备注"></textarea>
			<input type="button" class="submit" value="确定">
		</form>
	</div>

	<div class="error">
		<p><img src="images/ku.png">请正确填写输入框</p>
	</div>
 
	<script type="text/javascript" src="js/jq.min.js"></script>
	<script type="text/javascript" src="js/nav.js"></script>
	<script type="text/javascript" src="js/float.js"></script>
	<script type="text/javascript">
		$(function(){
			$.ajax({
			    url:'<%=request.getContextPath()%>/buoy/getall',
			    type:'POST', 
			    async:false,  
			    timeout:5000,   
			    dataType:'json',   
			    beforeSend:function(xhr){
			        console.log(xhr)
			        console.log('发送前')
			    },
			    success:function(data,textStatus,jqXHR){
			        console.log(data)
			        console.log(textStatus)
			        console.log(jqXHR)
			        if(data.type==0) {
			        	alert(data.message);
			        	return;
			        }
			        if(data.type==2) {
			        	alert(data.message);
			        	return;
			        } 
			        var stations = data.sysdata.stations;
			        //alert(stations[0].sBuoyid);
                     //移除之前表格所有内容
			     	$('#table tr').remove();
			     	var v = "<tr><th>站位号</th><th>浮标编号</th><th>经纬度</th><th>操作</th></tr>";
			     	$("#table").append(v);
			     	var id = stations[1].sId;
			        for (var i = 0; i < stations.length; i ++) {
			        	var id = stations[i].sId;
			        	var stationid = stations[i].sStation;
			        	var date = stations[i].date;
			        	var active = stations[i].sActive;
			        	var describe = stations[i].sDescribe;
			        	var buoyid = stations[i].sBuoyid;
			        	var jing_ = locationChange(7,stations[i].sLongitude);
			        	var wei_ = locationChange(6,stations[i].sLatitude);
			        	var LL = "E"+jing_+" N"+wei_;
			        	var v = "<tr><td hidden='true' class=tag>"+active+"</td><td hidden='true' class=tag>"+id+"</td><td hidden='true' class=tag>"+date+"</td><td hidden='true' class=tag>"+describe+"</td><td class=tag>"+stationid+"</td>"+
			        	"<td class=tag>"+buoyid+"</td><td class=tag>"+LL+"</td><td><a class='modify-btn' href='javascript:;'>修改</a></td></tr>";
			        	$('#table').append(v);
			        } 
			        
			    },
			    error:function(xhr,textStatus){
			        console.log('错误')
			        console.log(xhr)
			        console.log(textStatus)
			    },
			    complete:function(){
			        console.log('结束')
			    }
			})
		})
		
	</script>
</body>
</html>
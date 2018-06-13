<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path=request.getContextPath(); %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
	<title>用户管理</title>
	<link rel="shortcut icon" href="images/user.png" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/global.css"/>
	<link rel="stylesheet" type="text/css" href="css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="css/nav.css"/>
	<link rel="stylesheet" type="text/css" href="css/float.css"/>
	<link rel="stylesheet" type="text/css" href="css/user.css"/>
	<link rel="stylesheet" type="text/css" href="css/page.css"/>
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
		<span hidden="true" id="nowuser"><shiro:principal/></span>
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
				<a class="list" href="buoy#"><i class="fa fa-map-marker"></i></a>

				<ul>
					<li>浮标管理</li>
				</ul>
			</li>

			<!-- 用户管理 -->
			<li>
				<a class="list active" href="users#"><i class="fa fa-user"></i></a>

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
		<p class="border-box">用户管理</p>

		<div>
			<div class="setting">
				<button class="setting-btn" href="javascript:;"><i class="fa fa-cog"></i><span>设置</span></button>
				<a href="javascript:;" class="refresh disnone">取消</a>

				<div class="setting-box disnone">					
					<a class="increase-btn" href="javascript:;">增加用户</a>
					<a class="delete-btn" href="javascript:;">删除用户</a>
				</div>

				<div class="clear">
				</div>
			</div>

			<table id="table">
				<tr>
					<th>管理员姓名</th>
					<th>管理员账号</th>
					<th>权限设置</th>
					<th>添加时间</th>
					<th>角色状态</th>
					<th>操作</th>
				</tr>
				<!-- <tr>
					<td>张三</td>
					<td>001</td>
					<td><span>查看地图、日志</span><span>导出日志</span><span>导出数据</span></td>
					<td>2016-5-6</td>
					<td>启用</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>2</td>
					<td>002</td>
					<td><span>查看地图、日志</span><span>导出数据</span></td>
					<td>2016-5-6</td>
					<td>启用</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>3</td>
					<td>003</td>
					<td><span>查看地图、日志</span><span>导出日志</span></td>
					<td>2016-5-6</td>
					<td>启用</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>4</td>
					<td>004</td>
					<td><span>导出日志</span><span>导出数据</span></td>
					<td>2016-5-6</td>
					<td>启用</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>5</td>
					<td class="fubiao">005</td>
					<td><span>报警设置</span><span>导出日志</span><span>导出数据</span></td>
					<td>2016-5-6</td>
					<td>启用</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>6</td>
					<td>006</td>
					<td><span>查看地图、日志</span><span>导出日志</span><span>浮标管理</span></td>
					<td>2016-5-6</td>
					<td>启用</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>7</td>
					<td>007</td>
					<td><span>查看地图、日志</span><span>导出日志</span><span>导出数据</span></td>
					<td>2016-5-6</td>
					<td>启用</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>8</td>
					<td>008</td>
					<td><span>查看地图、日志</span><span>导出日志</span><span>导出数据</span></td>
					<td>2016-5-6</td>
					<td>启用</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>9</td>
					<td>009</td>
					<td><span>查看地图、日志</span><span>导出日志</span><span>导出数据</span></td>
					<td>2016-5-6</td>
					<td>启用</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>10</td>
					<td>010</td>
					<td><span>查看地图、日志</span><span>导出日志</span><span>导出数据</span></td>
					<td>2016-5-6</td>
					<td>启用</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr>
				<tr>
					<td>11</td>
					<td>011</td>
					<td><span>查看地图、日志</span><span>导出日志</span><span>导出数据</span></td>
					<td>2016-5-6</td>
					<td>启用</td>
					<td>
						<a class="modify-btn" href="javascript:;">修改</a>
					</td>
				</tr> -->
			</table>

			<div class="page">
				<a href="javascript:;" id='first'>首页</a>
				<a href="javascript:;" id='previous'>上一页</a>
				<span id='pageno'>1</span>/
				<span id='pageCount'>3</span>
				<a href="javascript:;" id='next'>下一页</a>
				<a href="javascript:;" id='last'>尾页</a>
				转到<input type="text" id='jumppage'>页
				<input type="submit" value="确定" id='jump'/>
			</div>
			<div class="page-box">
			</div>

			<div class="clear">
			</div>
		</div>
	</div>

	<div class="clear">
	</div>

	<div class="dask disnone">
	</div>
	<div class="increase-float border-box disnone">
		<p><span>增加浮标</span></p>
		<form>
			<p>管理员：<span></span></p>
			<input type="text" class="border-box zhanwei" placeholder="请输入管理员姓名">
			<input type="text" class="border-box fubiao-num" placeholder="请输入管理员账号">
			<input type="password" class="border-box" class='pwd' placeholder="请输入6-16位密码">
			<div class="status">
				<span>角色状态</span>
				<label><input type="radio" name="status" checked><span>启用</span></label>
				<label><input type="radio" name="status"><span>禁用</span></label>
			</div>
			<div class="right">
				<span>权限管理</span>
				<table id="permissions">
					<!-- <tr>
						<td><label><input type="checkbox" name="right"><span>查看地图、日志</span></label></td>
						<td><label><input type="checkbox" name="right"><span>导出日志</span></label></td>
						<td><label><input type="checkbox" name="right"><span>导出数据</span></label></td>
					</tr>
					<tr>
						<td><label><input type="checkbox" name="right"><span>用户管理</span></label></td>
						<td><label><input type="checkbox" name="right"><span>浮标管理</span></label></td>
						<td><label><input type="checkbox" name="right"><span>报警设置</span></label></td>
					</tr> -->
				</table>
			</div>

			<textarea class="border-box on text" rows="6" placeholder="请输入备注"></textarea>
			<input type="button" class="submit" value="确定">
		</form>
	</div>

	<div class="error">
		<p><img src="images/ku.png"><span>输入框不能为空</span></p>
	</div>
 
	<script type="text/javascript" src="js/jq.min.js"></script>
	<script type="text/javascript" src="js/nav.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
	<script type="text/javascript">
		$(function(){
			getData(1);
		})
		$('#first').click(function(){
			var now = parseInt($('#pageno').text());
			if (now == 1) return;
			var pageno = 1;
			clickToPage(pageno);
		})
		$('#last').click(function(){
			var last = parseInt($('#pageCount').text());
			var now = parseInt($('#pageno').text());
			if (now == last) return;
			getData(last);
		})
		$('#previous').click(function(){
			var now = parseInt($('#pageno').text());
			var previous = now - parseInt(1);
			if (previous < 1) return;
			getData(previous);
		})
		$('#next').click(function(){
			var last = parseInt($('#pageCount').text());
			var next = parseInt($('#pageno').text()) + parseInt(1);
			if (next > last) return;
			getData(next);
		})
		$('#jump').click(function(){
			var jpage = parseInt($('#jumppage').val());
			var last = parseInt($('#pageCount').text());
			var now =           ($('#pageno').text());
			if (jpage == now) return;
			if (jpage > last) {
				alert("该页不存在!");
				return;
			}
			if (jpage < 1) {
				alert("页数必须大于1!");
				return;
			}
			getData(jpage);
		})
		function getData(pageno) {
			$.ajax({
			    url:'<%=request.getContextPath()%>/users/getusers',
			    type:'POST', 
			    async:false,  
			    timeout:5000,   
			    dataType:'json',
			    data:{
			    	pageno:pageno
			    },
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
			        var users = data.sysdata.users;
                     //移除之前表格所有内容
			     	$('#table tr').remove();
			     	var v = "<tr><th>管理员姓名</th><th>账号</th><th>权限</th><th>添加时间</th><th>角色状态</th><th>操作</th></tr>";
			     	$("#table").append(v);
			     	//var id = stations[1].sId;
			        for (var i = 0; i < users.length; i ++) {
			        	var id = users[i].id;
			        	var locked = users[i].locked;
			        	if (locked == 0) {
			        		locked = '启用';
			        	}else {
				        	locked = '禁用';
			        	}
			        	var date = users[i].date;
			        	var realname = users[i].realname;
			        	var username = users[i].username;
			        	var isdelete = users[i].deleted;
			        	if (isdelete == false) {
			        		isdelete = 0;
			        	}else {
			        		isdelete = 1;
			        	} 
			        	var permissions = users[i].permissions;
			        	var description="";
			        	var descriptionId = [];
			        	for (var j = 0; j < permissions.length;j++) {
			        		description += "<span>"+permissions[j].description+"</span> ";
			        		descriptionId.push(permissions[j].id);
			        	}
			        	var v = "<tr><td class=tag>"+realname+"</td>"+              //真实姓名
			        	"<td class=tag>"+username+"</td>"							//用户名
			        	+"<td class=tag>"+description+"</td>"						//描述
			        	+"<td class=tag>"+date+"</td>"								//日期
			        	+"<td class=tag>"+locked+"</td>"							//是否锁定
			        	+"<td><a class='modify-btn' href='javascript:;'>修改</a></td>" //操作
			        	+"<td hidden='true' class=tag>"+id+"</td>"					//id
			        	+"<td hidden='true' class=tag>"+descriptionId+"</td>"			//权限id
			        	+"<td hidden='true' class='tag'></td>"         
			        	+"<td hidden='true' class='tag'>"+isdelete+"</td>"			//是否删除
			        	+"<td hidden='true' class='tag'>0</td>"
			        	+"<td hidden='true' class=tag>  </td></tr>";
			        	$('#table').append(v);
			        } 
			        var permissions = data.sysdata.permissions;
		        	//$("#permissions tr").remove();
		        	$("#permissions tr").remove();
		        	var tr=$("<tr></tr>");
		        	for (var i = 0; i < permissions.length; i++) {
		        	    
		        		if (i % 3 == 0) {
		        			tr=$("<tr></tr>");
		        			$("#permissions").append(tr);
		        		}
		        		var desc = permissions[i].description;
		        		var descId = permissions[i].id;
		        		var td=$("<td><label><input type='checkbox' name='right'  value='"+descId+"'><span>"+desc+"</span></label></td>");
		        		tr.append(td);
		        	}
		        	 $('#pageno').text(data.sysdata.page.pageNo);
				     $('#pageCount').text(data.sysdata.page.pageCount);
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
		}
	</script>
</body>
</html>
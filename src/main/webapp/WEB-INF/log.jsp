<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path=request.getContextPath(); %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>日志查询</title>
	<link rel="shortcut icon" href="images/user.png" />
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/global.css"/>
	<link rel="stylesheet" type="text/css" href="css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="css/nav.css"/>
	<link rel="stylesheet" type="text/css" href="css/log.css"/>
	<link rel="stylesheet" type="text/css" href="css/download.css"/>
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
				<a class="list active" href="log#"><i class="fa fa-file"></i></a>

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

	<div class="container border-box box">
		<div class="head">
			<p class="border-box">
				日志查询
				<span>
					<input value="请输入日期" class="laydate-icon" onclick="laydate()">	
					至
					<input value="请输入日期" class="laydate-icon to" onclick="laydate()">	
					事件类型
					<select id='type'>
						<option value="1">报警日志</option>
						<option value="2">浮标管理日志</option>
						<option value="3">用户管理日志</option>
					</select>
					<input type="submit" value="查询" id='query'>			
				</span>
			</p>
		</div>

		<div class="table-box">
			<table id="table">
				<tr>
					<th>事件标题</th>
					<th>事件时间</th>
					<th>事件说明</th>
				</tr>
				<!-- <tr>
					<td>浮标异常</td>
					<td>2016-7-10 12:30</td>
					<td>事件说明事件说明事件说明事件说明</td>
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
				<input type="submit" value="确定" id="jump"/>
			</div>
			<div class="page-box">
			</div>

			<div class="clear">
			</div>
		</div>

		<!-- 切换数据导出模式 -->
		<div class="change-box">
			<a href="javascript:;" class="change download border-box">日志导出模式</a>

			<div class="choose-box disnone">
				<input value="请输入日期" class="laydate-icon" id='from' onclick="laydate()">
				<span>至</span>
				<input value="请输入日期" class="laydate-icon" id='to' onclick="laydate()">
					
				<a href="javascript:;" class="choose-all"><img src="images/choose-empty.png">导出所有类型</a>
				<input type="submit" class="download-data" value="导出日志" onclick="exportdata();"/>
				<a href="javascript:;" class="choose-table">导出年/季度/月/日日志</a>
			</div>
		</div>
	</div>

	<div class="dask disnone">
	</div>
	<div class="table-type border-box disnone">
		<div class="btn-box">
			<a href="javascript:;" class="active table-btn">日日志</a>
			<a href="javascript:;" class="table-btn">季度日志</a>
			<a href="javascript:;" class="table-btn">月日志</a>
			<a href="javascript:;" class="table-btn">年日志</a>
		</div>

		<div class="type">
			<div class="type-box">
				<form>
					<input value="请输入日期" class="laydate-icon to" onclick="laydate()">	
					<br />
					<input type="submit" value="导出日报表" onclick="exportByDay();">	
				</form>		
			</div>

			<div class="type-box">
				<form>
					<select id='quarter'>
						<option>第一季度</option>
						<option>第二季度</option>
						<option>第三季度</option>
						<option>第二季度</option>
					</select>	
					<br />
					<input type="submit" value="导出日日志" onclick="exportByQuarter();">	
				</form>		
			</div>

			<div class="type-box">
				<form>
					<input type="text" placeholder="请输入年份" id='year2'>
					<span>年</span>
					<select id='month'>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
					</select>
					<span>月</span>
					<input type="submit" value="导出月日志" onclick="exportByMonth();">	
				</form>		
			</div>

			<div class="type-box">
				<form>
					<input type="text" placeholder="请输入年份" id='year'>
					<span>年</span>	
					<input type="submit" value="导出年日志" onclick="exportByYear();">	
				</form>		
			</div>

			<div class="clear">
			</div>
		</div>
	</div>

	<script src="js/jq.min.js"></script>
	<script src="js/nav.js"></script>
	<script src="js/log.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/download.js"></script>
	<script src="js/laydate/laydate.js"></script>
	<script>
		;!function(){

		laydate.skin('danlan');

		laydate({
		   elem: '#demo'
		})

		}();
	</script>
	<script type="text/javascript">
	$(function(){
		var pageno = 1;
		fromDay = $('.laydate-icon').val("");
		toDay = $('.laydate-icon.to').val("");
		var type = $("#type").val();
		getData(pageno,undefined,undefined,type);
		if($.cookie("type")) {
			$("#type").val($.cookie("type"));
			clickToPage(1);
		}
		
	})
    //window.setInterval(alarm,1000); 
	
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
		clickToPage(last);
	})
	$('#previous').click(function(){
		var now = parseInt($('#pageno').text());
		var previous = now - parseInt(1);
		if (previous < 1) return;
		clickToPage(previous);
	})
	$('#next').click(function(){
		var last = parseInt($('#pageCount').text());
		var next = parseInt($('#pageno').text()) + parseInt(1);
		if (next > last) return;
		clickToPage(next);
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
		clickToPage(jpage);
	})
	
	$("#query").click(function(){
		clickToPage(1);
	})
	
	/* function alarm() {
		alert("alarm");
	}
	 */
	function clickToPage(pageno) {
		var type = $("#type").val();
		var fromDay = $('.laydate-icon').val();
		var toDay = $('.laydate-icon.to').val();
		if (fromDay=="请输入日期"||fromDay==""||fromDay == undefined||fromDay==null) {
			fromDay = undefined;
		}
		if (toDay=="请输入日期"||toDay==""||toDay == undefined||toDay == null) {
			toDay = undefined;
		}
		$.cookie("type",type);
		if (!panduan(fromDay,toDay)) return; 
		getData(pageno,fromDay,toDay,type);
	}
	
	function panduan(fromDay,toDay) {
		if (fromDay != undefined && toDay == undefined) {
				alert("请输入结束日期!");
				return false;
		}
		if (fromDay == undefined && toDay != undefined) {
			alert("请输入起始日期!");
			return false;
		}
		if (typeof(fromDay) != undefined && typeof(toDay) != undefined) {
			if (toDay < fromDay) {
				alert("起始日期必须大于结束日期!");
				return false;
			}
		}
		return true;
	}
	
	function getData(pageno,from,to,type) {
		$.ajax({
		    url:'<%=request.getContextPath()%>/log/getall',
		    type:'POST', 
		    async:false,  
		    timeout:5000,   
		    data:{
		    	pageno:pageno,
		    	fromDay:from,
		    	toDay:to,
		    	type:type
		    },
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
		        var logs = data.sysdata.logs;
		        //alert(logs.length)
                 //移除之前表格所有内容
		     	$('#table tr').remove();
		     	var v = "<tr><th>事件标题</th><th>事件时间</th><th>事件说明</th></tr>";
		     	$("#table").append(v);
		        for (var i = 0; i < logs.length; i ++) {
		        	//var id = logs[i].id;
		        	//alert("aa");
		        	var date = logs[i].date;
		        	var details = logs[i].details;
		        	var summary = logs[i].summary;
		        	var v = "<tr><td>"+summary+"</td><td>"+date+"</td><td>"+details+"</td></tr>";
		        	$('#table').append(v);
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
	
	function exportdata() {
		var from = $("#from").val();
		var to = $("#to").val();
		if (from=="请输入日期"||from==""||from == undefined||from==null) {
			from = undefined;
			alert("请输入起始日期");
			return;
		}
		
		if (to=="请输入日期"||to==""||to == undefined||to == null) {
			to = undefined;
			alert("请输入结束日期");
			return;
		}
		if (typeof(from) != undefined && typeof(to) != undefined) {
			if (to < from) {
				alert("起始日期必须大于结束日期!");
				return;
			}
		}
		var type = $("#type").val();
		//alert(type);
		var all = 0;
		if($(".choose-all").hasClass('active')) {
			all = 1;
		}
		var url="<%=request.getContextPath() %>/log/export?"; 
		window.open(url+"&day1="+from+"&day2="+to+"&type="+type+"&all="+all+"&param=1"); 
		return;
	}
	function exportByDay() {
		var from = $("#day").val();
		//alert(from);
		if (from=="请输入日期"||from==""||from == undefined||from==null) {
			from = undefined;
			alert("请输入日期"); 
			return;
		}
		var type = $("#type").val();
		//alert(type);
		var all = 0;
		if($(".choose-all").hasClass('active')) {
			all = 1;
		}
		var url="<%=request.getContextPath() %>/log/export?"; 
		window.open(url+"&day1="+from+"&type="+type+"&all="+all+"&param=2"); 
		return;
	}
	function exportByQuarter() {
		var quarter = $("#quarter").val();
		var myDate = new Date();
		var now = myDate.getMonth(); //获取当前月份(0-11,0代表1月)
		//alert(now);
		var temp = (parseInt(quarter)-1)*3+parseInt(quarter);
		if (temp > (parseInt(now)-1)) {
			alert("该季度没有数据");
			return;
		}
		var type = $("#type").val();
		var all = 0;
		if($(".choose-all").hasClass('active')) {
			all = 1;
		}
		var url="<%=request.getContextPath() %>/log/export?"; 
		window.open(url+"&day1="+quarter+"&type="+type+"&all="+all+"&param=3"); 
		return;
	}
	function exportByMonth() {
		var year = $("#year2").val();
		if(!checkNum(year)) return;
		var month = $("#month").val();
		var type = $("#type").val();
		var all = 0;
		if($(".choose-all").hasClass('active')) {
			all = 1;
		}
		alert(year+month);
		var url="<%=request.getContextPath() %>/log/export?"; 
		window.open(url+"&day1="+year+"&day2="+month+"&type="+type+"&all="+all+"&param=4"); 
		return;
	}
	function exportByYear() {
		var year = $("#year").val();
		if(!checkNum(year)) return;
		var type = $("#type").val();
		var all = 0;
		if($(".choose-all").hasClass('active')) {
			all = 1;
		}
		var url="<%=request.getContextPath() %>/log/export?"; 
		window.open(url+"&day1="+year+"&type="+type+"&all="+all+"&param=5"); 
		return;
	} 
	function checkNum(num)  
    {  
        //验证必须是数字  
        if(isNaN(num))  
        {  
            alert("请输入数字！");  
            return false;  
        }  
        if(num == "")  
        {  
            alert("您的输入年份!");  
            return false;  
        } 
        //验证必须是4位  
        if(num.match(/\d/g).length!=4)  
        {  
            alert("您的输入必须为4位数字!");  
            return false;  
        }  
        
        if(num.match(/\d/g).length>4)  
        {  
            alert("您的输入超过了4位数字!");  
            return false;  
        }  
        if(num.match(/\d/g).length<4)  
        {  
            alert("您的输入不足4位数字!");  
            return false;  
        }  
        return true;
    }   
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String path=request.getContextPath(); %>
 <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>海洋局数据库</title>
	<link rel="shortcut icon" href="images/user.png" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/global.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/nav.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/visualization.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/download.css"/>
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
				<a class="list active" href="visualization#"><i class="fa fa-bar-chart"></i></a>

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

	<div class="container border-box box">
		<div class="statistics">
			<div class="head">
				<p class="border-box">
					数据查询表
					<span>
						<input value="请输入日期" class="laydate-icon" onclick="laydate()">	
						至
						<input value="请输入日期" class="laydate-icon to" onclick="laydate()">	
						<input type="submit" value="确定" onclick="showbyday();">			
					</span>
				</p>
			</div>

			<!-- 折线图 -->
			<div class="zhexian border-box">
				<span id='name'>风速</span>
				<div id="zhexian"></div>
			</div>

			<!-- 选择属性 -->
			<div class="feature box">
				<div class="feature-box border-box qixiangdeng">
					<p>
						<span class="qixiang span" num="0">气象</span>
						<span class="shuiwen span" num="1">水文</span>
						<span class="hailiu span" num="2">海流</span>
					</p>

					<div>
						<a class="factor-btn first" href="javascript:changeShow('w_airpre','weather','气压');" id="w_airpre"><img src="<%=path %>/images/hpa.png"><span>气压</span></a>
						<a class="factor-btn" href="javascript:changeShow('w_airtemp','weather','气温');"id="w_airtemp"><img src="<%=path %>/images/temperature.png"><span>气温</span></a>
						<a class="factor-btn" href="javascript:changeShow('w_oppohumi','weather','湿度');" id="w_oppohumi"><img src="<%=path %>/images/wet.png"><span>湿度</span></a>
					</div>
					<div>
						<a class="first factor-btn" href="javascript:changeShow('wq_wattemp','waterquality','水温');" id="wq_wattemp"><img src="<%=path %>/images/temperature.png"><span>水温</span></a>
						<a class="factor-btn" href="javascript:changeShow('wq_salinity','waterquality','盐度');" id="wq_salinity"><img src="<%=path %>/images/sault.png"><span>盐度</span></a>
						<a class="factor-btn" href="javascript:changeShow('wq_conductivity','waterquality','电导率');" id="wq_conductivity"><img src="<%=path %>/images/ele.png"><span>电导率</span></a>
					</div>
					<div>
						<a class="first last factor-btn" href="javascript:changeShow('c_speed1','current','流速');" id="c_speed1"><img src="<%=path %>/images/water-speed.png"><span>流速</span></a>
						<a class="factor-btn last" href="javascript:changeShow('c_to1','current','流向');" id="c_to1"><img src="<%=path %>/images/wind.png"><span>流向</span></a>
					</div>
					<div class="clear">
					</div>
				</div>

				<div class="feature-box border-box bo">
					<p><span class="span" num="0">波</span></p>

					<div>
						<a class="first factor-btn" href="javascript:changeShow('w_high_max','wave','最大波高');" id="w_high_max"><img src="<%=path %>/images/bo.png"><span>最大波高</span></a>
						<a class="factor-btn" href="javascript:changeShow('w_high_tenth','wave','1/10波高');" id="w_high_tenth"><img src="<%=path %>/images/bo.png"><span>1/10波高</span></a>
						<a class="factor-btn" href="javascript:changeShow('w_high_effective','wave','有效波高');" id="w_high_effective"><img src="<%=path %>/images/bo.png"><span>有效波高</span></a>
						<a class="factor-btn first" href="javascript:changeShow('w_high_average','wave','平均波高');" id="w_high_average"><img src="<%=path %>/images/bo.png"><span>平均波高</span></a>
						<a class="factor-btn" href="javascript:changeShow('w_cycle_max','wave','最大波周期');" id="w_cycle_max"><img src="<%=path %>/images/bo.png"><span>最大波周期</span></a>
						<a class="factor-btn" href="javascript:changeShow('w_cycle_tenth','wave','1/10波周期');" id="w_cycle_tenth"><img src="<%=path %>/images/bo.png"><span>1/10波周期</span></a>
						<a class="first last factor-btn" href="javascript:changeShow('w_cycle_effective','wave','有效波周期');" id="w_cycle_effective"><img src="<%=path %>/images/bo.png"><span>有效波周期</span></a>
						<a class="factor-btn last" href="javascript:changeShow('w_cycle_average','wave','平均波周期');" id="w_cycle_average"><img src="<%=path %>/images/bo.png"><span>平均波周期</span></a>
						<a class="factor-btn last" href="javascript:changeShow('w_to','wave','波向');" id="w_to"><img src="<%=path %>/images/wind.png"><span>波向</span></a>
					</div>

					<div class="clear">
					</div>
				</div>

				<div class="feature-box border-box wind">
					<p><span class="span" num="0">风</span></p>

					<div>
						<a class="first factor-btn" href="javascript:changeShow('wind_speed_max','wind','最大风速');" id="wind_speed_max"><img src="<%=path %>/images/wind-speed.png"><span>最大风速</span></a>
						<a class="factor-btn" href="javascript:changeShow('wind_speed_ji','wind','极大风速');" id="wind_speed_ji"><img src="<%=path %>/images/wind-speed.png"><span>极大风速</span></a>
						<a class="factor-btn" href="javascript:changeShow('wind_speed_instant','wind','瞬时风速');" id="wind_speed_instant"><img src="<%=path %>/images/wind-speed.png"><span>瞬时风速</span></a>
						<a class="first factor-btn" href="javascript:changeShow('wind_speed_ten','wind','平均风速');" id="wind_speed_ten"><img src="<%=path %>/images/wind-speed.png"><span>平均风速</span></a>
						<a class="factor-btn" href="javascript:changeShow('wind_speed_maxto','wind','最大风向');" id="wind_speed_maxto"><img src="<%=path %>/images/wind.png"><span>最大风向</span></a>
						<a class="factor-btn" href="javascript:changeShow('wind_speed_jito','wind','极大风向');" id="wind_speed_jito"><img src="<%=path %>/images/wind.png"><span>极大风向</span></a>
						<a class="factor-btn first last" href="javascript:changeShow('wind_to_instant','wind','瞬时风向');" id="wind_to_instant"><img src="<%=path %>/images/wind.png"><span>瞬时风向</span></a>
						<a class="last factor-btn" href="javascript:changeShow('wind_speed_tento','wind','平均风向');" id="wind_to_instant"><img src="<%=path %>/images/wind.png"><span>平均风向</span></a>
					</div>

					<div class="clear">
					</div>
				</div>

				<div class="clear">
				</div>
			</div>

			<!-- 切换数据导出模式 -->
			<div class="change-box">
				<a href="javascript:;" class="change download border-box">数据导出模式</a>

				<div class="choose-box disnone">
					<input value="请输入日期" class="laydate-icon" id="exportFrom" onclick="laydate()">
					<span>至</span>
					<input value="请输入日期" class="laydate-icon" id="exportTo" onclick="laydate()">
					
					<a href="javascript:;" class="choose-all"><img src="<%=path %>/images/choose-empty.png">导出所有属性</a>
					<input type="submit" class="download-data" value="导出数据" onclick="exportdata();"/>
					<a href="javascript:;" class="choose-table">导出年/季度/月/日报表</a>
				</div>

				<div class="clear"></div>
			</div>
		</div>
	</div>

	<div class="clear">
	</div>

	<div class="zhexian-box disnone">
		<a href="javascript:;" class="close-expand"><i class="fa fa-remove"></i></a>
		<div id="expand-zhexian">
		</div>
	</div>

	<div class="dask disnone">
	</div>
	<div class="table-type border-box disnone">
		<div class="btn-box">
			<a href="javascript:;" class="active table-btn">日报表</a>
			<a href="javascript:;" class="table-btn">季度报表</a>
			<a href="javascript:;" class="table-btn">月报表</a>
			<a href="javascript:;" class="table-btn">年报表</a>
		</div>

		<div class="type">
			<div class="type-box">
				<form>
					<input value="请输入日期" class="laydate-icon to" id="day" onclick="laydate()">	
					<br />
					<input type="submit" value="导出日报表" onclick="exportByDay();">	
				</form>			
			</div>

			<div class="type-box">
				<form>
					<select id="quarter">
						<option value="1">第一季度</option>
						<option value="2">第二季度</option>
						<option value="3">第三季度</option>
						<option value="4">第四季度</option>
					</select>		
					<br />
					<input type="submit" value="导出季度报表" onclick="exportByQuarter()">	
				</form>		
			</div>

			<div class="type-box">
				<form>
					<input type="text" id="year2" placeholder="请输入年份">
					<span>年</span>
					<select id="month">
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
					<input type="submit" value="导出月报表" onclick="exportByMonth();">		
				</form>		
			</div>

			<div class="type-box">
				<form>
					<input type="text" placeholder="请输入年份"  id="year">
					<span>年</span>	
					<input type="submit" value="导出年报表" onclick="exportByYear();">		
				</form>		
			</div>

			<div class="clear">
			</div>
		</div>
	</div>
	<input type="hidden" id="param1" value="wind_speed_instant">
	<input type="hidden" id="param2" value="wind">
	<input type="hidden" id="param3" value="瞬时风速">
	<script src="<%=path %>/js/jq.min.js"></script>
	<script src="<%=path %>/js/echarts.min.js"></script>
	<script src="<%=path %>/js/nav.js"></script>
	<script src="<%=path %>/js/visualization.js"></script>
	<script src="<%=path %>/js/download.js"></script>
	<script src="<%=path %>/js/laydate/laydate.js"></script>
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
			show('wind_speed_instant','wind','瞬时风速',undefined,undefined);
			$(".head").css({'width':$(window).width()-140+'px'});
		});
		function exportByDay() {
			var from = $("#day").val();
			if (from=="请输入日期"||from==""||from == undefined||from==null) {
				from = undefined;
				alert("请输入日期");
				return;
			}
			var k = initparams();
			var url="<%=request.getContextPath() %>/visualization/exportdatas?data="; 
			window.open(url+k+"&day1="+from+"&param=4");
			return;
		}
		
		function exportByQuarter() {
			var quarter = $("#quarter").val();
			var myDate = new Date();
			var now = myDate.getMonth(); //获取当前月份(0-11,0代表1月)
			var temp = (parseInt(quarter)-1)*3+parseInt(quarter);
			if (temp > (parseInt(now)-1)) {
				alert("该季度没有数据");
				return;
			}
			var k = initparams();
			var url="<%=request.getContextPath() %>/visualization/exportdatas?data="; 
			window.open(url+k+"&day1="+quarter+"&param=3");
			return;
		}
		
		function exportByMonth() {
			var year = $("#year2").val();
			if(!checkNum(year)) return;
			var month = $("#month").val();
			var k = initparams();
	        var url="<%=request.getContextPath() %>/visualization/exportdatas?data="; 
			window.open(url+k+"&day1="+year+"&day2="+month+"&param=2");
			return;
		}
		function exportByYear() {
			var year = $("#year").val();
			//alert(year);
			if(!checkNum(year)) return;
			var k = initparams();
			<%-- var url="<%=request.getContextPath() %>/visualization/exportbyyear?data="; 
			window.open(url+k+"&year="+year); --%>
			var url="<%=request.getContextPath() %>/visualization/exportdatas?data="; 
			window.open(url+k+"&day1="+year+"&param=5");
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
		function initparams() {
			var k = [];
			//初始化浮标属性
			k.push("b_longitude");
			k.push("b_latitude");
			k.push("b_watpolice");
			k.push("b_doorpolice");
			k.push("b_shift");
			k.push("b_hatch");
			k.push("b_bearing");
			k.push("b_voltage");
			k.push("b_ridlight");
			k.push("b_free");
			$(".choose-factor a.active").each(function () {
			    //$(this).find('span').each(function() {
			   	k.push($(this).attr('id'));
			    //});
			 });
			return k;
		}
		
		function exportdata(){
			var from = $("#exportFrom").val();
			var to = $("#exportTo").val();
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
			var k = initparams();
	        var url="<%=request.getContextPath() %>/visualization/exportdatas?data="; 
			window.open(url+k+"&day1="+from+"&day2="+to+"&param=1");
			
		}
		
		function changeShow(param1,param2,param3) {
			var fromDay = $('.laydate-icon').val();
			var toDay = $('.laydate-icon.to').val();
			if (fromDay=="请输入日期"||fromDay==""||fromDay == undefined||fromDay==null) {
				fromDay = undefined;
			}
			if (toDay=="请输入日期"||toDay==""||toDay == undefined||toDay == null) {
				toDay = undefined;
			}
			if (typeof(fromDay) != undefined && typeof(toDay) != undefined) {
				if (toDay < fromDay) {
					alert("起始日期必须大于结束日期!");
					return;
				}
			}
			show(param1,param2,param3,fromDay,toDay);
		}
		
		function showbyday() {
			var fromDay = $('.laydate-icon').val();
			var toDay = $('.laydate-icon.to').val();
			if (fromDay=="请输入日期"||fromDay==""||fromDay == undefined||fromDay==null) {
				alert("请选择起始日期");
				return;
				//fromDay = undefined;
			}
			if (toDay=="请输入日期"||toDay==""||toDay == undefined||toDay == null) {
				//toDay = undefined;
				alert("请选择结束日期");
				return;
			}
			if (typeof(fromDay) != undefined && typeof(toDay) != undefined) {
				if (toDay < fromDay) {
					alert("起始日期必须大于结束日期!");
					return;
				}
			} 
			var param1 = $('#param1').val();
			var param2 = $('#param2').val();
			var param3 = $('#param3').val();
			show(param1,param2,param3,fromDay,toDay);
		}
		
		function show(param1,param2,param3,fromDay,toDay) {
			//记录展示的属性
			$('#param1').val(param1);
			$('#param2').val(param2);
			$('#param3').val(param3);
			$("#name").text(param3);
			$.ajax({
			    url:'<%=request.getContextPath()%>/visualization/show',
			    type:'POST', //GET
			    async:false,    //或false,是否异步
			    data:{
			    	field:param1,
			        table:param2,
			        fromDay:fromDay,
			        toDay:toDay
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    beforeSend:function(xhr){
			        console.log(xhr)
			        console.log('发送前')
			    },
			    success:function(data,textStatus,jqXHR){
			        console.log(data)
			        console.log(textStatus)
			        console.log(jqXHR)
			        //alert(data.data.length);
			        if(data.type==0) {
			        	alert(data.message);
			        	return;
			        } 
			       // alert(data.sysdata.buoys);
			        var k = [];
			        for(var i = 0; i < data.sysdata.data.length; i++) {
			        	var temp = data.sysdata.data[i];
			        	var t = temp.split(",");
			        	//alert(t);
			        	//alert(temp); 
			        	k.push(t);
			        }  
			        var buoys = data.sysdata.buoys;
			        var time = data.sysdata.time.split(",");
			        zhexian(document.getElementById('zhexian'),time,k,buoys);
			        zhexian(document.getElementById('expand-zhexian'),time,k,buoys);
			        
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
		
		// 折线图
		function zhexian(obj,time,k,buoys){
			//alert(k[0]);
		    var myChart = echarts.init(obj);
		    		    var series=[];
		    for(var i = 0; i < k.length;i++){
		    	series.push({name:buoys[i],type: 'line',data:k[i]});
			}     
		    // 指定图表的配置项和数据
		    var date=[];
		    var max=240;
		    var min=0;
		    date[0]=min;
	    	for(var i=1;i<24;i++){
		        date.push((max-min)/24*i);
		    }
	    	
		    var option = {
		        tooltip: {
		            trigger: 'axis'
		        },
		        legend:{
		            data: buoys
		        },
		        xAxis: {
		            type: 'category',
		            boundaryGap: false,
		            data: time, 
		        },
		        yAxis: {},
		        series:series,
		        dataZoom: [{
		            type: 'slider',
		            start: 0,
		            end: 30,
		        }],
		    };
		    if ($('#param1').val() == 'w_airpre') {
	    		/* for(var i=1;i<10;i++){
	    			ydata.push((1200-800)/5 *i);
			    } */
	    		option.yAxis.max = 995;
	    		option.yAxis.min = 1015;
	    		option.yAxis.splitNumber = 5;
	    	} 
		    // 使用刚指定的配置项和数据显示图表。
		    myChart.setOption(option);
		}
		
	</script>
</body>
</html>
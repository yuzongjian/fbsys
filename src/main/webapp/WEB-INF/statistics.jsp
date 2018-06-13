<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<% String path=request.getContextPath(); %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="refresh" content="1800">
	<title>海洋局数据库--数据实时显示</title>
	<link rel="shortcut icon" href="images/user.png" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/global.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/nav.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/statistics.css"/>
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
				<a class="list " href="map#"><i class="fa fa-play-circle-o"></i></a>

				<ul>
					<li>海域数据</li>					
				</ul>
			</li>

			<!-- 数据监控 -->
			<li>
				<a class="list active" href="statistics#"><img src="images/camera.png"></a>

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

	<div class="container border-box box">

		<div class="operate">
			<div class="choose">
				<div class= "choose-btn choose-btn-station zhanwei border-box">
					<ul class="down-box" id="station">
						<!-- <li><a href="javascript:;" class="down-list">11</a></li> -->
					</ul>

					<div>
						<label>
						站位号：
						<span id='zhanweihao'>${statistics.station}</span>
						</label>
						<a href="javascript:;" class="down-btn"><i class="fa fa-caret-down"></i></a>
					</div>
				</div>

				<%-- <div class="choose-btn">
					<span id="buoyId">浮标：${statistics.bBuoyid }</span>
				</div> --%>
				
				<div class="choose-btn choose-btn-buoy fubiao border-box">
					<ul class="down-box" id="fubiaolist">
						<li><a href="javascript:;" class="down-list">11</a></li>
						<li><a href="javascript:;" class="down-list">111</a></li>
						<li><a href="javascript:;" class="down-list">1</a></li>
						<li><a href="javascript:;" class="down-list">11</a></li>
						<li><a href="javascript:;" class="down-list">111</a></li>
						<li><a href="javascript:;" class="down-list">1</a></li>
						<li><a href="javascript:;" class="down-list">11</a></li>
						<li><a href="javascript:;" class="down-list">111</a></li>
						<li><a href="javascript:;" class="down-list">1</a></li>
					</ul>

					<div>
						<label>
							浮标：
							<span id="buoyId">${statistics.bBuoyid }</span>
						</label>
						<a href="javascript:;" class="fubiao-btn"><i class="fa fa-caret-down"></i></a>
					</div>
				</div>

				<div class="calendar choose-btn choose-btn-time">
					<ul class="down-box" id="checkbox">
						<!-- <li><a href="javascript:;" class="down-list">2017 1-12 23:55</a></li> -->
					</ul>

					<div>
						<%-- <a href="javascript:last();" class="last-time"><i class="fa fa-caret-left"></i></a>
						<a href="javascript:;" class="year" >${statistics.time }</a>
						<a href="javascript:next();" class="next-time"><i class="fa fa-caret-right"></i></a>

						<div class="clear">
						</div> --%>
						<label>
							<span class="year" >${statistics.time }</span>
						</label>
						<a href="javascript:;" class="down-btn"><i class="fa fa-caret-down"></i></a>
					</div>
				</div>

				<input value="请输入日期" class="laydate-icon" id="planStartTime" onclick="laydate({istime: true, istoday: true,format: 'YYYY-MM-DD',choose:checkDate});" ">	

				<a href="#" class="refresh" title="刷新"><i class="fa fa-refresh"></i></a>

				<div class="clear">
				</div>
			</div>

			<div class="three">
				<%--<div class="three-box">
					 <div class="left-box">
						<i class="fa fa-map-marker"></i>
						<p>位置</p>
					</div>

					<div class="right-box border-box">
						<p id="bLongitude">经度<span>${statistics.bLongitude }</span></p>
						<p id="bLatitude">纬度<span>${statistics.bLatitude }</span></p>
					</div> --%>
					
					<div class="three-box">
					<div class="left-box location">
						<i class="fa fa-map-marker"></i>
						<p>位置</p>
						<p><span id="moveDistance">${statistics.moveDistance}</span>km</p>
					</div>

					<div class="right-box border-box">
						<div class="detail">
							<p>当前经度</p>
							<p id="bLongitude">${statistics.bLongitude }</p>
						</div>

						<div class="detail">
							<p>当前纬度</p>
							<p id="bLatitude">${statistics.bLatitude }</p>
						</div>

						<div class="detail">
							<p>原始经度</p>
							<p id="oLongitude">${statistics.oLongitude }</p>
						</div>

						<div class="detail">
							<p>原始纬度</p>
							<p id="oLatitude">${statistics.oLatitude }</p>
						</div>

						<div class="clear">
						</div>
					</div>

					<div class="clear">
					</div>
				</div>

				<div class="three-box">
					<div class="left-box">
						<i class="fa fa-warning"></i>
						<p>报警</p>
					</div>

					<div class="right-box border-box">
						<div class="detail">
							<p>舱门</p>
							<p id="bDoorpolice">${statistics.bDoorpolice }</p>
						</div>

						<div class="detail">
							<p>舱盖</p>
							<p id="bHatch">${statistics.bHatch }</p>
						</div>
						
						<div class="detail">
							<p>舱进水</p>
							<p id="bWatpolice">${statistics.bWatpolice }</p>
						</div>

						<div class="detail">
							<p>移位</p>
							<p id="bShift">${statistics.bShift }</p>
						</div>
						
						<div class="clear">
						</div>
					</div>

					<div class="clear">
					</div>
				</div>

				<div class="three-box last">
					<div class="left-box">
						<i class="fa fa-info"></i>
						<p>详情</p>
					</div>

					<div class="right-box border-box">
						<div class="detail">
							<p>电压</p>
							<p id="bVoltage">${statistics.bVoltage }V</p>
						</div>

						<div class="detail">
							<p>方位</p>
							<p id="bBearing">${statistics.bBearing }°</p>
						</div>

						<div class="detail">
							<p>锚灯</p>
							<%-- <p id="bRidlight">${statistics.bRidlight }</p> --%>
							<div on="true"> </div>
						</div>

						<div class="detail">
							<p>剩余空间</p>
							<p id="bFree">${statistics.bFree }m</p>
						</div>

						<div class="clear">
						</div>
					</div>

					<div class="clear">
					</div>
				</div>

					<div class="clear">
					</div>
				</div>

				<div class="clear">
				</div>
			</div>

			<div class="factor">
				<div class="left-factor">
					<div class="left-factor-box qixiang border-box">
						<p>气象</p>
						<div>
							<div class="factor-detail">
								<p>气压（hPa）</p>
								<p><a href="javascript:tubiao('w_airpre','weather','气压');" id="wAirpre">${statistics.wAirpre }</a></p>
							</div>

							<div class="factor-detail">
								<p>气温（℃）</p>
								<p><a href="javascript:tubiao('w_airtemp','weather','气温');" id="wAirtemp">${statistics.wAirtemp }</a></p>
							</div>

							<div class="factor-detail">
								<p>湿度（%）</p>
								<p><a href="javascript:tubiao('w_oppohumi','weather','湿度');" id="wOppohumi">${statistics.wOppohumi }</a></p>
							</div>

							<div class="clear">
							</div>
						</div>
					</div>

					<div class="left-factor-box shuiwen border-box">
						<p>水文</p>
						<div>
							<div class="factor-detail">
								<p>水温（℃）</p>
								<p><a href="javascript:tubiao('wq_wattemp','waterquality','水温');" id="wqWattemp">${statistics.wqWattemp }</a></p>
							</div>

							<div class="factor-detail">
								<p>盐度（%）</p>
								<p><a href="javascript:tubiao('wq_salinity','waterquality','盐度');" id="wqSalinity">${statistics.wqSalinity }</a></p>
							</div>

							<div class="factor-detail">
								<p>电导率（ms/cm）</p>
								<p><a href="javascript:tubiao('wq_conductivity','waterquality','盐度');" id="wqConductivity">${statistics.wqConductivity}</a></p>
							</div>

							<div class="clear">
							</div>
						</div>
					</div>

					<div class="left-factor-box change border-box">
						<p id="tubiao">风速表</p>

						<!-- 折线图 -->
						<div id="zhexian" style="height:220px;"></div>
					</div>

					<!-- 警报,最多显示14条警报 -->
					<div class="warning">
						<!--  <div class="warning-box">
							<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>12站台温度异常<a href="javascript:;" title="关闭" class="close-alarm"><img src="images/close.png"/></a></p>
						</div>  -->


						<!-- <div class="warning-box">
							<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>12站台温度异常<a href="javascript:;" title="关闭" class="close-alarm"><img src="images/close.png"/></a></p>
						</div>

						<div class="warning-box">
							<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>13站台温度异常<a href="javascript:;" title="关闭" class="close-alarm"><img src="images/close.png"/></a></p>
						</div>

						<div class="warning-box">
							<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>14站台温度异常<a href="javascript:;" title="关闭" class="close-alarm"><img src="images/close.png"/></a></p>
						</div>

						<div class="warning-box">
							<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>12站台温度异常<a href="javascript:;" title="关闭" class="close-alarm"><img src="images/close.png"/></a></p>
						</div>

						<div class="warning-box">
							<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>13站台温度异常<a href="javascript:;" title="关闭" class="close-alarm"><img src="images/close.png"/></a></p>
						</div>

						<div class="warning-box">
							<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>14站台温度异常<a href="javascript:;" title="关闭" class="close-alarm"><img src="images/close.png"/></a></p>
						</div>

						<div class="warning-box">
							<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>12站台温度异常<a href="javascript:;" title="关闭" class="close-alarm"><img src="images/close.png"/></a></p>
						</div>

						<div class="warning-box">
							<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>13站台温度异常<a href="javascript:;" title="关闭" class="close-alarm"><img src="images/close.png"/></a></p>
						</div>

						<div class="warning-box">
							<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>14站台温度异常<a href="javascript:;" title="关闭" class="close-alarm"><img src="images/close.png"/></a></p>
						</div>

						<div class="warning-box">
							<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>12站台温度异常<a href="javascript:;" title="关闭" class="close-alarm"><img src="images/close.png"/></a></p>
						</div>

						<div class="warning-box">
							<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>13站台温度异常<a href="javascript:;" title="关闭" class="close-alarm"><img src="images/close.png"/></a></p>
						</div>
 -->
					</div>
				</div>

				<div class="right">
					<div class="right-factor">
						<div class="right-factor-box hailiu border-box">
							<div class="haha">
								<span>海流</span>

								<div>
									<div class="factor-detail border-box">
										<span>层数</span>
										<span>表层</span>
									</div>

									<div class="factor-detail border-box">
										<span>层深（m）</span>
										<span>2</span>
									</div>

									<div class="factor-detail border-box">
										流速<a href="javascript:tubiao('c_speed1','current','流速');" id="cSpeed1">${statistics.cSpeed1}m/s</a>
									</div>

									<div class="clear">
									</div>
								</div>
							</div>
							
							<div class="bearing">
								<img src="<%=path %>/images/clock.png" class="clock">
								<img src="<%=path %>/images/second.png" class="second">
								<span id="cTo1">${statistics.cTo1}°</span>
							</div>

							<div class="clear">
							</div>
						</div>
					</div>

					<div class="right-factor">
						<div class="right-factor-box table-factor bo border-box">
							<table>
								<tr>
									<th class="table-head">波</th>
									<th>最大</th>
									<th>1/10</th>
									<th>有效</th>
									<th>平均</th>
								</tr>

								<tr>
									<td>波高（m）</td>
									<td><a href="javascript:tubiao('w_high_max','wave','最大波高');" id="wHighMax">${statistics.wHighMax}</a></td>
									<td><a href="javascript:tubiao('w_high_tenth','wave','十分之一波高');" id="wHighTenth">${statistics.wHighTenth}</a></td>
									<td><a href="javascript:tubiao('w_high_average','wave','有效波高');" id="wHighEffective">${statistics.wHighEffective}</a></td>
									<td><a href="javascript:tubiao('w_high_effective','wave','平均波高');" id="wHighAverage">${statistics.wHighAverage}</a></td>
								</tr>

								<tr>
									<td>波周期（s）</td>
									<td><a href="javascript:tubiao('w_cycle_max','wave','最大波周期');" id="wCycleMax">${statistics.wCycleMax}</a></td>
									<td><a href="javascript:tubiao('w_cycle_tenth','wave','十分之一波周期');" id="wCycleTenth">${statistics.wCycleTenth}</a></td>
									<td><a href="javascript:tubiao('w_cycle_average','wave','有效波周期');" id="wCycleAverage">${statistics.wCycleAverage}</a></td>
									<td><a href="javascript:tubiao('w_cycle_effective','wave','平均波周期');" id="wCycleEffective">${statistics.wCycleEffective}</a></td>

								<tr>
									<td>波向（°）</td>
									<td>
										<div class="bearing">
											<div>
												<img src="<%=path %>/images/clock.png" class="clock">
												<img src="<%=path %>/images/second.png" class="second">
											</div>
										</div>
										<span class="wTo">${statistics.wTo}</span>
									</td>
									<td>
										<div class="bearing">
											<div>
												<img src="<%=path %>/images/clock.png" class="clock">
												<img src="<%=path %>/images/second.png" class="second">
											</div>
										</div>
										<span class="wTo">${statistics.wTo}</span>
									</td>
									<td>
										<div class="bearing">
											<div>
												<img src="<%=path %>/images/clock.png" class="clock">
												<img src="<%=path %>/images/second.png" class="second">
											</div>
										</div>
										<span class="wTo">${statistics.wTo}</span>
									</td>
									<td>
										<div class="bearing">
											<div>
												<img src="<%=path %>/images/clock.png" class="clock">
												<img src="<%=path %>/images/second.png" class="second">
											</div>
										</div>
										<span class="wTo">${statistics.wTo}</span>
									</td>
								</tr>
							</table>
						</div>
					</div>

					<div class="right-factor">
						<div class="right-factor-box table-factor wind border-box">
							<table>
								<tr>
									<th class="table-head">风</th>
									<th>最大</th>
									<th>极大</th>
									<th>平均</th>
									<th>瞬时</th>
								</tr>

								<tr>
									<td>风速（m/s）</td>
									<td><a href="javascript:tubiao('wind_speed_max','wind','最大风速');" id="windSpeedMax">${statistics.windSpeedMax}</a></td>
									<td><a href="javascript:tubiao('wind_speed_ji','wind','极大风速');" id="windSpeedJi">${statistics.windSpeedJi}</a></td>
									<td><a href="javascript:tubiao('wind_speed_ten','wind','平均风速');" id="windSpeedTen">${statistics.windSpeedTen}</a></td>
									<td><a href="javascript:tubiao('wind_speed_instant','wind','瞬时风速');" id="windSpeedInstant">${statistics.windSpeedInstant}</a></td>
									
								</tr>

								<tr>
									<td>风向（°）</td>
									<td>
										<div class="bearing">
											<div>
												<img src="<%=path %>/images/clock.png" class="clock">
												<img src="<%=path %>/images/second.png" class="second">
											</div>
										</div>
										<span id="windSpeedMaxto">${statistics.windSpeedMaxto}</span>
									</td>
									<td>
										<div class="bearing">
											<div>
												<img src="<%=path %>/images/clock.png" class="clock">
												<img src="<%=path %>/images/second.png" class="second">
											</div>
										</div>
										<span id="windSpeedJito">${statistics.windSpeedJito}</span>
									</td>
									<td>
										<div class="bearing">
											<div>
												<img src="<%=path %>/images/clock.png" class="clock">
												<img src="<%=path %>/images/second.png" class="second">
											</div>
										</div>
										<span id="windSpeedTento">${statistics.windSpeedTento}</span>
									</td>
									<td>
										<div class="bearing">
											<div>
												<img src="<%=path %>/images/clock.png" class="clock">
												<img src="<%=path %>/images/second.png" class="second">
											</div>
										</div>
										<span id="windToInstant">${statistics.windToInstant}</span>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>

				<div class="clear">
				</div>
			</div>
		</div>
	</div>

	<div class="clear">
	</div>
	<input type="hidden" id="parm1" value="wind_speed_instant">
	<input type="hidden" id="parm2" value="wind">
	<input type="hidden" id="parm3" value="瞬时风速">
	<input type="hidden" id="logcount" value="">
		<div id='audio'>
		<audio controls="controls"loop="loop" preload="auto" hidden="true"
         src="<%=path %>/fonts/timenotify.wav">
	      你的浏览器不支持audio标签
	</audio>
	
	<script src="<%=path %>/js/jq.min.js"></script>
	<script src="<%=path %>/js/echarts.min.js"></script>
	<script src="<%=path %>/js/nav.js"></script>
	<script src="<%=path %>/js/statistics.js"></script>
	<script src="<%=path %>/js/statistics_data.js"></script>
	<script src="<%=path %>/js/laydate/laydate.js"></script>
	<script>
		;!function(){

		laydate.skin('danlan');

		laydate({
		})

		}();
	</script>
	<script type="text/javascript">
		/* function play() {
			$("#audio").play();
		}
		function pause() {
			$("#audio").pause();
		} */
		$(function(){
			$('#bLongitude').text(locationChange4(7,$('#bLongitude').text()));
			$('#bLatitude').text(locationChange4(6,$('#bLatitude').text()));
			$('#oLongitude').text(locationChange5(7,$('#oLongitude').text()));
			$('#oLatitude').text(locationChange5(6,$('#oLatitude').text()));
			var key = [];
			var cSpeed1= '${statistics.cSpeed1}';
			var wTo = '${statistics.wTo}';
			var windSpeedMaxto = '${statistics.windSpeedMaxto}';
			var windSpeedJito = '${statistics.windSpeedJito}';
			var windSpeedTento ='${statistics.windSpeedTento}';
			var windToInstant = '${statistics.windToInstant}';
			key.push(cSpeed1);
			key.push(wTo);
			key.push(windSpeedMaxto);
			key.push(windSpeedJito);
			key.push(windSpeedTento);
			key.push(windToInstant);
			refreshClock(key);
			
			var time = '${statistics.time}';
			alert(time);
			getStation();
			
			if (time != '') {
				time = time.substring(0,10);
				$('#planStartTime').val(time);
				getTime();
				
				tubiao('wind_speed_instant','wind','瞬时风速');
			}
			$('#planStartTime').val(time);
			//下拉框
			
		<%-- 	<div class="warning-box on third">
			<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>14站台温度异常<a href="javascript:;" title="关闭"><img src="<%=path %>/images/close.png"/></a></p>
		</div> --%>
		<%-- <div class="warning-box">
		<p><span><i class="fa fa-bell"></i>[2015-2-5，11:20]</span>12站台温度异常<a href="javascript:;" title="关闭" class="close-alarm"><img src="<%=path%>/images/close.png"/></a></p>
	</div> --%>
			//定时获取报警 30秒
	 		//window.setTimeout(getAlarmLog,30000);
			//默认1分钟 查询一次
			window.setInterval(getAlarmLog,60000);
			window.setInterval(refreshView,900000);
			
			getAlarmLog();
			
		});
		
		
	</script>
</body>
</html>



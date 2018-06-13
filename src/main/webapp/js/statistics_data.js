
function getAlarmLog() {
	$.ajax({
	    url:'statistics/json/alarmlog',
	    type:'POST', //GET
	    async:false,    //或false,是否异步
	    timeout:5000,    //超时时间
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){
	    },
	    success:function(data,textStatus,jqXHR){
	        if(data.type==0) {
	        	return;
	        } 
	        
	        var logs = data.sysdata.logs;
	        //移除之前的所有li
	       	$(".warning div").remove();
	        //$('#station li').remove();
	        for (var i = 0; i < logs.length; i ++) {
	        	if (i > 13) break;
	        	var t = logs[i].date;
	        	var tt = logs[i].details;
	        	var id = logs[i].id;
				var a = "<div class='warning-box'>"
				+"<p><span><i class='fa fa-bell'></i></span>"+tt+"<a href='javascript:closeAlarm(" +id+ ");'  title='关闭' class='close-alarm'><img src='images/close.png'/></a></p>"
				+"</div>";  
				 $(".warning").append(a);  
	        }
	        if (logs.length > 0) {
	        	$("#audio").find('audio')[0].play();
	        	
	        }
	        $("#logcount").val(logs.length);
	    },
	
	    complete:function(){
	    	for(var i=0;i<$(".warning-box").length;i++){
				$(".warning-box").eq(i).css({'marginLeft':20*i+'px'})
			}
			$(".warning-box").hover(function(){
				$(this).css({'zIndex':'100'});
			},function(){
				$(this).css({'zIndex':'1'});
			})

			$(".close-alarm").click(function(){
				$(this).parents(".warning-box").remove();
				for(var i=0;i<$(".warning-box").length;i++){
					$(".warning-box").eq(i).css({'marginLeft':20*i+'px'})
				}
			})
	    }
	})
}
//获取最新数据
function refreshView() {
	$.ajax({
	    url:'statistics/refresh',
	    type:'POST', 
	    async:false,  
	    timeout:5000,    
	    dataType:'json',   
	    beforeSend:function(xhr){
	    },
	    success:function(data,textStatus,jqXHR){
	        if(data.type==0) {
	        	alert(data.message);
	        	return;
	        } 
	        var d = data.sysdata.statistics;
	        //设置时间
	        var time = d.time;
	        $('#year').text(time);
	        time = time.substring(0,10);
	        $('#planStartTime').val(time);
	        //设置站位号
	        $('#zhanweihao').text(d.station);
	        //设置浮标号
	        var bBuoyid = d.bBuoyid;
	        $('#buoyId').text(bBuoyid);
	        setData(d);
	        getStation();
	        getTime();
			tubiao('wind_speed_instant','wind','瞬时风速');
	    },
	    complete:function(){
	        console.log('结束')
	    }
	})
}

//获取所有站位号对应的所有浮标
function closeAlarm(id) {
	
	$.ajax({
	    url:'statistics/json/closealarm',
	    type:'POST', //GET
	    async:false,    //或false,是否异步
	    data:{
	    	id:id
	    },
	    timeout:5000,    //超时时间
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){
	    },
	    success:function(data,textStatus,jqXHR){
	        if(data.type==0) {
	        	alert(data.message);
	        	return;
	        } 
	        
	        var count = $("#logcount").val();
	        if (count > 14) {
	        	getAlarmLog();
	        	return;
	        }
	        if ($(".warning-box").length <= 0) {
	        	$("#audio").find('audio')[0].pause();
	        }
	    },
	    complete:function(){
	        console.log('结束')
	    }
	})
	//$(this).parents(".warning-box").remove();
}

//获取所有站位号对应的所有浮标
function getStation() {
	$.ajax({
	    url:'statistics/json/station',
	    type:'POST', //GET
	    async:false,    //或false,是否异步
	    data:{
	    	
	    },
	    timeout:5000,    //超时时间
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){
	        console.log(xhr)
	        console.log('发送前')
	    },
	    success:function(data,textStatus,jqXHR){
	        if(data.type==0) {
	        	alert(data.message);
	        	//flag = 0;
	        	return;
	        } 
	        var stations = data.sysdata.stations;
	        //移除之前的所有li
	        $('#station li').remove();
	        $('#fubiaolist li').remove();
	        for (var i = 0; i < stations.length; i ++) {
	        	var t = stations[i].sStation;
	        	var tt = stations[i].sBuoyid;
	        	var v = "<li><a href = '#' onclick =\"selectByStation('" + EscapeChar(tt) + "')\"  class=down-list >"+t+"</a><span hidden='hidden'>"+tt+"</span></li>";
	        	var vv = "<li><a href = '#' onclick =\"selectByBuoy('" + EscapeChar(tt) + "','"+EscapeChar(t)+"')\"  class=down-list >"+tt+"</a><span hidden='hidden'>"+t+"</span></li>";
	        	$('#station').append(v);
	        	$('#fubiaolist').append(vv);
	        }
	        //zhexianChart(d,t);
	    },
	    error:function(xhr,textStatus){
	    },
	    complete:function(){
	    }
	})
}
function selectByBuoy(buoyId,stationId) {
	$('#zhanweihao').text(stationId);
	selectByStation(buoyId);
}

//通过站位获取浮标信息
function selectByStation(buoyId) {
	$('#buoyId').text(buoyId);
	
	//buoyId = buoyId.substring(3);
	var parm = $(".year").text();
	newData(parm);
	//刷新图表
	var parm1 = $("#parm1").val();
	var parm2 = $("#parm2").val();
	var parm3 = $("#parm3").val();
	
	if (parm != '') {
		//parm = parm.substring(0,10);
		var p = $('#planStartTime').val();
		getTime();
		tubiao(parm1,parm2,parm3);
	}else {
		getTime();
		tubiao(parm1,parm2,parm3);
	}
	
	
	
}
//根据日期控件的值从后台获取当天的时间点
function getTime() {
	var time = $('#planStartTime').val();
	var buoyId = $('#buoyId').text();
	//buoyId = buoyId.substring(3);
	
	var flag = 1;
	 $.ajax({
	    url:'statistics/json/time',
	    type:'POST', //GET
	    async:false,    //或false,是否异步
	    data:{
	    	date: time,
	    	buoy:buoyId
	    },
	    timeout:5000,    //超时时间
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){
	        console.log(xhr)
	        console.log('发送前')
	    },
	    success:function(data,textStatus,jqXHR){
	        if(data.type==0) {
	        	alert(data.message);
	        	flag = 0;
	        	return;
	        } 
	        if (data.type == 2) {
	        	return ;
	        }
	        var times = data.sysdata.time;
	        //移除之前的所有li
	        $('#checkbox li').remove();
	        $('.year').text(times[times.length-1]);
	        for (var i = 0; i < times.length; i ++) {
	        	var t = times[i].trim();
	        	var v = "<li><a href = '#' onclick =\"selctByTime('" + EscapeChar(t) + "')\"  class=down-list >"+t+"</a><span hidden='hidden'>"+t+"</span></li>";
	        	//$('#checkbox').append("<li><a href=javascript:selctByTime("+t+"); class=down-list>"+t+"</a></li>");
	        	$('#checkbox').append(v);
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
	
	return flag;
}
/**
 * 折线数据显示
 * @param d
 * @param t
 * @param name
 * @returns
 */
function zhexianChart(d,t,name){
	var myChart = echarts.init(document.getElementById('zhexian'));
	
	// 指定图表的配置项和数据
	var option = {
	    itemStyle: {
	        normal: {
	            // 设置扇形的颜色
	            color: '#36bba1',
	        }
	    },
	    tooltip: {
	        trigger: 'axis'
	    },
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: t, 
	    },
	    yAxis: {},
	    series: [{
	        name: name,
	        type: 'line',
	        data: d,
	    }],
	    dataZoom: [{
	        type: 'slider',
	        start: 0,
	        end: 30,
	    }],
	};
	//改变表名
	var a = $('#tubiao').text(name+'表');
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
}
/**
 * 设置图表
 * @param parm1
 * @param parm2
 * @param parm3
 * @returns
 */
function tubiao(parm1,parm2,parm3){
	$("#parm1").val(parm1);
	$("#parm2").val(parm2);
	$("#parm3").val(parm3);
	var parm4 = $('.year').text();
	var buoyId = $('#buoyId').text();
	//buoyId = buoyId.substring(3);
	$.ajax({
	    url:'statistics/json/tubiao',
	    type:'POST', //GET
	    async:false,    //或false,是否异步
	    data:{
	    	field:parm1,
	        table:parm2,
	        date:parm4,
	        buoyId:buoyId
	    },
	    timeout:5000,    //超时时间
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){
	        console.log(xhr)
	        console.log('发送前')
	    },
	    success:function(data,textStatus,jqXHR){
	        if (data.type == 0) {
	        	alert(data.message);
	        	return;
	        }
	        var date = data.sysdata.speed;
	        var time = data.sysdata.time;
	        var d = date.split(",");
	        var t = time.split(",");
	        zhexianChart(d,t,parm3);
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
//日期控件回调函数
function checkDate() {
	var f = getTime();
	//如果获取时间点失败 没必要再发送获取数据
	if (f == 0) return;
	var parm = $(".year").text();
	//
	newData(parm);
	var parm1 = $("#parm1").val();
	var parm2 = $("#parm2").val();
	var parm3 = $("#parm3").val();
	
	tubiao(parm1,parm2,parm3);
}
/**
 * 通过时间获取数据
 * @param t
 * @returns
 */
function selctByTime(t) {
	
	$('.year').text(t);
	//获取当前浮标号
	var buoyId = $('#buoyId').text();
	//buoyId = buoyId.substring(3);
	newData(t);
	//刷新图表
	var parm1 = $("#parm1").val();
	var parm2 = $("#parm2").val();
	var parm3 = $("#parm3").val();
	tubiao(parm1,parm2,parm3);
}
//字符转义
function EscapeChar(HaveSpecialval) {
    //转换半角单引号
    HaveSpecialval = HaveSpecialval.replace(/\'/g, "\\\'");

    //也可以使用&acute;
    HaveSpecialval = HaveSpecialval.replace(/\'/g, "&acute;");
    return HaveSpecialval;
}
/**
 * 下一时间点
 * @returns
 */
function next() {
	var now = $(".year").text();
	var key = [];
	$("#checkbox").each(function () {
	    $(this).find('li').each(function() {
	      key.push($(this).text());
	    });
	
	 });
	 for (var i = 0 ; i < key.length; i++) {
			if(key[i]==now && i != (key.length-1)) {
				$(".year").text(key[i+1]);
				newData(key[i+1]);
				break;
			}
			
	 }
	 
	 var parm1 = $("#parm1").val();
	 var parm2 = $("#parm2").val();
	 var parm3 = $("#parm3").val();
	 tubiao(parm1,parm2,parm3);
}
/**
 * 上一时间点
 * @returns
 */
function last() {
	var now = $(".year").text();
	var key = [];
	$("#checkbox").each(function () {
	    
	    $(this).find('li').each(function() {
	      //tmp = $(this).text();
	   
	      key.push($(this).text());
	    });
	
	 });
	 for (var i = 0 ; i < key.length; i++) {
			if(key[i]==now && i!=0) {
				$(".year").text(key[i-1]);
				newData(key[i-1]);
				break;
			}
	 }
	 var parm1 = $("#parm1").val();
	 var parm2 = $("#parm2").val();
	 var parm3 = $("#parm3").val();
	 tubiao(parm1,parm2,parm3);
}
//根据时间刷新数据
function newData(parm1){
	var buoyId = $('#buoyId').text();
	$.ajax({
	    url:'statistics/json/view',
	    type:'POST', //GET
	    async:false,    //或false,是否异步
	    data:{
	    	date:parm1,
	        buoyId:buoyId
	    },
	    timeout:5000,    //超时时间
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){
	    },
	    success:function(data,textStatus,jqXHR){
	    		$('.year').text(data.sysdata.statistics.time);
	    		setData(data.sysdata.statistics);
	        
	    },
	    error:function(xhr,textStatus){
	    },
	    complete:function(){
	    }
	})
}
/**
 * 设置值
 * @param data
 * @returns
 */
function setData(data) {
//	/*$('#bLongitude').text(locationChange2(7,data.bLongitude));
//	$('#bLatitude').text(locationChange2(6,data.bLatitude));
	$('#bLongitude').text(locationChange4(7,data.bLongitude));
	$('#bLatitude').text(locationChange4(6,data.bLatitude));
	$('#oLongitude').text(locationChange5(7,data.oLongitude));
	$('#oLatitude').text(locationChange5(6,data.oLatitude));
	$('#moveDistance').text(data.moveDistance);
	
	$('#bDoorpolice').text(data.bDoorpolice);
	$('#bHatch').text(data.bHatch);
	$('#bWatpolice').text(data.bWatpolice);
	$('#bShift').text(data.bShift);
	$('#bVoltage').text(data.bVoltage);
	$('#bBearing').text(data.bBearing);
	//$('#bRidlight').text(data.bRidlight);
	changeRidlight(data.bRidlight); 
	$('#bFree').text(data.bFree);
	$('#wAirpre').text(data.wAirpre);
	$('#wAirtemp').text(data.wAirtemp);
	$('#wOppohumi').text(data.wOppohumi);
	$('#wqWattemp').text(data.wqWattemp);
	$('#wqSalinity').text(data.wqSalinity);
	$('#wqConductivity').text(data.wqConductivity);
	$('#cSpeed1').text(data.cSpeed1);
	$('#cTo1').text(data.cTo1);
	$('#wHighMax').text(data.wHighMax);
	$('#wHighTenth').text(data.wHighTenth);
	$('#wHighEffective').text(data.wHighEffective);
	$('#wHighAverage').text(data.wHighAverage);
	$('#wCycleMax').text(data.wCycleMax);
	$('#wCycleTenth').text(data.wCycleTenth);
	$('#wCycleAverage').text(data.wCycleAverage);
	$('#wCycleEffective').text(data.wCycleEffective);
	$('.wTo').text(data.wTo);
	$('#windSpeedMax').text(data.windSpeedMax);
	$('#windSpeedJi').text(data.windSpeedJi);
	$('#windSpeedInstant').text(data.windSpeedInstant);
	$('#windSpeedTen').text(data.windSpeedTen);
	$('#windSpeedMaxto').text(data.windSpeedMaxto);
	$('#windSpeedJito').text(data.windSpeedJito);
	$('#windSpeedTento').text(data.windSpeedTento);
	$('#windToInstant').text(data.windToInstant);
	var t = data.time.substring(0,10)
	$('#planStartTime').val(t);
	var key = [];
	key.push(data.cSpeed1);
	key.push(data.wTo);
	key.push(data.windSpeedMaxto);
	key.push(data.windSpeedJito);
	key.push(data.windSpeedTento);
	key.push(data.windToInstant);
	refreshClock(key);
	
}
/**
 * 更新锚灯颜色
 * @returns
 */
function changeRidlight(flag) {
	if (flag == '亮') {
		$(".three .three-box .right-box .detail div").css({'backgroundColor':'#ffec00'});
	}else {
		$(".three .three-box .right-box .detail div").css({'backgroundColor':'#7a7a7a'});
	}
}
//刷新轮盘指针
function refreshClock(data) {
	//todo 超出范围判断
	if (data[0] != '/' && data[0] > 0 && data[0] < 360) {
		clock($(".hailiu .second"),data[0]);
	} else {
		clock($(".hailiu .second"),0);
	}
	if (data[1] != '/' && data[1] > 0 && data[1] < 360) {
		clock($(".bo .second"),data[1]);
	} else {
		clock($(".bo .second"),0);
	}
	 for (var i = 1;i <= 4; i++) {
		if(data[i+1] != '/' && data[i+1] > 0 && data[i+1] < 360) {
			clock($(".wind tr:last-child td").eq(i).find(".second"),data[i+1]);
		} else {
			clock($(".wind tr:last-child td").eq(i).find(".second"),0);
		}
	}
	
}

function locationChange2(n,text){
	var arr=[];
	for(var i=0,len=text.length;i<len;i++){
	  arr[i]=text[i];
	}
	arr.splice(n-4,0,'°');
	arr.splice(n-1,0,'.');
	arr.splice(n+2,0,'′');
	return arr.join("");
}
function locationChange4(n,text){
	var arr=[];
	for(var i=0,len=text.length - 1;i<len;i++){
	  arr[i]=text[i];
	}
	arr.splice(n-4,0,'°');
	arr.splice(n-1,0,'.');
	arr.splice(n+2,0,'′');
	if (n == 7) return arr.join("")+'E';
	else return arr.join("")+"N";
}
function locationChange5(n,text){
	var arr=[];
	for(var i=0,len = text.length;i<len;i++){
	  arr[i]=text[i];
	}
	arr.splice(n-4,0,'°');
	arr.splice(n-1,0,'.');
	arr.splice(n+2,0,'′');
	if (n == 7) return arr.join("")+'E';
	else return arr.join("")+"N";
}
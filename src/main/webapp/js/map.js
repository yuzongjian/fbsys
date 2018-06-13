window.onload=function(){
	var mapOptions = {
		minZoom: 6, //地图最小层级
		maxZoom: 9, //地图最大层级
		mapType: BMAP_NORMAL_MAP
	}
	//ajax获取所有浮标信息
	var datas = getbuoy();
	var nodatabuoys = datas.nodatabuoys;
	var buoys = datas.buoys;
	
	var map = new BMap.Map("container", mapOptions);      //设置卫星图为底图BMAP_PERSPECTIVE_MAP

	map.enableScrollWheelZoom();                  // 启用滚轮放大缩小。
	map.enableKeyboard();                         // 启用键盘操作。  
	map.enableContinuousZoom();										//启用连续缩放效果
	
	// ----- control -----
	map.addControl(new BMap.NavigationControl()); //地图平移缩放控件
	map.addControl(new BMap.ScaleControl()); //显示比例尺在右下角
	
	
	// 缩放范围
	map.centerAndZoom(new BMap.Point(111.735690, 15.229647),6);
 	var b = new BMap.Bounds(new BMap.Point(84.661765, 1.653248),new BMap.Point(140.736721, 47.516893));
	try {    // js中尽然还有try catch方法，可以避免bug引起的错误
        BMapLib.AreaRestriction.setBounds(map, b); // 已map为中心，已b为范围的地图
    } catch (e) {
        // 捕获错误异常
        alert(e);
    }

	var opts = {				
				enableMessage:true,//设置允许信息窗发送短息
				width:280,
			   };

	//label("temperature","<img class='temperature'  num='12'>12℃","<img class='temperature' num='25'>25℃","<img class='temperature' num='30'>30℃");
	for (var i = 0;i < buoys.length;i++) {
		var tmp = "<img class='temperature' num="+buoys[i].wqWattemp+">"+buoys[i].wqWattemp+"℃";
		buoys[i].flag=tmp;
	}
	//还没接收过数据的默认故障情况
	for (var i = 0; i < nodatabuoys.length; i ++ ) {
		nodatabuoys[i].isFault = 0;
		nodatabuoys[i].flag='/';
	}
	
	label(buoys,nodatabuoys,"temperature");
	function addClickHandler(content,marker){
		marker.addEventListener("mouseover",function(e){
			openInfo(content,e)}
		);
	}
	function openInfo(content,e){
		var p = e.target;
		var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
		var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象 
		map.openInfoWindow(infoWindow,point); //开启信息窗口

		var labelContent=infoWindow.getContent();
		document.getElementById("label-contents").innerHTML="";
		document.getElementById("label-contents").innerHTML=labelContent;
		// 获取浮标编号：document.getElementById("label-contents").getElementsByClassName("num")[0].innerText
	}
	

	// 信息窗体和箭头的显示
	//object是图片的class（wind/ocean/temperature）
	//data是n个<img class='wind' num='56' deg='34'>56km/s，在图片里面标明num（数值）、deg（风向的角度）
	function label(data_info,nodata_info,object/*,data1,data2,data3*/){
		var allOverlay = map.getOverlays();
		for (var i = 0; i < allOverlay.length ; i++){
				map.removeOverlay(allOverlay[i]);
		}
		// 信息窗体
//	    var data_info = [[118.255230,22.630356,"10","20","10","20","10","20","10","20","<span class='num'>19</span>号<span class='location'>E19°12’,N19°12’</span>",data1,'1'],
//						 [111.760984,9.718826,"0","0","10","20","10","20","10","20","<span class='num'>15</span>号<span class='location'>E19°12’,N19°12’</span>",data2,'1'],
//						 [112.128930,19.975454,"3","3","10","20","10","20","10","20","<span class='num'>59</span>号<span class='location'>E19°12’,N19°12’</span>",data3,'0']
//						];
		for(var i=0;i<data_info.length;i++){
			if(parseInt(data_info[i].isFault)=='1'){
				var myIcon = new BMap.Icon("images/abnormal.png", new BMap.Size(23, 25), {  
                        offset: new BMap.Size(10, 25), // 指定定位位置  
                        //imageOffset: new BMap.Size(0, 0 - 10 * 25) // 设置图片偏移  
                    });  
				
				//var marker = new BMap.Marker(new BMap.Point(data_info[i][0],data_info[i][1]),{icon:myIcon});  // 创建标注
				var marker = new BMap.Marker(new BMap.Point(locationChange(1,data_info[i].bLongitude),locationChange(2,data_info[i].bLatitude)),{icon:myIcon});
			}else{
				//var marker = new BMap.Marker(new BMap.Point(data_info[i][0],data_info[i][1]));  // 创建标注
				var marker = new BMap.Marker(new BMap.Point(locationChange(1,data_info[i].bLongitude),locationChange(2,data_info[i].bLatitude)));
			}

			/*var content =// "<div id='content-box' marker='"+i+"'><div class='time-box'><a href='javascript:;' class='aaa'><img src='images/left.png'></a><a>"+data_info[i][11]+"</a><a href='javascript:;'><img src='images/right.png'></a><div class='clear'></div></div><a class='new-data' href='javascript:;'>最新数据</a>"+
						"<p class='name'>浮标"+data_info[i][10]+"</p>"+
						"<table class='frame'><tr><td>最大风速<span>"+data_info[i][2]+"m/s</span></td><td>最大风向<span>"+data_info[i][3]+"°</span></td></tr>"+
						"<tr><td>最大波高<span>"+data_info[i][4]+"m</span></td><td>最大波向<span>"+data_info[i][5]+"°</span></td></tr>"+
						"<tr><td>流速<span>"+data_info[i][6]+"cm/s</span></td><td>流向<span>"+data_info[i][7]+"°</span></td></tr>"+
						"<tr><td>水温<span>"+data_info[i][8]+"℃</span></td><td>气温<span>"+data_info[i][9]+"℃</span></td></tr>"+
						"</table></div>";*/
			var content =// "<div id='content-box' marker='"+i+"'><div class='time-box'><a href='javascript:;' class='aaa'><img src='images/left.png'></a><a>"+data_info[i][11]+"</a><a href='javascript:;'><img src='images/right.png'></a><div class='clear'></div></div><a class='new-data' href='javascript:;'>最新数据</a>"+
				"<p class='name'>站位号："+data_info[i].station+"&nbsp;&nbsp;&nbsp;&nbsp;浮标号：<span class=' num'>"+data_info[i].bBuoyid+"</span><br>经纬度：<span class='location'>"+locationChange2(7,data_info[i].bLongitude)+"&nbsp;&nbsp; "+locationChange2(6,data_info[i].bLatitude)+"</span></p>"+
				//"<p class='name'>浮标<span class='num'>"+data_info[i].bBuoyid+"</span> <span class='location'>"+locationChange2(7,data_info[i].bLongitude)+" "+locationChange2(6,data_info[i].bLatitude)+"</span>"+
				"</p>"+
				"<table class='frame'><tr><td>最大风速<span>"+data_info[i].windSpeedMax+"m/s</span></td><td>最大风向<span>"+data_info[i].windSpeedJito+"°</span></td></tr>"+
				"<tr><td>最大波高<span>"+data_info[i].wHighMax+"m</span></td><td>最大波向<span>"+data_info[i].wTo+"°</span></td></tr>"+
				"<tr><td>流速<span>"+data_info[i].cSpeed1+"cm/s</span></td><td>流向<span>"+data_info[i].cTo1+"°</span></td></tr>"+
				"<tr><td>水温<span>"+data_info[i].wqWattemp+"℃</span></td><td>气温<span>"+data_info[i].wAirtemp+"℃</span></td></tr>"+
				"<tr><td hidden='true' class='time'>"+data_info[i].time+"<td></tr></table></div>";
			map.addOverlay(marker);
			addClickHandler(content,marker);
			marker.enableMassClear();        
			var label = new BMap.Label(data_info[i].flag,{offset:new BMap.Size(20,-3)});
			marker.setLabel(label);
			label.setStyle({ 
				background :"transparent",
				border :"0", 
				fontSize:"14px",
				fontWeight:"bold",
			});
		}
		
		//无数据浮标的处理
		for(var i = 0 ; i < nodata_info.length; i ++) {
			if(parseInt(nodata_info[i].isFault)=='1'){
				var myIcon = new BMap.Icon("images/abnormal.png", new BMap.Size(23, 25), {  
                        offset: new BMap.Size(10, 25), // 指定定位位置  
                        //imageOffset: new BMap.Size(0, 0 - 10 * 25) // 设置图片偏移  
                    });  
				
				//var marker = new BMap.Marker(new BMap.Point(data_info[i][0],data_info[i][1]),{icon:myIcon});  // 创建标注
				var marker = new BMap.Marker(new BMap.Point(locationChange3(1,nodata_info[i].sLongitude),locationChange3(2,nodata_info[i].sLatitude)),{icon:myIcon});
			}else{
				//var marker = new BMap.Marker(new BMap.Point(data_info[i][0],data_info[i][1]));  // 创建标注
				var marker = new BMap.Marker(new BMap.Point(locationChange3(1,nodata_info[i].sLongitude),locationChange3(2,nodata_info[i].sLatitude)));
			}
			var content =// "<div id='content-box' marker='"+i+"'><div class='time-box'><a href='javascript:;' class='aaa'><img src='images/left.png'></a><a>"+data_info[i][11]+"</a><a href='javascript:;'><img src='images/right.png'></a><div class='clear'></div></div><a class='new-data' href='javascript:;'>最新数据</a>"+
				"<p class='name'>站位号："+nodata_info[i].sStation+"&nbsp;&nbsp;&nbsp;浮标号：<span class='num'>"+nodata_info[i].sBuoyid+"</span><br>经纬度 <span class='location'>"+locationChange4(7,nodata_info[i].sLongitude)+"&nbsp;&nbsp; "+locationChange4(6,nodata_info[i].sLatitude)+"</span>"+
				"</p>"+
				"<table class='frame'><tr><td>最大风速<span>/ m/s</span></td><td>最大风向<span>/ °</span></td></tr>"+
				"<tr><td>最大波高<span>/ m</span></td><td>最大波向<span>/ °</span></td></tr>"+
				"<tr><td>流速<span>/ cm/s</span></td><td>流向<span>/ °</span></td></tr>"+
				"<tr><td>水温<span>/ ℃</span></td><td>气温<span>/ ℃</span></td></tr>"+
				"<tr><td hidden='true' class='time'>"+nodata_info[i].date+"<td></tr></table></div>";
			map.addOverlay(marker);
			addClickHandler(content,marker);
			marker.enableMassClear();        
			var label = new BMap.Label(nodata_info[i].flag,{offset:new BMap.Size(20,-3)});
			marker.setLabel(label);
			label.setStyle({ 
				background :"transparent",
				border :"0", 
				fontSize:"14px",
				fontWeight:"bold",
			});
		}
		
		// 判断label颜色和旋转角度
		for(var i=0;i<document.getElementsByClassName(object).length;i++){
			//document.getElementsByClassName(span)[i].setAttribute('class',span+' '+span+i);
			document.getElementsByClassName(object)[i].setAttribute('class',object+' '+object+i);
			if(document.getElementsByClassName(object)[i].getAttribute('num')<25){
				//document.getElementsByClassName(span+i)[0].style.color="#68c08d";
				if(!(object=="temperature"))
					document.getElementsByClassName(object)[i].src='images/'+object+'Blue.png';
			}else if(document.getElementsByClassName(object)[i].getAttribute('num')>25&&document.getElementsByClassName(object)[i].getAttribute('num')<50){
				//document.getElementsByClassName(span+i)[0].style.color="#bad876";
				if(!(object=="temperature"))
					document.getElementsByClassName(object)[i].src='images/'+object+'Green.png';
			}else if(document.getElementsByClassName(object)[i].getAttribute('num')>50&&document.getElementsByClassName(object)[i].getAttribute('num')<75){
				//document.getElementsByClassName(span+i)[0].style.color="#f89448";
				if(!(object=="temperature"))
					document.getElementsByClassName(object)[i].src='images/'+object+'Orange.png';
			}else if(document.getElementsByClassName(object)[i].getAttribute('num')=='/'){
				//document.getElementsByClassName(span+i)[0].style.color="#f89448";
				if(!(object=="temperature"))
					document.getElementsByClassName(object)[i].src='';
			}else{
				//document.getElementsByClassName(span+i)[0].style.color="#f15966";
				if(!(object=="temperature"))
					document.getElementsByClassName(object)[i].src='images/'+object+'Red.png';
			}

			var deg=document.getElementsByClassName(object+i)[0].getAttribute('deg');
			document.getElementsByClassName(object+i)[0].style.transform="rotate("+deg+"deg)";
		}
	}

	// 点击浮标右部滑块滑出
	map.addEventListener("click", function(e){   //点击事件    
        if(e.overlay){  
        	var left=document.getElementById("detail").offsetLeft-400;
        	if(left==document.body.clientWidth-400){
            	starMove(left,20);
        	}

        	// 又不滑块里面的 详细数据 不需要请求后台，前端直接获取
        	document.getElementById("fubiao").getElementsByTagName("span")[0].innerHTML=document.getElementById("label-contents").getElementsByClassName("num")[0].innerText;
        	document.getElementById("fubiao").getElementsByTagName("span")[1].innerHTML=document.getElementById("label-contents").getElementsByClassName("location")[0].innerText;
        	// 获取时间
        	var time=document.getElementById("label-contents").getElementsByClassName("time")[0].innerText;
            //document.getElementById("detail").getElementsByClassName("time")[0].getElementsByTagName("span")[0].innerHTML=time;
        	$("#time").html(time);
        	/*for(var i=0;i<8;i++){
        		var text=document.getElementById("label-contents").getElementsByClassName("frame")[0].getElementsByTagName("span")[i].innerText;
        		document.getElementsByClassName("detail-data")[0].getElementsByTagName("tr")[i].getElementsByTagName("td")[1].innerHTML=text;
        		//document.getElementById("detail").getElementsByClassName("time")[0].getElementsByTagName("span")[0].innerHTML=buoys[i].time;
        	}*/
        	//数据统一重新后台获取赋值
        	//每次点击先清空原先数据
        	clearData();
        	preOrNextTime(2);
        	
        	/*$('#bDoorpolice').html(buoy.bDoorpolice);
	        $('#bHatch').html(buoy.bHatch);
	        $('#bWatpolice').html(buoy.bWatpolice);
	        $('#bShift').html(buoy.bShift);
	        $('#bVoltage').html(buoy.bVoltage);
	        $('#bBearing').html(buoy.bBearing);
	        $('#bRidlight').html(buoy.bRidlight);
	        $('#bFree').html(buoy.bFree);*/
        }  
    }) 

    document.getElementsByClassName("a-btn")[0].addEventListener("click",function(){
		//label("wind","<img class='wind' num='56' deg='34'>56km/s","<img class='wind' num='96' deg='90'>96km/s","<img class='wind' num='76' deg='49'>76km/s")
    	for (var i = 0;i < buoys.length;i++) {
    		var tmp = "<img class='wind' num="+buoys[i].windSpeedTen+" deg="+buoys[i].windSpeedTento+">"+buoys[i].windSpeedTen+"m/s";
    		buoys[i].flag=tmp;
    	}
    	for (var i = 0; i < nodatabuoys.length; i ++ ) {
    		nodatabuoys[i].isFault = 0;
    		nodatabuoys[i].flag='/';
    	}
    	
    	label(buoys,nodatabuoys,'wind');
	}) 

	document.getElementsByClassName("a-btn")[1].addEventListener("click",function(){
		//label("ocean","<img class='ocean' num='/' deg='4'>","<img class='ocean' num='4' deg='245'>4km/s","<img class='ocean' num='67' deg='304'>67km/s")
		for (var i = 0;i < buoys.length;i++) {
    		var tmp = "<img class='ocean' num="+buoys[i].cSpeed1+" deg="+buoys[i].cTo1+">"+buoys[i].cSpeed1+"km/s";
    		buoys[i].flag=tmp;
    	}
		for (var i = 0; i < nodatabuoys.length; i ++ ) {
    		nodatabuoys[i].isFault = 0;
    		nodatabuoys[i].flag='/';
    	}
    	label(buoys,nodatabuoys,'ocean');
	}) 

	document.getElementsByClassName("a-btn")[2].addEventListener("click",function(){
		//label("temperature","<img class='temperature' num='/'>12℃","<img class='temperature' num='25'>25℃","<img class='temperature' num='30'>30℃");
		for (var i = 0;i < buoys.length;i++) {
			var tmp = "<img class='temperature' num="+buoys[i].wqWattemp+">"+buoys[i].wqWattemp+"℃";
			buoys[i].flag=tmp;
		}
		for (var i = 0; i < nodatabuoys.length; i ++ ) {
    		nodatabuoys[i].isFault = 0;
    		nodatabuoys[i].flag='/';
    	}
		label(buoys,nodatabuoys,"temperature");
	}) 
}

// 右侧悬浮框关闭按钮
document.getElementById("close").addEventListener("click",function(){
	var left=document.getElementById("detail").offsetLeft+400;
    starMove(left,-20);
})

// 滑动
var timer=null;
function starMove(iTarget,speed){
	clearInterval(timer);
	var oDiv=document.getElementById("detail");
	timer=setInterval(function(){
		if(oDiv.offsetLeft==iTarget){
			clearInterval(timer);
		}else{
			oDiv.style.left=oDiv.offsetLeft-speed+'px';
		}
	},5)
}

//自定义

function getbuoy(){
	var returnData;
	$.ajax({
	    url:'map/getbuoys',
	    type:'POST',
	    async:false,   
	    timeout:5000,    //超时时间
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    success:function(data,textStatus,jqXHR){
	        if (data.type == 0) {
	        	//alert(data.message);
	        	flag = 0;
	        }
	        returnData = data.sysdata;
	    },
	    error:function(xhr,textStatus){
	        console.log('错误')
	        console.log(xhr)
	        console.log(textStatus)
	    }
	})
	return returnData;
}
/**
 * 转为map识别的维度形式
 * xxx.xxxx
 * xx.xxxx
 * @param n
 * @param text
 * @returns
 */
function locationChange(n,text){
	var arr=[];
	for(var i=0,len=text.length;i<len;i++){
	  arr[i]=text[i];
	}
	if (n == 1) {
		arr.splice(3,0,'.');
	}else {
		arr.splice(2,0,'.');
	}
//	arr.splice(n-1,0,'.');
//	arr.splice(n+2,0,'′');
	return arr.join("").substring(0,arr.length-1);
}
/**
 * 转为map识别的维度形式 原结尾不带坐标字母的转换
 * xxx.xxxx
 * xx.xxxx
 * @param n
 * @param text
 * @returns
 */
function locationChange3(n,text){
	var arr=[];
	for(var i=0,len=text.length;i<len;i++){
	  arr[i]=text[i];
	}
	if (n == 1) {
		arr.splice(3,0,'.');
	}else {
		arr.splice(2,0,'.');
	}
//	arr.splice(n-1,0,'.');
//	arr.splice(n+2,0,'′');
	return arr.join("").substring(0,arr.length);
}
//转为经纬度形式
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
//转为经纬度形式
//结尾不带浮标字母
function locationChange4(n,text){
	var arr=[];
	for(var i=0,len=text.length;i<len;i++){
	  arr[i]=text[i];
	}
	arr.splice(n-4,0,'°');
	arr.splice(n-1,0,'.');
	arr.splice(n+2,0,'′');
	if (n == 7) return arr.join("")+'E';
	else return arr.join("")+"N";
}
function preOrNextTime(type) {
	var buoy = $('#buoy').text();
	var time = $('#time').html();
	$.ajax({
	    url:'map/getortherdata',
	    type:'POST',
	    async:false,   
	    timeout:5000,    
	    dataType:'json',   
	    data:{
	    	buoy:buoy,
	    	time:time,
	    	type:type
	    },
	    success:function(data,textStatus,jqXHR){
	        if (data.type == 0) {
	        	return;
	        }
	        var buoy = data.sysdata.buoys;
	        $('#bDoorpolice').html(buoy.bDoorpolice);
	        $('#bHatch').html(buoy.bHatch);
	        $('#bWatpolice').html(buoy.bWatpolice);
	        $('#bShift').html(buoy.bShift);
	        $('#bVoltage').html(buoy.bVoltage);
	        $('#bBearing').html(buoy.bBearing);
	        $('#bRidlight').html(buoy.bRidlight);
	        $('#bFree').html(buoy.bFree);
	        
	        $('#time').html(buoy.time);
	        
	        $('#windSpeedMax').html(buoy.windSpeedMax+"m/s");
	        $('#windSpeedJito').html(buoy.windSpeedJito+"°");
	        $('#wHighMax').html(buoy.wHighMax+"m");
	        $('#wTo').html(buoy.wTo+"°");
	        $('#cSpeed1').html(buoy.cSpeed1+"cm/s");
	        $('#cTo1').html(buoy.cTo1+"°");
	        $('#wqWattemp').html(buoy.wqWattemp+"°C");
	        $('#wAirtemp').html(buoy.wAirtemp+"°C");
	    },
	    error:function(xhr,textStatus){
	        console.log('错误')
	        console.log(xhr)
	        console.log(textStatus)
	    }
	})
}

function clearData() {
 	$('#bDoorpolice').html("/");
    $('#bHatch').html("/");
    $('#bWatpolice').html("/");
    $('#bShift').html("/");
    $('#bVoltage').html("/");
    $('#bBearing').html("/");
    $('#bRidlight').html("/");
    $('#bFree').html("/ V");
    
    
    $('#windSpeedMax').html("/ m/s");
    $('#windSpeedJito').html(" /°");
    $('#wHighMax').html("/ m");
    $('#wTo').html("/ °");
    $('#cSpeed1').html("/ cm/s");
    $('#cTo1').html("/ °");
    $('#wqWattemp').html("/ °C");
    $('#wAirtemp').html("/ °C");
}
$(function(){
	opPosition();
//	zhexianChart();
//	clock($(".hailiu .second"),100);
//	clock($(".bo .second"),0);
//	for(var i=1;i<$(".wind tr td").length;i++)
//		clock($(".wind tr td").eq(i).find(".second"),30);
//
//	for(var i=0;i<$(".warning-box").length;i++){
//		$(".warning-box").eq(i).css({'marginLeft':20*i+'px'})
//	}
	// 错灯状态，在html里面262行传个"true"/"false";
	if($(".three .three-box .right-box .detail div").attr("on")=="true"){
		$(".three .three-box .right-box .detail div").css({'backgroundColor':'#ffec00'});
	}else{
		$(".three .three-box .right-box .detail div").css({'backgroundColor':'#7a7a7a'});
	}
})

$(window).resize(function(){
	opPosition();
})

$(".down-btn").click(function(){
	down($(this));
	// $(this).parents(".choose-btn").siblings().removeClass("choose-active");
	// $(this).parents(".choose ul li .downlist").removeClass("li-active");
	// $(".down-box").removeClass(".scroll-active");
	scroll(".active");
})

$(".fubiao-btn").click(function(){
	down($(this));
	scroll(".active");
})


$(".year").click(function(){
	down($(this));
	scroll(".active");
})

$(document).on("click",".zhanwei .down-list",function(event){
	downInstead($(this),$(this).parents(".down-box").siblings().find("span"));
})
$(document).on("click",".fubiao .down-list",function(event){
	downInstead($(this),$(this).parents(".down-box").siblings().find("span"));
})


$(document).on("click",".calendar .down-list",function(event){
	downInstead($(this),$(this).parents(".down-box").siblings().find(".year"));
})
$('.fubiao div').click(function(event) {
	event.stopPropagation();
})

$('.calendar div').click(function(event) {
	event.stopPropagation();
})

$('.choose .choose-btn:first-child div').click(function(event) {
	event.stopPropagation();
})

$(document).click(function() {
	$('.down-box').hide();
	$(".down-box").removeClass("active");
})

// 刷新页面
$(".refresh").click(function(){
	location.reload();
})



$(".qixiang a").click(function(){
	$(".change > p").text($(this).parent().siblings().text());
})

$(".shuiwen a").click(function(){
	$(".change > p").text($(this).parent().siblings().text());
})

$(".hailiu a").click(function(){
	$(".change > p").text($(this).siblings().text());
})

$(".bo a").click(function(){
	$(".change > p").text($(".bo table tr:first-child th").eq($(this).parent().index()).text()+$(this).parents("tr").find("td:first-child").text());
})

$(".wind a").click(function(){
	$(".change > p").text($(".wind table tr:first-child th").eq($(this).parent().index()).text()+$(this).parents("tr").find("td:first-child").text());
})

//$(document).on('click', '.choose-btn-station div label,.choose-btn-buoy div label', function(){
//	if($(this).parents(".choose-btn").hasClass("choose-active")){
//		$(this).parents(".choose-btn").removeClass("choose-active");
//	}else{
//		$(".down-box").removeClass("active");
//		$(this).parents(".choose-btn").addClass("choose-active");
//		$(this).parents(".choose-btn").siblings().removeClass("choose-active");
//		$(".down-box").removeClass("scroll-active");		
//		$(".choose-active").find(".down-box").addClass("scroll-active");
//		$(".down-box").hide();
//		if ($(this).hasClass('choose-btn-station')) {
//			scroll(".scroll-active");
//		} else {
//			scroll(".scroll-active");
//		}
//	}
//})

// 滚轮事件：滚动选中
$(".choose-btn div label").click(function(){
	if($(this).parents(".choose-btn").hasClass("choose-active")){
		$(this).parents(".choose-btn").removeClass("choose-active");
	}else{
		$(".down-box").removeClass("active");
		$(this).parents(".choose-btn").addClass("choose-active");
		$(this).parents(".choose-btn").siblings().removeClass("choose-active");
		$(".down-box").removeClass("scroll-active");		
		$(".choose-active").find(".down-box").addClass("scroll-active");
		$(".down-box").hide();
		//不同选项滚轮触发不同函数
		if ($(this).parents(".choose-btn").hasClass('choose-btn-station')) {
			scroll(".scroll-active",1);
		}else if ($(this).parents(".choose-btn").hasClass('choose-btn-buoy')) {
			scroll(".scroll-active",2);
		}else {
			scroll(".scroll-active",3);
		}
		//scroll(".scroll-active");
	}
})

function scroll(obj,flag){
	var index=0;
	$(document).off('mousewheel DOMMouseScroll').on("mousewheel DOMMouseScroll", function (e) {
		// $(".down-box").hide();
		// $(".choose-active").find(".down-box").addClass("active");

		var delta = (e.originalEvent.wheelDelta && (e.originalEvent.wheelDelta > 0 ? 1 : -1)) ||  // chrome & ie
		            (e.originalEvent.detail && (e.originalEvent.detail > 0 ? -1 : 1));
		if (delta < 0){
			index++;
			if(index>$(".choose "+obj+" li").length-1){
				index=0;
				$(".choose "+obj).scrollTop(0);
			}
			if(index>5){
				var top=$(".choose "+obj).scrollTop();
				$(".choose "+obj).scrollTop(top+20);
			}
		}else if (delta > 0) {
			index--;
			if(index<0){
				index=$(".choose "+obj+" li").length-1;
				$(".choose "+obj).scrollTop($(".choose "+obj+" li").length*20-120);
		 	}
		 	if(index<5){
		 		var top=$(".choose "+obj).scrollTop();
				$(".choose "+obj).scrollTop(top-20);
		 	}
		}
		console.log(index);
		$(".choose li a").removeClass("li-active");
		$(".choose "+obj).find("li:eq("+index+") a").addClass("li-active");
		if(index>5){
			var top=$(".choose "+obj).scrollTop();
			$(".choose "+obj).scrollTop(top+20);
		}
		var litext=$(".li-active").text();
		var lispan = $(".choose "+obj).find("li:eq("+index+") span").text();
		$(obj).parent().find("div span").text(litext);
		if (flag == 1) {
			selectByStation(lispan);
		}else if (flag == 2) {
			selectByBuoy(litext,lispan);
		}else if (flag == 3) {
			selctByTime(lispan);
		}
		//$(".choose "+obj).find("li:eq("+index+") a").trigger("click");
//		$(".li-active").trigger("click");
	})
}

// 报警
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

function down(obj){
	if(obj.parents(".choose-btn").find(".down-box").hasClass("active")){
		obj.parents(".choose-btn").find(".down-box").hide();
		obj.parents(".choose-btn").find(".down-box").removeClass("active");
	}else{
		obj.parents(".choose-btn").siblings().find(".down-box").removeClass("active");
		obj.parents(".choose-btn").siblings().find(".down-box").hide();

		obj.parents(".choose-btn").find(".down-box").show();
		obj.parents(".choose-btn").find(".down-box").addClass("active");
		obj.parents(".choose-btn").siblings().removeClass("choose-active");
		obj.parents(".choose-btn").addClass("choose-active");
		$(".down-box").removeClass("scroll-active");
		//$(".down-box").scrollTop(0);
		//obj.parents(".choose-btn").find(".down-box li").eq(0).find("a").addClass("li-active");

	}
}

function downInstead(obj,contain){
	var text=obj.html();
	contain.html(text);
	obj.parents(".down-box").removeClass("active");
	obj.parents(".down-box").addClass("scroll-active");
	obj.parents(".down-box").hide();
	scroll(".scroll-active")
}

// 各元素位置自适应
function opPosition(){
	$(".three-box").css({'width':$(".three").width()*0.32+'px'});
	$(".three-box").css({'marginRight':$(".three").width()*0.02+'px'});
	if($(".box").height()<$(window).height()){
		$(".box").css({'height':$(window).height()+'px'})
	}
}

// 仪表盘指针转动
function clock(obj,deg){
	obj.css("transform","rotate("+deg+"deg)");
	obj.css("-moz-transform","rotate("+deg+"deg)");
	obj.css("-o-transform","rotate("+deg+"deg)");
	obj.css("-ms-transform","rotate("+deg+"deg)");
	obj.css("-webkit-transform","rotate("+deg+"deg)");
}

function zhexianChart(){
	var myChart = echarts.init(document.getElementById('zhexian'));

	// 指定图表的配置项和数据
	var date=[];
	var max=240;
	var min=0;
	date[0]=min;
	for(var i=1;i<24;i++){
	    date.push((max-min)/24*i);
	}
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
	        data: date, 
	    },
	    yAxis: {},
	    series: [{
	        name: '风速',
	        type: 'line',
	        data: [5, 20, 36, 10, 10, 20,5, 20, 36, 10, 10, 20,5, 20, 36, 10, 10, 60,5, 20, 36, 10, 10, 20],
	    }],
	    dataZoom: [{
	        type: 'slider',
	        start: 0,
	        end: 30,
	    }],
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
}

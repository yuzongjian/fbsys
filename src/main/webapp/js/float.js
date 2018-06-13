var jing=false;
var wei=false;

$(function(){
	$(".container > div").css({'minHeight':$(".setting").height()+$("table").height()+30+'px','height':$(window).height()-160+'px'})
})

$(window).resize(function(){
	$(".container > div").css({'minHeight':$(".setting").height()+$("table").height()+30+'px','height':$(window).height()-160+'px'})
})

// 点击设置
$(document).on('click','.setting-btn',function(event){
	if($(".setting-box").hasClass("disnone")){
		$(".setting-box").removeClass("disnone");
		$(".refresh").removeClass("disnone");
		$(this).html('保存设置');
		$(this).addClass("yellow");
		stopDefault();
	}else{

		var data = [];
		var v = -1;
		$("#table").find('tr').each(function() {
			if (v != -1) {
				
				k = [];
				$(this).find('.tag').each(function() {
		    		 k.push($(this).text());
		    	});
				var s = k[6].split(" ");
				var str = "";
				for(var i = 0; i< k.length - 1; i++) {
					str = str + k[i] + ",";
				}
				s[0] = locationChange2(s[0].substring(1));
				s[1] = locationChange2(s[1].substring(1));
				str = str + s[0] + "," + s[1];
				data[v] = str;
				v = v + 1;
			}else {
				v = 0;
			}
			
		});
		var s ;
		s = data.join("|");
		$.ajax({
		    url:'buoy/saveorupdate',
		    type:'POST', 
		    async:false,   
		    data:{
		 	   	data:s
		    },
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
		        if (data.type == 1) {
		        	alert(data.message);
		        }
		        if (data.type == 0) {
		        	alert(data.message);
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
		$(".setting-box").addClass("disnone");
		$(".refresh").addClass("disnone");
		$(this).html('<i class="fa fa-cog"></i>设置');
		$(this).removeClass("yellow");
		location.reload();
	}
})

$(document).on('click','.save',function(event){

})

// 取消保存
$(".refresh").click(function(){
	location.reload();
})

// 修改浮标
$(document).on('click','.modify-btn',function(event){
	kuang($(this),-245,-230,'修改浮标','modify');
	var t = $(this).parents("tr").find("td:eq(4)").text();	
	$(".increase-float form").find(".fubiao-num").removeClass("disnone");
	$(".increase-float form").find(".location").removeClass("disnone");
	$(".increase-float input").eq(0).removeClass("on");
	$(".increase-float input").eq(1).addClass("on");
	$(".increase-float input").eq(2).addClass("on");
	$(".increase-float input").eq(3).addClass("on");
	//设置原始参数
	$(".increase-float form").find(".fubiao-num").val($(this).parents("tr").find("td:eq(5)").text());
	var k = $(this).parents("tr").find("td:eq(6)").text().split(" ");
	k[0] = k[0].substring(1);
	//locationChange2();
	k[0] = locationChange2(k[0]);
	k[1] = k[1].substring(1);
	k[1] = locationChange2(k[1]);
	$(".increase-float form").find(".jing").val(k[0]);
	$(".increase-float form").find(".wei").val(k[1]);
	$(".increase-float textarea").addClass("margintop");
})

// 点击增加站位号
$('.increase-btn').click(function(){
	kuang($(this),-245,-230,'增加站位号','increase');
	$(".increase-float form").find("p").addClass("disnone");
	for(var i=0;i<$(".increase-float input[type='text']").length;i++){
		$(".increase-float input").eq(i).removeClass("disnone").addClass("on");
	}
	$(".increase-float textarea").addClass("margintop");
})

// 点击删除站位号
$('.delete-btn').click(function(event){
	if($(this).hasClass("on")){
		$(this).removeClass("on");
		$(".delete").remove();
	}else{
		$("table tr td:last-child").append("<a href='javascript:;' class='delete'>删除</a>");
		$(this).addClass("on");
	}
})

// 点击删除出现弹框
$(document).on('click','.delete',function(event){
	kuang($(this),-182,-151,'删除站位号','delete-sure');
	$(".increase-float form").find(".fubiao-num").addClass("disnone");
	for(var i=0;i<$(".increase-float input[type='text']").length;i++){
		$(".increase-float input").eq(i).removeClass("on");
	}
	$(".increase-float textarea").removeClass("margintop")
})

$(".dask").click(function(){
	primary();
})

// 确定删除站位号未保存到后台
$(document).on('click','.delete-sure',function(event){
	if($(".increase-float .on").val()==''){
		error();
	}else{
		$("tr.choosen td:nth-child(5)").attr("hidden",true);
		$("tr.choosen td:nth-child(6)").attr("hidden",true);
		$("tr.choosen td:nth-child(7)").attr("hidden",true);
		$("tr.choosen td:nth-child(8)").attr("hidden",true);
		$("tr.choosen td:nth-child(1)").text(1);
		$("tr.choosen td:nth-child(3)").text("");
		$("tr.choosen td:nth-child(4)").text($(this).parents('form').find(".text").val());
		
//		$("tr.choosen").remove();
		primary();
		$(".setting-btn").addClass("save");
	}
})

// 确定添加站位号未保存到后台
$(document).on('click','.increase',function(event){
	var flag=true;
	for(var i=0;i<$(".increase-float .on").length;i++){
		if($(".increase-float .on").eq(i).val()=='')
			flag=false;
	}
	if(!flag||!jing||!wei){
		error();
	}else{
		// 1删除 2id 3时间 4 备注 5 站位号 6 浮标号 7 经纬度
		var jingdu=locationChange(7,$(".jing").val());
		var weidu=locationChange(6,$(".wei").val());
		$("table").append('<tr>'+
				'<td hidden=true class=tag></td><td hidden=true class=tag></td><td hidden=true class=tag></td>'+
	            '<td hidden=true class=tag>'+$(this).parents('form').find(".text").val()+'</td>'+
							'<td class=tag>'+$(this).parents('form').find(".zhanwei").val()+'</td>'+
							'<td class=tag>'+$(this).parents('form').find(".fubiao-num").val()+'</td>'+
							'<td class=tag>'+'E'+jingdu+' N'+weidu+'</td>'+
							'<td>'+
								'<a class="modify-btn" href="javascript:;">修改</a>'+
							'</td>'+
						'</tr>');
		if($(".delete-btn").hasClass("on"))
			$("table tr:last-child td:last-child").append('<a class="delete" href="javascript:;">删除</a>')
		primary();
		$(".setting-btn").addClass("save");
	}
})

// 确定修改站位号未保存到后台
$(document).on('click','.modify',function(event){
	if($(".increase-float .on").val()==''||$("textarea").val()==''||
			$(".increase-float form").find(".jing").val() == "" ||
			$(".increase-float form").find(".jing").val()==''){
		error();
	}else{
		var stationid = $("tr.choosen td:nth-child(5)").text();
		//alert(stationid);
		var buoyid = $(".fubiao-num").val();
		var describe = $(".text").val();
		var flag = 0;
		var jing = $(".jing").val();
		var wei = $(".wei").val();
		var jingdu=locationChange(7,$(".jing").val());
		var weidu=locationChange(6,$(".wei").val());
		if(!$(".setting-box").hasClass("disnone")) {
			$("tr.choosen td:nth-child(4)").text($(this).parents('form').find(".text").val());
			$("tr.choosen td:nth-child(3)").text("");
			$("tr.choosen td:nth-child(6)").text($(".fubiao-num").val());
//			$("tr.choosen td:nth-child(7)").text($(".jing").val()+' '+$(".wei").val());
			$("tr.choosen td:nth-child(7)").text('E'+jingdu+' N'+weidu);
			primary();
			$(".setting-btn").addClass("save");
			return;
		} 
		$.ajax({
		    url:'buoy/updatebuoy',
		    type:'POST', //GET
		    async:false,    //或false,是否异步
		    data:{
		    	stationid:stationid,
		    	buoyid:buoyid,
		    	longitude:jing,
		    	latitude:wei,
		    	describe:describe
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
		        if (data.type == 0) {
		        	alert(data.message);
		        	flag = 1;
		        }else {
		        	alert(data.message);
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
		if (flag == 1) return;
		$("tr.choosen td:nth-child(4)").text($(this).parents('form').find(".text").val());
		$("tr.choosen td:nth-child(3)").text("");
		$("tr.choosen td:nth-child(6)").text($(".fubiao-num").val());
		$("tr.choosen td:nth-child(7)").text('E'+jingdu+' N'+weidu);
		primary();
		$(".setting-btn").addClass("save");
	}
})

$(".jing").focus(function(){
	$(".increase-float form > .jing-ex").html('<img src="images/a.png">请输入7位数字，不需要输入小数点，如：1132455');
})

$(".wei").focus(function(){
	$(".increase-float form > .wei-ex").html('<img src="images/a.png">请输入6位数字，不需要输入小数点，如：1132455');
})

$(".jing").blur(function(){
	var num=/^[A-Za-z0-9]+$/;
	if($(this).val().length==7&&num.test($(this).val())){
		$(this).next().html("<img src='images/true.png'>输入正确");
		jing=true;
	}else{
		$(this).next().html("<img src='images/error.png'>请输入正确格式");
	}
})

$(".wei").blur(function(){
	var num=/^[A-Za-z0-9]+$/;
	if($(this).val().length==6&&num.test($(this).val())){
		$(this).next().html("<img src='images/true.png'>输入正确");
		wei=true;
	}else{
		$(this).next().html("<img src='images/error.png'>请输入正确格式");
	}
})

// 错误提示
function error(){
	$(".error").animate({'top':'0px'},100);
}

// 弹框样式
function kuang(obj,css,animate,text,operate){
	var num=obj.parents("tr").find("td:eq(4)").text();	
	$(".increase-float form p span").text(num);
	kuangOpen(css,animate,text,operate);
	$(".increase-float form").find("p").removeClass("disnone");
	$(".increase-float form").find(".zhanwei").addClass("disnone");
	$(".increase-float form").find(".location").addClass("disnone");
	obj.parents("tr").addClass("choosen");
	obj.parents("tr").siblings().removeClass("choosen");
	$(".increase-float form > span").html("");
	jing=false;
	wei=false;
}

function kuangOpen(css,animate,text,operate){
	$(".dask").removeClass("disnone");
	$(".increase-float").removeClass("disnone");
	$(".increase-float").css({'marginTop':css+'px'});
	$(".increase-float").animate({'marginTop':animate+'px'},150);
	$(".increase-float > p span").text(text);
	$(".increase-float form input[type='button']").attr('class',operate);
}

function primary(){
	$(".dask").addClass("disnone");
	$(".increase-float").addClass("disnone");
	$(".increase-float").animate({'marginTop':'-200px'},200);
	$(".increase-float form").find("p").addClass("disnone");
	$(".increase-float form").find(".zhanwei").addClass("disnone");
	$(".increase-float form").find(".fubiao-num").addClass("disnone");
	$(".increase-float form").find(".location").addClass("disnone");
	$(".increase-delete").removeClass("increase");
	$("table tr").removeClass("choosen");
	$(".error").animate({'top':'-35px'},100);
	for(var i=0;i<$(".on").length;i++){
		$(".on").eq(i).val('');
	}
}
//转为经纬度形式
function locationChange(n,text){
	var arr=[];
	for(var i=0,len=text.length;i<len;i++){
	  arr[i]=text[i];
	}
	arr.splice(n-4,0,'°');
	arr.splice(n-1,0,'.');
	arr.splice(n+2,0,'’');
	return arr.join("");
}
//去除经纬度的标点符号
function locationChange2(text){
	/*var arr=[];
	for(var i=0,len=text.length;i<len;i++){
	  arr[i]=text[i];
	}
	arr.splice(n-4,0);
	arr.splice(n-1,0);
	arr.splice(n+2,0);*/
	text = text.replace('°',"");
	text = text.replace('.',"");
	text = text.replace('’',"");
	return text;
}
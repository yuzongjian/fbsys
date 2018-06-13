$(function(){
	container()
})

$(window).resize(function(){
	container()
})

function container(){
	$(".container > div").css({'minHeight':$(".setting").height()+$("table").height()+30+'px','height':$(window).height()-160+'px'})
	if($(".container").height()<$(window).height()){
		$(".container").css({'height':$(window).height()+'px'});
	}	
	$(".container").css({'width':$("body").width()-60+'px'});
}

// 点击设置
$(document).on('click','.setting-btn',function(event){
	if($(".setting-box").hasClass("disnone")){
		$(".setting-box").removeClass("disnone");
		$(".refresh").removeClass("disnone");
		$(this).html('保存设置');
		$(this).addClass("yellow");
		stopDefault();
	}else{
		//1 真实姓名 2账号 3权限 4 时间 5 锁定 6 id 7 权限id 8 ？ 9 删除 10 修改标志 11密码 
		var data = [];
		v = -1;
		$("#table").find('tr').each(function() {
			if (v != -1) {
				var k = [];
				$(this).find('.tag').each(function() {
		    		 k.push($(this).text());
		    	});
				if (k[4] == '启用') {
					k[4] = 0;
				}else {
					k[4] = 1;
				}
				//alert(k[6]);
				k[6] = k[6].replace(/\,/g, '%');
				data[v] = k;
				v = v + 1;
			}else {
				v = 0;
			}
			
			
		});
		data = data.join("|");
		$.ajax({
		    url:'user/modify',
		    type:'POST', 
		    async:false,   
		    data:{
		 	   	datas:data
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

// 修改用户权限
$(document).on('click','.modify-btn',function(event){
	kuang($(this),-230,-190,'修改浮标','modify');
	$(".increase-float form").find(".status").removeClass("disnone");
	$(".increase-float form").find(".right").removeClass("disnone");
	$(".increase-float form").find(".fubiao-num").addClass("disnone");
	$(".increase-float form [type='password']").addClass("disnone");
	for(var i=0;i<$(".increase-float input[type='text']").length;i++){
		$(".increase-float input").eq(i).removeClass("on");
	}
	$(".increase-float form [type='password']").removeClass("on");
	for(var i=0;i<$(".right label").length;i++){
		for(var j=0;j<$(".container table tr.choosen td:nth-child(3) span").length;j++)
			
			if($(".right label").eq(i).find("span").text()==$(".container table tr.choosen td:nth-child(3)").find("span").eq(j).text())
				$(".right label").eq(i).find("input[type='checkbox']").prop("checked",true)
	}
	
	if ($("tr.choosen td:nth-child(5)").text() == '禁用') {
		$("#status2").prop("checked",true);
	}else {
		$("#status1").prop("checked",true);
	}
})


// 点击增加用户
$('.increase-btn').click(function(){
	kuang($(this),-221,-190,'增加用户','increase');
	$(".increase-float form").find("p").addClass("disnone");
	$(".increase-float form [type='password']").removeClass("disnone");
	$(".increase-float form").find(".status").removeClass("disnone");
	$(".increase-float form").find(".right").removeClass("disnone");
	for(var i=0;i<$(".increase-float input[type='text']").length;i++){
		$(".increase-float input").eq(i).removeClass("disnone").addClass("on");
	}
	$(".increase-float form [type='password']").addClass("on");
})

// 点击删除用户
$('.delete-btn').click(function(event){
	if($(this).hasClass("on")){
		$(this).removeClass("on");
		$(".delete").remove();
	}else{
		$(".container table tr td:nth-child(6)").append("<a href='javascript:;' class='delete'>删除</a>");
		$(this).addClass("on");
	}
})

// 点击删除出现弹框
$(document).on('click','.delete',function(event){
	kuang($(this),-182,-151,'删除用户','delete-sure');
	$(".increase-float form").find(".fubiao-num").addClass("disnone");
	$(".increase-float form [type='password']").addClass("disnone");
	$(".increase-float form .status").addClass("disnone");
	$(".increase-float form .right").addClass("disnone");
	for(var i=0;i<$(".increase-float input[type='text']").length;i++){
		$(".increase-float input").eq(i).removeClass("on");
	}
	$(".increase-float form [type='password']").removeClass("on");
})

$(".dask").click(function(){
	primary();
})

// 确定删除用户未保存到后台
$(document).on('click','.delete-sure',function(event){
	var nowuser = $("#nowuser").text();
	if ('admin' == $("tr.choosen td:nth-child(2)").text()) {
		alert("无法删除admin账号");
		return;
	}
	if (nowuser == $("tr.choosen td:nth-child(2)").text()) {
		alert("无法删除自己的账号");
		return;
	}
	
	if($(".increase-float .on").val()==''){
		error("输入框不能为空");
	}else{
		$("tr.choosen td:nth-child(1)").attr("hidden",true);
		$("tr.choosen td:nth-child(2)").attr("hidden",true);
		$("tr.choosen td:nth-child(3)").attr("hidden",true);
		$("tr.choosen td:nth-child(4)").attr("hidden",true);
		$("tr.choosen td:nth-child(5)").attr("hidden",true);
		$("tr.choosen td:nth-child(6)").attr("hidden",true);
		$("tr.choosen td:nth-child(9)").text($('.text').val());
		$("tr.choosen td:nth-child(10)").text('1');
		$("tr.choosen td:nth-child(11)").text('1');
		
		//$("tr.choosen").remove();
		primary();
		$(".setting-btn").addClass("save");
//		$("tr.choosen").remove();
//		primary();
//		$(".setting-btn").addClass("save");
	}
})

// 确定修改站位号未保存到后台
$(document).on('click','.modify',function(event){
	if($(".increase-float .on").val()==''||$("textarea").val()==''){
		error();
	}else{
		ids = [];
		for(var i=0;i<$(this).parents('form').find("input[type='checkbox']:checked").length;i++){
			ids.push($(this).parents('form').find("input[type='checkbox']:checked").eq(i).val()); 
			//$(this).parents('form').find("input[type='checkbox']:checked").eq(i).val()
		}
		
		$(".container table tr td:nth-child(3)").removeClass("right-detail");
		$("tr.choosen td:nth-child(5)").text($(".status input[type='radio']:checked").parent().find("span").text());
		$("tr.choosen td:nth-child(3)").addClass("right-detail");
		$("tr.choosen td:nth-child(3)").text("");
		for(var i=0;i<$(this).parents('form').find("input[type='checkbox']:checked").length;i++){
			$(".right-detail").append("<span>"+$(this).parents('form').find("input[type='checkbox']:checked").eq(i).parent().find("span").text()+"</span>")
		}
		$("tr.choosen td:nth-child(9)").text($('.text').val());
		$("tr.choosen td:nth-child(8)").text(ids);
		if (ids== "") {
			alert("权限不能为空!");
			return;
		}
		var nowuser = $("#nowuser").text();
		if ('admin' == $("tr.choosen td:nth-child(2)").text()) {
			alert("无法修改admin账号");
			return;
		}
		if (nowuser == $("tr.choosen td:nth-child(2)").text()) {
			alert("无法修改自己的账号");
			return;
		}
		if(!$(".setting-box").hasClass("disnone")) {
			
			$("tr.choosen td:nth-child(11)").text('1');
			primary();
			$(".setting-btn").addClass("save");
			return;
		}else {
			var status = true;
			if($("tr.choosen td:nth-child(5)").text() == '禁用') {
				status = true;
			}else {
				status = false;
			}
			//id
			var id = $("tr.choosen td:nth-child(7)").text();
			var beizhu = $("tr.choosen td:nth-child(9)").text();
			var username = $("tr.choosen td:nth-child(1)").text();
			
			$.ajax({
			    url:'users/update',
			    type:'POST', //GET
			    async:false,    //或false,是否异步
			    data:{
			    	id:id,
			    	beizhu:beizhu,
			    	locked:status,
			    	ids:ids,
			    	username:username
			    	//describe:describe
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
			primary();
			$(".setting-btn").addClass("save");
		}
	}
})

// 确定添加用户未保存到后台
$(document).on('click','.increase',function(event){
	var flag=true;
	for(var i=0;i<$(".increase-float .on").length;i++){
		if($(".increase-float .on").eq(i).val()==''){
			flag=false;
			error("输入框不能为空");
		}
	}
	if($(".increase-float input[type='checkbox']:checked").length==0){
		flag=false;
		error("请选择管理员权限");
	}
	if($(".increase-float form input[type='password']").val().length>16||$(".increase-float form input[type='password']").val().length<6){
		flag=false;
		error("密码超出范围");
	}
	var checkedResult = checkUserName($(this).parents('form').find(".fubiao-num").val());
	if (!checkedResult) {
		flag=false;
		error("账号名已经存在");
	}
	if(flag){
		var date=new Date();
		// var arr=new Array($("input[type='password']").val().length);
		// for(var i=0;i<arr.length;i++){
		// 	arr[i]="*"
		// }
		ids = [];
		for(var i=0;i<$(this).parents('form').find("input[type='checkbox']:checked").length;i++){
			ids.push($(this).parents('form').find("input[type='checkbox']:checked").eq(i).val()); 
			//$(this).parents('form').find("input[type='checkbox']:checked").eq(i).val()
		}
		//alert(ids);
		//var pwd = $(".pwd").val();
		var pwd = $(".increase-float form input[type='password']").val()
		$(".container table tr td:nth-child(3)").removeClass("right-detail");
		$(".container table").append('<tr>'+
							'<td class=tag>'+$(this).parents('form').find(".zhanwei").val()+'</td>'+
							'<td class=tag>'+$(this).parents('form').find(".fubiao-num").val()+'</td>'+
							//'<td>'+$("input[type='password']").val()+'</td>'+
							'<td class="right-detail tag"></td>'+
							'<td class=tag>'+date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+'</td>'+
							'<td class=tag>'+$(this).parents('form').find("input[type='radio']:checked").parent().find("span").text()+'</td>'+
							'<td>'+
								'<a class="modify-btn" href="javascript:;">修改</a>'+
							'</td>'+
							'<td hidden=true class=tag></td>'+
							
							'<td hidden=true class=tag>'+ids+'</td>'+
							'<td hidden=true class=tag>'+$('.text').val()+'</td>'+
							'<td hidden=true class=tag>0</td>'+
							'<td hidden=true class=tag>1</td>'+
							'<td hidden=true class=tag>'+pwd+'</td>'+
						'</tr>');
		// $(".password").html(arr);
		// $("tr td:nth-child(3)").removeAttr("class");
		for(var i=0;i<$(this).parents('form').find("input[type='checkbox']:checked").length;i++){
			$(".right-detail").append("<span>"+$(this).parents('form').find("input[type='checkbox']:checked").eq(i).parent().find("span").text()+"</span>")
		}
		if($(".delete-btn").hasClass("on"))
			$("table tr:last-child td:last-child").append('<a class="delete" href="javascript:;">删除</a>')
		primary();
		$(".setting-btn").addClass("save");
	}
})

// 错误提示
function error(text){
	$(".error").animate({'top':'0px'},100);
	$(".error").find("span").text(text);
}

// 弹框样式
function kuang(obj,css,animate,text,operate){
	var num=obj.parents("tr").find("td:eq(0)").text()	
	$(".increase-float form p span").text(num);
	kuangOpen(css,animate,text,operate);
	$(".increase-float form").find("p").removeClass("disnone");
	$(".increase-float form").find(".zhanwei").addClass("disnone");
	$(".increase-float form").find(".location").addClass("disnone");
	obj.parents("tr").addClass("choosen");
	obj.parents("tr").siblings().removeClass("choosen");
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
	$(".increase-float form").find("input[type='password']").addClass("disnone");
	$(".increase-float .status").addClass("disnone");
	$(".increase-float .right").addClass("disnone");
	$(".increase-delete").removeClass("increase");
	$("table tr").removeClass("choosen");
	$(".error").animate({'top':'-35px'},100);
	$(".increase-float .right input[type='checkbox']:checked").attr("checked",false)
	for(var i=0;i<$(".on").length;i++){
		$(".on").eq(i).val('');
	}
}

function checkUserName(username) {
	//alert("hehe-"+username);
	var flag = 1;
	$.ajax({
	    url:'users/checked',
	    type:'POST',
	    async:false,   
	    data:{
	    	username:username
	    },
	    timeout:5000,    //超时时间
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    success:function(data,textStatus,jqXHR){
	        console.log(data)
	        console.log(textStatus)
	        console.log(jqXHR)
	        if (data.type == 0) {
	        	//alert(data.message);
	        	flag = 0;
	        }
	    },
	    error:function(xhr,textStatus){
	        console.log('错误')
	        console.log(xhr)
	        console.log(textStatus)
	    }
	})
	return flag;
}
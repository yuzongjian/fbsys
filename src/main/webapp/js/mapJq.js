$(function(){
	for(i=0;i<$(".alert").length;i++)
		$(".alert").eq(i).attr("num",i)
})

$(".alert").click(function(){
	$(this).siblings().removeClass("active");
	$(this).addClass("active");
	var num=$(this).attr("num");
	$(".table").animate({'marginLeft':-336*num+'px'},200);
	$(".detail-box .table").scrollTop(0);
})

$(document).on('click','.a-btn',function(event){
	if(!$(this).hasClass("active")){
		$(this).parent().siblings().find("a").removeClass("active");
		$(this).addClass("active");
	}
})

$(document).on('click','.aaa',function(event){
	alert("a")
})
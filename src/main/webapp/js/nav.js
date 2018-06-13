$(function(){
	navPosition();
})

$(window).resize(function(){
	navPosition();
})

function navPosition(){
	var screenHeight=$(window).height();
	var screenWidth=$(window).width();
	$(".nav").css({'height':$(window).height()+'px'});
	if($(".container").height()<$(window).height()){
		$(".container").css({'height':$(window).height()+'px'});
	}
	$(".box").css({'width':$("body").width()-60+'px'});
}

$(".list").hover(function(){
	$(this).parent("li").siblings().find("ul").stop(true,true);
	$(this).parent("li").siblings().find("ul").css({'display':'none','top':'-30px'});
	$(this).parent("li").find("ul").css('display','block');
	$(this).parent("li").find("ul").animate({'opacity':'1','top':'0'},200);
})

$(".nav").mouseleave(function(){
	$(this).find("ul li ul").css({'display':'none','top':'-30px'});
})

function stopDefault( e ) { 
	if ( e && e.preventDefault ) 
		e.preventDefault(); 
	else 
		window.event.returnValue = false; 
	return false; 
} 
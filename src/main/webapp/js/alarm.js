$(function(){
	if ($("#inp").attr("checked")) {
            $(this).parents(".control").find("#section").css({'display':'block'});
        }
})

$(".btn").click(function(){
	if($(this).parent().find("#inp").attr("checked")){
		$(this).find("#change").html("off");
		$(this).find("#change").animate({'left':'24px'},100);
		$(this).parents(".control").find("#section").css({'display':'none'});
		$(this).parent().find("#inp").removeAttr("checked");
		$(this).css({'backgroundColor':'#ddd'})
	}else{
		$(this).find("#change").html("on");
		$(this).find("#change").animate({'left':'0px'},100);
		$(this).parents(".control").find("#section").css({'display':'block'});
		$(this).parent().find("#inp").attr("checked","checked");
		$(this).css({'backgroundColor':'#abcdef'})
	}
})
$(function(){
    $(".container .table-box").css({'minHeight':$("table").height()+$("page-box").height()+50+'px','height':$(window).height()-180+'px'})
})

$(window).resize(function(){
    $(".container .table-box").css({'minHeight':$("table").height()+$("page-box").height()+50+'px','height':$(window).height()-180+'px'})
})

$(".choose-all").click(function(){
    if($(this).hasClass('active')){
        $(this).find('img').attr('src','images/choose-empty.png');
        $(this).removeClass('active');
    }else{
        $(this).find('img').attr('src','images/choose-all.png');
        $(this).addClass('active');
    }
})

// 模式切换
$(".change").click(function(){
    if($(this).hasClass("download")){
        // 数据导出模式
        $(".choose-box").removeClass("disnone");
        $(this).text("查看日志模式");
        $(this).removeClass("download");
    }else{
        // 查看图表模式
        $(".choose-box").addClass("disnone");
        $(this).text("日志导出模式");
        $(this).addClass("download");
    }
})
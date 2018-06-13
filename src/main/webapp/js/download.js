$(function(){
    for(var i=0;i<$(".table-btn").length;i++){
        $(".table-btn").eq(i).attr('index',i);
    }
})

// 点击导出报表出现弹框
$(".choose-table").click(function(){
    $(".dask").removeClass("disnone");
    $(".table-type").removeClass("disnone");
    $(".table-type").animate({'marginTop':'-100px'},150);
})

// 点击遮罩层弹框消失
$(".dask").click(function(){
    $(".dask").addClass("disnone");
    $(".table-type").addClass("disnone");
    $(".table-type").animate({'marginTop':'-130px'},150);
})

// 弹框切换
$(".table-btn").click(function(){
    num=$(this).attr('index');
    $(".type").animate({'marginLeft':-num*300},200);
    $(this).siblings().removeClass("active")
    $(this).addClass("active")
})
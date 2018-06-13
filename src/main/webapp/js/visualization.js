$(function(){
//	zhexian(document.getElementById('zhexian'));
//    zhexian(document.getElementById('expand-zhexian'));
//
//    $(".head").css({'width':$(window).width()-140+'px'});
});

// 折线图
function zhexian(obj){
    var myChart = echarts.init(obj);

    // 指定图表的配置项和数据
    var date=[];
    var max=240;
    var min=0;
    date[0]=min;
    for(var i=1;i<24;i++){
        date.push((max-min)/24*i);
    }
    var option = {
        tooltip: {
            trigger: 'axis'
        },
        legend:{
            data: ['浮标1','浮标2','浮标3']
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: date, 
        },
        yAxis: {},
        series: [
            {
                name: '浮标1',
                type: 'line',
                data: [5, 20, 36, 10, 10, 20,5, 20, 36, 10, 10, 20,5, 20, 36, 10, 10, 60,5, 20, 36, 10, 10, 20],
            },
            {
                name: '浮标2',
                type: 'line',
                data: [15, 2, 56, 40, 47, 28,15, 2, 56, 40, 47, 28,15, 2, 56, 40, 47, 28,15, 2, 56, 40, 47, 28],
            },
            {
                name: '浮标3',
                type: 'line',
                data: [1, 6, 50, 48, 12, 45,35, 1, 6, 50, 48, 12, 45,35,1, 6, 50, 48, 12, 45,35,1, 6, 50],
            }
        ],
        dataZoom: [{
            type: 'slider',
            start: 0,
            end: 30,
        }],
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

// 双击折线图
$("#zhexian").dblclick(function(){
    $(".zhexian-box").removeClass("disnone");
    $(".zhexian-box").css({'height':$(window).height(),'width':$(window).width()});
    $(".zhexian-box").addClass("active");
})

$(".close-expand").click(function(){
    $(".zhexian-box").addClass("disnone");
})

$(".zhexian-box").dblclick(function(){
    $(this).addClass("disnone");
})

$(".factor-btn").click(function(){
    if($(this).hasClass("to-choose")){
        if($(this).hasClass("active")){
            $(this).removeClass("active");
        }else{
            $(this).addClass("active");
        }
    }
})

// 模式切换
$(".change").click(function(){
    if($(this).hasClass("download")){
        // 数据导出模式
        $(".choose-box").removeClass("disnone");
        $(".feature-box > div").addClass("choose-factor");
        $(this).text("查看图表模式");
        $(this).removeClass("download");
        $(".feature-box div a").addClass("to-choose");
        $(".feature-box > p span").addClass("factor-all");
        $(".feature-box > p span").addClass("active");
        $('span.span').replaceWith(function(){
            return $("<a />", {html: $(this).html(), class:$(this).attr('class'), href:'javascript:;', num:$(this).attr('num')});
        });
    }else{
        // 查看图表模式
        $(".choose-box").addClass("disnone");
        $(".feature-box div").removeClass("choose-factor");
        $(this).text("数据导出模式");
        $(this).addClass("download");
        $(".feature-box div a").removeClass("to-choose");
        $(".factor-btn").removeClass("active");
        $(".feature-box > p a").removeClass("factor-all");
        $('a.span').replaceWith(function(){
            return $("<span />", {html: $(this).html(), class:$(this).attr('class'), num:$(this).attr('num')});
        });
    }
})

// 点击属性名，对应的所有属性全选
$(document).on("click",".factor-all",function(event){
    if($(this).hasClass("active")){
        $(this).parents(".feature-box").find("div").eq($(this).attr("num")).find(".factor-btn").addClass("active");
        $(this).removeClass("active");
    }else{
        $(this).parents(".feature-box").find("div").eq($(this).attr("num")).find(".factor-btn").removeClass("active");
        $(this).addClass("active");
    }
})

$(".choose-all").click(function(){
    if($(this).hasClass('active')){
        $(this).find('img').attr('src','images/choose-empty.png');
        $(this).removeClass('active');
        $(".factor-btn").removeClass("active");
    }else{
        $(this).find('img').attr('src','images/choose-all.png');
        $(this).addClass('active');
        $(".factor-btn").addClass("active");
    }
})
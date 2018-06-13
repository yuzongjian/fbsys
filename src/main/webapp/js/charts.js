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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path=request.getContextPath(); %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>报警设置</title>
	<link rel="shortcut icon" href="images/user.png" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/global.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/nav.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/alarm.css"/>
</head>
<body>
	<!-- 导航栏 -->
	<div class="nav border-box">
		<shiro:authenticated>  
			<div class="user">
				<img src="images/tlogo.jpg">
				<div class="disnone"><a href="logout#">注销</a></div>
			</div>
			<span><shiro:principal/></span>
		</shiro:authenticated>  
		<ul>
			<!-- 海域数据 -->
			<li>
				<a class="list" href="map#"><i class="fa fa-play-circle-o"></i></a>

				<ul>
					<li>海域数据</li>					
				</ul>
			</li>

			<!-- 数据监控 -->
			<li>
				<a class="list" href="statistics#"><img src="images/camera.png"></a>

				<ul>
					<li>数据监控</li>					
				</ul>
			</li>

			<!-- 统计查询 -->
			<li>
				<a class="list" href="visualization#"><i class="fa fa-bar-chart"></i></a>

				<ul>
					<li>统计查询</li>					
				</ul>
			</li>

			<!-- 报警设置 -->
			<li>
				<a class="list active" href="#"><i class="fa fa-cog"></i></a>

				<ul>
					<li>报警设置</li>					
				</ul>
			</li>

			<!-- 日志详情 -->
			<li>
				<a class="list" href="log#"><i class="fa fa-file"></i></a>

				<ul>
					<li>日志详情</li>
				</ul>
			</li>

			<!-- 浮标管理 -->
			<li>
				<a class="list" href="buoy#"><i class="fa fa-map-marker"></i></a>

				<ul>
					<li>浮标管理</li>
				</ul>
			</li>

			<!-- 用户管理 -->
			<li>
				<a class="list" href="users#"><i class="fa fa-user"></i></a>

				<ul>
					<li>用户管理</li>
				</ul>
			</li>
		</ul>
		
		<div class="logo-box">
			<img src="images/user.png">
		</div>
	</div>
	<div class="nav-box">
	</div>

	<div class="container border-box box">
		<p class="border-box">
			报警设置
			<span><button onclick="save()">保存</button></span>
		</p>

		<div id='alarm'>
			<div class="qixiang child-box border-box">
				<p>气象</p>
				<div class="control">
					<span>气压</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date" onkeypress=panduan()/>
			                hPa&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date" /> hPa
			                <input type="hidden" value="airpre"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        on
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>

				<div class="control">
					<span>气温</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date"/>
			                ℃&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date"/> ℃
			                <input type="hidden" value="airtemp"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        on
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>

				<div class="control">
					<span>湿度</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date" />
			                %&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date"/> %
			                <input type="hidden" value="oppohumi"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        on
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>
			</div>

			<div class="hailiu child-box border-box">
				<p>海流</p>
				<div class="control">
					<span>流速</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date" />
			                cm/s&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date"/> cm/s
			                <input type="hidden" value="speed"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        on
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>
			</div>

			<div class="shuiwen child-box border-box">
				<p>水文</p>
				<div class="control">
					<span>水温</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date" />
			                ℃&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date"/> ℃
			                <input type="hidden" value="wattemp"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        on
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>

				<div class="control">
					<span>盐度</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date" />
			                %&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date"/> %
			                <input type="hidden" value="salinity"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        on
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>

				<div class="control">
					<span>导电率</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date" />
			                ms/cm&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date"/> ms/cm
			                <input type="hidden" value="conductivity"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        on
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>
			</div>

			<div class="bo child-box border-box">
				<p>波</p>
				<div class="control">
					<span>最大波高</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date" />
			                hPa&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date"/> hPa
			                <input type="hidden" value="high_max"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        on
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>

				<div class="control">
					<span>有效波高</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date" />
			                ℃&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date"/> ℃
			                <input type="hidden" value="high_effective"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        on
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>

				<div class="control">
					<span>有效波周期</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date" />
			                %&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date"/> %
			                <input type="hidden" value="cycle_effective"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        on
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>
			</div>

			<div class="wind child-box border-box">
				<p>风</p>
				<div class="control">
					<span>最大风速</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date" />
			                hPa&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date"/> hPa
			                <input type="hidden" value="speed_max"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        on
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>

				<div class="control">
					<span>极大风速</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date" />
			                ℃&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date"/> ℃
			                <input type="hidden" value="speed_ji"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        on
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>

				<div class="control">
					<span>平均风速</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date" />
			                %&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date"/> %
			                <input type="hidden" value="speed_ten"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        on
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>
			</div>
			
			
			<div class="location child-box border-box">
				<p>位置</p>
				<div class="control">
					<span>位置偏移</span>
					<section id="section">
			            <p>正常范围：
			                <input type="text" name="begin-date" />
			                km&nbsp;&nbsp;至&nbsp;&nbsp;<input type="text" name="end-date"/> km
			                <input type="hidden" value="location"><div id="tip"></div>
			            </p>             
			        </section>
					<label>		               
		                <input type="checkbox" id='inp' class="ios-switch tinyswitch" checked="checked"/>
		                <div class="btn" id='btn'>
		                    <div id='change'>
		                        
		                    </div>
		                </div>		           
		            </label>

		            <div class="clear">
		            </div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="<%=path %>/js/jq.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/nav.js"></script>
	<script type="text/javascript" src="<%=path %>/js/alarm.js"></script>
	<script type="text/javascript">
    // window.onload=function(){
    //     var inp=document.getElementById('inp');
    //     var oBtn=document.getElementById('btn');
    //         change=document.getElementById('change');
    //     var oBox=document.getElementById('section');


    //      if (inp.checked) {
    //         oBox.style.display='block'
    //     }

    //      oBtn.onclick=function(){

    //         if (inp.checked) {
    //             change.innerHTML='off';
    //             oBox.style.display='none'
    //         }else{
    //             change.innerHTML='on';
        
    //             oBox.style.display='block'
    //         }
                   
    //      }   

    // }
    	$(function(){
    		//alert("qw");
    		getData();
    	})
    	//刷新获取获取警报设置的数据
    	function getData() {
    		$.ajax({
			    url:'<%=request.getContextPath()%>/alarm/view',
			    type:'POST', //GET
			    async:false,    //或false,是否异步
			    timeout:5000,    
			    dataType:'json',    
			    beforeSend:function(xhr){
			        console.log(xhr)
			        console.log('发送前')
			    },
			    success:function(data,textStatus,jqXHR){
			        var result = data.sysdata.alarms;
			       $("#alarm").find('.control').each(function () {
					    var hidden = $(this).find("input[type='hidden']").val();
					    for (var i = 0; i < result.length;i++) {
					    	if (hidden == result[i].type) {
					    		$(this).find("input[name='begin-date']").val(result[i].from);
					    		$(this).find("input[name='end-date']").val(result[i].to);
					    		if (result[i].active != 1) {
					    			$(this).find("#change").trigger("click");
					    		}
					    		break;
					    	}
					    }
					 });
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
    	}	
    	/* function panduan() {
    		/* if(/\D/.test(str)){
    			alert('只能输入数字');
    			return false;
    		}
    		return true; */

    	/* } */ 
		function save() {
			var str = "";
			var array = [];
			var flag = 0;
			$("#alarm").find('.control').each(function () {
				$(this).find("#tip").html("");
			    var from = $(this).find("input[name='begin-date']").val();
			    var to = $(this).find("input[name='end-date']").val();
			    var hidden = $(this).find("input[type='hidden']").val();
			    var open = $(this).find("#change").text().trim();
			    if (open == 'on') {
			    	open = 1;
			    }else {
			    	open = 0;
			    }
			    if(open == 1) {
			    	if (from.trim() == "") {
			    		$(this).find("#tip").html("<font color='red'>请输入正确的值</font>");
			    		flag = 1;
				    	return;
			    	}
			    	if (parseFloat(from.trim()) > parseFloat(to.trim())) {
			    		//alert(to);
				    	$(this).find("#tip").html("<font color='red'>起始值必须小于最大值</font>");
				    	flag = 1;
				    	return;
				    }
			    }
			    str = from + ','+ to + ','+ open + ',' + hidden;
				array.push(str);
			 });
			if (flag == 1) {
				return;
			}
			var data = array.join('|');
			//alert("aaa");
			
			$.ajax({
			    url:'<%=request.getContextPath()%>/alarm/save',
			    type:'POST', 
			    async:false,  
			    data:{
			    	data:data
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
			        if (data.type != 0) {
			        	alert(data.message);
			        	location.reload(true);     
			        }else{
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
		}
    </script>
</body>
</html> 
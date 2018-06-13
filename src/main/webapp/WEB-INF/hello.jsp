<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
<title>Insert title here</title>
</head>
<body>
haha
<script type="text/javascript">
	$(function(){
		
		alert("haha");
		//$("#test")
		
	});
	function tt(){
		alert("hehe");
		alert($("#test a:first").val());
	}
</script>

<div id="test" onclick="tt()">
<a href="www.baidu.com">aaa</a>
</div>
</body>
</html>
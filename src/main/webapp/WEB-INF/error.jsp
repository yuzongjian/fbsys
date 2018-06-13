<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>海洋局数据库</title>
	<link rel="shortcut icon" href="images/user.png" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/global.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/error.css"/>
</head>
<body>
	<div class="error">
		<img src="<%=path %>/images/cloud.png"/>
		<span><img src="<%=path %>/images/error.png">404</span>
		<p>抱歉您访问的页面出现错误，请刷新重试
		<br>多次重试无果后，请您联系系统管理员或技术支持</p>
	</div>

	<script src="<%=path %>/js/jq.min.js"></script>
	<script>
		$(".error").css({'marginTop':($(window).height()-300)/2+'px'});
	</script>
</body>

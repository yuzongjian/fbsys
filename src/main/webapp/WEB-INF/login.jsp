<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path=request.getContextPath(); %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
	<title>用户登录</title>
	<link rel="shortcut icon" href="images/user.png" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/global.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/login.css"/>
</head>
<body>
	<div class="login">
		<img src="images/user.png">
		<h1><img src="images/tlogo.jpg">国家海洋局南海调查技术中心</h1>
		<div class="login-box">
			<p>用户登录</p>
			<form action="login" method="post">
				<input type="text" name="username" placeholder="请输入账号">
				<input type="password" name="password" placeholder="请输入密码">
				<br>
				<div><font color="red" size="3">${msg}</font></div>
				<input type="submit" value="登&nbsp;&nbsp;录">
			</form>
		</div>
	</div>

	<script type="text/javascript" src="<%=path %>/js/jq.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/login.js"></script>
</body>
</html>
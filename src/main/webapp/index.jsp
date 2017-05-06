<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"  href="${path }/js/bootstrap/css/bootstrap.css"/>
<script type="text/javascript" src="${path }/js/common/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${path }/js/bootstrap/js/bootstrap.js"></script>
<title>Insert title here</title>
<style type="text/css">
	*{border-radius: }
</style>
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top" role="nacigation">
		<div class="container">
			<div class="navbar-header">
				<a id="el" class="navbar-brand" style="padding:0">
					<img alt="E-Learning" src="img/logo70.jpg" />
				</a>
				<h4 class="navbar-text"><b>E-Learning</b></h4>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${path }/user/login.html">登录${path }</a></li>
					<li class="navbar-text glyphicon glyphicon-grain"></li>
					<li><a href="#">注册</a></li>
				</ul>
			</div>
		</div>
	</div>
	<form action="">
	<div class="container-fluid" style="margin-top:70px;">
		<div class="row">
			<div class="col-md-6 col-md-offset-3 form-group">
				<div class="input-group">
					<label for="userName">用户名</label>
					<input type="text" class="form-control" id="userName" name="userName" placeholder="请填写用户名"/>
				</div>
				<div class="input-group">
					<label for="phone">手机号</label>
					<input type="text" class="form-control" id="phone" name="phone" placeholder="请填写手机号"/>
				</div>
				<div class="input-group">
					<label for="verifyCode">验证码</label>
					<input type="text" class="form-control" id="verifyCode" name="verifyCode" placeholder="请填写验证码"/>
				</div>
			</div>
		</div>
	</div>
	</form>
</body>
</html>
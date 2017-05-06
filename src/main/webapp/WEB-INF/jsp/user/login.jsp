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
	body,html{height:100%}
	.loginpage{
		margin:0px;
		padding:0px;
		height:100%;
	}
	.login-box{
		height:350px;;
		padding-top:4%;
		background: #EBEFF9;
		opacity: 0.8;
		position:absolute;
		top:25%;
	}
</style>
</head>
<body>
	<div class="container-fluid loginpage">
		<div style="background:url('${path }/img/login.png') repeat-x fixed left; background-size:100% auto; height:100%;">
			<div class="row">
				<div class="col-md-4 col-md-offset-7 login-box">
					<form class="form-horizontal login-form">
					  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
					    <div class="col-sm-10">
					      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
					    <div class="col-sm-10">
					      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <div class="checkbox">
					        <label>
					          <input type="checkbox"> Remember me
					        </label>
					      </div>
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-default">Sign in</button>
					    </div>
					  </div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
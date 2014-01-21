<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台登录</title>
<link href="${pageContext.request.contextPath }/css/admin.css" rel="stylesheet" type="text/css" />
</head>

<body style="background:url(admin-images/load-bg-1.jpg) repeat-x">
	<form action="${pageContext.request.contextPath }/admin/login" method="post">
		<div class="load-wrap">
			<p class="user-box" style="color: red">${message }</p>
    		<p class="user-box">用户名：<input name="userName" type="text" style="margin-left:1px;" value="${userName }"/></p>
        	<p class="user-box">密&nbsp;&nbsp;&nbsp;&nbsp;码：<input name="passWord" type="password" value="${passWord }"/></p>
        	<p><input name="" type="submit" class="load-btn" value="登录" /></p>
    	</div>
    </form>
</body>
</html>

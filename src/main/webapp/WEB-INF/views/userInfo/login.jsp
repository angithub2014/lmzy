<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>

</head>

<body>
	<div class="users">
       <div class="load-box">
       <form action="${pageContext.request.contextPath }/userInfo/login" method="post">
           <p class="tishi-box">${message }</p>
           <p>用&nbsp;户&nbsp;名：<input name="userName" type="text" value="${userName }"/></p>
           <p>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input name="passWord" type="password" value="${passWord }"/></p>
           <div><input name="" type="submit" value="登录" class="user-btn" /></div>
           <p class="tishi"><a href="${pageContext.request.contextPath }/userInfo/findPassWord">忘记密码</a><a href="${pageContext.request.contextPath }/register">立即注册</a></p>
       </form>
       </div>
   </div>
   </body>
</html>
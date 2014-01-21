<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>找回密码</title>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-migrate-1.1.0.js"></script>
<script src="${pageContext.request.contextPath }/js/findPassWord.js"></script>

</head>

<body>
	<div class="users">
       <div class="zhuce-box zhaohui-box">
       		<form action="${pageContext.request.contextPath }/userInfo/findPassWord" method="post">
       		<p class="tishi-box">${message }</p>
        	<p>用&nbsp;&nbsp;户&nbsp;&nbsp;名：<input name="userName" id="username" type="text" style="margin-left:1px;" onblur="checkUserName()"/><span id="usernameImage"></span><span id="usernameTip">4-16个字符，可以使用字母、汉字、数字、下划线</span></p>
        	<p>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input name="email" id="email" type="text" style="margin-left:2px;" onblur="checkEmail()"/><span id="emailImage"></span><span id="emailTip">如：345692808@qq.com</span></p>
       		<div><input name="" type="submit" value="找回密码" class="user-btn-zhuce" style="margin-top:60px;" /></div>
       		</form>
       </div>
       		
       </div>
   </body>
 </html>
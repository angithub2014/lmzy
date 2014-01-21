<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>找回密码</title>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-migrate-1.1.0.js"></script>
<script src="${pageContext.request.contextPath }/js/resetPassWord.js"></script>

</head>

<body>
	<div class="users">
       <div class="zhuce-box zhaohui-box">
       		<form name="resetPassWordForm" id="resetPassWordForm" method="post">
        	<p>用&nbsp;&nbsp;户&nbsp;&nbsp;名：${userName }
        	<input name="userName" id="username" type="hidden" style="margin-left:1px;" value="${userName }"/></p>
        	<p>登录密码：<input name="passWord" id="password" type="password" style="margin-left:2px;" onblur="checkPassWord()"/><span id="passwordImage"></span><span id="passwordTip">6-16个字符，建议使用字母、数字组合、混合大小写</span></p>
        	<p>确认密码：<input name="rePassWord" id="realPass" type="password" style="margin-left:2px;" onblur="checkRealPass()"/><span id="realPassImage"></span><span id="realpasswordTip">请再次输入密码</span></p>
       		<div><input name="submit" type="button" value="找回密码" class="user-btn-zhuce" style="margin-top:60px;" onclick="resetPassWord()"/></div>
       		</form>
       </div>
       		
       </div>
   </body>
 </html>
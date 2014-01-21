<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath }/js/register.js"></script>

</head>
<body>
<div class="users">
    <div class="zhuce-box">
    <form name="userRegisterForm" id="userRegisterForm" method="post">
        <p>用&nbsp;&nbsp;户&nbsp;&nbsp;名：<input name="userName" id="username" type="text" style="margin-left:1px;" onblur="checkUserName()"/><span id="usernameImage"></span><span id="usernameTip">4-16个字符，可以使用字母、汉字、数字、下划线</span></p>
        <p>登录密码：<input name="passWord" id="password" type="password" style="margin-left:2px;" onblur="checkPassWord()"/><span id="passwordImage"></span><span id="passwordTip">6-16个字符，建议使用字母、数字组合、混合大小写</span></p>
        <p>确认密码：<input name="rePassWord" id="realPass" type="password" style="margin-left:2px;" onblur="checkRealPass()"/><span id="realPassImage"></span><span id="realpasswordTip">请再次输入密码</span></p>
        <p>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input name="email" id="email" type="text" style="margin-left:2px;" onblur="checkEmail()"/><span id="emailImage"></span><span id="emailTip">如：345692808@qq.com</span></p>
        <p>验&nbsp;&nbsp;证&nbsp;&nbsp;码：<input name="checkCode" id="checkCode" type="text" /><em><img id="checkCodeImg" src="${pageContext.request.contextPath }/checkCode.jsp" /></em><span style="padding-left:68px;">看不清？</span><a href="#" class="change" onclick="changeImg()">换一张</a></p>
        <div class="min"><input type="checkbox" checked="checked" id="registerXieyi" value="checked"/>我已满十八周岁且已阅读并同意<a href="#">《用户服务协议》</a></div>
        <div><input name="submit" type="button" value="立即注册" class="user-btn-zhuce" onclick="register()"/></div>
    </form>
    </div>	
</div>
</body>
</html>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册成功</title>

</head>
<body>
        <div class="users">
        	<div class="zhuce-box">
            	<p style=" padding-left:75px; padding-top:20px;"><strong style="font-weight:normal; color:#de0201;">${userInfo.userName }</strong>，黎明之翼欢迎您，恭喜您已注册成功！</p>
               
                <div style="margin-top:60px;"><a href="" name="" class="user-btn-zhuce" >英雄联盟</a><a href="${pageContext.request.contextPath }/mssjIndex" name=""  class="user-btn-zhuce" >魔兽世界</a></div>
                
            </div>
             
        </div>
		
    
</body>
</html>
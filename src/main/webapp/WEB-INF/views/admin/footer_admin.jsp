<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>进入游戏</title>
<link href="${pageContext.request.contextPath }/css/allpage.css" rel="stylesheet" type="text/css" />

</head>
<body>
		
<div class="users play-user">
        	<div class="user-load"><a href="${pageContext.request.contextPath }/login" style="padding-left:172px;">登录</a><span>|</span><a href="${pageContext.request.contextPath }/register" style="padding-left:33px;">注册</a></div>
            <ul class="play">
                <li class="left">
                	<a href="#" class="go"><img src="${pageContext.request.contextPath }/images/go-yx.jpg" /></a>
                	<a href="#"><img src="${pageContext.request.contextPath }/images/lianmeng.jpg" width="448" height="501" alt="英雄联盟" /></a>
                </li>
                <li class="right">
                	<a href="${pageContext.request.contextPath }/mssjIndex" class="go"><img src="${pageContext.request.contextPath }/images/go-ms.jpg" /></a>
                	<a href="${pageContext.request.contextPath }/mssjIndex"><img src="${pageContext.request.contextPath }/images/moshou.jpg" width="448" height="501" alt="魔兽世界" /></a>
                </li>
            </ul>
  </div>
		
    
</body>
</html>

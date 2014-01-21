<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>进入游戏</title>
<link href="${pageContext.request.contextPath }/css/allpage.css" rel="stylesheet" type="text/css" />

</head>
<body style="background:url(${pageContext.request.contextPath }/images/playbodybg.jpg) repeat-x; height:650px;">
		
<div class="users play-user-2" style="padding:0;">
		<div style="margin:0 auto; width:980px; height:650px;">
			<c:choose>
                	<c:when test="${not empty userInfo }">
                	   <div class="user-load" style="background:none"><b style="position:absolute;">你好,<c:choose><c:when test="${fn:length(userInfo.userName)>5 }">${fn:substring(userInfo.userName,0,3)}**</c:when><c:otherwise>${userInfo.userName }</c:otherwise></c:choose> </b>
                <a href="${pageContext.request.contextPath }/userInfo/modifyPassWordIndex.do" class="left" style="padding-left:103px;">[修改密码]</a><span style="padding:0 26px 0 11px">|</span><a href="${pageContext.request.contextPath }/userInfo/loginOut.do">[退出登录]</a>
                	</div></c:when>
                	<c:otherwise>
        	<div class="user-load" style="background:none"><a href="${pageContext.request.contextPath }/login" style="padding-left:103px;">登录</a><span>|</span><a href="${pageContext.request.contextPath }/register" style="padding-left:33px;">注册</a></div>
                	</c:otherwise>
                </c:choose>
           <a href="#"style="position:absolute; left:506px;top:310px;"><img src="images/go-yx.jpg"></a>
           <a href="${pageContext.request.contextPath }/mssjIndex" style="position:absolute; left:796px;top:310px;"><img src="${pageContext.request.contextPath }/images/go-ms.jpg"></img></a>
          </div>    
  </div>
		
    
</body>
</html>

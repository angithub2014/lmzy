<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath }/css/admin.css" rel="stylesheet" type="text/css" />

<div class="admin-head">
	<c:if test="${not empty admin }">
		 <div class="logo">当前用户：${admin.userName}<a href="${pageContext.request.contextPath }/admin/loginOut.do">【退出登录】</a></div>
	</c:if>
   
</div>
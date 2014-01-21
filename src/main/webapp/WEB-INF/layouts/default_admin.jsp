<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link href="${pageContext.request.contextPath }/css/admin.css" rel="stylesheet" type="text/css" />

</head>
<body class="admin">
	<tiles:insertAttribute name="header_admin" ignore="true" />
	<div class="admin-body clearfix">
	<tiles:insertAttribute name="left_admin" ignore="true"/>
	<tiles:insertAttribute name="body" />
	</div>
</body>
</html>

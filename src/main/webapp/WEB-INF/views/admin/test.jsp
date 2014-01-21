<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>进入游戏</title>
<link href="${pageContext.request.contextPath }/css/allpage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>

</head>
<body>
		
	<form action="${pageContext.request.contextPath }/mgr/totest" method="post">
		<textarea rows="30" cols="50" name="content">请输入.</textarea>
		<input type="file"  name="file"/>
		<input name="" type="submit" value="提交"/>
	</form>
<script type="text/javascript">CKEDITOR.replace('content');</script>

</body>
</html>

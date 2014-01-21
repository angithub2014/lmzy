<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>

 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/news/insertNewsType.do" method="post">
		<table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
            <tr class="box-head">
                <td>添加新闻类目</td>
            </tr>
            <tr>
                <td>类目名称：<select name="gameid"><option value="1">魔兽世界</option>
                <option value="2">英雄联盟</option></select></td>
            </tr>
            <tr>
                <td>新闻类别：<input name="name" type="text" value="${name }"/></td>
            </tr>
      </table>
     <p><input name="" type="submit" value="添加" class="addbtn" /></p>
    </form>
     
 </div>
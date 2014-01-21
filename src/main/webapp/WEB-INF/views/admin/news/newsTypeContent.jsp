<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>

 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/news/updateNewsType.do" method="post">
		<table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
            <tr class="box-head">
                <td>修改新闻类目</td>
            </tr>
            <tr>
                <td>类目名称：<c:choose>
                	<c:when test="${adminNewsType.gameid ==1 }">
                		魔兽世界
                		<input name="gameid" type="hidden" value="${adminNewsType.gameid }"/>
                	</c:when>
                	<c:when test="${adminNewsType.gameid ==2 }">
                		英雄联盟
                		<input name="gameid" type="hidden" value="${adminNewsType.gameid }"/>
                	</c:when>
                </c:choose></td>
            </tr>
            <tr>
                <td>视频类别：<input name="name" type="text" value="${adminNewsType.name }"/></td>
            </tr>
      </table>
      <input name="newstypeid" type="hidden" value="${adminNewsType.id }"/>
     <p><input name="" type="submit" value="修改" class="addbtn" /></p>
    </form>
     
 </div>
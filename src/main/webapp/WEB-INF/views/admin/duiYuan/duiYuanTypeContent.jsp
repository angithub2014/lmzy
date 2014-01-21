<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>

 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/duiYuan/updateDuiYuanType.do" method="post">
		<table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
            <tr class="box-head">
                <td>修改队员类目</td>
            </tr>
            <tr>
                <td>类目名称：<c:choose>
                	<c:when test="${adminDuiYuanType.gameid ==1 }">
                		魔兽世界
                		<input name="gameid" type="hidden" value="${adminDuiYuanType.gameid }"/>
                	</c:when>
                	<c:when test="${adminDuiYuanType.gameid ==2 }">
                		英雄联盟
                		<input name="gameid" type="hidden" value="${adminDuiYuanType.gameid }"/>
                	</c:when>
                </c:choose></td>
            </tr>
            <tr>
                <td>视频类别：<input name="name" type="text" value="${adminDuiYuanType.name }"/></td>
            </tr>
      </table>
      <input name="dytypeid" type="hidden" value="${adminDuiYuanType.id }"/>
     <p><input name="" type="submit" value="修改" class="addbtn" /></p>
    </form>
     
 </div>
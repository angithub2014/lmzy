<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>

 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/news/updateNews.do" method="post" enctype="multipart/form-data">
		<input name="newsid" type="hidden" value="${adminNews.id }"/>
       <table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
           <tr class="box-head">
               <td>新闻类型</td>
           </tr>
           <tr>
               <td>标题：<input name="title" type="text" value="${adminNews.title }"/></td>
           </tr>
           <tr>
                <td>类别：${adminNews.newstypename }<!--<c:choose>
                	<c:when test="${adminNews.gameid ==1 }">
                		魔兽世界
                		<input name="gameid" type="hidden" value="${adminNews.gameid }"/>
                	</c:when>
                	<c:when test="${adminNews.gameid ==2 }">
                		英雄联盟
                		<input name="gameid" type="hidden" value="${adminNews.gameid }"/>
                	</c:when>
                </c:choose>-->
                <input name="gameid" type="hidden" value="${adminNews.gameid }"/>
                </td>
           </tr>
           <tr>
                <td>来源：<input name="source" type="text" value="${adminNews.source }"/></td>
           </tr>
           <tr>
               <td>编辑：<input name="author" type="text" value="${adminNews.author }"/></td>
           </tr>
           <tr>
                <td>图片上传：<span class="wenjian"><input name="file" type="file" /></span>（照片尺寸：124像素×124像素）</td>
           </tr>
           <tr>
                <td>新闻内容：<br /><textarea name="content" cols="" rows="">${adminNews.content }</textarea></td>
           </tr>
            
       </table>
       <p><input name="" type="submit" value="更新" class="addbtn" /></p>
     </form>   
     <script type="text/javascript">CKEDITOR.replace('content');</script>
     
 </div>
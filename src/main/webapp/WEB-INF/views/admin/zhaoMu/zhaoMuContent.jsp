<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>

 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/zhaoMu/updateZhaoMu.do" method="post" enctype="multipart/form-data">
		<input name="zhaomuid" type="hidden" value="${adminZhaoMu.id }"/>
       <table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
           <tr class="box-head">
               <td>编辑招募信息</td>
           </tr>
           <tr>
               <td>标题：<input name="title" type="text" value="${adminZhaoMu.title }"/></td>
           </tr>
           <tr>
                <td>类别：<c:choose>
                	<c:when test="${adminZhaoMu.gameid ==1 }">
                		魔兽世界
                		<input name="gameid" type="hidden" value="${adminZhaoMu.gameid }"/>
                	</c:when>
                	<c:when test="${adminZhaoMu.gameid ==2 }">
                		英雄联盟
                		<input name="gameid" type="hidden" value="${adminZhaoMu.gameid }"/>
                	</c:when>
                </c:choose>
                </td>
           </tr>
           <tr>
                <td>来源：<input name="source" type="text" value="${adminZhaoMu.source }"/></td>
           </tr>
           <tr>
               <td>编辑：<input name="author" type="text" value="${adminZhaoMu.author }"/></td>
           </tr>
           <tr>
                <td>图片上传：<span class="wenjian"><input name="file" type="file" /></span>（照片尺寸：124像素×124像素）</td>
           </tr>
           <tr>
                <td>新闻内容：<br /><textarea name="content" cols="" rows="">${adminZhaoMu.content }</textarea></td>
           </tr>
            
       </table>
       <p><input name="" type="submit" value="更新" class="addbtn" /></p>
     </form>   
     <script type="text/javascript">CKEDITOR.replace('content');</script>
     
 </div>
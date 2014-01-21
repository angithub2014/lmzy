<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>

 <div class="right">
   <c:choose>
           		<c:when test="${not empty aboutUs }">

	<form action="${pageContext.request.contextPath }/admin/other/updateAboutUs.do" method="post">
           		</c:when>
           		<c:otherwise>
	<form action="${pageContext.request.contextPath }/admin/other/insertAboutUs.do" method="post">
           		</c:otherwise>
           </c:choose>
       <table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
           <tr class="box-head">
               <td>关于我们</td>
           </tr>
           <tr>
               <td>标题：<input name="title" type="text" value="${aboutUs.title }"/></td>
           </tr>
           
           <tr>
                <td>
      	<input name="gameid" type="hidden" value="1"/>          

           </tr>
           <tr>
                <td>联系人：<input name="name" type="text" value="${aboutUs.name }"/></td>
           </tr>
           <tr>
               <td>邮箱：<input name="email" type="text" value="${aboutUs.email }"/></td>
           </tr>
           <tr>
               <td>电话：<input name="mobile" type="text" value="${aboutUs.mobile}"/></td>
           </tr>
           <tr>
                <td>内容：<br /><textarea name="content" cols="" rows="">${aboutUs.content}</textarea></td>
           </tr>
            
       </table>
                  			<input name="id" type="hidden" value="${aboutUs.id }"/>          
       
                              <c:choose>
           		<c:when test="${not empty aboutUs }">

           			<p><input name="submitType" type="submit" value="修改" class="addbtn" /></p>
           		</c:when>
           		<c:otherwise>
           			<p><input name="submitType" type="submit" value="添加" class="addbtn" /></p>
           		</c:otherwise>
           </c:choose>
       
     </form>   
     <script type="text/javascript">CKEDITOR.replace('content');</script>
     
 </div>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>

 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/news/insertNews.do" method="post" enctype="multipart/form-data">
       <table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
           <tr class="box-head">
               <td>添加新闻类型</td>
           </tr>
           <tr>
               <td>标题：<input name="title" type="text" value="${title }"/></td>
           </tr>
           
           <tr>
                <td>
      	<input name="gameid" type="hidden" value="1"/>          
                类别：<select name="newstypeid"><c:forEach items="${newsTypeList }" var="newsType">
					<option value="${newsType.id }" ${newstypeid eq newsType.id ? 'selected':'' }>${newsType.name }</option>
				</c:forEach></select></td>

           </tr>
           <tr>
                <td>来源：<input name="source" type="text" value="${source }"/></td>
           </tr>
           <tr>
               <td>编辑：<input name="author" type="text" /></td>
           </tr>
           <tr>
                <td>图片上传：<span class="wenjian"><input name="file" type="file" /></span>（照片尺寸：124像素×124像素）</td>
           </tr>
           <tr>
                <td>新闻内容：<br /><textarea name="content" cols="" rows=""></textarea></td>
           </tr>
            
       </table>
       <p><input name="" type="submit" value="添加" class="addbtn" /></p>
     </form>   
     <script type="text/javascript">CKEDITOR.replace('content');</script>
     
 </div>
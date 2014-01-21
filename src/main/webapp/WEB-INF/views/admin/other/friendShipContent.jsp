<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>

 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/other/updateFriendShip.do" method="post" enctype="multipart/form-data">
		<input name="id" type="hidden" value="${selectFriendShip.id }"/>
       <table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
           <tr class="box-head">
               <td>友情链接</td>
           </tr>
           <tr>
               <td>名称：<input name="name" type="text" value="${selectFriendShip.name }"/></td>
           </tr>
           <tr>
                <td>
                <input name="gameid" type="hidden" value="${selectFriendShip.gameid }"/>
                </td>
           </tr>
           <tr>
                <td>链接：<input name="url" type="text" value="${selectFriendShip.url }"/></td>
           </tr>
           <tr>
            <td>图片上传：<span class="wenjian"><input name="file" type="file" /></span>（图片尺寸：140像素×50像素）</td>
           		</tr>
       </table>
       <p><input name="" type="submit" value="更新" class="addbtn" /></p>
     </form>   
     <script type="text/javascript">CKEDITOR.replace('content');</script>
     
 </div>
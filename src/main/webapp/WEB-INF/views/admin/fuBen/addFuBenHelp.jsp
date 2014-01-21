<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/fuBen/insertFuBenHelp.do" method="post" >
<table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
            	<tr class="box-head">
                	<td>添加副本信息</td>
                </tr>
                <tr>
                	<td>标题：<input name="title" type="text" value="${title }"/></td>
                </tr>
                <tr>
                	<td>类别：<select name="fbid"><c:forEach items="${fuBenList }" var="fuBen">
					<option value="${fuBen.id }" ${fbid eq fuBen.id ? 'selected':'' }>${fuBen.name }</option>
				</c:forEach></select></td>
                </tr>
                <tr>
                	<td>来源：<input name="source" type="text" /></td>
                </tr>
                <tr>
                	<td>编辑：<input name="author" type="text" /></td>
                </tr>
                <tr>
                	<td>副本内容：<br /><textarea name="content" cols="" rows=""></textarea></td>
                </tr>
            
            </table>
            <p><input name="" type="submit" value="添加" class="addbtn" /></p>     </form>   
     <script type="text/javascript">CKEDITOR.replace('content');</script>
 </div>
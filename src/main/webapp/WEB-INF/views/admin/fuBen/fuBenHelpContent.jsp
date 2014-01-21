<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>

 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/fuBen/updateFuBenHelp.do" method="post">
<table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
            	<tr class="box-head">
                	<td>添加副本信息</td>
                </tr>
                <tr>
                	<td>标题：<input name="title" type="text" value="${adminFuBenHelp.title }"/></td>
                </tr>
                <tr>
                	<td>类别：${adminFuBenHelp.name }</td>
                </tr>
                <tr>
                	<td>来源：<input name="source" type="text" value="${adminFuBenHelp.source }"/></td>
                </tr>
                <tr>
                	<td>编辑：<input name="author" type="text" value="${adminFuBenHelp.author }"/></td>
                </tr>
                <tr>
                	<td>副本内容：<br /><textarea name="content" cols="" rows="">${adminFuBenHelp.content }</textarea></td>
                </tr>
            
            </table>
            <input name="fbhelpid" type="hidden" value="${adminFuBenHelp.id }"/>
            <input name="fbid" type="hidden" value="${adminFuBenHelp.fbid }"/>
            <input name="gameid" type="hidden" value="1"/>
            <p><input name="" type="submit" value="修改" class="addbtn" /></p>     </form>   
     <script type="text/javascript">CKEDITOR.replace('content');</script>
     
 </div>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>

 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/zhiYe/updateZhiYeHelp.do" method="post" enctype="multipart/form-data">
<table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
            	<tr class="box-head">
                	<td>编辑职业信息</td>
                </tr>
                <tr>
                	<td>标题：<input name="title" type="text" value="${adminZhiYeHelp.title }"/></td>
                </tr>
                <tr>
                	<td>类别：${adminZhiYeHelp.zyname }</td>
                </tr>
                <tr>
                	<td>来源：<input name="source" type="text" value="${adminZhiYeHelp.source }"/></td>
                </tr>
                <tr>
                	<td>编辑：<input name="author" type="text" value="${adminZhiYeHelp.author }"/></td>
                </tr>
                <tr>
                	<td>副本内容：<br /><textarea name="content" cols="" rows="">${adminZhiYeHelp.content }</textarea></td>
                </tr>
            
            </table>
            <input name="zyhelpid" type="hidden" value="${adminZhiYeHelp.id }"/>
            <input name="zyid" type="hidden" value="${adminZhiYeHelp.occupationid }"/>
            <input name="gameid" type="hidden" value="1"/>
            <p><input name="" type="submit" value="修改" class="addbtn" /></p>     </form>   
     <script type="text/javascript">CKEDITOR.replace('content');</script>
     
 </div>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>

 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/shiPin/updateShiPin.do" method="post" enctype="multipart/form-data">
<table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
            	<tr class="box-head">
                	<td>编辑视频信息</td>
                </tr>
                <tr>
                	<td>视频名称：<input name="name" type="text" value="${adminShiPin.name }"/></td>
                </tr>
                <tr>
                	<td>类别：${adminShiPin.sptypename }</td>
                </tr>
                <tr>
                	<td>观看地址：<input name="watchurl" type="text" value="${adminShiPin.watchurl }"/></td>
                </tr>
                <tr>
                <td>图片上传：<span class="wenjian"><input name="file" type="file" /></span>（图片尺寸：201像素×129像素）</td>
           		</tr>
            
            </table>
            <input name="spid" type="hidden" value="${adminShiPin.id }"/>
            <input name="sptypeid" type="hidden" value="${adminShiPin.videotypeid }"/>
            <input name="gameid" type="hidden" value="1"/>
            <p><input name="" type="submit" value="修改" class="addbtn" /></p>     </form>   
     
 </div>
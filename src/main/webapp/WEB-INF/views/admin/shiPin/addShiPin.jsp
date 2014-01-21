<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/shiPin/insertShiPin.do" method="post" enctype="multipart/form-data">
<table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
            	<tr class="box-head">
                	<td>添加游戏视频</td>
                </tr>
                <tr>
                	<td>视频名称：<input name="name" type="text" value="${name }"/></td>
                </tr>
                <tr>
                	<td>类别：<select name="sptypeid"><c:forEach items="${shiPinTypeList }" var="shiPinType">
					<option value="${shiPinType.id }" ${sptypeid eq shiPinType.id ? 'selected':'' }>${shiPinType.name }</option>
				</c:forEach></select></td>
                </tr>
                <tr>
                	<td>观看地址：<input name="watchurl" type="text" /></td>
                </tr>
                 <tr>
                <td>图片上传：<span class="wenjian"><input name="file" type="file" /></span>（图片尺寸：201像素×129像素）</td>
           		</tr>
            
            </table>
            <p><input name="" type="submit" value="添加" class="addbtn" /></p>     </form>   
     <script type="text/javascript">CKEDITOR.replace('content');</script>
 </div>
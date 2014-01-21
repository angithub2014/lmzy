<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/duiYuan/insertDuiYuan.do" method="post" enctype="multipart/form-data">
<table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
            	<tr class="box-head">
                	<td>添加队员信息</td>
                </tr>
                <tr>
                	<td>队员名称：<input name="name" type="text" value="${name }"/></td>
                </tr>
                <tr>
                	<td>所属分类：<select name="dytypeid"><c:forEach items="${duiYuanTypeList }" var="duiYuanType">
					<option value="${duiYuanType.id }" ${dytypeid eq duiYuanType.id ? 'selected':'' }>${duiYuanType.name }</option>
				</c:forEach></select></td>
                </tr>
                <tr>
                	<td>所属角色：<select name="role">
					<option value="坦克组">坦克组</option>
					<option value="治疗组">治疗组</option>
					<option value="近战组">近战组</option>
					<option value="远程组">远程组</option>
				</select></td>
                </tr>
                <tr>
                	<td>详情链接：<input name="detailurl" type="text" /></td>
                </tr>
                <tr>
                	<td>英雄榜地址：<input name="herourl" type="text" /></td>
                </tr>
                 <tr>
                <td>职业图标：<span class="wenjian"><input name="file" type="file" /></span>（图片尺寸：25像素×25像素）</td>
           		</tr>
            
            </table>
            <p><input name="" type="submit" value="添加" class="addbtn" /></p>     </form>   
     <script type="text/javascript">CKEDITOR.replace('content');</script>
 </div>
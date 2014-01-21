<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>

 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/duiYuan/updateDuiYuan.do" method="post" enctype="multipart/form-data">
<table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
            	<tr class="box-head">
                	<td>编辑队员信息</td>
                </tr>
                <tr>
                	<td>队员名称：<input name="name" type="text" value="${adminDuiYuan.name }"/></td>
                </tr>
                <tr>
                	<td>所属分类：${adminDuiYuan.dytypename }</td>
                </tr>
                <tr>
                	<td>所属角色：${adminDuiYuan.role }</td>
                </tr>
                <tr>
                	<td>详情链接：<input name="detailurl" type="text" value="${adminDuiYuan.detailurl }"/></td>
                </tr>
                <tr>
                	<td>英雄榜地址：<input name="herourl" type="text" value="${adminDuiYuan.herourl }"/></td>
                </tr>
                <tr>
                <td>职业图标：<span class="wenjian"><input name="file" type="file" /></span>（图片尺寸：25像素×25像素）</td>
           		</tr>
            
            </table>
            <input name="dyid" type="hidden" value="${adminDuiYuan.id }"/>
            <input name="dytypeid" type="hidden" value="${adminDuiYuan.teamtypeid }"/>
            <input name="gameid" type="hidden" value="1"/>
            <p><input name="" type="submit" value="修改" class="addbtn" /></p>     </form>   
     
 </div>
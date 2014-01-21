<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>

 <div class="right">
	<form action="${pageContext.request.contextPath }/admin/team/insertTeam.do" method="post" enctype="multipart/form-data">
       <table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
           <tr class="box-head">
               <td>添加队员信息</td>
           </tr>
           <tr>
               <td style="color:#0596E9">基本信息</td>
                </tr>
           <tr>
                <td>类别：<select name="gameid">
                	<option value="1">魔兽世界</option>
                	<option value="2">英雄联盟</option>
                	</select>
                </td>
           </tr>
           <tr>
                	<td>玩家ID：<input name="nameid" type="text" /></td>
                </tr>
               <tr>
                	<td>类别：<select name="teamtype">
                	<option value="yuan">远程组</option>
                	<option value="jin">近战组</option>
                	</select>
                </td>
                </tr>
                
            
       </table>
       <p><input name="" type="submit" value="添加" class="addbtn" /></p>
     </form>   
 </div>
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
                	<td>姓名：<input name="name" type="text" /></td>
                </tr>
               <tr>
                	<td>昵称：<input name="nickname" type="text" /></td>
                </tr>
                <tr>
                	<td>简介：<br /><textarea name="description" cols="" rows=""></textarea></td>
                </tr>
                <tr>
                	<td>生日：<input name="birthday" type="text" /></td>
                </tr>
                <tr>
                	<td>籍贯：<input name="nativeplace" type="text" /></td>
                </tr>
                <tr>
                	<td>身高：<input name="height" type="text" />cm</td>
                </tr>
                <tr>
                	<td>体重：<input name="weight" type="text" />kg</td>
                </tr>
                 <tr>
                	<td>擅长英雄：<input name="hero" type="text" /></td>
                </tr>
                 <tr>
                	<td>擅长地图：<input name="map" type="text" /></td>
                </tr>
                 <tr>
                	<td>曾效力战队：<input name="onceteam" type="text" /></td>
                </tr>
                <tr>
                	<td>队员照片：<span class="wenjian"><input name="file" type="file" /></span>（照片尺寸：75像素×75像素）</td>
                </tr>
                 <tr>
                	<td style="color:#0596E9">个人配置</td>
                </tr>
                <tr>
                	<td>鼠标：<input name="mouse" type="text" /></td>
                </tr>
               <tr>
                	<td>键盘：<input name="keyboard" type="text" /></td>
                </tr>
                <tr>
                	<td>耳机：<input name="earphone" type="text" /></td>
                </tr>
                <tr>
                	<td style="color:#0596E9">电脑与游戏</td>
                </tr>
                <tr>
                	<td>电脑配置：<br /><textarea name="computer" cols="" rows=""></textarea></td>
                </tr>
               <tr>
                	<td>游戏设定：<br /><textarea name="gameset" cols="" rows=""></textarea></td>
                </tr>
            
       </table>
       <p><input name="" type="submit" value="添加" class="addbtn" /></p>
     </form>   
     <script type="text/javascript">CKEDITOR.replace('computer');</script>
     <script type="text/javascript">CKEDITOR.replace('gameset');</script>
 </div>
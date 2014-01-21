<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath }/js/admin.js"></script>

 <div class="right">
   			<form action="${pageContext.request.contextPath }/admin/fuBen/selectFuBenList.do" method="post">
 
        	<div class="leimu-tit">副本类目管理：</div>
			<div class="lb-head">副本类别：<select name="gameId" style="margin-right:85px;"><option value="1" ${'1' eq gameId ? 'selected':'' }>魔兽世界</option><option value="2" ${'2' eq gameId ? 'selected':'' }>英雄联盟</option></select><input name="" type="submit" value="查询" class="addbtn" /></div></form>
        	<table class="shangchuan-box leimu-box" width="100%" cellspacing="0" cellpadding="0">
            	<tr class="box-head xwlb">
                	<td width="260">类目名称</td>
                    <td>操作</td>
                </tr>
                <c:if test="${not empty fuBenList }">
                	<c:forEach items="${fuBenList }" var="fuBen">
                		<tr>
                			<td>${fuBen.name }
                			</td>
                    		<td><a href="${pageContext.request.contextPath }/admin/fuBen/selectFuBen.do?fbid=${fuBen.id}">编辑</a></td>
                    		
                		</tr>
                	</c:forEach>
                </c:if>
                
                
            
            </table>
            <p><a href="${pageContext.request.contextPath }/admin/addFuBen.do?selectType=fb" class="addbtn-2">添加副本类型</a></p>
        
        </div>
    
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath }/js/admin.js"></script>

 <div class="right">
    			<form action="${pageContext.request.contextPath }/admin/zhiYe/selectNewsTypeList.do" method="post">
 
        	<div class="leimu-tit">新闻分类管理：</div>
			<div class="lb-head">新闻类别：<select name="gameId" style="margin-right:85px;"><option value="1" ${'1' eq gameId ? 'selected':'' }>魔兽世界</option><option value="2" ${'2' eq gameId ? 'selected':'' }>英雄联盟</option></select><input name="" type="submit" value="查询" class="addbtn" /></div></form>
        	<table class="shangchuan-box leimu-box" width="100%" cellspacing="0" cellpadding="0">
            	<tr class="box-head xwlb">
                	<td width="260">类目名称</td>
                    <td>操作</td>
                </tr>
                <c:if test="${not empty newsTypeList }">
                	<c:forEach items="${newsTypeList }" var="newsType">
                		<tr>
                			<td>${newsType.name }
                			</td>
                    		<td><a href="${pageContext.request.contextPath }/admin/news/selectNewsType.do?newstypeid=${newsType.id}">编辑</a></td>
                    		
                		</tr>
                	</c:forEach>
                </c:if>
                
                
            
            </table>
            <p><a href="${pageContext.request.contextPath }/admin/addNewsType.do?selectType=news" class="addbtn-2">添加</a></p>
        
        </div>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath }/js/admin.js"></script>

 <div class="right">
 			<form action="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList.do" method="post">
			<div class="lb-head">招募类型：<select name="gameId" style="margin-right:85px;"><option value="1" ${'1' eq gameId ? 'selected':'' }>魔兽世界</option><option value="2" ${'2' eq gameId ? 'selected':'' }>英雄联盟</option></select>是否审核：<select name="state"><option value="2" ${'2' eq state ? 'selected':'' }>默认全部</option><option value="1" ${'1' eq state ? 'selected':'' }>已审核</option><option value="0" ${'0' eq state ? 'selected':'' }>未审核</option></select><input name="" type="submit" value="查询" class="addbtn" /></div></form>
        	<table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
            	<tr class="box-head xwlb">
                	<td>招募类型</td>
                    <td width="330">标题</td>
                    <td>时间</td>
                    <td>是否审核</td>
                    <td>操作</td>
                </tr>
                <c:if test="${not empty zhaoMuList }">
                	<c:forEach items="${zhaoMuList }" var="zhaoMu">
                		<tr>
                			<td>
                				<c:choose>
                					<c:when test="${'1' eq zhaoMu.gameid }">
                						魔兽世界
                					</c:when>
                					<c:when test="${'2' eq zhaoMu.gameid }">
                						英雄联盟
                					</c:when>
                				</c:choose> 
                			</td>
                    		<td>${zhaoMu.title }</td>
                    		<td>${zhaoMu.createtime }</td>
                    		<td>
                    			<c:choose>
                					<c:when test="${'1' eq zhaoMu.state }">
                						已审核
                					</c:when>
                					<c:when test="${'0' eq zhaoMu.state }">
                						未审核
                					</c:when>
                				</c:choose> 
                    		</td>
                    		<td><c:choose>
                					<c:when test="${'1' eq zhaoMu.state }">
                						<a href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMu.do?zhaomuid=${zhaoMu.id}">编辑</a> <a href="#" onclick="updateZhaoMuState(${zhaoMu.id},0)">删除</a>
                					</c:when>
                					<c:when test="${'0' eq zhaoMu.state }">
                						<a href="#" onclick="updateZhaoMuState(${zhaoMu.id},1)">审核</a> <a href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMu.do?zhaomuid=${zhaoMu.id}">编辑</a>
                					</c:when>
                				</c:choose> </td>
                		</tr>
                	</c:forEach>
                </c:if>
            
            </table>
             <p class="page">
          		<c:if test="${totalPage>0 }">
          			<c:if test="${nowPage>1 }">
          				<a href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList?gameId=${gameId }&state=${state }&nowPage=1">首页</a>
               			<a href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList?gameId=${gameId }&state=${state }&nowPage=${nowPage-1}" class="arro">&nbsp;<img src="${pageContext.request.contextPath }/images/page-left.jpg" />&nbsp;</a>
          			</c:if>
          			<c:choose>
    				<c:when test="${totalPage>1&&(totalPage<5 || totalPage==5) }">
    					<c:forEach var="item" varStatus="status" begin="1" end="${totalPage }">
    						<c:choose>
    							<c:when test="${status.index ==nowPage }">
    								<a class="pagecurtt">${ status.index}</a>
    							</c:when>
    							<c:otherwise>
    								<a href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList?gameId=${gameId }&state=${state }&nowPage=${status.index}">${ status.index}</a>
    							</c:otherwise>
    						
    						</c:choose> 
						</c:forEach> 
    				</c:when>
    				<c:when test="${totalPage>5}">
    					<c:choose>
    						<c:when test="${nowPage<=totalPage-5 }">
    							<c:choose>
    								<c:when test="${nowPage>5 }">
    									<a>……</a><a 
    						   		       href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList?gameId=${gameId }&state=${state }&nowPage=${nowPage-2}">${nowPage-2 }</a><a 
    						   		       href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList?gameId=${gameId }&state=${state }&nowPage=${nowPage-1}">${nowPage-1 }</a><a class="pagecurtt">${nowPage }</a><a 
    						   		       href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList?gameId=${gameId }&state=${state }&nowPage=${nowPage+1}">${nowPage+1 }</a><a 
    						   		       href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList?gameId=${gameId }&state=${state }&nowPage=${nowPage+2}">${nowPage+2 }</a><a 
    						   		      >……</a>
    								</c:when>
    								<c:otherwise>
    									<c:forEach var="item" varStatus="status" begin="1" end="5">
    										<c:choose>
    											<c:when test="${status.index ==nowPage }">
    												<a class="pagecurtt">${ status.index}</a>
    											</c:when>
    											<c:otherwise>
    												<a href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList?gameId=${gameId }&state=${state }&nowPage=${status.index}">${ status.index}</a>
    											</c:otherwise>
    										</c:choose> 
										</c:forEach>
										<a>……</a>
    								</c:otherwise>
    							</c:choose>
    						</c:when>
    						<c:otherwise>
    							<a>……</a>
    							<c:forEach var="item" varStatus="status" begin="${totalPage-4 }" end="${totalPage }">
    								<c:choose>
    									<c:when test="${status.index ==nowPage }">
    										<a class="pagecurtt">${ status.index}</a>
    									</c:when>
    									<c:otherwise>
    									<a href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList?gameid=${gameid }&state=${state }&nowPage=${status.index}">${ status.index}</a>
    									</c:otherwise>
    								</c:choose> 
								</c:forEach>
    						</c:otherwise>
    					</c:choose>
    				</c:when>
    			</c:choose>
          			<c:if test="${nowPage<totalPage }">
          			    <a href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList?gameid=${gameid }&state=${state }&nowPage=${nowPage+1}" class="arro">&nbsp;<img src="${pageContext.request.contextPath }/images/page-right.jpg" />&nbsp;</a> 
          				<a href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList?gameid=${gameid }&state=${state }&nowPage=${totalPage}">尾页</a>
          			</c:if>
          		</c:if>               
           </p>
            <p><a href="${pageContext.request.contextPath }/admin/addZhaoMu.do?selectType=zm" class="addbtn-2">添加新闻</a></p>
        
        </div>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath }/js/admin.js"></script>

 <div class="right">
  			<form action="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do" method="post">
 			<input name = "gameId" value="1" type="hidden"/>
			<div class="lb-head">视频分类<a href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinTypeList.do">查看</a>：<select name="sptypeid" style="margin-right:85px;">
			<option value="0">默认全部</option>
			<c:if test="${not empty shiPinTypeList }">
				<c:forEach items="${shiPinTypeList }" var="shiPinType">
					<option value="${shiPinType.id }" ${sptypeid eq shiPinType.id ? 'selected':'' }>${shiPinType.name }</option>
				</c:forEach>
			</c:if>
			</select>是否审核：<select name="state"><option value="2">默认全部</option><option value="1" ${'1' eq state ? 'selected':'' }>已审核</option><option value="0" ${'0' eq state ? 'selected':'' }>未审核</option></select><input name="" type="submit" value="查询" class="addbtn" /></div></form>
        	<table class="shangchuan-box" width="100%" cellspacing="0" cellpadding="0">
            	<tr class="box-head xwlb">
                	<td>视频分类</td>
                    <td width="330">视频名称</td>
                    <td>时间</td>
                    <td>是否审核</td>
                    <td>操作</td>
                </tr>
               <c:if test="${not empty shiPinList }">
                	<c:forEach items="${shiPinList }" var="shiPin">
                		<tr>
                			<td>${shiPin.sptypename }
                			</td>
                    		<td>${shiPin.name }</td>
                    		<td>${shiPin.createtime }</td>
                    		<td>
                    			<c:choose>
                					<c:when test="${'1' eq shiPin.state }">
                						已审核
                					</c:when>
                					<c:when test="${'0' eq shiPin.state }">
                						未审核
                					</c:when>
                				</c:choose> 
                    		</td>
                    		<td><c:choose>
                					<c:when test="${'1' eq shiPin.state }">
                						<a href="${pageContext.request.contextPath }/admin/shiPin/selectShiPin.do?spid=${shiPin.id}">编辑</a> <a href="#" onclick="updateShiPinState(${shiPin.id},0)">删除</a>
                					</c:when>
                					<c:when test="${'0' eq shiPin.state }">
                						<a href="#" onclick="updateShiPinState(${shiPin.id},1)">审核</a> <a href="${pageContext.request.contextPath }/admin/shiPin/selectShiPin.do?sphelpid=${shiPin.id}">编辑</a>
                					</c:when>
                				</c:choose> </td>
                		</tr>
                	</c:forEach>
                </c:if>
            
            </table>
<p class="page">
          		<c:if test="${totalPage>0 }">
          			<c:if test="${nowPage>1 }">
          				<a href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do?gameid=${gameid }&sptypeid=${sptypeid }&state=${state }&nowPage=1">首页</a>
               			<a href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do?gameid=${gameid }&sptypeid=${sptypeid }&state=${state }&nowPage=${nowPage-1}" class="arro">&nbsp;<img src="${pageContext.request.contextPath }/images/page-left.jpg" />&nbsp;</a>
          			</c:if>
          			<c:choose>
    				<c:when test="${totalPage>1&&(totalPage<5 || totalPage==5) }">
    					<c:forEach var="item" varStatus="status" begin="1" end="${totalPage }">
    						<c:choose>
    							<c:when test="${status.index ==nowPage }">
    								<a class="pagecurtt">${ status.index}</a>
    							</c:when>
    							<c:otherwise>
    								<a href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do?gameid=${gameid }&sptypeid=${sptypeid }&state=${state }&nowPage=${status.index}">${ status.index}</a>
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
    						   		       href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do?gameid=${gameid }&sptypeid=${sptypeid }&state=${state }&nowPage=${nowPage-2}">${nowPage-2 }</a><a 
    						   		       href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do?gameid=${gameid }&sptypeid=${sptypeid }&state=${state }&nowPage=${nowPage-1}">${nowPage-1 }</a><a class="pagecurtt">${nowPage }</a><a 
    						   		       href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do?gameid=${gameid }&sptypeid=${sptypeid }&state=${state }&nowPage=${nowPage+1}">${nowPage+1 }</a><a 
    						   		       href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do?gameid=${gameid }&sptypeid=${sptypeid }&state=${state }&nowPage=${nowPage+2}">${nowPage+2 }</a><a 
    						   		      >……</a>
    								</c:when>
    								<c:otherwise>
    									<c:forEach var="item" varStatus="status" begin="1" end="5">
    										<c:choose>
    											<c:when test="${status.index ==nowPage }">
    												<a class="pagecurtt">${ status.index}</a>
    											</c:when>
    											<c:otherwise>
    												<a href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do?gameid=${gameid }&sptypeid=${sptypeid }&state=${state }&nowPage=${status.index}">${ status.index}</a>
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
    									<a href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do?gameid=${gameid }&sptypeid=${sptypeid }&state=${state }&nowPage=${status.index}">${ status.index}</a>
    									</c:otherwise>
    								</c:choose> 
								</c:forEach>
    						</c:otherwise>
    					</c:choose>
    				</c:when>
    			</c:choose>
          			<c:if test="${nowPage<totalPage }">
          			    <a href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do?gameid=${gameid }&sptypeid=${sptypeid }&state=${state }&nowPage=${nowPage+1}" class="arro">&nbsp;<img src="${pageContext.request.contextPath }/images/page-right.jpg" />&nbsp;</a> 
          				<a href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do?gameid=${gameid }&sptypeid=${sptypeid }&state=${state }&nowPage=${totalPage}">尾页</a>
          			</c:if>
          		</c:if>               
           </p>
            <p><a href="${pageContext.request.contextPath }/admin/shiPin/toInsertShiPin.do" class="addbtn-2">添加</a></p>
        
        </div>
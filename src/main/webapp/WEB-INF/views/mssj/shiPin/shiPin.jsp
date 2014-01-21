<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="pro-left">
                <div class="pro-show">
                		<ul class="title">
                            <li class="left"></li>
                            <li class="center"><span class="shipin">视频</span></li>
                            <li class="right"></li>
                            <div class="clear"></div>
                        </ul>
                        <ul class="pro-shipin shipin-xq">
                        	<c:if test="${not empty shiPinList }">
                        	<c:forEach items="${shiPinList }" var="shiPin" varStatus="shiPinIndex">
                        		<c:choose>
                        			<c:when test="${(shiPinIndex.index+1)%3==0 }">
                        			<li style="padding-right:0;">
                        			</c:when>
                        			<c:otherwise>
                        			<li>
                        			</c:otherwise>
                        		</c:choose>
                        		<a href="${shiPin.watchurl }"><img src="${shiPin.imageurl }" /></a><p><a href="${shiPin.watchurl }">${shiPin.name }</a></p></li>
                        		
                        	</c:forEach>
                        	</c:if>
                            <div class="clear"></div>
                        </ul>
                </div>
                
	<p class="page">
          		<c:if test="${totalPage>0 }">
          			<c:if test="${nowPage>1 }">
          				<a href="${pageContext.request.contextPath }/mssj/shiPin/selectShiPinList?sptypeId=${sptypeId }&nowPage=1">首页</a>
               			<a href="${pageContext.request.contextPath }/mssj/shiPin/selectShiPinList?sptypeId=${sptypeId }&nowPage=${nowPage-1}" class="arro">&nbsp;<img src="${pageContext.request.contextPath }/images/page-left.jpg" />&nbsp;</a>
          			</c:if>
          			<c:choose>
    				<c:when test="${totalPage>1&&(totalPage<5 || totalPage==5) }">
    					<c:forEach var="item" varStatus="status" begin="1" end="${totalPage }">
    						<c:choose>
    							<c:when test="${status.index ==nowPage }">
    								<a class="pagecurtt">${ status.index}</a>
    							</c:when>
    							<c:otherwise>
    								<a href="${pageContext.request.contextPath }/mssj/shiPin/selectShiPinList?sptypeId=${sptypeId }&nowPage=${status.index}">${ status.index}</a>
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
    						   		       href="${pageContext.request.contextPath }/mssj/shiPin/selectShiPinList?sptypeId=${sptypeId }&nowPage=${nowPage-2}">${nowPage-2 }</a><a 
    						   		       href="${pageContext.request.contextPath }/mssj/shiPin/selectShiPinList?sptypeId=${sptypeId }&nowPage=${nowPage-1}">${nowPage-1 }</a><a class="pagecurtt">${nowPage }</a><a 
    						   		       href="${pageContext.request.contextPath }/mssj/shiPin/selectShiPinList?sptypeId=${sptypeId }&nowPage=${nowPage+1}">${nowPage+1 }</a><a 
    						   		       href="${pageContext.request.contextPath }/mssj/shiPin/selectShiPinList?sptypeId=${sptypeId }&nowPage=${nowPage+2}">${nowPage+2 }</a><a 
    						   		      >……</a>
    								</c:when>
    								<c:otherwise>
    									<c:forEach var="item" varStatus="status" begin="1" end="5">
    										<c:choose>
    											<c:when test="${status.index ==nowPage }">
    												<a class="pagecurtt">${ status.index}</a>
    											</c:when>
    											<c:otherwise>
    												<a href="${pageContext.request.contextPath }/mssj/shiPin/selectShiPinList?sptypeId=${sptypeId }&nowPage=${status.index}">${ status.index}</a>
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
    									<a href="${pageContext.request.contextPath }/mssj/shiPin/selectShiPinList?sptypeId=${sptypeId }&nowPage=${status.index}">${ status.index}</a>
    									</c:otherwise>
    								</c:choose> 
								</c:forEach>
    						</c:otherwise>
    					</c:choose>
    				</c:when>
    			</c:choose>
          			<c:if test="${nowPage<totalPage }">
          			    <a href="${pageContext.request.contextPath }/mssj/shiPin/selectShiPinList?sptypeId=${sptypeId }&nowPage=${nowPage+1}" class="arro">&nbsp;<img src="${pageContext.request.contextPath }/images/page-right.jpg" />&nbsp;</a> 
          				<a href="${pageContext.request.contextPath }/mssj/shiPin/selectShiPinList?sptypeId=${sptypeId }&nowPage=${totalPage}">尾页</a>
          			</c:if>
          		</c:if>               
           </p>            
 </div>
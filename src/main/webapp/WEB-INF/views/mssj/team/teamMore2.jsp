<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="pro-left">
      <div class="pro-show" style="margin-top:0;">
          <ul class="title">
              <li class="left"></li>
              <li class="center"><span class="duiyuan">队员展示</span></li>
              <li class="right"></li>
              <div class="clear"></div>
          </ul>
          <ul class="text">
          		<c:if test="${not empty teamList}">
          			<c:forEach items="${teamList }" var="team">
						<dl class="news-show clearfix">
                            <dd><a href="${pageContext.request.contextPath }/mssj/select/selectTeamContent?teamId=${team.id}"><img src="${team.headimg }" /></a></dd>
                            <dt><a href="${pageContext.request.contextPath }/mssj/select/selectTeamContent?teamId=${team.id}" style="color:#de0201">${team.nickname } </a></dt>
                            <dt><p>${team.description}</p></dt>
                            <div class="clear"></div>
                        </dl>
					</c:forEach>
          		</c:if>
          </ul>
          <p class="page">
          		<c:if test="${totalPage>0 }">
          			<c:if test="${nowPage>1 }">
          				<a href="${pageContext.request.contextPath }/mssj/select/selectTeamList?nowPage=1">首页</a>
               			<a href="${pageContext.request.contextPath }/mssj/select/selectTeamList?nowPage=${nowPage-1}" class="arro">&nbsp;<img src="${pageContext.request.contextPath }/images/page-left.jpg" />&nbsp;</a>
          			</c:if>
          			<c:choose>
    				<c:when test="${totalPage>1&&(totalPage<5 || totalPage==5) }">
    					<c:forEach var="item" varStatus="status" begin="1" end="${totalPage }">
    						<c:choose>
    							<c:when test="${status.index ==nowPage }">
    								<a class="pagecurtt">${ status.index}</a>
    							</c:when>
    							<c:otherwise>
    								<a href="${pageContext.request.contextPath }/mssj/select/selectTeamList?nowPage=${status.index}">${ status.index}</a>
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
    						   		       href="${pageContext.request.contextPath }/mssj/select/selectTeamList?nowPage=${nowPage-2}">${nowPage-2 }</a><a 
    						   		       href="${pageContext.request.contextPath }/mssj/select/selectTeamList?nowPage=${nowPage-1}">${nowPage-1 }</a><a class="pagecurtt">${nowPage }</a><a 
    						   		       href="${pageContext.request.contextPath }/mssj/select/selectTeamList?nowPage=${nowPage+1}">${nowPage+1 }</a><a 
    						   		       href="${pageContext.request.contextPath }/mssj/select/selectTeamList?nowPage=${nowPage+2}">${nowPage+2 }</a><a 
    						   		      >……</a>
    								</c:when>
    								<c:otherwise>
    									<c:forEach var="item" varStatus="status" begin="1" end="5">
    										<c:choose>
    											<c:when test="${status.index ==nowPage }">
    												<a class="pagecurtt">${ status.index}</a>
    											</c:when>
    											<c:otherwise>
    												<a href="${pageContext.request.contextPath }/mssj/select/selectTeamList?nowPage=${status.index}">${ status.index}</a>
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
    									<a href="${pageContext.request.contextPath }/mssj/select/selectTeamList?nowPage=${status.index}">${ status.index}</a>
    									</c:otherwise>
    								</c:choose> 
								</c:forEach>
    						</c:otherwise>
    					</c:choose>
    				</c:when>
    			</c:choose>
          			<c:if test="${nowPage<totalPage }">
          			    <a href="${pageContext.request.contextPath }/mssj/select/selectTeamList?nowPage=${nowPage+1}" class="arro">&nbsp;<img src="${pageContext.request.contextPath }/images/page-right.jpg" />&nbsp;</a> 
          				<a href="${pageContext.request.contextPath }/mssj/select/selectTeamList?nowPage=${totalPage}">尾页</a>
          			</c:if>
          		</c:if>               
           </p>
                        
                       
                </div>
                
            
            </div>
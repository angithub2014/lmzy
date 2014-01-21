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
          
          
          <c:if test="${fn:length(duiYuanTypeList)>0 }">
          		          <!-- 阵容一 -->
          
          	<h4><span>&nbsp;</span><b>${duiYuanTypeList[0].name }</b><span>&nbsp;</span></h4>
               <div class="zhanshi-box clearfix">
                   <div class="pro">
                   <div>
                   <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-1.jpg" width="216" height="33" /></h2>
                   <ul class="clearfix">
                   		<c:forEach items="${duiYuanList0 }" var="tankezu">
                   			<c:if test="${tankezu.role =='坦克组' }">
                   				<li><em><img src="${tankezu.imgurl }" width="25" height="25" /></em><a href="${tankezu.detailurl }" class="duiyuan-name">${tankezu.name }</a><a href="${tankezu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                   </ul>
                   </div>
                   <div>
                      <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-4.jpg" width="216" height="33" /></h2>
                      <ul class="clearfix">
                      <c:forEach items="${duiYuanList0 }" var="jinzhanzu">
                   			<c:if test="${jinzhanzu.role =='近战组' }">
                   				<li><em><img src="${jinzhanzu.imgurl }" width="25" height="25" /></em><a href="${jinzhanzu.detailurl }" class="duiyuan-name">${jinzhanzu.name }</a><a href="${jinzhanzu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                      </ul>
                    </div>
                </div>
                <div class="pro" style="margin:0 3px;">
                  <div>
                     <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-2.jpg" width="216" height="33" /></h2>
                     <ul class="clearfix">
                      <c:forEach items="${duiYuanList0 }" var="zhiliaozu">
                   			<c:if test="${zhiliaozu.role =='治疗组' }">
                   				<li><em><img src="${zhiliaozu.imgurl }" width="25" height="25" /></em><a href="${zhiliaozu.detailurl }"  class="duiyuan-name">${zhiliaozu.name }</a><a href="${zhiliaozu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                     </ul>
                  </div>
               </div>
               <div class="pro" style="background:none">
                    <div>
                       <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-3.jpg" width="216" height="33" /></h2>
                       <ul class="clearfix">
						<c:forEach items="${duiYuanList0 }" var="yuanchengzu">
                   			<c:if test="${yuanchengzu.role =='远程组' }">
                   				<li><em><img src="${yuanchengzu.imgurl }" width="25" height="25" /></em><a href="${yuanchengzu.detailurl }"  class="duiyuan-name">${yuanchengzu.name }</a><a href="${yuanchengzu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>                       
                   		</ul>
                    </div>
                </div>
                                
            </div>
          		
          </c:if>
          <c:if test="${fn:length(duiYuanTypeList)>1 }">
            <!-- 阵容一二-->
          	<h4><span>&nbsp;</span><b>${duiYuanTypeList[1].name }</b><span>&nbsp;</span></h4>
               <div class="zhanshi-box clearfix">
                   <div class="pro">
                   <div>
                   <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-1.jpg" width="216" height="33" /></h2>
                   <ul class="clearfix">
                   		<c:forEach items="${duiYuanList1 }" var="tankezu">
                   			<c:if test="${tankezu.role =='坦克组' }">
                   				<li><em><img src="${tankezu.imgurl }" width="25" height="25" /></em><a href="${tankezu.detailurl }"  class="duiyuan-name">${tankezu.name }</a><a href="${tankezu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                   </ul>
                   </div>
                   <div>
                      <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-4.jpg" width="216" height="33" /></h2>
                      <ul class="clearfix">
                      <c:forEach items="${duiYuanList1 }" var="jinzhanzu">
                   			<c:if test="${jinzhanzu.role =='近战组' }">
                   				<li><em><img src="${jinzhanzu.imgurl }" width="25" height="25" /></em><a href="${jinzhanzu.detailurl }"  class="duiyuan-name">${jinzhanzu.name }</a><a href="${jinzhanzu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                      </ul>
                    </div>
                </div>
                <div class="pro" style="margin:0 3px;">
                  <div>
                     <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-2.jpg" width="216" height="33" /></h2>
                     <ul class="clearfix">
                      <c:forEach items="${duiYuanList1 }" var="zhiliaozu">
                   			<c:if test="${zhiliaozu.role =='治疗组' }">
                   				<li><em><img src="${zhiliaozu.imgurl }" width="25" height="25" /></em><a href="${zhiliaozu.detailurl }"  class="duiyuan-name">${zhiliaozu.name }</a><a href="${zhiliaozu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                     </ul>
                  </div>
               </div>
               <div class="pro" style="background:none">
                    <div>
                       <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-3.jpg" width="216" height="33" /></h2>
                       <ul class="clearfix">
						<c:forEach items="${duiYuanList1 }" var="yuanchengzu">
                   			<c:if test="${yuanchengzu.role =='远程组' }">
                   				<li><em><img src="${yuanchengzu.imgurl }" width="25" height="25" /></em><a href="${yuanchengzu.detailurl }"  class="duiyuan-name">${yuanchengzu.name }</a><a href="${yuanchengzu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>                       
                   		</ul>
                    </div>
                </div>
                                
            </div>
            </c:if>
            <c:if test="${fn:length(duiYuanTypeList)>2 }">
            <!-- 阵容三-->
            <h4><span>&nbsp;</span><b>${duiYuanTypeList[2].name }</b><span>&nbsp;</span></h4>
               <div class="zhanshi-box clearfix">
                   <div class="pro">
                   <div>
                   <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-1.jpg" width="216" height="33" /></h2>
                   <ul class="clearfix">
                   		<c:forEach items="${duiYuanList2 }" var="tankezu">
                   			<c:if test="${tankezu.role =='坦克组' }">
                   				<li><em><img src="${tankezu.imgurl }" width="25" height="25" /></em><a href="${tankezu.detailurl }"  class="duiyuan-name">${tankezu.name }</a><a href="${tankezu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                   </ul>
                   </div>
                   <div>
                      <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-4.jpg" width="216" height="33" /></h2>
                      <ul class="clearfix">
                      <c:forEach items="${duiYuanList2 }" var="jinzhanzu">
                   			<c:if test="${jinzhanzu.role =='近战组' }">
                   				<li><em><img src="${jinzhanzu.imgurl }" width="25" height="25" /></em><a href="${jinzhanzu.detailurl }"  class="duiyuan-name">${jinzhanzu.name }</a><a href="${jinzhanzu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                      </ul>
                    </div>
                </div>
                <div class="pro" style="margin:0 3px;">
                  <div>
                     <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-2.jpg" width="216" height="33" /></h2>
                     <ul class="clearfix">
                      <c:forEach items="${duiYuanList2 }" var="zhiliaozu">
                   			<c:if test="${zhiliaozu.role =='治疗组' }">
                   				<li><em><img src="${zhiliaozu.imgurl }" width="25" height="25" /></em><a href="${zhiliaozu.detailurl }"  class="duiyuan-name">${zhiliaozu.name }</a><a href="${zhiliaozu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                     </ul>
                  </div>
               </div>
               <div class="pro" style="background:none">
                    <div>
                       <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-3.jpg" width="216" height="33" /></h2>
                       <ul class="clearfix">
						<c:forEach items="${duiYuanList2 }" var="yuanchengzu">
                   			<c:if test="${yuanchengzu.role =='远程组' }">
                   				<li><em><img src="${yuanchengzu.imgurl }" width="25" height="25" /></em><a href="${yuanchengzu.detailurl }"  class="duiyuan-name">${yuanchengzu.name }</a><a href="${yuanchengzu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>                       
                   		</ul>
                    </div>
                </div>
                                
            </div>
            </c:if>
            <c:if test="${fn:length(duiYuanTypeList)>3 }">
            <!-- 阵容四-->
            <h4><span>&nbsp;</span><b>${duiYuanTypeList[3].name }</b><span>&nbsp;</span></h4>
               <div class="zhanshi-box clearfix">
                   <div class="pro">
                   <div>
                   <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-1.jpg" width="216" height="33" /></h2>
                   <ul class="clearfix">
                   		<c:forEach items="${duiYuanList3 }" var="tankezu">
                   			<c:if test="${tankezu.role =='坦克组' }">
                   				<li><em><img src="${tankezu.imgurl }" width="25" height="25" /></em><a href="${tankezu.detailurl }"  class="duiyuan-name">${tankezu.name }</a><a href="${tankezu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                   </ul>
                   </div>
                   <div>
                      <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-4.jpg" width="216" height="33" /></h2>
                      <ul class="clearfix">
                      <c:forEach items="${duiYuanList3 }" var="jinzhanzu">
                   			<c:if test="${jinzhanzu.role =='近战组' }">
                   				<li><em><img src="${jinzhanzu.imgurl }" width="25" height="25" /></em><a href="${jinzhanzu.detailurl }"  class="duiyuan-name">${jinzhanzu.name }</a><a href="${jinzhanzu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                      </ul>
                    </div>
                </div>
                <div class="pro" style="margin:0 3px;">
                  <div>
                     <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-2.jpg" width="216" height="33" /></h2>
                     <ul class="clearfix">
                      <c:forEach items="${duiYuanList3 }" var="zhiliaozu">
                   			<c:if test="${zhiliaozu.role =='治疗组' }">
                   				<li><em><img src="${zhiliaozu.imgurl }" width="25" height="25" /></em><a href="${zhiliaozu.detailurl }"  class="duiyuan-name">${zhiliaozu.name }</a><a href="${zhiliaozu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                     </ul>
                  </div>
               </div>
               <div class="pro" style="background:none">
                    <div>
                       <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-3.jpg" width="216" height="33" /></h2>
                       <ul class="clearfix">
						<c:forEach items="${duiYuanList3 }" var="yuanchengzu">
                   			<c:if test="${yuanchengzu.role =='远程组' }">
                   				<li><em><img src="${yuanchengzu.imgurl }" width="25" height="25" /></em><a href="${yuanchengzu.detailurl }"  class="duiyuan-name">${yuanchengzu.name }</a><a href="${yuanchengzu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>                       
                   		</ul>
                    </div>
                </div>
                                
            </div>
            </c:if>
            <c:if test="${fn:length(duiYuanTypeList)>4}">
            <!-- 阵容五-->
            <h4><span>&nbsp;</span><b>${duiYuanTypeList[4].name }</b><span>&nbsp;</span></h4>
               <div class="zhanshi-box clearfix">
                   <div class="pro">
                   <div>
                   <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-1.jpg" width="216" height="33" /></h2>
                   <ul class="clearfix">
                   		<c:forEach items="${duiYuanList4 }" var="tankezu">
                   			<c:if test="${tankezu.role =='坦克组' }">
                   				<li><em><img src="${tankezu.imgurl }" width="25" height="25" /></em><a href="${tankezu.detailurl }"  class="duiyuan-name">${tankezu.name }</a><a href="${tankezu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                   </ul>
                   </div>
                   <div>
                      <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-4.jpg" width="216" height="33" /></h2>
                      <ul class="clearfix">
                      <c:forEach items="${duiYuanList4 }" var="jinzhanzu">
                   			<c:if test="${jinzhanzu.role =='近战组' }">
                   				<li><em><img src="${jinzhanzu.imgurl }" width="25" height="25" /></em><a href="${jinzhanzu.detailurl }"  class="duiyuan-name">${jinzhanzu.name }</a><a href="${jinzhanzu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                      </ul>
                    </div>
                </div>
                <div class="pro" style="margin:0 3px;">
                  <div>
                     <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-2.jpg" width="216" height="33" /></h2>
                     <ul class="clearfix">
                      <c:forEach items="${duiYuanList4 }" var="zhiliaozu">
                   			<c:if test="${zhiliaozu.role =='治疗组' }">
                   				<li><em><img src="${zhiliaozu.imgurl }" width="25" height="25" /></em><a href="${zhiliaozu.detailurl }"  class="duiyuan-name">${zhiliaozu.name }</a><a href="${zhiliaozu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                     </ul>
                  </div>
               </div>
               <div class="pro" style="background:none">
                    <div>
                       <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-3.jpg" width="216" height="33" /></h2>
                       <ul class="clearfix">
						<c:forEach items="${duiYuanList4 }" var="yuanchengzu">
                   			<c:if test="${yuanchengzu.role =='远程组' }">
                   				<li><em><img src="${yuanchengzu.imgurl }" width="25" height="25" /></em><a href="${yuanchengzu.detailurl }"  class="duiyuan-name">${yuanchengzu.name }</a><a href="${yuanchengzu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>                       
                   		</ul>
                    </div>
                </div>
                                
            </div>
        </c:if>
        <p class="page">
          		<c:if test="${totalPage>0 }">
          			<c:if test="${nowPage>1 }">
          				<a href="${pageContext.request.contextPath }/mssj/duiYuan/selectDuiYuanList?nowPage=1">首页</a>
               			<a href="${pageContext.request.contextPath }/mssj/duiYuan/selectDuiYuanList?nowPage=${nowPage-1}" class="arro">&nbsp;<img src="${pageContext.request.contextPath }/images/page-left.jpg" />&nbsp;</a>
          			</c:if>
          			<c:choose>
    				<c:when test="${totalPage>1&&(totalPage<5 || totalPage==5) }">
    					<c:forEach var="item" varStatus="status" begin="1" end="${totalPage }">
    						<c:choose>
    							<c:when test="${status.index ==nowPage }">
    								<a class="pagecurtt">${ status.index}</a>
    							</c:when>
    							<c:otherwise>
    								<a href="${pageContext.request.contextPath }/mssj/duiYuan/selectDuiYuanList?nowPage=${status.index}">${ status.index}</a>
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
    						   		       href="${pageContext.request.contextPath }/mssj/duiYuan/selectDuiYuanList?nowPage=${nowPage-2}">${nowPage-2 }</a><a 
    						   		       href="${pageContext.request.contextPath }/mssj/duiYuan/selectDuiYuanList?nowPage=${nowPage-1}">${nowPage-1 }</a><a class="pagecurtt">${nowPage }</a><a 
    						   		       href="${pageContext.request.contextPath }/mssj/duiYuan/selectDuiYuanList?nowPage=${nowPage+1}">${nowPage+1 }</a><a 
    						   		       href="${pageContext.request.contextPath }/mssj/duiYuan/selectDuiYuanList?nowPage=${nowPage+2}">${nowPage+2 }</a><a 
    						   		      >……</a>
    								</c:when>
    								<c:otherwise>
    									<c:forEach var="item" varStatus="status" begin="1" end="5">
    										<c:choose>
    											<c:when test="${status.index ==nowPage }">
    												<a class="pagecurtt">${ status.index}</a>
    											</c:when>
    											<c:otherwise>
    												<a href="${pageContext.request.contextPath }/mssj/duiYuan/selectDuiYuanList?nowPage=${status.index}">${ status.index}</a>
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
    									<a href="${pageContext.request.contextPath }/mssj/duiYuan/selectDuiYuanList?nowPage=${status.index}">${ status.index}</a>
    									</c:otherwise>
    								</c:choose> 
								</c:forEach>
    						</c:otherwise>
    					</c:choose>
    				</c:when>
    			</c:choose>
          			<c:if test="${nowPage<totalPage }">
          			    <a href="${pageContext.request.contextPath }/mssj/duiYuan/selectDuiYuanList?nowPage=${nowPage+1}" class="arro">&nbsp;<img src="${pageContext.request.contextPath }/images/page-right.jpg" />&nbsp;</a> 
          				<a href="${pageContext.request.contextPath }/mssj/duiYuan/selectDuiYuanList?nowPage=${totalPage}">尾页</a>
          			</c:if>
          		</c:if>               
           </p>
        </div>
     </div>
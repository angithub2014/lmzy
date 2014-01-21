<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="pro-left">
     <div class="pro-show" style="margin-top:0;">
          <ul class="title">
              <li class="left"></li>
              <li class="center"><span class="tupian">图片新闻</span></li>
              <li class="right"></li>
              <div class="clear"></div>
          </ul>
          <c:if test="${not empty imgNewsList }">
                <c:forEach items="${imgNewsList }" var="imgNews">
                     <dl class="news-show clearfix">
                        <dd><a href="${pageContext.request.contextPath }/mssj/news/selectNewsContent?newsId=${imgNews.id}"><img src="${imgNews.imgurl }" /></a></dd>
                        <dt><a href="${pageContext.request.contextPath }/mssj/news/selectNewsContent?newsId=${imgNews.id}" class="biaoti">${imgNews.title }</a></dt>
                        <dt>
                        <c:set var="len" value="${fn:indexOf(imgNews.content, '</p>') }"></c:set>
                        ${fn:substring(imgNews.content,0,len) } 
                        <p><a href="${pageContext.request.contextPath }/mssj/news/selectNewsContent?newsId=${imgNews.id}" class="chakan">查看详情</a></p>
                        </dt>
                        <div class="clear"></div>
                     </dl>
                </c:forEach>
         </c:if>
     </div>
     <div class="pro-show">
          <ul class="title">
              <li class="left"></li>
              <li class="center"><span class="shipin">视频展示</span></li>
              <li class="right"></li>
              <div class="clear"></div>
          </ul>
          <ul class="pro-shipin">
          		<c:if test="${not empty indexShiPinList }">
                        	<c:forEach items="${indexShiPinList }" var="shiPin" varStatus="shiPinIndex">
                        		<c:choose>
                        			<c:when test="${(shiPinIndex.index+1)%3==0 }">
                        			<li style="padding-right:0;">
                        			</c:when>
                        			<c:otherwise>
                        			<li>
                        			</c:otherwise>
                        		</c:choose>
                        		<a href="${shiPin.watchurl }"><img src="${shiPin.imageurl }" /><p><a href="${shiPin.watchurl }">${shiPin.name }</a></p></a></li>
                        		
                        	</c:forEach>
                        	</c:if>
              <div class="clear"></div>
          </ul>
      </div>
        <div class="pro-show" style="margin-top:0;">
               <ul class="title">
                  <li class="left"></li>
                  <li class="center"><span class="duiyuan">队员展示</span></li>
                  <li class="right"></li>
                  <div class="clear"></div>
               </ul>
               <h4><span>&nbsp;</span><b>${indexDuiYuanType }</b><span>&nbsp;</span></h4>
               <div class="zhanshi-box clearfix">
                   <div class="pro">
                   <div>
                   <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-1.jpg" width="216" height="33" /></h2>
                   <ul class="clearfix">
                   		<c:forEach items="${indexDuiYuanList }" var="tankezu">
                   			<c:if test="${tankezu.role =='坦克组' }">
                   				<li><em><img src="${tankezu.imgurl }" width="25" height="25" /></em><a href="${tankezu.detailurl }"  class="duiyuan-name"	>${tankezu.name }</a><a href="${tankezu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>
                   </ul>
                   </div>
                   <div>
                      <h2><img src="${pageContext.request.contextPath }/images/duiyuan-img-4.jpg" width="216" height="33" /></h2>
                      <ul class="clearfix">
                      <c:forEach items="${indexDuiYuanList }" var="jinzhanzu">
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
                      <c:forEach items="${indexDuiYuanList }" var="zhiliaozu">
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
						<c:forEach items="${indexDuiYuanList }" var="yuanchengzu">
                   			<c:if test="${yuanchengzu.role =='远程组' }">
                   				<li><em><img src="${yuanchengzu.imgurl }" width="25" height="25" /></em><a href="${yuanchengzu.detailurl }"  class="duiyuan-name">${yuanchengzu.name }</a><a href="${yuanchengzu.herourl }"><img src="${pageContext.request.contextPath }/images/duiyuanxqbg.jpg" width="22" height="22" /></a></li>
                   				
                   			</c:if>
                   		</c:forEach>                       </ul>
                    </div>
                </div>
                                
            </div>
        </div>
   </div>
         

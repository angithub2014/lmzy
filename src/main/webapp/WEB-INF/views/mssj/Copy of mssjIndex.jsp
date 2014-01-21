<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="${pageContext.request.contextPath }/css/allpage.css" rel="stylesheet" type="text/css" />

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
      <div class="pro-show">
         <ul class="title">
            <li class="left"></li>
            <li class="center"><span class="duiyuan">队员展示</span></li>
            <li class="right"></li>
            <div class="clear"></div>
         </ul>
         <ul class="pro-duiyuan-box">
            <li class="left">
            <p>远程组</p>
               <ul class="clearfix">
               	 <c:if test="${not empty indexTeam1List }">
           			<c:forEach items="${indexTeam1List }" var="index1Team">
           				<li>
           					<a>${index1Team.nameid }</a>
               			</li>
           			</c:forEach>
           		</c:if>
               </ul>
                            	
            </li>
            <li class="center">&nbsp;</li>
            <li class="right">
            <p>近战组</p>
               <ul class="clearfix">
                  <c:if test="${not empty indexTeam2List }">
           			<c:forEach items="${indexTeam2List }" var="index2Team">
           				<li>
           					<a>${index2Team.nameid }</a>
               			</li>
           			</c:forEach>
           		</c:if>
               </ul>
           </li>
           <div class="clear"></div>
           </ul>
       </div>
    </div>

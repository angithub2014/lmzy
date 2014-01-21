<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.Random" %>
<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-migrate-1.1.0.js"></script>
<script src="${pageContext.request.contextPath }/js/header.js"></script>

<% 
	int rand = (int)(Math.random()*10)+1;
%>
<div class="header">
   		<div class="head-top">
           		<a href="${pageContext.request.contextPath }/index"><img src="${pageContext.request.contextPath }/images/logo.jpg" width="206" height="165" /></a>
                <div class="on-Load">
                <em class="goto">进入<a href="#">英雄联盟>></a></em>
                <c:choose>
                	<c:when test="${not empty userInfo }">
                	     你好,<c:choose><c:when test="${fn:length(userInfo.userName)>5 }">${fn:substring(userInfo.userName,0,3)}**</c:when><c:otherwise>${userInfo.userName }</c:otherwise></c:choose> 
                	
                	<a href="${pageContext.request.contextPath }/userInfo/modifyPassWordIndex.do">【修改密码】</a><a href="${pageContext.request.contextPath }/userInfo/loginOut.do">【退出登录】</a>
                	</c:when>
                	<c:otherwise>
                		<a href="${pageContext.request.contextPath }/login" class="left">登录</a><span>|</span><a href="${pageContext.request.contextPath }/register" class="right">注册</a>
                	</c:otherwise>
                </c:choose>
                </div>
   	    </div>
		<div class="nav">
             	<div class="clearfix">
                     <span class="img-left">
                     	<img src="${pageContext.request.contextPath }/images/nav-bg-left.jpg" width="14" height="14" />
                     </span>
                     <ul id="navs">
                       <li>
                       		<span><a href="${pageContext.request.contextPath }/mssjIndex" <c:if test="${selectType eq 'index' }">class="cur"</c:if>>首&nbsp;&nbsp;&nbsp;&nbsp;页</a></span>
                       </li>
                       <li id="fb">
                       		<span id="fb"><a <c:if test="${selectType eq 'fb' }">class="cur"</c:if> href="${pageContext.request.contextPath }/mssj/fuBen/selectFuBenMoreList?gameId=1">副本攻略</a></span>

                       </li>
                       <li  id="zy">
                            <span id="zy"><a <c:if test="${selectType eq 'zy' }">class="cur"</c:if> href="${pageContext.request.contextPath }/mssj/zhiYe/selectZhiYeMoreList?gameId=1">职业指南</a></span>
                       </li>
                       <li id="sp">
                       		<span id="sp"><a href="${pageContext.request.contextPath }/mssj/shiPin/selectShiPinMoreList" <c:if test="${selectType eq 'sp' }">class="cur"</c:if>>视&nbsp;&nbsp;&nbsp;&nbsp;频</a></span>
                       </li>
                       <li id="news">
                       		<span id="news"><a href="${pageContext.request.contextPath }/mssj/news/selectNewsList" <c:if test="${selectType eq 'news' }">class="cur"</c:if>>新&nbsp;&nbsp;&nbsp;&nbsp;闻</a></span>
                       </li>
                       <li>
                       		<span><a href="${pageContext.request.contextPath }/mssj/duiYuan/selectDuiYuanList" <c:if test="${selectType eq 'dy' }">class="cur"</c:if>>队员展示</a></span>
                       </li>
                       <li>
                       		<span><a href="${pageContext.request.contextPath }/mssj/aboutUs" <c:if test="${selectType eq 'us' }">class="cur"</c:if>>关于我们</a></span>
                       </li>
                       <li>
                            <span><a href="hhttp://bbs.wingsofaurora.com.cn" target="_blank">论&nbsp;&nbsp;&nbsp;&nbsp;坛</a></span>
                       </li>
                     </ul>
                     <span class="img-right">
                     	<img src="${pageContext.request.contextPath }/images/nav-bg-right.jpg" width="14" height="14" />
                      </span>
         		</div>
       </div>
    </div>
    <div class="body-bj">
    <div class="banner-1">
    	<div class="banner-box">
    		<a href="#"><img src="${pageContext.request.contextPath }/images/mssj-tu<%=rand %>.jpg" width="1000" height="270" /></a>
            <a href="#"><img src="${pageContext.request.contextPath }/images/mssj-tu<%=rand %>.jpg" width="1000" height="270" /></a>
            <a href="#"><img src="${pageContext.request.contextPath }/images/mssj-tu<%=rand %>.jpg" width="1000" height="270" /></a>
            <a href="#"><img src="${pageContext.request.contextPath }/images/mssj-tu<%=rand %>.jpg" width="1000" height="270" /></a>
        </div> 
        <!--<div class="arro"><a href="#" class="focus"><img src="images/talk.png" class="left focus" /></a><a href="#" class="focus"><img src="images/talk.png" class="right focus" /></a></div>   -->
    </div>
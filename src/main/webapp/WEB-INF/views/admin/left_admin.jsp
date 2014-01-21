<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="left">
   <ul>
      <c:choose>
      	<c:when test="${'news' eq selectType || 'news' eq param.selectType}">
      		<li class="cur"><a href="${pageContext.request.contextPath }/admin/news/selectNewsList.do">新闻惯例</a></li>
      	</c:when>
      	<c:otherwise>
      		<li ><a href="${pageContext.request.contextPath }/admin/news/selectNewsList.do">新闻惯例</a></li>
      	</c:otherwise>
      </c:choose>
      <c:choose>
      	<c:when test="${'fb' eq selectType || 'fb' eq param.selectType}">
      		<li class="cur"><a href="${pageContext.request.contextPath }/admin/fuBen/selectFuBenHelpList.do">副本攻略</a></li>
      	</c:when>
      	<c:otherwise>
      		<li ><a href="${pageContext.request.contextPath }/admin/fuBen/selectFuBenHelpList.do">副本攻略</a></li>
      	</c:otherwise>
      </c:choose>
      <c:choose>
      	<c:when test="${'zy' eq selectType || 'zy' eq param.selectType}">
      		<li class="cur"><a href="${pageContext.request.contextPath }/admin/zhiYe/selectZhiYeHelpList.do">职业指南</a></li>
      	</c:when>
      	<c:otherwise>
      		<li ><a href="${pageContext.request.contextPath }/admin/zhiYe/selectZhiYeHelpList.do">职业指南</a></li>
      	</c:otherwise>
      </c:choose>
      <c:choose>
      	<c:when test="${'zm' eq selectType || 'zm' eq param.selectType}">
      		<li class="cur"><a href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList.do">招聘信息</a></li>
      	</c:when>
      	<c:otherwise>
      		<li ><a href="${pageContext.request.contextPath }/admin/zhaoMu/selectZhaoMuList.do">招聘信息</a></li>
      	</c:otherwise>
      </c:choose>
      <c:choose>
      	<c:when test="${'dy' eq selectType || 'dy' eq param.selectType}">
      		<li class="cur"><a href="${pageContext.request.contextPath }/admin/duiYuan/selectDuiYuanList.do">队员介绍</a></li>
      	</c:when>
      	<c:otherwise>
      		<li ><a href="${pageContext.request.contextPath }/admin/duiYuan/selectDuiYuanList.do">队员介绍</a></li>
      	</c:otherwise>
      </c:choose>
      <c:choose>
      	<c:when test="${'sp' eq selectType || 'sp' eq param.selectType}">
      		<li class="cur"><a href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do">游戏视频</a></li>
      	</c:when>
      	<c:otherwise>
      		<li ><a href="${pageContext.request.contextPath }/admin/shiPin/selectShiPinList.do">游戏视频</a></li>
      	</c:otherwise>
      </c:choose>
      <c:choose>
      	<c:when test="${'fs' eq selectType || 'fs' eq param.selectType}">
      		<li class="cur"><a href="${pageContext.request.contextPath }/admin/other/selectFriendShipList.do">友情链接</a></li>
      	</c:when>
      	<c:otherwise>
      		<li ><a href="${pageContext.request.contextPath }/admin/other/selectFriendShipList.do">友情链接</a></li>
      	</c:otherwise>
      </c:choose>
      <c:choose>
      	<c:when test="${'as' eq selectType || 'as' eq param.selectType}">
      		<li class="cur"><a href="${pageContext.request.contextPath }/admin/other/selectAboutUs.do">关于我们</a></li>
      	</c:when>
      	<c:otherwise>
      		<li ><a href="${pageContext.request.contextPath }/admin/other/selectAboutUs.do">关于我们</a></li>
      	</c:otherwise>
      </c:choose>
   </ul>
</div>

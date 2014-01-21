<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="pro-right">
   <div class="pro-show-right">
       <h2 class="weibo"><a href="${pageContext.request.contextPath }/mssj/weiBo">更多</a>微博</h2>
       <div class="right-box one">
<iframe width="100%" height="550" class="share_self"  frameborder="0" scrolling="no" src="http://widget.weibo.com/weiboshow/index.php?language=&width=0&height=550&fansRow=1&ptype=1&speed=0&skin=5&isTitle=1&noborder=1&isWeibo=1&isFans=0&uid=2425622061&verifier=7cf1afbe&dpc=1"></iframe>
						</div>
            <h2 class="zhinan"><a href="${pageContext.request.contextPath }/mssj/zhiYe/selectZhiYeMoreList?gameId=1">更多</a>最新职业指南</h2>
            <div class="right-box">
                 <ul>
                 <c:if test="${not empty zhiYeListRight }">
                    <c:forEach items="${zhiYeListRight }" var="zhiYe">
                        <li><a href="${pageContext.request.contextPath }/mssj/zhiYe/selectZhiYeContent?zhiYeGuideId=${zhiYe.id}">${zhiYe.title }</a><span>${fn:substring(zhiYe.createtime,0,10)}</span></li>
                    </c:forEach>			
                 </c:if>
                 </ul>
            </div>
            <div class="right-banner"><a href="${pageContext.request.contextPath }/mssj/select/selectRecruitList"><img src="${pageContext.request.contextPath }/images/right-ban.jpg" /></a></div>
            <h2 class="gonglve"><a href="${pageContext.request.contextPath }/mssj/fuBen/selectFuBenMoreList?gameId=1">更多</a>最新副本攻略</h2>
            <div class="right-box">
                <ul>
                    <c:if test="${not empty fuBenListRight }">
                    <c:forEach items="${fuBenListRight }" var="fuBen">
                        <li><a href="${pageContext.request.contextPath }/mssj/fuBen/selectFuBenContent?fuBenHelpId=${fuBen.id}">${fuBen.title }</a><span>${fn:substring(fuBen.createtime,0,10)}</span></li>
                    </c:forEach>			
                 	</c:if>
                 </ul>
            </div>
            <h2 class="zhaomu"><a href="${pageContext.request.contextPath }/mssj/select/selectRecruitList">更多</a>招募信息</h2>
            <div class="right-box">
                <c:if test="${not empty recruitListRight }">
                	<c:forEach items="${recruitListRight }" var="recruit">
                		<div class="moshou"><a href="${pageContext.request.contextPath }/mssj/select/selectRecruitContent?recruitId=${recruit.id}" style="display:inline-block; width:28px;"><img src="${recruit.imgurl}" /></a><a href="${pageContext.request.contextPath }/mssj/select/selectRecruitContent?recruitId=${recruit.id}" style="display:inline-block; width:198px; padding-left:10px; overflow:hidden">${recruit.title }</a><a href="${pageContext.request.contextPath }/mssj/select/selectRecruitContent?recruitId=${recruit.id}" class="btn" ><img src="${pageContext.request.contextPath }/images/moshou-btn.jpg" /></a></div>
                		
                	</c:forEach>
                </c:if>
            </div>
            <h2 class="luntan"><a href="hhttp://bbs.wingsofaurora.com.cn/forum.jsp?fid=2&spec=digest">更多</a>论坛精华</h2>
            <div class="right-box">
                 <ul>
                 	<c:if test="${not empty bbsListRight }">
                    <c:forEach items="${bbsListRight }" var="bbs">
                        <li><a href="hhttp://bbs.wingsofaurora.com.cn/topic-${bbs.topicID }.html">${bbs.title }</a><span>${fn:substring(bbs.createTime,0,10)}</span></li>
                    </c:forEach>			
                 	</c:if>
                  </ul>
             </div>
             <h2 class="lianxi">联系方式</h2>
             <div class="right-box tel">
                 <p>联系人：${aboutUs.name }<br />联系邮箱：${aboutUs.email }<br />电话：${aboutUs.mobile }<br /></p>
             </div>
         </div>
   </div>
   </div>
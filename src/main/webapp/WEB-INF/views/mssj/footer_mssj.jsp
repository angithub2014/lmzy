<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="frebox">
	<div class="frelogo">
	<c:forEach items="${publicFriendShipList }" var="friendShip">
	<c:choose>
		<c:when test="${not empty friendShip.imgurl }">
		         
		            <a href="${friendShip.url }"><img src="${friendShip.imgurl }" width="140" height="50" /></a>
		
		</c:when>
			<c:otherwise>
	 
	</c:otherwise>
		
	</c:choose>
           
             </c:forEach>
      		</div>
    <div class="frename">
    <c:forEach items="${publicFriendShipList }" var="friendShip">
	<c:choose>
		<c:when test="${empty friendShip.imgurl }">
		         
            <a href="${friendShip.url }">${friendShip.name }</a>
		
		</c:when>
			<c:otherwise>
	 
	</c:otherwise>
		
	</c:choose>
           
             </c:forEach>
            
           
            </div>

      </div>
        
 <div class="foot-box">
 	<div class="foot">
    		<p>Copyright&copy; 2009-2014 All rights reserved  增值电信业务经营许可证（B2-20100007）　京ICP备10007936号</p>
            <ul>
            	<li><a href="#"><img src="${pageContext.request.contextPath }/images/foot_img_1.jpg" /></a></li>
                <li><a href="#"><img src="${pageContext.request.contextPath }/images/foot_img_2.jpg" /></a></li>
                <li><a href="#"><img src="${pageContext.request.contextPath }/images/foot_img_3.jpg" /></a></li>
                <li><a href="#"><img src="${pageContext.request.contextPath }/images/foot_img_4.jpg" /></a></li>
            </ul>
    </div>
</div>
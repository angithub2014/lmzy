<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pro-left">
    <div class="pro-show" style="margin-top:0;">
       <ul class="title">
           <li class="left"></li>
           <li class="center"><span class="gonglve">副本攻略</span></li>
           <li class="right"></li>
           <div class="clear"></div>
       </ul>
       <div class="news">
            <h3>${fuBen.title }</h3>
            <p class="writer">${fuBen.createtime }&nbsp;&nbsp;&nbsp;&nbsp;来源：${fuBen.source }&nbsp;&nbsp;&nbsp;&nbsp;责编：${fuBen.author }&nbsp;&nbsp;&nbsp;&nbsp;点击：<span>${fuBen.total }</span></p>
            <p class="text">${fuBen.content }</p>
      </div>
    </div>
</div>
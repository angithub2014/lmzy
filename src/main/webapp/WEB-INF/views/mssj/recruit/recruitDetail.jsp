<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pro-left">
      <div class="pro-show" style="margin-top:0;">
          <ul class="title">
               <li class="left"></li>
               <li class="center"><span class="gonglve">招募信息</span></li>
               <li class="right"></li>
               <div class="clear"></div>
          </ul>
           <div class="news">
            <h3>${recruit.title }</h3>
            <p class="writer">${recruit.createtime }&nbsp;&nbsp;&nbsp;&nbsp;来源：${recruit.source }&nbsp;&nbsp;&nbsp;&nbsp;责编：${recruit.author }&nbsp;&nbsp;&nbsp;&nbsp;点击：<span>${recruit.total }</span></p>
            <p class="text">${recruit.content }</p>
      </div>
      </div>      
</div>
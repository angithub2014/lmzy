<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pro-left">
      <div class="pro-show" style="margin-top:0;">
          <ul class="title">
               <li class="left"></li>
               <li class="center"><span class="gonglve">新闻</span></li>
               <li class="right"></li>
               <div class="clear"></div>
          </ul>
           <div class="news">
            <h3>${news.title }</h3>
            <p class="writer">${news.createtime }&nbsp;&nbsp;&nbsp;&nbsp;来源：${news.source }&nbsp;&nbsp;&nbsp;&nbsp;责编：${news.author }&nbsp;&nbsp;&nbsp;&nbsp;点击：<span>${news.total }</span></p>
            <p class="text">${news.content }</p>
      </div>
      </div>      
</div>
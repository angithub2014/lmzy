<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pro-left">
      <div class="pro-show" style="margin-top:0;">
          <ul class="title">
               <li class="left"></li>
               <li class="center"><span class="gonglve">职业指南</span></li>
               <li class="right"></li>
               <div class="clear"></div>
          </ul>
           <div class="news">
            <h3>${zhiYe.title }</h3>
            <p class="writer">${zhiYe.createtime }&nbsp;&nbsp;&nbsp;&nbsp;来源：${zhiYe.source }&nbsp;&nbsp;&nbsp;&nbsp;责编：${zhiYe.author }&nbsp;&nbsp;&nbsp;&nbsp;点击：<span>${zhiYe.total }</span></p>
            <p class="text">${zhiYe.content }</p>
      </div>
                        
                       
                </div>
                
            
            </div>
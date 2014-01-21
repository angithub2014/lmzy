<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pro-left">
   <div class="pro-show" style="margin-top:0;">
       <ul class="title">
           <li class="left"></li>
           <li class="center"><span class="duiyuan">队员详情</span></li>
           <li class="right"></li>
           <div class="clear"></div>
       </ul>
       <dl class="duiyuan-show clearfix" style="margin-bottom:10px;">
       <dd><img src="${team.headimg}" /></dd>
       <dt>姓名：${team.name}</dt>
       <dt>昵称：${team.nickname}</dt>
       <dt>生日：${team.birthday}</dt>
       <dt>籍贯：${team.nativeplace}</dt>
       <dt>身高：${team.height}CM</dt>
       <dt>体重：${team.weight}公斤</dt>
       <dt>擅长英雄：${team.hero}</dt>
       <dt>擅长地图：${team.map}</dt>
       <dt>曾效力战队：${team.onceteam}</dt>
       <div class="clear"></div>
       </dl>
       <h5 class="duiyuan-ziliao">个人配备</h5>
       <p class="duiyuan-juti">鼠　标：${team.mouse}<br />
                        键　盘：${team.keyboard}<br />
                        耳　机：${team.earphone}</p>
         <h5 class="duiyuan-ziliao">电脑配备</h5>
         <p class="duiyuan-juti">${team.computer}</p>
         <h5 class="duiyuan-ziliao">游戏设定</h5>
         <p class="duiyuan-juti">${team.gameset}</p>
                      
                </div>
                
            
            </div>
function updateNewsState(newsid,state){
	$.ajax({
		type:'post',//可选
		url:'updateNewsState',
		data:'newsid='+newsid+"&state="+state,//多个参数用&连接
		dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
		success:function(msg){
		if(msg!=null&&msg.errorCode=='0'){	
			alert("操作成功!");
			location.reload(); 
		}else{
			alert("操作失败!");
		}
		},
		error:function(){
			alert("网络出现异常!");
		}
	});
}
function deleteNews(newsid){
	$.ajax({
		type:'post',//可选
		url:'deleteNews',
		data:'newsid='+newsid,//多个参数用&连接
		dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
		success:function(msg){
		if(msg!=null&&msg.errorCode=='0'){	
			alert("删除成功!");
			location.reload(); 
		}else{
			alert("删除失败!");
		}
		},
		error:function(){
			alert("网络出现异常!");
		}
	});
}
function updateFuBenHelpState(fbhelpid,state){
	$.ajax({
		type:'post',//可选
		url:'updateFuBenHelpState',
		data:'fbhelpid='+fbhelpid+"&state="+state,//多个参数用&连接
		dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
		success:function(msg){
		if(msg!=null&&msg.errorCode=='0'){	
			alert("操作成功!");
			location.reload(); 
		}else{
			alert("操作失败!");
		}
		},
		error:function(){
			alert("网络出现异常!");
		}
	});
}
function updateZhiYeHelpState(zyhelpid,state){
	$.ajax({
		type:'post',//可选
		url:'updateZhiYeHelpState',
		data:'zyhelpid='+zyhelpid+"&state="+state,//多个参数用&连接
		dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
		success:function(msg){
		if(msg!=null&&msg.errorCode=='0'){	
			alert("操作成功!");
			location.reload(); 
		}else{
			alert("操作失败!");
		}
		},
		error:function(){
			alert("网络出现异常!");
		}
	});
	
}
function updateZhaoMuState(zhaomuid,state){
	$.ajax({
		type:'post',//可选
		url:'updateZhaoMuState',
		data:'zhaomuid='+zhaomuid+"&state="+state,//多个参数用&连接
		dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
		success:function(msg){
		if(msg!=null&&msg.errorCode=='0'){	
			alert("操作成功!");
			location.reload(); 
		}else{
			alert("操作失败!");
		}
		},
		error:function(){
			alert("网络出现异常!");
		}
	});
}
function updateTeamState(teamid,state){
	$.ajax({
		type:'post',//可选
		url:'updateTeamState',
		data:'teamid='+teamid+"&state="+state,//多个参数用&连接
		dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
		success:function(msg){
		if(msg!=null&&msg.errorCode=='0'){	
			alert("操作成功!");
			location.reload(); 
		}else{
			alert("操作失败!");
		}
		},
		error:function(){
			alert("网络出现异常!");
		}
	});
}
function updateShiPinState(spid,state){
	$.ajax({
		type:'post',//可选
		url:'updateShiPinState',
		data:'spid='+spid+"&state="+state,//多个参数用&连接
		dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
		success:function(msg){
		if(msg!=null&&msg.errorCode=='0'){	
			alert("操作成功!");
			location.reload(); 
		}else{
			alert("操作失败!");
		}
		},
		error:function(){
			alert("网络出现异常!");
		}
	});
	
}
function updateDuiYuanState(dyid,state){
	$.ajax({
		type:'post',//可选
		url:'updateDuiYuanState',
		data:'dyid='+dyid+"&state="+state,//多个参数用&连接
		dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
		success:function(msg){
		if(msg!=null&&msg.errorCode=='0'){	
			alert("操作成功!");
			location.reload(); 
		}else{
			alert("操作失败!");
		}
		},
		error:function(){
			alert("网络出现异常!");
		}
	});
	
}

function updateFriendShipState(id,state){
	$.ajax({
		type:'post',//可选
		url:'updateFriendShipState',
		data:'id='+id+"&state="+state,//多个参数用&连接
		dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
		success:function(msg){
		if(msg!=null&&msg.errorCode=='0'){	
			alert("操作成功!");
			location.reload(); 
		}else{
			alert("操作失败!");
		}
		},
		error:function(){
			alert("网络出现异常!");
		}
	});
}

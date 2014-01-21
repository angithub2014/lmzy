//$(function(){
//	$("#fb").mouseover(function(){
//		var gameId = "1";
//		$.ajax({
//			type:'POST',//可选
//			url:'/lmzy/fuBen/selectFuBen',
//			data:'gameId='+gameId,//多个参数用&连接
//			dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
//			success:function(msg){
//	        	  if(msg!=null){
//	        		  var a="<ul class='fb1'>";
//	        		  var a1="";
//	        		  var a2="</ul>";
////	        		  $("span#fb").append("<ul class='fb1'>");
//	        		  for(var i=0;i<msg.length;i++){
//		  	      		var name = msg[i].name;
//		  	      		var fbId = msg[i].id;
//		  	      		a1= a1 +'<li class="fb1"><a href="${pageContext.request.contextPath }/fuBen/selectFuBenList?gameId='+gameId+'&fbId='+fbId+'">'+name+'</a></li>';
////		  	      		$("span#fb").append('<li class="fb1"><a href="${pageContext.request.contextPath }/fuBen/selectFuBenList?gameId='+gameId+'&fbId='+fbId+'">'+name+'</a></li>');
//
//		        	  }
//	        		  $("span#fb").append(a+a1+a2);
//	        	  }
//			},
//			error:function(){
//				alert("请求失败！");
//			//ajax提交失败的处理函数！
//			}
//			});
//		
//		});
//	$("#fb").mouseout(function(){
//		$("ul").remove(".fb1");
//		$("li").remove(".fb1");
//	});
//	$("#zy").mouseover(function(){
//		var gameId = "1";
//		$.ajax({
//			type:'POST',//可选
//			url:'/lmzy/zhiYe/selectZhiYe',
//			data:'gameId='+gameId,//多个参数用&连接
//			dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
//			success:function(msg){
//	        	  if(msg!=null){
//	        		  var a="<ul class='zy1'>";
//	        		  var a1="";
//	        		  var a2="</ul>";
////	        		  $("span#fb").append("<ul class='fb1'>");
//	        		  for(var i=0;i<msg.length;i++){
//		  	      		var name = msg[i].name;
//		  	      		var zyId = msg[i].id;
//		  	      		a1= a1 +'<li class="zy1"><a href="${pageContext.request.contextPath }/fuBen/selectFuBenList?gameId='+gameId+'&zyId='+zyId+'">'+name+'</a></li>';
////		  	      		$("span#fb").append('<li class="fb1"><a href="${pageContext.request.contextPath }/fuBen/selectFuBenList?gameId='+gameId+'&fbId='+fbId+'">'+name+'</a></li>');
//
//		        	  }
//	        		  $("span#zy").append(a+a1+a2);
//	        	  }
//			},
//			error:function(){
//				alert("请求失败！");
//			//ajax提交失败的处理函数！
//			}
//			});
//		
//		});
//	$("#zy").mouseout(function(){
//		$("ul").remove(".zy1");
//		$("li").remove(".zy1");
//	});
//});
$(document).ready(function(){
	$("#navs > li").each(function(num){
		if(num==1){
			$(this).hover(function(){
				var gameId = "1";
				$.ajax({
					type:'POST',//可选
					url:'/lmzy/mssj/fuBen/selectFuBen',
					data:'gameId='+gameId,//多个参数用&连接
					dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
					success:function(msg){
			        	  if(msg!=null){
			        		  var a="<ul class='fb1'>";
			        		  var a1="";
			        		  var a2="</ul>";
//			        		  $("span#fb").append("<ul class='fb1'>");
			        		  for(var i=0;i<msg.length;i++){
				  	      		var name = msg[i].name;
				  	      		var fbId = msg[i].id;
				  	      		a1= a1 +'<li class="fb1"><a href="/lmzy/mssj/fuBen/selectFuBenList?gameId='+gameId+'&fuBenId='+fbId+'">'+name+'</a></li>';
//				  	      		$("span#fb").append('<li class="fb1"><a href="${pageContext.request.contextPath }/fuBen/selectFuBenList?gameId='+gameId+'&fbId='+fbId+'">'+name+'</a></li>');

				        	  }
			        		  $("span#fb").append(a+a1+a2);
			        	  }
					},
					error:function(){
					//ajax提交失败的处理函数！
					}
					});

//				$(this).find("a").eq(0).addClass("c");
//				$(this).find("ul").css("display","block");
				
			
			},function(){
				$("ul").remove(".fb1");
				$("li").remove(".fb1");
//
//				$(this).find("ul").css("display","none");
//				$(this).find("a").eq(0).removeClass("c");
			});

		}else if(num==2){
			$(this).hover(function(){
				var gameId = "1";
				$.ajax({
					type:'POST',//可选
					url:'/lmzy/mssj/zhiYe/selectZhiYe',
					data:'gameId='+gameId,//多个参数用&连接
					dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
					success:function(msg){
			        	  if(msg!=null){
			        		  var a="<ul class='zy1'>";
			        		  var a1="";
			        		  var a2="</ul>";
//			        		  $("span#fb").append("<ul class='fb1'>");
			        		  for(var i=0;i<msg.length;i++){
				  	      		var name = msg[i].name;
				  	      		var zyId = msg[i].id;
				  	      		a1= a1 +'<li class="zy1"><a href="/lmzy/mssj/zhiYe/selectZhiYeList?gameId='+gameId+'&zhiYeId='+zyId+'">'+name+'</a></li>';
//				  	      		$("span#fb").append('<li class="fb1"><a href="${pageContext.request.contextPath }/fuBen/selectFuBenList?gameId='+gameId+'&fbId='+fbId+'">'+name+'</a></li>');

				        	  }
			        		  $("span#zy").append(a+a1+a2);
			        	  }
					},
					error:function(){
					//ajax提交失败的处理函数！
					}
					});

				$(this).find("a").eq(0).addClass("c");
				$(this).find("ul").css("display","block");
				
			
			},function(){
				$("ul").remove(".zy1");
				$("li").remove(".zy1");

//				$(this).find("ul").css("display","none");
//				$(this).find("a").eq(0).removeClass("c");
			});
		}else if(num==3){
			$(this).hover(function(){
				var gameId = "1";
				$.ajax({
					type:'POST',//可选
					url:'/lmzy/mssj/shiPin/selectShiPinType',
					data:'gameId='+gameId,//多个参数用&连接
					dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
					success:function(msg){
			        	  if(msg!=null){
			        		  var a="<ul class='sp1'>";
			        		  var a1="";
			        		  var a2="</ul>";
//			        		  $("span#fb").append("<ul class='fb1'>");
			        		  for(var i=0;i<msg.length;i++){
				  	      		var name = msg[i].name;
				  	      		var sptypeId = msg[i].id;
				  	      		a1= a1 +'<li class="sp1"><a href="/lmzy/mssj/shiPin/selectShiPinList?gameId='+gameId+'&sptypeId='+sptypeId+'">'+name+'</a></li>';
//				  	      		$("span#fb").append('<li class="fb1"><a href="${pageContext.request.contextPath }/fuBen/selectFuBenList?gameId='+gameId+'&fbId='+fbId+'">'+name+'</a></li>');

				        	  }
			        		  $("span#sp").append(a+a1+a2);
			        	  }
					},
					error:function(){
					//ajax提交失败的处理函数！
					}
					});

				$(this).find("a").eq(0).addClass("c");
				$(this).find("ul").css("display","block");
				
			
			},function(){
				$("ul").remove(".sp1");
				$("li").remove(".sp1");

//				$(this).find("ul").css("display","none");
//				$(this).find("a").eq(0).removeClass("c");
			});
		}else if(num==4){
			$(this).hover(function(){
				var gameId = "1";
				$.ajax({
					type:'POST',//可选
					url:'/lmzy/mssj/news/selectNewsType',
					data:'gameId='+gameId,//多个参数用&连接
					dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
					success:function(msg){
			        	  if(msg!=null){
			        		  var a="<ul class='news1'>";
			        		  var a1="";
			        		  var a2="</ul>";
			        		  for(var i=0;i<msg.length;i++){
				  	      		var name = msg[i].name;
				  	      		var newstypeId = msg[i].id;
				  	      		a1= a1 +'<li class="news1"><a href="/lmzy/mssj/news/selectNewsList?gameId='+gameId+'&newstypeid='+newstypeId+'">'+name+'</a></li>';

				        	  }
			        		  $("span#news").append(a+a1+a2);
			        	  }
					},
					error:function(){
					//ajax提交失败的处理函数！
					}
					});

				$(this).find("a").eq(0).addClass("c");
				$(this).find("ul").css("display","block");
				
			
			},function(){
				$("ul").remove(".news1");
				$("li").remove(".news1");
			});
		}
	
	
	});


});


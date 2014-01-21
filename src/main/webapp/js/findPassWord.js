
function LTrim(str){
    var i;
    for(i=0;i<str.length;i++){
        if(str.charAt(i)!=" "&&str.charAt(i)!=" ")break;
    }
    str=str.substring(i,str.length);
    return str;
}
function RTrim(str){
    var i;
    for(i=str.length-1;i>=0;i--)
    {
        if(str.charAt(i)!=" "&&str.charAt(i)!=" ")break;
    }
    str=str.substring(0,i+1);
    return str;
}
function Trim(str){
    return LTrim(RTrim(str));
}
function Length(str) {  
    var len = 0;  
    for (var i=0; i<str.length; i++) {
        if (str.charCodeAt(i)>127 || str.charCodeAt(i)==94) {  
            len += 2;  
        } else {  
            len ++;  
        }  
    }  
    return len;  
}
//增加对号图片
function addRightImages(id,textid){
	$("#"+id).children().remove();
	var node = $("#"+id);
	var img = $(node>'img');
	if(img.length<=0){
		$("#"+id).append("<img src='/lmzy/images/duigou.gif'/>");
		$("#"+textid).text("");
	}
}
//增加X号图片及文字描述
function addWrongImages(valid,id,textid,character){
	$("#"+id).children().remove();
	var node = $("#"+id);
	var img = $(node>'img');
	if(img.length<=0){
		$("#"+id).append("<img  src='/lmzy/images/chahao.gif'/>");
		$("#"+textid).text(character);
		//$("#"+valid).val("");
		//$("#"+valid).focus();
		return false;
	}
}

//验证用户名是否可用
var nameflag=0;
	function checkUserName(){
		var patt=/^(([a-zA-Z0-9_]|[0-9]|[\u4e00-\u9fa5]){2,16})+$/;
		var getusername=$("#username").val();
		if(getusername!=Trim(getusername)){
			addWrongImages('username','usernameImage','usernameTip','用户不支持输入空格，请重新输入！');
			nameflag=0;
			return;
		}
		if(Length(getusername)<4 || Length(getusername)>16){
			addWrongImages('username','usernameImage','usernameTip','用户名长度至少为4个，最多16个字符！');
			nameflag=0;
			return;
		}
		if(patt.test(getusername)==false){
			addWrongImages('username','usernameImage','usernameTip','用户名仅支持4-16位字母、汉字、数字、下划线！');
			nameflag=0;
			return;
		}
		$.ajax({
			type:'post',//可选
			url:'selectUserName',
			data:'userName='+getusername,//多个参数用&连接
			dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
			success:function(msg){
	        	  if(msg!=null&&msg.result!=''){
	        		  addRightImages("usernameImage","usernameTip");
						nameflag=1;
						return;	        	  
				}else{
					
					addWrongImages('username','usernameImage','usernameTip','用户不存在！');
					nameflag=0;
					return;
	        	  }
			},
			error:function(){
				alert("网络出现异常!");
			}
		});
	}


	//验证邮箱
	var emailflag = 1;
	function checkEmail(){
		var email = $("#email").val();
		 var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if(reg.test(email)){
			$.ajax({
				type:'post',//可选
				url:'selectEmail',
				data:'email='+email,//多个参数用&连接
				dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
				success:function(msg){
		        	if(msg!=null&&msg.result!=''){
						addRightImages("emailImage","emailTip");
						emailflag = 1;
						return true;

					}else{
	        		  	addWrongImages('email','emailImage','emailTip','邮箱不存在！');
						nameflag=0;
						return false;	        	  

		        	  }
				},
				error:function(){
					alert("网络出现异常!");
				}
			});
		}
		addWrongImages('email','emailImage','emailTip','邮箱格式错误！');
		emailflag = 0;
		return false;
	}
	function findPassWord(){
		if(!(nameflag==1 && emailflag==1)){		
			alert('您填写的信息没能全部通过验证，请根据错误提示修改后再提交。');
			return ;
		}
		var email = $("#email").val();
		var getusername=$("#username").val();
		$.ajax({
			type:'post',//可选
			url:'selectUserName',
			data:'userName='+getusername,//多个参数用&连接
			dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
			success:function(msg){
	        	if(msg!=null&&msg.result!=''){
	        		if(msg.result.email==email){
	        			return true;
	        		}else{
	        			alert('您填写的用户名或邮箱错误。');
						return false;
	        		}
				}else{
					alert('您填写的用户名或邮箱错误。');
					return false;
	        	  }
			},
			error:function(){
				alert("网络出现异常!");
			}
		});
	}


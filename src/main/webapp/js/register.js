
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
			return false;
		}
		if(Length(getusername)<4 || Length(getusername)>16){
			addWrongImages('username','usernameImage','usernameTip','用户名长度至少为4个，最多16个字符！');
			nameflag=0;
			return false;
		}
		if(patt.test(getusername)==false){
			addWrongImages('username','usernameImage','usernameTip','用户名仅支持4-16位字母、汉字、数字、下划线！');
			nameflag=0;
			return false;
		}
		$.ajax({
			type:'post',//可选
			url:'userInfo/selectUserName',
			data:'userName='+getusername,//多个参数用&连接
			dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
			success:function(msg){
	        	  if(msg!=null&&msg.result!=''){
	        		  	addWrongImages('username','usernameImage','usernameTip','用户名已存在，请更换用户名！');
						nameflag=0;
						return false;	        	  
				}else{
					addRightImages("usernameImage","usernameTip");
					nameflag=1;
					return true;
	        	  }
			},
			error:function(){
				alert("网络出现异常!");
			}
		});
	}

	//验证用户输入的密码
	var passflag=0;
	var realpassflag=0;
	function checkPassWord(){
		var password = $("#password").val();
		if(password!= Trim(password)){
			addWrongImages('password','passwordImage','passwordTip','空格不可做为密码输入！');
			passflag=0;
			realpassflag=0;
			addWrongImages('realPass','realPassImage','realpasswordTip','两次输入密码不相同。');
			return false;
		}
		if(Length(password)<6 || Length(password)>16){
			addWrongImages('password','passwordImage','passwordTip','密码长度必须是6-16个字符！');
			passflag=0;
			realpassflag=0;
			addWrongImages('realPass','realPassImage','realpasswordTip','两次输入密码不相同。');
			return false;
		}
		
		addRightImages("passwordImage","passwordTip");
		passflag=1;
		checkRealPass();
		return true;
		
	}
	
	//验证输入的确认密码
	
	function checkRealPass(){
		var realpasswprd = $("#realPass").val();
		var password = $("#password").val();
		if(realpasswprd!= Trim(realpasswprd)){
			addWrongImages('realPass','realPassImage','realpasswordTip','空格不可做为密码输入！');
			realpassflag=0;
			return false;
		}
		if(realpasswprd !=password){
			addWrongImages('realPass','realPassImage','realpasswordTip','两次输入密码不相同。');
			realpassflag=0;
			return false;
		}
		addRightImages("realPassImage","realpasswordTip");
		realpassflag=1;
		return true;
	}
	//验证邮箱
	var emailflag = 1;
	function checkEmail(){
		var email = $("#email").val();
		 var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if(reg.test(email)){
			$.ajax({
				type:'post',//可选
				url:'userInfo/selectEmail',
				data:'email='+email,//多个参数用&连接
				dataType:'json',//服务器返回的数据类型 可选XML ,Json jsonp script html text等
				success:function(msg){
		        	if(msg!=null&&msg.result!=''){
		        		  	addWrongImages('email','emailImage','emailTip','邮箱已被占用！');
							nameflag=0;
							return false;	        	  
					}else{
						addRightImages("emailImage","emailTip");
						emailflag = 1;
						return true;
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
	function register(){
		if ($("#registerXieyi").attr("checked")!='checked') {
			alert('您没有同意《用户服务协议》！');
			return;
		}
		if(!(nameflag==1 && passflag==1 && realpassflag==1 && emailflag==1)){		
			alert('您填写的注册信息没能全部通过验证，请根据错误提示修改后再提交。');
			return ;
		}
		var checkCode = $("#checkCode").val();
		if(checkCode==""){
			alert("请输入验证码！");
			return ;
		}
		$.ajax({
			url	:'userInfo/validateCheckCode',
			type:'POST',
			data:'checkCode='+checkCode,
			dataType:'json',
			success:function(data){
				if(data!=null&&data.result=='true'){
					var params=$('#userRegisterForm').serialize();
					$.ajax({
						url	: 'userInfo/register',
						type:"POST",
						data:params,
						async:false,
						dataType:'json',
						success:function(data){
							if(data !==null){
								if(data.errorCode=='0'){
									alert("注册成功！");
									location.href =data.url;
									return;
								}else if(data.errorCode=='3'){
									alert("用户名已占用！");
									return;
								}else{
									alert("注册失败！");
									return;
								}						
							}else{
								alert("网络异常！");
								return ;
							}
						},
						error:function(){
							alert("网络出现异常!");
						}
					});

				}else{
					alert("验证码不正确！");
					changeImg();
					return ;
				}
			},
			error:function(){
				alert("网络出现异常!");
			}
		});
	}
//刷新验证码
function changeImg(){  
	 var imgSrc = $("#checkCodeImg");  
	 var src = imgSrc.attr("src");
	 imgSrc.attr("src",chgUrl(src));  
}
//时间戳  
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳  
function chgUrl(url){  
	var timestamp = (new Date()).valueOf();
	if(url.indexOf("?")>=0)
		url = url.substring(0,url.indexOf("?"));
	url = url + "?timestamp=" + timestamp;  
	return url;  
}

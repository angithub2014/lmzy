
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
//
//var oldpassflag=0;
//function checkOldPassWord(){
//	var password = $("#oldpassword").val();
//	if(password!= Trim(password)){
//		addWrongImages('oldpassword','oldpasswordImage','oldpasswordTip','空格不可做为密码输入！');
//		return false;
//	}
//	if(Length(password)<6 || Length(password)>16){
//		addWrongImages('oldpassword','oldpasswordImage','oldpasswordTip','密码长度必须是6-16个字符！');
//		return false;
//	}
//	var userName = $("#username").val();
//	addRightImages("passwordImage","passwordTip");
//	passflag=1;
//	checkRealPass();
//	return true;
//	
//}
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
function resetPassWord(){
	if(!(passflag==1 && realpassflag==1)){		
		alert('您填写的信息没能全部通过验证，请根据错误提示修改后再提交。');
		return ;
	}
	var params=$('#resetPassWordForm').serialize();
	$.ajax({
		url	: 'toResetPassWord',
		type:"POST",
		data:params,
		async:false,
		dataType:'json',
		success:function(data){
			if(data !==null){
				if(data.errorCode=='0'){
					alert("修改成功！");
					location.href =data.url;
					return;
				}else{
					alert("修改失败！");
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
}

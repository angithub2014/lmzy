package com.lmzy.core.controller;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.core.po.UserInfo;
import com.lmzy.core.service.UserInfoService;
import com.lmzy.core.util.CommonUtil;
import com.lmzy.core.util.Mail;
import com.lmzy.core.util.PaySign;
import com.lmzy.core.util.validate.ValidateUtil;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
	@Value("${mailFrom}")
	String mailFrom;
	@Value("${mailHost}")
	String mailHost;
	@Value("${mailUserName}")
	String mailUserName;
	@Value("${mailPassWord}")
	String mailPassWord;
	@Autowired
	UserInfoService userInfoService;
	@RequestMapping("/register")
	@ResponseBody 
	public Map<String, Object> register(
			@RequestParam(value="userName",defaultValue="")String userName,
			@RequestParam(value="passWord",defaultValue="")String passWord,
			@RequestParam(value="email",defaultValue="")String email,
			HttpServletRequest request){
		UserInfo userInfo1 = userInfoService.selectUserInfoByUserName(userName);
		Map<String, Object> map = new HashMap<String, Object>();

		if(userInfo1!=null){
			map.put("errorCode", "3");
			map.put("userInfo", userInfo1);
			map.put("url", "/lmzy/register");
			return map;
		}
		UserInfo userInfo = userInfoService.register(userName, passWord,email);
		System.out.println("userInfo:"+userInfo);
		if(userInfo!=null){
			request.getSession().setAttribute("userInfo", userInfo);
			map.put("errorCode", "0");
			map.put("userInfo", userInfo);
			map.put("url", "/lmzy/registerSuccess");
		}else{
			map.put("errorCode", "1");
			map.put("userInfo", userInfo);
			map.put("url", "/lmzy/register");
		}
		return map;
	}
	@RequestMapping("/login")
	public ModelAndView login(
			@RequestParam(value="userName",defaultValue="")String userName,
			@RequestParam(value="passWord",defaultValue="")String passWord,
			HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		String validateResult = validateLogin(userName, passWord);
		if(!"".equals(validateResult)){
			modelAndView.addObject("userName", userName);
			modelAndView.addObject("passWord", passWord);
			modelAndView.addObject("message", validateResult);
			modelAndView.setViewName("login");
			return modelAndView;
		}
		UserInfo userInfo = userInfoService.selectUserInfoByUserName(userName);
		if(userInfo!=null){
			try {
				if(userInfo!=null&&PaySign.EncoderByMd5(passWord).equals(userInfo.getPassWord())){
					modelAndView.addObject("message", "登录成功！");
					request.getSession().setAttribute("userInfo", userInfo);
					modelAndView.setViewName("index");
					return modelAndView;
				}else{
					modelAndView.addObject("message", "用户名/密码不正确！");
					modelAndView.addObject("userName", userName);
					modelAndView.addObject("passWord", passWord);
					modelAndView.setViewName("login");
					return modelAndView;
				}
			} catch (Exception e) {
				modelAndView.addObject("message", "服务器忙，请稍后再试！");
				modelAndView.setViewName("login");
				return modelAndView;

			}
		}

		return modelAndView;
	}
	@RequestMapping("/loginOut.do")
	public ModelAndView loginOut(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		request.getSession().removeAttribute("userInfo");
		modelAndView.setViewName("login");
		return modelAndView;
	}
	@RequestMapping("/findPassWord")
	public ModelAndView findPassWord(
			@RequestParam(value="userName",defaultValue="")String userName,
			@RequestParam(value="email",defaultValue="")String email,
			HttpServletRequest request) throws UnsupportedEncodingException{
		ModelAndView modelAndView = new ModelAndView();
		String validateResult = validateFindPassWord(userName, email);
		System.out.println("validateResult:"+validateResult);
		if(!"".equals(validateResult)&&validateResult!=null){
			modelAndView.addObject("userName", userName);
			modelAndView.addObject("email", email);
			modelAndView.addObject("message", validateResult);
			modelAndView.setViewName("findPassWord");
			return modelAndView;
		}
		UserInfo userInfo = userInfoService.selectUserInfoByUserName(userName);
		if(userInfo!=null){
			if(email.equals(userInfo.getEmail())){
				 String sid = CommonUtil.getUuid();
//				 String sidUrl = URLEncoder.encode(sid, "UTF-8");
				 System.out.println("sid:"+sid);
				 UserInfo info = userInfoService.updateSidByUserName(userName, sid);
				 if(info!=null){
					 StringBuffer sb = new StringBuffer();
					 sb.append("亲爱的用户 "+userName+"：您好！<br><br>");  
			         sb.append("您收到这封这封电子邮件是因为您 (也可能是某人冒充您的名义) 申请了一个新的密码。假如这不是您本人所申请, 请不用理会<br>这封电子邮件, 但是如果您持续收到这类的信件骚扰, 请您尽快联络管理员。<br><br>");  
			         sb.append("要使用新的密码, 请使用以下链接启用密码。<br><br>");  
			         sb.append("<a href='http://192.168.0.215:8080/lmzy/userInfo/resetPassWord?userName="+userName+"&sid="+sid+"'>http://192.168.0.215:8080/lmzy/userInfo/resetPassWord?userName="+userName+"&sid="+sid+"</a>");  
			         sb.append("<br><br><br>为了确保您的帐号安全，该链接仅7天内访问有效。<br>");  
			         sb.append("如果该链接已经失效，请您点击下面链接来重新获取修改密码的邮件:<br>");  
			         sb.append("<a href='http://192.168.0.215:8080/lmzy/userInfo/findPassWord'>http://192.168.0.215:8080/lmzy/userInfo/findPassWord</a><br>");  
			         sb.append("<br><br><br>如果点击链接不工作...<br><br>");  
			         sb.append("请您选择并复制整个链接，打开浏览器窗口并将其粘贴到地址栏中。然后单击'转到'按钮或按键盘上的 Enter 键。<br>");  
			         sb.append("<a style='color:red'>请勿直接回复该邮件</a>，有关<a href='http://192.168.0.215:8080/lmzy'>黎明之翼 </a> 的更多信息，请访问：http://192.168.0.215:8080/lmzy<br>");  
			         sb.append("<br><br>我们将一如既往、热忱的为您服务！");  
			         sb.append("<br><br>               黎明之翼<br><br> ");  
			         /** strm[1]第一个跟第二个@间内容,strm[strm.length - 1]最后一@内容 */  
			         String strm[] = email.split("@");  
			         // 创建邮件  
			         Mail mail = new Mail();  
			         mail.setTo(email);  
			         mail.setFrom(mailFrom);// 你的邮箱  
			         mail.setHost(mailHost);  
			         mail.setUsername(mailUserName);// 用户  
			         mail.setPassword(mailPassWord);// 密码  
			         mail.setSubject(MimeUtility.encodeText("黎明之翼找回您的账户密码", "UTF-8", "B"));
			         mail.setContent(sb.toString());  
			         if (mail.sendMail()) {
			        	 System.out.println("成功！");
			            modelAndView.addObject("message", "您的申请已提交成功，请查看您的******" + strm[strm.length - 1]+ "邮箱。");
			         } else {
			        	 System.out.println("失败！");
			            modelAndView.addObject("message", "操作失败，轻稍后重新尝试！");
			         }
			         modelAndView.setViewName("findPassWordResult");
					 return modelAndView;

				 }else{
			         modelAndView.addObject("message", "操作失败，轻稍后重新尝试！");
					 modelAndView.setViewName("findPassWordResult");
					 return modelAndView;
				 }
			}else{
				modelAndView.addObject("message", "邮箱不正确！");
				modelAndView.addObject("userName", userName);
				modelAndView.addObject("email", email);
				modelAndView.setViewName("findPassWord");
				return modelAndView;
			}
		}else{
			modelAndView.addObject("message", "用户不存在！");
			modelAndView.addObject("userName", userName);
			modelAndView.addObject("email", email);
			modelAndView.setViewName("findPassWord");
			return modelAndView;
		}
	}
	@RequestMapping("/resetPassWord")
	public ModelAndView resetPassWord(
			@RequestParam(value="userName",defaultValue="")String userName,
			@RequestParam(value="sid",defaultValue="")String sid,
			HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("userName:"+userName+",sid="+sid);
		UserInfo userInfo = userInfoService.selectUserInfoByUserName(userName);
		String usid = userInfo.getSid();
		if(sid.equals(usid)){
			String modifyTime = userInfo.getModifyTime();
			Date date = new Date();
			long dateLong = date.getTime();
			long time = 1000*60*60*24*7;
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date date2 = df.parse(modifyTime);
				long date2Long = date2.getTime();
				if(dateLong-date2Long>time){
					modelAndView.addObject("message", "该链接已失效！");
					modelAndView.setViewName("findPassWordResult");
					return modelAndView;
				}else{
					modelAndView.addObject("userName", userName);
					modelAndView.setViewName("resetPassWord");
					return modelAndView;
				}
			} catch (ParseException e) {
				modelAndView.addObject("message", "网络异常！");
				modelAndView.setViewName("findPassWordResult");
				return modelAndView;
			}
		}else{
			modelAndView.addObject("message", "该链接已失效！");
			modelAndView.setViewName("findPassWordResult");
			return modelAndView;
		}
	}
	@RequestMapping("/toResetPassWord")
	@ResponseBody 
	public Map<String, Object> toResetPassWord(
			@RequestParam(value="userName",defaultValue="")String userName,
			@RequestParam(value="passWord",defaultValue="")String passWord,
			HttpServletRequest request){
		System.out.println("userName:"+userName+",passWord:"+passWord);
		UserInfo userInfo = userInfoService.updatePassWordByUserName(userName, passWord);
		System.out.println("userInfo:"+userInfo);
		Map<String, Object> map = new HashMap<String, Object>();
		if(userInfo!=null){
			request.getSession().setAttribute("userInfo", userInfo);
			map.put("errorCode", "0");
			map.put("userInfo", userInfo);
			map.put("url", "/lmzy/login");
		}else{
			map.put("errorCode", "1");
			map.put("userName", userName);
			map.put("userInfo", userInfo);
			map.put("url", "/lmzy/login");
		}
		return map;
	}
	@RequestMapping("/modifyPassWordIndex.do")
	public ModelAndView modifyPassWordIndex(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		UserInfo userInfo= (UserInfo)request.getSession().getAttribute("userInfo");
		String userName = userInfo.getUserName();
		modelAndView.addObject("userName", userName);
		modelAndView.setViewName("modifyPassWord");
		return modelAndView;
	}
	@RequestMapping(value="/modifyPassWord",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> modifyPassWord(
			@RequestParam(value="passWord",defaultValue="")String passWord,
			HttpServletRequest request){
		System.out.println("passWord:"+passWord);
		UserInfo userInfos= (UserInfo)request.getSession().getAttribute("userInfo");
		String userName = userInfos.getUserName();
		UserInfo userInfo = userInfoService.updatePassWordByUserName(userName, passWord);
		System.out.println("userInfo:"+userInfo);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(userInfo!=null&&PaySign.EncoderByMd5(passWord).equals(userInfo.getPassWord())){
				request.getSession().setAttribute("userInfo", userInfo);
				map.put("errorCode", "0");
				map.put("userInfo", userInfo);
				map.put("url", "/lmzy/login");
			}else{
				map.put("errorCode", "1");
				map.put("userName", userName);
				map.put("userInfo", userInfo);
				map.put("url", "/lmzy/modifyPassWordIndex.do");
			}
		} catch (NoSuchAlgorithmException e) {
			map.put("errorCode", "1");
			map.put("userName", userName);
			map.put("userInfo", userInfo);
			map.put("url", "/lmzy/modifyPassWordIndex.do");
		} catch (UnsupportedEncodingException e) {
			map.put("errorCode", "1");
			map.put("userName", userName);
			map.put("userInfo", userInfo);
			map.put("url", "/lmzy/modifyPassWordIndex.do");
		}
		return map;
	}
	@RequestMapping(value = "/selectUserName", method = RequestMethod.POST)  
	@ResponseBody 
	public Map<String,Object> selectUserName(
			@RequestParam(value="userName",defaultValue="") String userName){
		 System.out.println("userName:"+userName);
		 Map<String, Object> map = new HashMap<String, Object>(1);
		 UserInfo userInfo = userInfoService.selectUserInfoByUserName(userName);
		 System.out.println("userInfo:"+userInfo);
		 if(userInfo!=null)
			 map.put("result", userInfo);
		 else
			 map.put("result", "");
		 return map;
	}
	@RequestMapping(value = "/selectEmail", method = RequestMethod.POST)  
	@ResponseBody 
	public Map<String,Object> selectEmail(
			@RequestParam(value="email",defaultValue="") String email){
		System.out.println("email:"+email);
		 Map<String, Object> map = new HashMap<String, Object>(1);
		 UserInfo userInfo = userInfoService.selectUserInfoByEmail(email);
		 System.out.println("userInfo:"+userInfo);
		 if(userInfo!=null)
			 map.put("result", userInfo);
		 else
			 map.put("result", "");
		 return map;
	}
	@RequestMapping(value="/selectPassWord", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> selectPassWord(
			@RequestParam(value="userName",defaultValue="")String userName,
			@RequestParam(value="passWord",defaultValue="")String passWord,
			HttpServletRequest request){
		UserInfo userInfo = userInfoService.selectUserInfoByUserName(userName);
		 Map<String, Object> map = new HashMap<String, Object>();
		if(userInfo!=null){
			try {
				if(userInfo!=null&&PaySign.EncoderByMd5(passWord).equals(userInfo.getPassWord())){
					map.put("errorCode", "0");
				}else{
					map.put("errorCode", "1");
				}
			} catch (Exception e) {
				map.put("errorCode", "1");
			}
		}

		return map;
	}
	@RequestMapping(value = "/validateCheckCode", method = RequestMethod.POST)  
	@ResponseBody 
	public Map<String, String> validateCheckCode(@RequestParam(value="checkCode",defaultValue="") String checkCode,
			HttpServletRequest request){
		System.out.println("checkCode="+checkCode);
		 Map<String, String> map = new HashMap<String, String>(1);
		String validateCheckCode = (String) request.getSession().getAttribute("validateCode");
		System.out.println("validateCheckCode="+validateCheckCode);
		if(checkCode.equals(validateCheckCode)){
			map.put("result", "true");
			return map;
		}else{
			map.put("result", "false");
			return map;
		}
	}
	public String validateLogin(String userName,String passWord){
		if(ValidateUtil.validateIsNull(userName))
			return "用户名不能为空！";
		if(ValidateUtil.validateIsNull(passWord))
			return "密码不能为空！";
		return "";
	}
	public String validateFindPassWord(String userName,String email){
		if(ValidateUtil.validateIsNull(userName))
			return "用户名不能为空！";
		if(ValidateUtil.validateIsNull(email))
			return "邮箱不能为空！";
		return "";
	}
	public static void main(String[] args) {
		//lueSGJZetyySpUndWjMBEg==
		try {//4f208e87dbf1f6ded475ec7a7c8dea87
			String s = new String("administrator".getBytes("ISO-8859-1"), "utf-8");
			System.out.println(PaySign.EncoderByMd5("lueSGJZetyySpUndWjMBEg=="));
			System.out.println(CommonUtil.MD5_SHA(CommonUtil.MD5_SHA(s)));
//			System.out.println(Base32.decode(Base32.decode("administrator1")));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

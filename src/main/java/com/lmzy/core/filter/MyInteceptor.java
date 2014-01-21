package com.lmzy.core.filter;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.admin.po.Admin;
import com.lmzy.core.po.UserInfo;
import com.lmzy.core.util.ModelAndViewUtil;

public class MyInteceptor implements HandlerInterceptor {
	Logger logger = Logger.getLogger(MyInteceptor.class);
	@Autowired
	ModelAndViewUtil modelAndViewUtil;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
//		HttpResponse httpResponse = HttpRes
		String uri = request.getRequestURI();
		logger.info("MyInteceptor/preHandle拦截器uri："+uri);
		if(uri.indexOf(".do")>-1){
			if(uri.indexOf("lmzy/admin")==-1){
				UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
				if(userInfo==null){
					request.getRequestDispatcher("/login").forward(request, response); 
					return false;
				}
			}else{
				Admin admin = (Admin) request.getSession().getAttribute("admin");
				if(admin==null){
					request.getRequestDispatcher("/admin/login").forward(request, response); 
					return false;
				}

			}

		}
//		if(uri.indexOf("loginOut")==-1&&uri.indexOf("login")==-1&&uri.indexOf(".do")==-1&&uri.indexOf("messageCenter/leaveMessage")==-1&&uri.indexOf("userInfo/registerIndex")==-1){
//			String parameters = "";
//			Map parameterMap = request.getParameterMap();
//			  Set key = parameterMap.keySet();
//			  int i=1;
//			  String parakey="";
//			  String paravalue ="";
//			  for(Object aaa: key.toArray()){
//		         parakey = aaa.toString();
//		         String [] str = ((String[])parameterMap.get(aaa));
//		         paravalue = ((String[])parameterMap.get(aaa))[0];
//		         String para = "";
//		         if(str.length>1){
//		        	 for(int m=0;m<str.length;m++){
//		        		 if(m==0){
//		        			 para+=parakey+"="+str[m];
//		        		 }else{
//		        			 para+="&"+parakey+"="+str[m];
//		        		 }
//		        		
//		        	 }
//		        	 
//		         }else{
//		        	 para = parakey+"="+paravalue;
//		         }
//		         if(i==1){
//		            parameters += para; 
//		         }else{
//		            parameters += "&"+para; 
//		         }
//		         i++;
//		       }
//			  logger.info("loginOutUrl:"+ uri+(parameters==null||"".equals(parameters) ? "":"?"+parameters));
//			  request.getSession().setAttribute("loginOutUrl", uri+(parameters==null||"".equals(parameters) ? "":"?"+parameters));
//		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
		String userName = "";
		if(userInfo!=null){
			userName = userInfo.getUserName();
		}
		if(modelAndView!=null){
			modelAndView.addObject("viewTopUserName", userName);
		}
		modelAndViewUtil.getPublicModelAndView(modelAndView, 1);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}

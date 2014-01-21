package com.lmzy.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.admin.po.Admin;
import com.lmzy.core.po.UserInfo;

@Controller
@RequestMapping("/admin")
public class AdminIndexController {
	@RequestMapping("/adminIndex")
	public ModelAndView index(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if(admin!=null){
			modelAndView.addObject("admin", admin);
			modelAndView.setViewName("admin/adminIndex");
		}else{
			modelAndView.setViewName("admin/login");
		} 
		return modelAndView;
	}
	@RequestMapping("/totest")
	public ModelAndView totest(
			@RequestParam(value="content",defaultValue="")String content){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("content:"+content);
		modelAndView.addObject("content", content);
		modelAndView.setViewName("admin/testresult");
		return modelAndView;
	}
}

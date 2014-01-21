package com.lmzy.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mssj")
public class MssjPublicController {
	@RequestMapping("/aboutUs")
	public ModelAndView aboutUs(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("selectType", "us");
		modelAndView.setViewName("mssj/aboutUs");
		return modelAndView;
	}
	@RequestMapping("/weiBo")
	public ModelAndView weiBo(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("selectType", "wb");
		modelAndView.setViewName("mssj/weibo");
		return modelAndView;
	}
	@RequestMapping("/shiPin")
	public ModelAndView shiPin(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("selectType", "sp");
		modelAndView.setViewName("mssj/shiPin");
		return modelAndView;
	}
}

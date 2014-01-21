package com.lmzy.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.admin.po.Admin;
import com.lmzy.admin.service.AdminService;
import com.lmzy.core.util.PaySign;
import com.lmzy.core.util.validate.ValidateUtil;
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
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
			System.out.println("验证错误！");
			modelAndView.setViewName("admin/login");
			return modelAndView;
		}
		Admin admin = adminService.selectAdminByUserName(userName);
		if(admin!=null){
			try {
				if("T".equals(admin.getManageflag())){
					if(PaySign.EncoderByMd5(passWord).equals(admin.getPassWord())){
						modelAndView.addObject("message", "登录成功！");
						request.getSession().setAttribute("admin", admin);
						System.out.println("登录成功！");
						modelAndView.setViewName("admin/adminIndex");
						return modelAndView;
					}else{
						modelAndView.addObject("message", "用户名/密码不正确！");
						System.out.println("密码错误！");
						modelAndView.addObject("userName", userName);
						modelAndView.addObject("passWord", passWord);
						modelAndView.setViewName("admin/login");
						return modelAndView;
					}

				}else{
					modelAndView.addObject("message", "对不起，你没有权限！");
					modelAndView.addObject("userName", userName);
					modelAndView.addObject("passWord", passWord);
					modelAndView.setViewName("admin/login");
					return modelAndView;

				}
			} catch (Exception e) {
				modelAndView.addObject("message", "服务器忙，请稍后再试！");
				modelAndView.setViewName("admin/login");
				return modelAndView;

			}
		}
		modelAndView.addObject("message", "用户名/密码不正确！");
		modelAndView.addObject("userName", userName);
		modelAndView.addObject("passWord", passWord);
		modelAndView.setViewName("admin/login");
		return modelAndView;
	}
	public String validateLogin(String userName,String passWord){
		if(ValidateUtil.validateIsNull(userName))
			return "用户名不能为空！";
		if(ValidateUtil.validateIsNull(passWord))
			return "密码不能为空！";
		return "";
	}
	@RequestMapping("/loginOut.do")
	public ModelAndView loginOut(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		request.getSession().removeAttribute("admin");
		modelAndView.setViewName("admin/login");
		return modelAndView;
	}
}

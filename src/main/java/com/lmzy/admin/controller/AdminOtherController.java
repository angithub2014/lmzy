package com.lmzy.admin.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.admin.po.AdminVideo;
import com.lmzy.admin.service.AdminOtherService;
import com.lmzy.core.util.DateUtil;
import com.lmzy.core.util.FileUpload;

@Controller
@RequestMapping("/admin/other")
public class AdminOtherController {
	@Autowired
	AdminOtherService adminOtherService;
	@Autowired
	FileUpload fileUpload;
	@Value("${uploadUrl}")
	String uploadUrl;
	@Value("${uploadUrlBeiFen}")
	String uploadUrlBeiFen;
	@RequestMapping("/selectFriendShipList.do")
	public ModelAndView selectFriendShipList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="state",defaultValue="2") int state,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage,
			@RequestParam(value="startTime",defaultValue="") String startTime,
			@RequestParam(value="endTime",defaultValue="1") String endTime){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 10;
		List<Map<String, Object>> list = adminOtherService.selectFriendShipList(gameId,state, "","",(nowPage-1)*maxLine, maxLine,"desc");
		int count = adminOtherService.selectFriendShipCount(gameId,state);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("friendShipList", list);
		modelAndView.addObject("state", state);
		modelAndView.addObject("gameId", gameId);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "fs");
		modelAndView.setViewName("admin/friendShip");
		return modelAndView;
	}
	@RequestMapping("/toInsertFriendShip.do")
	public ModelAndView toInsertFriendShip(){
		ModelAndView modelAndView  = new ModelAndView();
		modelAndView.addObject("selectType", "fs");
		modelAndView.setViewName("admin/addFriendShip");
		return modelAndView;
	}
	@RequestMapping("/insertFriendShip.do")
	public ModelAndView insertFriendShip(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="name",defaultValue="") String name,
			@RequestParam(value="url",defaultValue="") String url,
			@RequestParam(value="file",defaultValue="") MultipartFile file,

			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 if(file.isEmpty()){ 
				int count = adminOtherService.insertFriendShip(gameId,0,name,"",url,DateUtil.getDataFormatForDateTime(new Date(), ""));
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "添加成功");
				}else{
					modelAndView.addObject("message", "添加失败");
				}
				modelAndView.addObject("selectType", "fs");
				modelAndView.setViewName("admin/addFriendShipResult");
				return modelAndView;
         }else{ 
             System.out.println("文件长度: " + file.getSize()); 
             System.out.println("文件类型: " + file.getContentType()); 
             System.out.println("文件名称: " + file.getName()); 
             System.out.println("文件原名: " + file.getOriginalFilename()); 
             System.out.println("========================================"); 
             //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中 
             String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload"); 
             //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的 
             try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadUrl, file.getOriginalFilename()));
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadUrlBeiFen, file.getOriginalFilename()));
	
				int count = adminOtherService.insertFriendShip(gameId,0,name,"/lmzy/upLoadImg/"+file.getOriginalFilename(),url,DateUtil.getDataFormatForDateTime(new Date(), ""));
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "添加成功");
				}else{
					modelAndView.addObject("message", "添加失败");
				}
				modelAndView.addObject("selectType", "fs");
				modelAndView.setViewName("admin/addFriendShipResult");
				return modelAndView;
			} catch (IOException e) {
				modelAndView.addObject("message", "上传图片异常！");
				modelAndView.addObject("selectType", "fs");
				modelAndView.setViewName("admin/addFriendShipResult");
				return modelAndView;
			} 
         } 
		
		
		
		

	}
	@RequestMapping("/updateFriendShip.do")
	public ModelAndView updateFriendShip(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="id",defaultValue="") int id,
			@RequestParam(value="name",defaultValue="") String name,
			@RequestParam(value="url",defaultValue="") String url,
			@RequestParam(value="file",defaultValue="") MultipartFile file,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 if(file.isEmpty()){ 
				int count = adminOtherService.updateFriendShip(id,name,"",url);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "修改成功");
				}else{
					modelAndView.addObject("message", "修改失败");
				}
				modelAndView.addObject("selectType", "fs");
				modelAndView.setViewName("admin/addFriendShipResult");
				return modelAndView;
         }else{ 
             System.out.println("文件长度: " + file.getSize()); 
             System.out.println("文件类型: " + file.getContentType()); 
             System.out.println("文件名称: " + file.getName()); 
             System.out.println("文件原名: " + file.getOriginalFilename()); 
             System.out.println("========================================"); 
             //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中 
             String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload"); 
             //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的 
             try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadUrl, file.getOriginalFilename()));
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadUrlBeiFen, file.getOriginalFilename()));
	
				int count = adminOtherService.updateFriendShip(id,name,"/lmzy/upLoadImg/"+file.getOriginalFilename(),url);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "修改成功");
				}else{
					modelAndView.addObject("message", "修改失败");
				}
				modelAndView.addObject("selectType", "fs");
				modelAndView.setViewName("admin/addFriendShipResult");
				return modelAndView;
			} catch (IOException e) {
				modelAndView.addObject("message", "上传图片异常！");
				modelAndView.addObject("selectType", "fs");
				modelAndView.setViewName("admin/addFriendShipResult");
				return modelAndView;
			} 
         } 
	

	}
	@RequestMapping("/selectFriendShip.do")
	public ModelAndView selectFriendShip(
			@RequestParam(value="id",defaultValue="") int id){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminOtherService.selectFriendShip(id);
		modelAndView.addObject("selectFriendShip", map);
		modelAndView.addObject("selectType", "fs");
		modelAndView.setViewName("admin/friendShipContent");
		return modelAndView;
	}
	@RequestMapping("/updateFriendShipState")
	@ResponseBody 
	public Map<String, Object> updateFriendShipState(
			@RequestParam(value="id",defaultValue="") int id,
			@RequestParam(value="state",defaultValue="") int state){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = adminOtherService.updateFriendShipState(id, state);
		System.out.println("count:"+count);
		if(count>0){
			map.put("errorCode", "0");

		}else{
			map.put("errorCode", "1");
		}
		return map;
	}
	@RequestMapping("/selectAboutUs.do")
	public ModelAndView selectAboutUs(){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminOtherService.selectAboutUs();
		modelAndView.addObject("aboutUs", map);
		modelAndView.addObject("selectType", "as");
		modelAndView.setViewName("admin/aboutUs");
		return modelAndView;
	}
	@RequestMapping("/toAboutUs.do")
	public ModelAndView toAboutUs(
			@RequestParam(value="gameid",defaultValue="") int gameid,
			@RequestParam(value="title",defaultValue="") String title,
			@RequestParam(value="content",defaultValue="") String content,
			@RequestParam(value="name",defaultValue="") String name,
			@RequestParam(value="email",defaultValue="") String email,
			@RequestParam(value="mobile",defaultValue="") String mobile,
			@RequestParam(value="id",defaultValue="") int id,
			@RequestParam(value="submitType",defaultValue="") String submitType,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		if("添加".equals(submitType))
			return insertAboutUs(gameid, title, content, name, email, mobile, request, response);
		else if("修改".equals(submitType))
			return updateAboutUs(gameid, id, title, content, name, email, mobile, request, response);
		return modelAndView;

	}

	@RequestMapping("/updateAboutUs.do")
	public ModelAndView updateAboutUs(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="id",defaultValue="") int id,
			@RequestParam(value="title",defaultValue="") String title,
			@RequestParam(value="content",defaultValue="") String content,
			@RequestParam(value="name",defaultValue="") String name,
			@RequestParam(value="email",defaultValue="") String email,
			@RequestParam(value="mobile",defaultValue="") String mobile,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		int count = adminOtherService.updateAboutUs(id, title, content, name, email, mobile);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "修改成功");
		}else{
			modelAndView.addObject("message", "修改失败");
		}
		modelAndView.addObject("selectType", "fs");
		modelAndView.setViewName("admin/addAboutUsResult");
		return modelAndView;

	}
	
	@RequestMapping("/insertAboutUs.do")
	public ModelAndView insertAboutUs(
			@RequestParam(value="gameid",defaultValue="") int gameid,
			@RequestParam(value="title",defaultValue="") String title,
			@RequestParam(value="content",defaultValue="") String content,
			@RequestParam(value="name",defaultValue="") String name,
			@RequestParam(value="email",defaultValue="") String email,
			@RequestParam(value="mobile",defaultValue="") String mobile,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		int count = adminOtherService.insertAboutUs(gameid, title, content, name, email, mobile, DateUtil.getDataFormatForDateTime(new Date(), ""));
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "添加成功");
		}else{
			modelAndView.addObject("message", "添加失败");
		}
		modelAndView.addObject("selectType", "fs");
		modelAndView.setViewName("admin/addAboutUsResult");
		return modelAndView;

	}
}

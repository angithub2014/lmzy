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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.admin.po.AdminRecruit;
import com.lmzy.admin.service.AdminZhaoMuService;
import com.lmzy.core.util.DateUtil;
import com.lmzy.core.util.FileUpload;
@Controller
@RequestMapping("/admin/zhaoMu")
public class AdmiZhaoMuController {
	@Autowired
	AdminZhaoMuService adminZhaoMuService;
	@Autowired
	FileUpload fileUpload;
	@Value("${uploadUrl}")
	String uploadUrl;
	@Value("${uploadUrlBeiFen}")
	String uploadUrlBeiFen;
	@RequestMapping("/selectZhaoMuList.do")
	public ModelAndView selectZhaoMuList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="state",defaultValue="2") int state,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage,
			@RequestParam(value="startTime",defaultValue="") String startTime,
			@RequestParam(value="endTime",defaultValue="1") String endTime){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 10;
		List<Map<String, Object>> list = adminZhaoMuService.selectZhaoMuList(gameId,state, "","",(nowPage-1)*maxLine, maxLine,"desc");
		int count = adminZhaoMuService.selectZhaoMuCount(gameId,state);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("zhaoMuList", list);
		modelAndView.addObject("state", state);
		modelAndView.addObject("gameId", gameId);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "zm");
		modelAndView.setViewName("admin/zhaoMu");
		return modelAndView;
	}
	@RequestMapping("/insertZhaoMu.do")
	public ModelAndView insertZhaoMu(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="title",defaultValue="") String title,
			@RequestParam(value="source",defaultValue="") String source,
			@RequestParam(value="author",defaultValue="") String author,
			@RequestParam(value="file",defaultValue="") MultipartFile file,
			@RequestParam(value="content",defaultValue="") String content,
			@RequestParam(value="state",defaultValue="0") int state,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 if(file.isEmpty()){ 
			 AdminRecruit adminZhaoMu = new AdminRecruit();
				adminZhaoMu.setTitle(title);
				adminZhaoMu.setAuthor(author);
				adminZhaoMu.setGameid(gameId);
				adminZhaoMu.setSource(source);
				adminZhaoMu.setState(state);
				adminZhaoMu.setContent(content);
				adminZhaoMu.setCreatetime(DateUtil.getDataFormatForDateTime(new Date(), ""));
//				adminZhaoMu.setImgurl("");
				int count = adminZhaoMuService.insertZhaoMu(adminZhaoMu);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "添加成功");
				}else{
					modelAndView.addObject("message", "添加失败");
				}
				 modelAndView.setViewName("admin/addZhaoMuResult");
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
				AdminRecruit adminZhaoMu = new AdminRecruit();
				adminZhaoMu.setTitle(title);
				adminZhaoMu.setAuthor(author);
				adminZhaoMu.setGameid(gameId);
				adminZhaoMu.setSource(source);
				adminZhaoMu.setState(state);
				adminZhaoMu.setContent(content);
				adminZhaoMu.setCreatetime(DateUtil.getDataFormatForDateTime(new Date(), ""));
				adminZhaoMu.setImgurl("/lmzy/upLoadImg/"+file.getOriginalFilename());
				int count = adminZhaoMuService.insertZhaoMu(adminZhaoMu);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "添加成功");
				}else{
					modelAndView.addObject("message", "添加失败");
				}
				modelAndView.addObject("selectType", "zm");
				modelAndView.setViewName("admin/addZhaoMuResult");
				return modelAndView;
			} catch (IOException e) {
				modelAndView.addObject("message", "上传图片异常！");
				modelAndView.addObject("selectType", "zm");
				modelAndView.setViewName("admin/addZhaoMuResult");
				return modelAndView;
			} 
         } 

	}
	
	@RequestMapping("/updateZhaoMuState")
	@ResponseBody 
	public Map<String, Object> updateZhaoMuState(
			@RequestParam(value="zhaomuid",defaultValue="") int zhaomuid,
			@RequestParam(value="state",defaultValue="") int state){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = adminZhaoMuService.updateZhaoMuState(zhaomuid, state);
		System.out.println("count:"+count);
		if(count>0){
			map.put("errorCode", "0");

		}else{
			map.put("errorCode", "1");
		}
		return map;
	}
	@RequestMapping("/selectZhaoMu.do")
	public ModelAndView selectZhaoMu(
			@RequestParam(value="zhaomuid",defaultValue="") int zhaomuid){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminZhaoMuService.selectZhaoMuContent(zhaomuid);
		modelAndView.addObject("adminZhaoMu", map);
		modelAndView.addObject("selectType", "zm");
		modelAndView.setViewName("admin/zhaoMuContent");
		return modelAndView;
	}
	@RequestMapping(value="/updateZhaoMu.do", method=RequestMethod.POST)
	public ModelAndView updateZhaoMu(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="zhaomuid",defaultValue="") int zhaomuid,
			@RequestParam(value="title",defaultValue="") String title,
			@RequestParam(value="source",defaultValue="") String source,
			@RequestParam(value="author",defaultValue="") String author,
			@RequestParam(value="file",defaultValue="") MultipartFile file,
			@RequestParam(value="content",defaultValue="") String content,
			@RequestParam(value="state",defaultValue="0") int state,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 if(file.isEmpty()){ 
			 AdminRecruit adminZhaoMu = new AdminRecruit();
				adminZhaoMu.setId(zhaomuid);
				adminZhaoMu.setTitle(title);
				adminZhaoMu.setAuthor(author);
				adminZhaoMu.setGameid(gameId);
				adminZhaoMu.setSource(source);
				adminZhaoMu.setState(state);
				adminZhaoMu.setContent(content);
				adminZhaoMu.setCreatetime(DateUtil.getDataFormatForDateTime(new Date(), ""));
//				adminZhaoMu.setImgurl("");
				int count = adminZhaoMuService.updateZhaoMu(adminZhaoMu);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "修改成功");
				}else{
					modelAndView.addObject("message", "修改失败");
				}
				modelAndView.addObject("selectType", "zm");
				 modelAndView.setViewName("admin/addZhaoMuResult");
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
				AdminRecruit adminZhaoMu = new AdminRecruit();
				adminZhaoMu.setId(zhaomuid);
				adminZhaoMu.setTitle(title);
				adminZhaoMu.setAuthor(author);
				adminZhaoMu.setGameid(gameId);
				adminZhaoMu.setSource(source);
				adminZhaoMu.setState(state);
				adminZhaoMu.setContent(content);
				adminZhaoMu.setCreatetime(DateUtil.getDataFormatForDateTime(new Date(), ""));
				adminZhaoMu.setImgurl("/lmzy/upLoadImg/"+file.getOriginalFilename());
				int count = adminZhaoMuService.updateZhaoMu(adminZhaoMu);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "修改成功");
				}else{
					modelAndView.addObject("message", "修改失败");
				}
				modelAndView.addObject("selectType", "zm");
				modelAndView.setViewName("admin/addZhaoMuResult");
				return modelAndView;
			} catch (IOException e) {
				modelAndView.addObject("message", "上传图片异常！");
				modelAndView.addObject("selectType", "zm");
				modelAndView.setViewName("admin/addZhaoMuResult");
				return modelAndView;
			} 
         } 

	}
}

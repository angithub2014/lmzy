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

import com.lmzy.admin.po.AdminNews;
import com.lmzy.admin.po.AdminOccupationGuide;
import com.lmzy.admin.po.AdminVideo;
import com.lmzy.admin.service.AdminShiPinService;
import com.lmzy.admin.service.AdminZhiYeService;
import com.lmzy.core.util.DateUtil;
import com.lmzy.core.util.FileUpload;

@Controller
@RequestMapping("/admin/shiPin")
public class AdminShiPinController {
	@Autowired
	AdminShiPinService adminShiPinService;
	@Autowired
	FileUpload fileUpload;
	@Value("${uploadUrl}")
	String uploadUrl;
	@Value("${uploadUrlBeiFen}")
	String uploadUrlBeiFen;
	@RequestMapping("/selectShiPinList.do")
	public ModelAndView selectShiPinList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="sptypeid",defaultValue="0") int sptypeid,
			@RequestParam(value="state",defaultValue="2") int state,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage,
			@RequestParam(value="startTime",defaultValue="") String startTime,
			@RequestParam(value="endTime",defaultValue="1") String endTime){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 10;
		List<Map<String, Object>> list = adminShiPinService.selectShiPinList(gameId,sptypeid,state, "","",(nowPage-1)*maxLine, maxLine,"desc");
		int count = adminShiPinService.selectShiPinCount(gameId, sptypeid, state);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		for(int i=0;i<list.size();i++){
			Map<String, Object> map = list.get(i);
			int zd = (Integer) map.get("videotypeid");
			Map<String, Object> map1 =  adminShiPinService.selectShiPinTypeContent(zd);
			String sptypename = (String) map1.get("name");
			map.put("sptypename", sptypename);
			list.remove(i);
			list.add(i, map);
		}
		List<Map<String, Object>> list2 = adminShiPinService.selectShiPinTypeList(gameId, 0, 100);
		modelAndView.addObject("shiPinTypeList", list2);
		modelAndView.addObject("shiPinList", list);
		modelAndView.addObject("state", state);
		modelAndView.addObject("gameId", gameId);
		modelAndView.addObject("sptypeid", sptypeid);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "sp");
		modelAndView.setViewName("admin/shiPin");
		return modelAndView;
	}
	@RequestMapping("/updateShiPinState")
	@ResponseBody 
	public Map<String, Object> updateShiPinState(
			@RequestParam(value="spid",defaultValue="") int spid,
			@RequestParam(value="state",defaultValue="") int state){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = adminShiPinService.updateShiPinState(spid, state);
		System.out.println("count:"+count);
		if(count>0){
			map.put("errorCode", "0");

		}else{
			map.put("errorCode", "1");
		}
		return map;
	}
	@RequestMapping("/toInsertShiPin.do")
	public ModelAndView toInsertShiPin(){
		ModelAndView modelAndView  = new ModelAndView();
		List<Map<String, Object>> list2 = adminShiPinService.selectShiPinTypeList(1, 0, 100);
		modelAndView.addObject("shiPinTypeList", list2);
		modelAndView.addObject("selectType", "sp");
		modelAndView.setViewName("admin/addShiPin");
		return modelAndView;
	}
	@RequestMapping("/insertShiPin.do")
	public ModelAndView insertShiPin(
			@RequestParam(value="gameid",defaultValue="1") int gameId,
			@RequestParam(value="sptypeid",defaultValue="") int sptypeid,
			@RequestParam(value="name",defaultValue="") String name,
			@RequestParam(value="watchurl",defaultValue="") String watchurl,
			@RequestParam(value="file",defaultValue="") MultipartFile file,
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
				AdminVideo adminVideo = new AdminVideo();
				adminVideo.setGameid(gameId);
				adminVideo.setVideotypeid(sptypeid);
				adminVideo.setName(name);
				adminVideo.setWatchurl(watchurl);
				adminVideo.setState(state);
				adminVideo.setCreatetime(DateUtil.getDataFormatForDateTime(new Date(), ""));
				int count = adminShiPinService.insertShiPin(adminVideo);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "添加成功");
				}else{
					modelAndView.addObject("message", "添加失败");
				}
				 modelAndView.setViewName("admin/addShiPinResult");
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
	
				AdminVideo adminVideo = new AdminVideo();
				adminVideo.setGameid(gameId);
				adminVideo.setName(name);
				adminVideo.setVideotypeid(sptypeid);
				adminVideo.setWatchurl(watchurl);
				adminVideo.setState(state);
				adminVideo.setCreatetime(DateUtil.getDataFormatForDateTime(new Date(), ""));
				adminVideo.setImageurl("/lmzy/upLoadImg/"+file.getOriginalFilename());

				int count = adminShiPinService.insertShiPin(adminVideo);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "添加成功");
				}else{
					modelAndView.addObject("message", "添加失败");
				}
				modelAndView.addObject("selectType", "sp");
				modelAndView.setViewName("admin/addShiPinResult");
				return modelAndView;
			} catch (IOException e) {
				modelAndView.addObject("message", "上传图片异常！");
				modelAndView.addObject("selectType", "sp");
				modelAndView.setViewName("admin/addShiPinResult");
				return modelAndView;
			} 
         } 


	}
	@RequestMapping("/updateShiPin.do")
	public ModelAndView updateShiPin(
			@RequestParam(value="gameid",defaultValue="1") int gameId,
			@RequestParam(value="sptypeid",defaultValue="") int sptypeid,
			@RequestParam(value="spid",defaultValue="") int spid,
			@RequestParam(value="name",defaultValue="") String name,
			@RequestParam(value="watchurl",defaultValue="") String watchurl,
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
				AdminVideo adminVideo = new AdminVideo();
				adminVideo.setGameid(gameId);
				adminVideo.setVideotypeid(sptypeid);
				adminVideo.setId(spid);
				adminVideo.setName(name);
				adminVideo.setWatchurl(watchurl);
				adminVideo.setCreatetime(DateUtil.getDataFormatForDateTime(new Date(), ""));
				int count = adminShiPinService.updateShiPin(adminVideo);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "添加成功");
				}else{
					modelAndView.addObject("message", "添加失败");
				}
				 modelAndView.setViewName("admin/addShiPinResult");
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
				AdminVideo adminVideo = new AdminVideo();
				adminVideo.setGameid(gameId);
				adminVideo.setVideotypeid(sptypeid);
				adminVideo.setId(spid);
				adminVideo.setName(name);
				adminVideo.setWatchurl(watchurl);
				adminVideo.setCreatetime(DateUtil.getDataFormatForDateTime(new Date(), ""));
				adminVideo.setImageurl("/lmzy/upLoadImg/"+file.getOriginalFilename());
				System.out.println("111111");
				int count = adminShiPinService.updateShiPin(adminVideo);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "修改成功");
				}else{
					modelAndView.addObject("message", "修改失败");
				}
				modelAndView.addObject("selectType", "sp");
				modelAndView.setViewName("admin/addNewsResult");
				return modelAndView;
			} catch (IOException e) {
				modelAndView.addObject("message", "上传图片异常！");
				modelAndView.addObject("selectType", "sp");
				modelAndView.setViewName("admin/addShiPinResult");
				return modelAndView;
			} 
         } 	}
	@RequestMapping("/selectShiPin.do")
	public ModelAndView selectShiPin(
			@RequestParam(value="spid",defaultValue="") int spid){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminShiPinService.selectShiPinContent(spid);
		int zd = (Integer) map.get("videotypeid");
		Map<String, Object> map1 =  adminShiPinService.selectShiPinTypeContent(zd);
		String sptypename = (String) map1.get("name");
		map.put("sptypename", sptypename);
		modelAndView.addObject("adminShiPin", map);
		modelAndView.addObject("selectType", "sp");
		modelAndView.setViewName("admin/shiPinContent");
		return modelAndView;
	}
	
	@RequestMapping("/selectShiPinTypeList.do")
	public ModelAndView selectShiPinTypeList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 10;
		List<Map<String, Object>> list = adminShiPinService.selectShiPinTypeList(gameId,(nowPage-1)*maxLine, maxLine);
		int count = adminShiPinService.selectShiPinTypeCount(gameId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("shiPinTypeList", list);
		modelAndView.addObject("gameId", gameId);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "sp");
		modelAndView.setViewName("admin/shiPinType");
		return modelAndView;
	}
	@RequestMapping("/insertShiPinType.do")
	public ModelAndView insertShiPinType(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="name",defaultValue="") String name,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		int count = adminShiPinService.insertShiPinType(gameId,name);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "添加成功");
		}else{
			modelAndView.addObject("message", "添加失败");
		}
		modelAndView.addObject("selectType", "sp");
		modelAndView.setViewName("admin/addShiPinResult");
		return modelAndView;

	}
	@RequestMapping("/updateShiPinType.do")
	public ModelAndView updateShiPinType(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="sptypeid",defaultValue="") int sptypeid,
			@RequestParam(value="name",defaultValue="") String name,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		int count = adminShiPinService.updateShiPinType(sptypeid,name);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "修改成功");
		}else{
			modelAndView.addObject("message", "修改失败");
		}
		modelAndView.addObject("selectType", "sp");
		modelAndView.setViewName("admin/addShiPinResult");
		return modelAndView;

	}
	@RequestMapping("/selectShiPinType.do")
	public ModelAndView selectShiPinType(
			@RequestParam(value="sptypeid",defaultValue="") int sptypeid){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminShiPinService.selectShiPinTypeContent(sptypeid);
		modelAndView.addObject("adminShiPinType", map);
		modelAndView.addObject("selectType", "sp");
		modelAndView.setViewName("admin/shiPinTypeContent");
		return modelAndView;
	}
}

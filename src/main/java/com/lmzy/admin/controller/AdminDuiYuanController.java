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

import com.lmzy.admin.po.AdminDuiYuan;
import com.lmzy.admin.po.AdminNews;
import com.lmzy.admin.po.AdminOccupationGuide;
import com.lmzy.admin.po.AdminVideo;
import com.lmzy.admin.service.AdminDuiYuanService;
import com.lmzy.admin.service.AdminZhiYeService;
import com.lmzy.core.util.DateUtil;
import com.lmzy.core.util.FileUpload;

@Controller
@RequestMapping("/admin/duiYuan")
public class AdminDuiYuanController {
	@Autowired
	AdminDuiYuanService adminDuiYuanService;
	@Autowired
	FileUpload fileUpload;
	@Value("${uploadUrl}")
	String uploadUrl;
	@Value("${uploadUrlBeiFen}")
	String uploadUrlBeiFen;
	@RequestMapping("/selectDuiYuanList.do")
	public ModelAndView selectDuiYuanList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="dytypeid",defaultValue="0") int dytypeid,
			@RequestParam(value="state",defaultValue="2") int state,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage,
			@RequestParam(value="startTime",defaultValue="") String startTime,
			@RequestParam(value="endTime",defaultValue="1") String endTime){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 10;
		List<Map<String, Object>> list = adminDuiYuanService.selectDuiYuanList(gameId,dytypeid,state, "","",(nowPage-1)*maxLine, maxLine,"desc");
		int count = adminDuiYuanService.selectDuiYuanCount(gameId, dytypeid, state);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		for(int i=0;i<list.size();i++){
			Map<String, Object> map = list.get(i);
			int zd = (Integer) map.get("teamtypeid");
			Map<String, Object> map1 =  adminDuiYuanService.selectDuiYuanTypeContent(zd);
			String dytypename = (String) map1.get("name");
			map.put("dytypename", dytypename);
			list.remove(i);
			list.add(i, map);
		}
		List<Map<String, Object>> list2 = adminDuiYuanService.selectDuiYuanTypeList(gameId, 0, 100);
		modelAndView.addObject("duiYuanTypeList", list2);
		modelAndView.addObject("duiYuanList", list);
		modelAndView.addObject("state", state);
		modelAndView.addObject("gameId", gameId);
		modelAndView.addObject("dytypeid", dytypeid);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "dy");
		modelAndView.setViewName("admin/duiYuan");
		return modelAndView;
	}
	@RequestMapping("/updateDuiYuanState")
	@ResponseBody 
	public Map<String, Object> updateDuiYuanState(
			@RequestParam(value="dyid",defaultValue="") int dyid,
			@RequestParam(value="state",defaultValue="") int state){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = adminDuiYuanService.updateDuiYuanState(dyid, state);
		System.out.println("count:"+count);
		if(count>0){
			map.put("errorCode", "0");

		}else{
			map.put("errorCode", "1");
		}
		return map;
	}
	@RequestMapping("/toInsertDuiYuan.do")
	public ModelAndView toInsertDuiYuan(){
		ModelAndView modelAndView  = new ModelAndView();
		List<Map<String, Object>> list2 = adminDuiYuanService.selectDuiYuanTypeList(1, 0, 100);
		modelAndView.addObject("duiYuanTypeList", list2);
		modelAndView.addObject("selectType", "dy");
		modelAndView.setViewName("admin/addDuiYuan");
		return modelAndView;
	}
	@RequestMapping("/insertDuiYuan.do")
	public ModelAndView insertDuiYuan(
			@RequestParam(value="gameid",defaultValue="1") int gameId,
			@RequestParam(value="dytypeid",defaultValue="") int dytypeid,
			@RequestParam(value="name",defaultValue="") String name,
			@RequestParam(value="role",defaultValue="") String role,
			@RequestParam(value="detailurl",defaultValue="") String detailurl,
			@RequestParam(value="herourl",defaultValue="") String herourl,
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
			    AdminDuiYuan adminDuiYuan = new AdminDuiYuan();
			    adminDuiYuan.setGameid(gameId);
			    adminDuiYuan.setTeamtypeid(dytypeid);
			    adminDuiYuan.setName(name);
			    adminDuiYuan.setRole(role);
			    adminDuiYuan.setDetailurl(detailurl);
			    adminDuiYuan.setHerourl(herourl);
			    adminDuiYuan.setState(state);
			    adminDuiYuan.setCreatetime(DateUtil.getDataFormatForDateTime(new Date(), ""));
				int count = adminDuiYuanService.insertDuiYuan(adminDuiYuan);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "添加成功");
				}else{
					modelAndView.addObject("message", "添加失败");
				}
				 modelAndView.setViewName("admin/addDuiYuanResult");
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
	
				AdminDuiYuan adminDuiYuan = new AdminDuiYuan();
			    adminDuiYuan.setGameid(gameId);
			    adminDuiYuan.setTeamtypeid(dytypeid);
			    adminDuiYuan.setName(name);
			    adminDuiYuan.setRole(role);
			    adminDuiYuan.setDetailurl(detailurl);
			    adminDuiYuan.setHerourl(herourl);
			    adminDuiYuan.setState(state);
			    adminDuiYuan.setCreatetime(DateUtil.getDataFormatForDateTime(new Date(), ""));
			    adminDuiYuan.setImgurl("/lmzy/upLoadImg/"+file.getOriginalFilename());

				int count = adminDuiYuanService.insertDuiYuan(adminDuiYuan);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "添加成功");
				}else{
					modelAndView.addObject("message", "添加失败");
				}
				modelAndView.addObject("selectType", "dy");
				modelAndView.setViewName("admin/addDuiYuanResult");
				return modelAndView;
			} catch (IOException e) {
				modelAndView.addObject("message", "上传图片异常！");
				modelAndView.addObject("selectType", "dy");
				modelAndView.setViewName("admin/addDuiYuanResult");
				return modelAndView;
			} 
         } 


	}
	@RequestMapping("/updateDuiYuan.do")
	public ModelAndView updateDuiYuan(
			@RequestParam(value="gameid",defaultValue="1") int gameId,
			@RequestParam(value="dytypeid",defaultValue="") int dytypeid,
			@RequestParam(value="dyid",defaultValue="") int dyid,
			@RequestParam(value="name",defaultValue="") String name,
			@RequestParam(value="role",defaultValue="") String role,
			@RequestParam(value="detailurl",defaultValue="") String detailurl,
			@RequestParam(value="herourl",defaultValue="") String herourl,
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
				AdminDuiYuan adminDuiYuan = new AdminDuiYuan();
				adminDuiYuan.setId(dyid);
			    adminDuiYuan.setGameid(gameId);
			    adminDuiYuan.setTeamtypeid(dytypeid);
			    adminDuiYuan.setName(name);
			    adminDuiYuan.setRole(role);
			    adminDuiYuan.setDetailurl(detailurl);
			    adminDuiYuan.setHerourl(herourl);
			    adminDuiYuan.setCreatetime(DateUtil.getDataFormatForDateTime(new Date(), ""));
				int count = adminDuiYuanService.updateDuiYuan(adminDuiYuan);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "添加成功");
				}else{
					modelAndView.addObject("message", "添加失败");
				}
				 modelAndView.setViewName("admin/addDuiYuanResult");
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
				AdminDuiYuan adminDuiYuan = new AdminDuiYuan();
			    adminDuiYuan.setGameid(gameId);
			    adminDuiYuan.setId(dyid);
			    adminDuiYuan.setTeamtypeid(dytypeid);
			    adminDuiYuan.setName(name);
			    adminDuiYuan.setRole(role);
			    adminDuiYuan.setDetailurl(detailurl);
			    adminDuiYuan.setHerourl(herourl);
			    adminDuiYuan.setCreatetime(DateUtil.getDataFormatForDateTime(new Date(), ""));
			    adminDuiYuan.setImgurl("/lmzy/upLoadImg/"+file.getOriginalFilename());
				int count = adminDuiYuanService.updateDuiYuan(adminDuiYuan);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "修改成功");
				}else{
					modelAndView.addObject("message", "修改失败");
				}
				modelAndView.addObject("selectType", "dy");
				modelAndView.setViewName("admin/addNewsResult");
				return modelAndView;
			} catch (IOException e) {
				modelAndView.addObject("message", "上传图片异常！");
				modelAndView.addObject("selectType", "dy");
				modelAndView.setViewName("admin/addDuiYuanResult");
				return modelAndView;
			} 
         } 	}
	@RequestMapping("/selectDuiYuan.do")
	public ModelAndView selectDuiYuan(
			@RequestParam(value="dyid",defaultValue="") int dyid){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminDuiYuanService.selectDuiYuanContent(dyid);
		int zd = (Integer) map.get("teamtypeid");
		Map<String, Object> map1 =  adminDuiYuanService.selectDuiYuanTypeContent(zd);
		String dytypename = (String) map1.get("name");
		map.put("dytypename", dytypename);
		modelAndView.addObject("adminDuiYuan", map);
		modelAndView.addObject("selectType", "dy");
		modelAndView.setViewName("admin/duiYuanContent");
		return modelAndView;
	}
	
	@RequestMapping("/selectDuiYuanTypeList.do")
	public ModelAndView selectDuiYuanTypeList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 10;
		List<Map<String, Object>> list = adminDuiYuanService.selectDuiYuanTypeList(gameId,(nowPage-1)*maxLine, maxLine);
		int count = adminDuiYuanService.selectDuiYuanTypeCount(gameId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("duiYuanTypeList", list);
		modelAndView.addObject("gameId", gameId);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "dy");
		modelAndView.setViewName("admin/duiYuanType");
		return modelAndView;
	}
	@RequestMapping("/insertDuiYuanType.do")
	public ModelAndView insertDuiYuanType(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="name",defaultValue="") String name,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		int count = adminDuiYuanService.insertDuiYuanType(gameId,name);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "添加成功");
		}else{
			modelAndView.addObject("message", "添加失败");
		}
		modelAndView.addObject("selectType", "dy");
		modelAndView.setViewName("admin/addDuiYuanResult");
		return modelAndView;

	}
	@RequestMapping("/updateDuiYuanType.do")
	public ModelAndView updateDuiYuanType(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="dytypeid",defaultValue="") int dytypeid,
			@RequestParam(value="name",defaultValue="") String name,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		int count = adminDuiYuanService.updateDuiYuanType(dytypeid,name);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "修改成功");
		}else{
			modelAndView.addObject("message", "修改失败");
		}
		modelAndView.addObject("selectType", "dy");
		modelAndView.setViewName("admin/addDuiYuanResult");
		return modelAndView;

	}
	@RequestMapping("/selectDuiYuanType.do")
	public ModelAndView selectDuiYuanType(
			@RequestParam(value="dytypeid",defaultValue="") int dytypeid){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminDuiYuanService.selectDuiYuanTypeContent(dytypeid);
		modelAndView.addObject("adminDuiYuanType", map);
		modelAndView.addObject("selectType", "dy");
		modelAndView.setViewName("admin/duiYuanTypeContent");
		return modelAndView;
	}
}

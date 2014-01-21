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

import com.lmzy.admin.po.AdminNews;
import com.lmzy.admin.service.AdminNewsService;
import com.lmzy.core.util.DateUtil;
import com.lmzy.core.util.FileUpload;
@Controller
@RequestMapping("/admin/news")
public class AdmiNewsController {
	@Autowired
	AdminNewsService adminNewsService;
	@Autowired
	FileUpload fileUpload;
	@Value("${uploadUrl}")
	String uploadUrl;
	@Value("${uploadUrlBeiFen}")
	String uploadUrlBeiFen;
	@RequestMapping("/selectNewsList.do")
	public ModelAndView selectNewsList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="state",defaultValue="2") int state,
			@RequestParam(value="newstypeid",defaultValue="0") int newstypeid,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage,
			@RequestParam(value="startTime",defaultValue="") String startTime,
			@RequestParam(value="endTime",defaultValue="1") String endTime){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 10;
		List<Map<String, Object>> list = adminNewsService.selectNewsList(gameId,newstypeid,state, "","",(nowPage-1)*maxLine, maxLine,"desc");
		int count = adminNewsService.selectNewsCount(gameId,newstypeid,state);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		for(int i=0;i<list.size();i++){
			Map<String, Object> map = list.get(i);
			if(map.get("newstypeid")!=null){
				int zd = (Integer) map.get("newstypeid");
				Map<String, Object> map1 =  adminNewsService.selectNewsTypeContent(zd);
				String newstypename = (String) map1.get("name");
				map.put("newstypename", newstypename);
				list.remove(i);
				list.add(i, map);
			}else{
				map.put("newstypename", "");
				list.remove(i);
				list.add(i, map);
			}
			
		}
		List<Map<String, Object>> list2 = adminNewsService.selectNewsTypeList(gameId, 0, 100);
		modelAndView.addObject("newsTypeList", list2);
		modelAndView.addObject("newsList", list);
		modelAndView.addObject("state", state);
		modelAndView.addObject("newstypeid", newstypeid);
		modelAndView.addObject("gameId", gameId);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "news");
		modelAndView.setViewName("admin/news");
		return modelAndView;
	}
	@RequestMapping("/toInsertNews.do")
	public ModelAndView toInsertNews(){
		ModelAndView modelAndView  = new ModelAndView();
		List<Map<String, Object>> list2 = adminNewsService.selectNewsTypeList(1, 0, 100);
		modelAndView.addObject("newsTypeList", list2);
		modelAndView.addObject("selectType", "news");
		modelAndView.setViewName("admin/addNews");
		return modelAndView;
	}
	@RequestMapping("/insertNews.do")
	public ModelAndView insertNews(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="newstypeid",defaultValue="") int newstypeid,
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
				AdminNews adminNews = new AdminNews();
				adminNews.setTitle(title);
				adminNews.setAuthor(author);
				adminNews.setGameId(gameId);
				adminNews.setNewstypeid(newstypeid);
				adminNews.setSource(source);
				adminNews.setState(state);
				adminNews.setContent(content);
				adminNews.setCreateTime(DateUtil.getDataFormatForDateTime(new Date(), ""));
//				adminNews.setImgurl("");
				int count = adminNewsService.insertNews(adminNews);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "添加成功");
				}else{
					modelAndView.addObject("message", "添加失败");
				}
				 modelAndView.setViewName("admin/addNewsResult");
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
	
             AdminNews adminNews = new AdminNews();
				adminNews.setTitle(title);
				adminNews.setAuthor(author);
				adminNews.setGameId(gameId);
				adminNews.setNewstypeid(newstypeid);
				adminNews.setSource(source);
				adminNews.setState(state);
				adminNews.setContent(content);
				adminNews.setCreateTime(DateUtil.getDataFormatForDateTime(new Date(), ""));
				adminNews.setImgurl("/lmzy/upLoadImg/"+file.getOriginalFilename());
				int count = adminNewsService.insertNews(adminNews);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "添加成功");
				}else{
					modelAndView.addObject("message", "添加失败");
				}
				modelAndView.addObject("selectType", "news");
				modelAndView.setViewName("admin/addNewsResult");
				return modelAndView;
			} catch (IOException e) {
				modelAndView.addObject("message", "上传图片异常！");
				modelAndView.addObject("selectType", "news");
				modelAndView.setViewName("admin/addNewsResult");
				return modelAndView;
			} 
         } 

	}
	
	@RequestMapping("/updateNewsState")
	@ResponseBody 
	public Map<String, Object> updateNewsState(
			@RequestParam(value="newsid",defaultValue="") int newsid,
			@RequestParam(value="state",defaultValue="") int state){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = adminNewsService.updateNewsState(newsid, state);
		System.out.println("count:"+count);
		if(count>0){
			map.put("errorCode", "0");

		}else{
			map.put("errorCode", "1");
		}
		return map;
	}
	@RequestMapping(value="/deleteNews", method=RequestMethod.POST)
	@ResponseBody 
	public Map<String, Object> deleteNews(
			@RequestParam(value="newsid",defaultValue="") int newsid){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = adminNewsService.deleteNews(newsid);
		System.out.println("count:"+count);
		if(count>0){
			map.put("errorCode", "0");

		}else{
			map.put("errorCode", "1");
		}
		return map;
	}
	@RequestMapping("/selectNews.do")
	public ModelAndView selectNews(
			@RequestParam(value="newsid",defaultValue="") int newsid){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminNewsService.selectNewsContent(newsid);
		if(map.get("newstypeid")!=null){
			int zd = (Integer) map.get("newstypeid");
			Map<String, Object> map1 =  adminNewsService.selectNewsTypeContent(zd);
			String newstypename = (String) map1.get("name");
			map.put("newstypename", newstypename);
		}

		modelAndView.addObject("adminNews", map);
		modelAndView.addObject("selectType", "news");
		modelAndView.setViewName("admin/newsContent");
		return modelAndView;
	}
	@RequestMapping(value="/updateNews.do", method=RequestMethod.POST)
	public ModelAndView updateNews(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="newsid",defaultValue="") int newsId,
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
				AdminNews adminNews = new AdminNews();
				adminNews.setId(newsId);
				adminNews.setTitle(title);
				adminNews.setAuthor(author);
				adminNews.setGameId(gameId);
				adminNews.setSource(source);
				adminNews.setState(state);
				adminNews.setContent(content);
				adminNews.setCreateTime(DateUtil.getDataFormatForDateTime(new Date(), ""));
//				adminNews.setImgurl("");
				int count = adminNewsService.updateNews(adminNews);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "修改成功");
				}else{
					modelAndView.addObject("message", "修改失败");
				}
				modelAndView.addObject("selectType", "news");
				 modelAndView.setViewName("admin/addNewsResult");
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
				AdminNews adminNews = new AdminNews();
				adminNews.setId(newsId);
				adminNews.setTitle(title);
				adminNews.setAuthor(author);
				adminNews.setGameId(gameId);
				adminNews.setSource(source);
				adminNews.setState(state);
				adminNews.setContent(content);
				adminNews.setCreateTime(DateUtil.getDataFormatForDateTime(new Date(), ""));
				adminNews.setImgurl("/lmzy/upLoadImg/"+file.getOriginalFilename());
				int count = adminNewsService.updateNews(adminNews);
				System.out.println("count="+count);
				if(count==1){
					modelAndView.addObject("message", "修改成功");
				}else{
					modelAndView.addObject("message", "修改失败");
				}
				modelAndView.addObject("selectType", "news");
				modelAndView.setViewName("admin/addNewsResult");
				return modelAndView;
			} catch (IOException e) {
				modelAndView.addObject("message", "上传图片异常！");
				modelAndView.addObject("selectType", "news");
				modelAndView.setViewName("admin/addNewsResult");
				return modelAndView;
			} 
         } 

	}
	@RequestMapping("/selectNewsTypeList.do")
	public ModelAndView selectShiPinTypeList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 10;
		List<Map<String, Object>> list = adminNewsService.selectNewsTypeList(gameId,(nowPage-1)*maxLine, maxLine);
		int count = adminNewsService.selectNewsTypeCount(gameId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("newsTypeList", list);
		modelAndView.addObject("gameId", gameId);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "news");
		modelAndView.setViewName("admin/newsType");
		return modelAndView;
	}
	@RequestMapping("/insertNewsType.do")
	public ModelAndView insertNewsType(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="name",defaultValue="") String name,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		int count = adminNewsService.insertNewsType(gameId,name);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "添加成功");
		}else{
			modelAndView.addObject("message", "添加失败");
		}
		modelAndView.addObject("selectType", "news");
		modelAndView.setViewName("admin/addNewsResult");
		return modelAndView;

	}
	@RequestMapping("/updateNewsType.do")
	public ModelAndView updateNewsType(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="newstypeid",defaultValue="") int newstypeid,
			@RequestParam(value="name",defaultValue="") String name,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		int count = adminNewsService.updateNewsType(newstypeid,name);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "修改成功");
		}else{
			modelAndView.addObject("message", "修改失败");
		}
		modelAndView.addObject("selectType", "news");
		modelAndView.setViewName("admin/addNewsResult");
		return modelAndView;

	}
	@RequestMapping("/selectNewsType.do")
	public ModelAndView selectNewsType(
			@RequestParam(value="newstypeid",defaultValue="") int newstypeid){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminNewsService.selectNewsTypeContent(newstypeid);
		modelAndView.addObject("adminNewsType", map);
		modelAndView.addObject("selectType", "news");
		modelAndView.setViewName("admin/newsTypeContent");
		return modelAndView;
	}
}

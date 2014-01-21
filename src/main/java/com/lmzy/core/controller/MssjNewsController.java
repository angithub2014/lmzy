package com.lmzy.core.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.admin.service.AdminNewsService;
import com.lmzy.core.service.NewsService;
@Controller
@RequestMapping("/mssj/news")
public class MssjNewsController {
	@Autowired
	NewsService newsService;
	@Autowired
	AdminNewsService adminNewsService;
	@RequestMapping("/selectNewsType")  
	@ResponseBody
	public List<Map<String, Object>> selectNewsType(
			@RequestParam(value="gameId",defaultValue="1") String gameId){
		return adminNewsService.selectNewsTypeList(Integer.parseInt(gameId),0,100);
	}
	@RequestMapping("/selectNewsList")
	public ModelAndView selectNewsList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="newstypeid",defaultValue="0") int newstypeid,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 20;
		List<Map<String, Object>> list = newsService.selectNewsList(gameId, newstypeid,(nowPage-1)*maxLine, maxLine);
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
		int count = newsService.selectNewsCount(gameId,newstypeid);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("newsList", list);
		modelAndView.addObject("newstypeid", newstypeid);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "news");
		modelAndView.setViewName("mssj/news/news");
		return modelAndView;
	}
	@RequestMapping("/selectNewsContent")
	public ModelAndView selectNewsContent(
			@RequestParam(value="newsId",defaultValue="1") int newsId){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map = newsService.selectNewsContent(newsId);
		int total = (Integer) map.get("total");
		int count = newsService.updateNewsTotal(newsId, total+1);
		map.put("total", total+1);
		System.out.println("count:"+count);
		modelAndView.addObject("selectType", "news");
		modelAndView.addObject("news", map);
		modelAndView.setViewName("mssj/news/newsDetail");
		return modelAndView;
	}
}

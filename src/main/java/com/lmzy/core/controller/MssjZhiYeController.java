package com.lmzy.core.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.core.service.ZhiYeService;
@Controller
@RequestMapping("/mssj/zhiYe")
public class MssjZhiYeController {
	@Autowired
	ZhiYeService zhiYeService;
	@RequestMapping("/selectZhiYe")  
	@ResponseBody
	public List<Map<String, Object>> selectZhiYe(
			@RequestParam(value="gameId",defaultValue="1") String gameId){
		System.out.println(zhiYeService.selectZhiYe(Integer.parseInt(gameId)));
		return zhiYeService.selectZhiYe(Integer.parseInt(gameId));
	}
	@RequestMapping("/selectZhiYeList")
	public ModelAndView selectZhiYeList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="zhiYeId",defaultValue="1") int zhiYeId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 20;
		List<Map<String, Object>> list = zhiYeService.selectZhiYeList(gameId, zhiYeId, (nowPage-1)*maxLine, maxLine);
		int count = zhiYeService.selectZhiYeCount(gameId, zhiYeId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("zhiYeList", list);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "zy");
		modelAndView.setViewName("mssj/zhiYe/zhiYe");
		return modelAndView;
	}
	@RequestMapping("/selectZhiYeContent")
	public ModelAndView selectZhiYeContent(
			@RequestParam(value="zhiYeGuideId",defaultValue="1") int zhiYeGuideId){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map = zhiYeService.selectZhiYeContent(zhiYeGuideId);
		System.out.println();
		int total = (Integer) map.get("total");
		int count = zhiYeService.updateZhiYeTotal(zhiYeGuideId, total+1);
		map.put("total", total+1);
		System.out.println("count:"+count);
		modelAndView.addObject("zhiYe", map);
		modelAndView.addObject("selectType", "zy");
		modelAndView.setViewName("mssj/zhiYe/zhiYeDetail");
		return modelAndView;
	}
	@RequestMapping("/selectZhiYeMoreList")
	public ModelAndView selectZhiYeMoreList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 20;
		List<Map<String, Object>> list = zhiYeService.selectZhiYeListByGameId(gameId,(nowPage-1)*maxLine, maxLine);
		int count = zhiYeService.selectZhiYeCountByGameId(gameId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("zhiYeList", list);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "zy");
		modelAndView.setViewName("mssj/zhiYe/zhiYeMore");
		return modelAndView;
	}
}

package com.lmzy.core.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.core.service.FuBenService;

@Controller
@RequestMapping("/mssj/fuBen")
public class MssjFuBenController {
	@Autowired
	FuBenService fuBenService;
	@RequestMapping("/selectFuBen")  
	@ResponseBody
	public List<Map<String, Object>> selectFuBen(
			@RequestParam(value="gameId",defaultValue="1") String gameId){
		System.out.println("gameId="+gameId);
		System.out.println(fuBenService.selectFuBen(Integer.parseInt(gameId)));
		return fuBenService.selectFuBen(Integer.parseInt(gameId));
	}
	@RequestMapping("/selectFuBenList")
	public ModelAndView selectFuBenList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="fuBenId",defaultValue="1") int fuBenId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 20;
		List<Map<String, Object>> list = fuBenService.selectFuBenList(gameId, fuBenId, (nowPage-1)*maxLine, maxLine);
		int count = fuBenService.selectFuBenCount(gameId, fuBenId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("fuBenList", list);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "fb");
		modelAndView.setViewName("mssj/fuBen/fuBen");
		return modelAndView;
	}
	@RequestMapping("/selectFuBenContent")
	public ModelAndView selectFuBenContent(
			@RequestParam(value="fuBenHelpId",defaultValue="1") int fuBenHelpId){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map = fuBenService.selectFuBenContent(fuBenHelpId);
		int total = (Integer) map.get("total");
		int count = fuBenService.updateFuBenTotal(fuBenHelpId, total+1);
		map.put("total", total+1);
		System.out.println("count:"+count);
		modelAndView.addObject("fuBen", map);
		modelAndView.addObject("selectType", "fb");
		modelAndView.setViewName("mssj/fuBen/fuBenDetail");
		return modelAndView;
	}
	@RequestMapping("/selectFuBenMoreList")
	public ModelAndView selectFuBenMoreList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 20;
		List<Map<String, Object>> list = fuBenService.selectFuBenListByGameId(gameId, (nowPage-1)*maxLine, maxLine);
		int count = fuBenService.selectFuBenCountByGameId(gameId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("fuBenList", list);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "fb");
		modelAndView.setViewName("mssj/fuBen/fuBenMore");
		return modelAndView;
	}
}

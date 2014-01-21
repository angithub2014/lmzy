package com.lmzy.core.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.core.service.ShiPinService;

@Controller
@RequestMapping("/mssj/shiPin")
public class MssjShiPinController {
	@Autowired
	ShiPinService shiPinService;
	@RequestMapping("/selectShiPinType")  
	@ResponseBody
	public List<Map<String, Object>> selectShiPinType(
			@RequestParam(value="gameId",defaultValue="1") String gameId){
		return shiPinService.selectShiPinType(Integer.parseInt(gameId));
	}
	@RequestMapping("/selectShiPinList")
	public ModelAndView selectShiPinList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="sptypeId",defaultValue="1") int sptypeId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 30;
		List<Map<String, Object>> list = shiPinService.selectShiPinList(gameId, sptypeId, (nowPage-1)*maxLine, maxLine);
		int count = shiPinService.selectShiPinCount(gameId, sptypeId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("shiPinList", list);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("sptypeId", sptypeId);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "sp");
		modelAndView.setViewName("mssj/shiPin");
		return modelAndView;
	}
//	@RequestMapping("/selectShiPinContent")
//	public ModelAndView selectZhiYeContent(
//			@RequestParam(value="spId",defaultValue="1") int spId){
//		ModelAndView modelAndView  = new ModelAndView();
//		Map<String, Object> map = shiPinService.selectShiPinContent(spId);
//		int total = (Integer) map.get("total");
//		int count = shiPinService.updateShiPinTotal(spId, total+1);
//		map.put("total", total+1);
//		System.out.println("count:"+count);
//		modelAndView.addObject("shiPin", map);
//		modelAndView.addObject("selectType", "sp");
//		modelAndView.setViewName("mssj/shiPin/shiPinDetail");
//		return modelAndView;
//	}
	@RequestMapping("/selectShiPinMoreList")
	public ModelAndView selectShiPinMoreList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 20;
		List<Map<String, Object>> list = shiPinService.selectShiPinListByGameId(gameId,(nowPage-1)*maxLine, maxLine);
		int count = shiPinService.selectShiPinCountByGameId(gameId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("shiPinList", list);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "sp");
		modelAndView.setViewName("mssj/shiPin");
		return modelAndView;
	}
}

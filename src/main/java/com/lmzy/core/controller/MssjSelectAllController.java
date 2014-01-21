package com.lmzy.core.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.core.service.SelectAllService;
@Controller
@RequestMapping("/mssj/select")
public class MssjSelectAllController {
	@Autowired
	SelectAllService selectAllService;
	@RequestMapping("/selectTeamList")
	public ModelAndView selectTeamList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage,
			HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		int maxLine = 20;
		List<Map<String, Object>> list = selectAllService.selectTeamList(gameId, (nowPage-1)*maxLine, maxLine);
		int count = selectAllService.selectTeamCount(gameId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("teamList", list);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "team");
		modelAndView.setViewName("mssj/team/teamMore");

		return modelAndView;
	}
	@RequestMapping("/selectTeamContent")
	public ModelAndView selectTeamContent(
			@RequestParam(value="teamId",defaultValue="") int teamId){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map = selectAllService.selectTeamContent(teamId);
//		int total = (Integer) map.get("total");
//		int count = selectAllService.updateTeamTotal(teamId, total+1);
//		map.put("total", total+1);

		modelAndView.addObject("selectType", "team");
		modelAndView.addObject("team", map);
		modelAndView.setViewName("mssj/team/teamDetail");
		return modelAndView;
	}@RequestMapping("/selectRecruitList")
	public ModelAndView selectRecruitList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage,
			HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		int maxLine = 20;
		List<Map<String, Object>> list = selectAllService.selectRecruitList(gameId, (nowPage-1)*maxLine, maxLine);
		int count = selectAllService.selectRecruitCount(gameId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("recruitList", list);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "recruit");
		modelAndView.setViewName("mssj/recruit/recruit");

		return modelAndView;
	}
	@RequestMapping("/selectRecruitContent")
	public ModelAndView selectRecruitContent(
			@RequestParam(value="recruitId",defaultValue="") int recruitId){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map = selectAllService.selectRecruitContent(recruitId);
		modelAndView.addObject("selectType", "recruit");
		int total = (Integer) map.get("total");
		int count = selectAllService.updateRecruitTotal(recruitId, total+1);
		map.put("total", total+1);
		modelAndView.addObject("recruit", map);
		modelAndView.setViewName("mssj/recruit/recruitDetail");
		return modelAndView;
	}
}

package com.lmzy.admin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.admin.po.AdminTeam;
import com.lmzy.admin.service.AdminTeamService;
import com.lmzy.core.util.DateUtil;
@Controller
@RequestMapping("/admin/team")
public class AdmiTeamController {
	@Autowired
	AdminTeamService adminTeamService;
	@RequestMapping("/selectTeamList.do")
	public ModelAndView selectNewsList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="state",defaultValue="2") int state,
			@RequestParam(value="teamtype",defaultValue="0") String teamtype,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage,
			@RequestParam(value="startTime",defaultValue="") String startTime,
			@RequestParam(value="endTime",defaultValue="1") String endTime){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 10;
		List<Map<String, Object>> list = adminTeamService.selectTeamList(gameId,state, teamtype,(nowPage-1)*maxLine, maxLine);
		int count = adminTeamService.selectTeamCount(gameId,state,teamtype);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("teamList", list);
		modelAndView.addObject("state", state);
		modelAndView.addObject("gameId", gameId);
		modelAndView.addObject("teamtype", teamtype);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "dy");
		modelAndView.setViewName("admin/team");
		return modelAndView;
	}
	@RequestMapping("/insertTeam.do")
	public ModelAndView insertTeam(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="nameid",defaultValue="") String nameid,
			@RequestParam(value="teamtype",defaultValue="") String teamtype,
			@RequestParam(value="state",defaultValue="0") int state,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		AdminTeam adminTeam = new AdminTeam();
		adminTeam.setGameid(gameId);
		adminTeam.setNameid(nameid);
		adminTeam.setTeamtype(teamtype);
		if("yuan".equals(teamtype)){
			adminTeam.setTeamtypename("远程组");
		}else{
			adminTeam.setTeamtypename("近战组");
		}
		adminTeam.setState(state);
		adminTeam.setCreatetime(DateUtil.getDataFormatForDateTime(new Date(), ""));
		int count = adminTeamService.insertTeam(adminTeam);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "添加成功");
		}else{
			modelAndView.addObject("message", "添加失败");
		}
			modelAndView.setViewName("admin/addTeamResult");
			return modelAndView;
         

	}
	
	@RequestMapping("/updateTeamState")
	@ResponseBody 
	public Map<String, Object> updateTeamState(
			@RequestParam(value="teamid",defaultValue="") int teamid,
			@RequestParam(value="state",defaultValue="") int state){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = adminTeamService.updateTeamState(teamid, state);
		System.out.println("count:"+count);
		if(count>0){
			map.put("errorCode", "0");

		}else{
			map.put("errorCode", "1");
		}
		return map;
	}
	@RequestMapping("/selectTeam.do")
	public ModelAndView selectTeam(
			@RequestParam(value="teamid",defaultValue="") int teamid){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminTeamService.selectTeamContent(teamid);
		modelAndView.addObject("adminTeam", map);
		modelAndView.addObject("selectType", "dy");
		modelAndView.setViewName("admin/teamContent");
		return modelAndView;
	}
	@RequestMapping(value="/updateTeam.do", method=RequestMethod.POST)
	public ModelAndView updateTeam(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="nameid",defaultValue="") String nameid,
			@RequestParam(value="teamid",defaultValue="") int teamid,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		AdminTeam adminTeam = new AdminTeam();
		adminTeam.setGameid(gameId);
		adminTeam.setId(teamid);
		int count = adminTeamService.updateTeam(adminTeam);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "修改成功");
		}else{
			modelAndView.addObject("message", "修改失败");
		}
		modelAndView.addObject("selectType", "dy");
		modelAndView.setViewName("admin/addTeamResult");
		return modelAndView;
	}
}

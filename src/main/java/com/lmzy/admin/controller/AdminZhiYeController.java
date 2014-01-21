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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.admin.po.AdminOccupationGuide;
import com.lmzy.admin.service.AdminZhiYeService;
import com.lmzy.core.util.DateUtil;

@Controller
@RequestMapping("/admin/zhiYe")
public class AdminZhiYeController {
	@Autowired
	AdminZhiYeService adminZhiYeService;
	@RequestMapping("/selectZhiYeHelpList.do")
	public ModelAndView selectZhiYeHelpList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="zyid",defaultValue="0") int zyid,
			@RequestParam(value="state",defaultValue="2") int state,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage,
			@RequestParam(value="startTime",defaultValue="") String startTime,
			@RequestParam(value="endTime",defaultValue="1") String endTime){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 10;
		List<Map<String, Object>> list = adminZhiYeService.selectZhiYeHelpList(gameId,zyid,state, "","",(nowPage-1)*maxLine, maxLine,"desc");
		int count = adminZhiYeService.selectZhiYeHelpCount(gameId,zyid,state);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		for(int i=0;i<list.size();i++){
			Map<String, Object> map = list.get(i);
			int zd = (Integer) map.get("occupationid");
			Map<String, Object> map1 =  adminZhiYeService.selectZhiYeContent(zd);
			String zyname = (String) map1.get("name");
			map.put("zyname", zyname);
			list.remove(i);
			list.add(i, map);
		}
		List<Map<String, Object>> list2 = adminZhiYeService.selectZhiYeList(gameId, 0, 100);
		modelAndView.addObject("zhiYeList", list2);
		modelAndView.addObject("zhiYeHelpList", list);
		modelAndView.addObject("state", state);
		modelAndView.addObject("gameId", gameId);
		modelAndView.addObject("zyid", zyid);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "zy");
		modelAndView.setViewName("admin/zhiYeHelp");
		return modelAndView;
	}
	@RequestMapping("/updateZhiYeHelpState")
	@ResponseBody 
	public Map<String, Object> updateZhiYeHelpState(
			@RequestParam(value="zyhelpid",defaultValue="") int zyhelpid,
			@RequestParam(value="state",defaultValue="") int state){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = adminZhiYeService.updateZhiYeHelpState(zyhelpid, state);
		System.out.println("count:"+count);
		if(count>0){
			map.put("errorCode", "0");

		}else{
			map.put("errorCode", "1");
		}
		return map;
	}
	@RequestMapping("/toInsertZhiYeHelp.do")
	public ModelAndView toInsertFuBenHelp(){
		ModelAndView modelAndView  = new ModelAndView();
		List<Map<String, Object>> list2 = adminZhiYeService.selectZhiYeList(1, 0, 100);
		modelAndView.addObject("zhiYeList", list2);
		modelAndView.addObject("selectType", "zy");
		modelAndView.setViewName("admin/addZhiYeHelp");
		return modelAndView;
	}
	@RequestMapping("/insertZhiYeHelp.do")
	public ModelAndView insertZhiYeHelp(
			@RequestParam(value="gameid",defaultValue="1") int gameId,
			@RequestParam(value="zyid",defaultValue="") int zyid,
			@RequestParam(value="title",defaultValue="") String title,
			@RequestParam(value="source",defaultValue="") String source,
			@RequestParam(value="author",defaultValue="") String author,
			@RequestParam(value="content",defaultValue="") String content,
			@RequestParam(value="state",defaultValue="0") int state,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		AdminOccupationGuide adminOccupationGuide = new AdminOccupationGuide();
		adminOccupationGuide.setGameid(gameId);
		adminOccupationGuide.setOccupationId(zyid);
		adminOccupationGuide.setTitle(title);
		adminOccupationGuide.setSource(source);
		adminOccupationGuide.setAuthor(author);
		adminOccupationGuide.setContent(content);
		adminOccupationGuide.setState(state);
		adminOccupationGuide.setCreateTime(DateUtil.getDataFormatForDateTime(new Date(), ""));
		int count = adminZhiYeService.insertZhiYeHelp(adminOccupationGuide);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "添加成功");
		}else{
			modelAndView.addObject("message", "添加失败");
		}
		modelAndView.addObject("selectType", "zy");
		modelAndView.setViewName("admin/addZhiYeResult");
		return modelAndView;

	}
	@RequestMapping("/updateZhiYeHelp.do")
	public ModelAndView updateZhiYeHelp(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="zyhelpid",defaultValue="") int zyhelpid,
			@RequestParam(value="zyid",defaultValue="") int zyid,
			@RequestParam(value="title",defaultValue="") String title,
			@RequestParam(value="source",defaultValue="") String source,
			@RequestParam(value="author",defaultValue="") String author,
			@RequestParam(value="content",defaultValue="") String content,
			@RequestParam(value="state",defaultValue="0") int state,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		AdminOccupationGuide adminOccupationGuide = new AdminOccupationGuide();
		adminOccupationGuide.setGameid(gameId);
		adminOccupationGuide.setId(zyhelpid);
		adminOccupationGuide.setOccupationId(zyid);
		adminOccupationGuide.setTitle(title);
		adminOccupationGuide.setSource(source);
		adminOccupationGuide.setAuthor(author);
		adminOccupationGuide.setContent(content);
		adminOccupationGuide.setState(state);
		adminOccupationGuide.setCreateTime(DateUtil.getDataFormatForDateTime(new Date(), ""));
		int count = adminZhiYeService.updateZhiYeHelp(adminOccupationGuide);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "修改成功");
		}else{
			modelAndView.addObject("message", "修改失败");
		}
		modelAndView.addObject("selectType", "zy");
		modelAndView.setViewName("admin/addZhiYeResult");
		return modelAndView;

	}
	@RequestMapping("/selectZhiYeHelp.do")
	public ModelAndView selectZhiYeHelp(
			@RequestParam(value="zyhelpid",defaultValue="") int zyhelpid){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminZhiYeService.selectZhiYeHelpContent(zyhelpid);
		int zd = (Integer) map.get("occupationid");
		Map<String, Object> map1 =  adminZhiYeService.selectZhiYeContent(zd);
		String zyname = (String) map1.get("name");
		map.put("zyname", zyname);
		modelAndView.addObject("adminZhiYeHelp", map);
		modelAndView.addObject("selectType", "zy");
		modelAndView.setViewName("admin/zhiYeHelpContent");
		return modelAndView;
	}
	
	@RequestMapping("/selectZhiYeList.do")
	public ModelAndView selectZhiYeList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 10;
		List<Map<String, Object>> list = adminZhiYeService.selectZhiYeList(gameId,(nowPage-1)*maxLine, maxLine);
		int count = adminZhiYeService.selectZhiYeCount(gameId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("zhiYeList", list);
		modelAndView.addObject("gameId", gameId);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "zy");
		modelAndView.setViewName("admin/zhiYe");
		return modelAndView;
	}
	@RequestMapping("/insertZhiYe.do")
	public ModelAndView insertZhiYe(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="name",defaultValue="") String name,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		int count = adminZhiYeService.insertZhiYe(gameId,name);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "添加成功");
		}else{
			modelAndView.addObject("message", "添加失败");
		}
		modelAndView.addObject("selectType", "zy");
		modelAndView.setViewName("admin/addZhiYeResult");
		return modelAndView;

	}
	@RequestMapping("/updateZhiYe.do")
	public ModelAndView updateZhiYe(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="zyid",defaultValue="") int zyid,
			@RequestParam(value="name",defaultValue="") String name,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		int count = adminZhiYeService.updateZhiYe(zyid,name);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "修改成功");
		}else{
			modelAndView.addObject("message", "修改失败");
		}
		modelAndView.addObject("selectType", "zy");
		modelAndView.setViewName("admin/addZhiYeResult");
		return modelAndView;

	}
	@RequestMapping("/selectZhiYe.do")
	public ModelAndView selectZhiYe(
			@RequestParam(value="zyid",defaultValue="") int zyid){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminZhiYeService.selectZhiYeContent(zyid);
		modelAndView.addObject("adminZhiYe", map);
		modelAndView.addObject("selectType", "zy");
		modelAndView.setViewName("admin/zhiYeContent");
		return modelAndView;
	}
}

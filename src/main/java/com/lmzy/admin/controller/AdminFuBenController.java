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

import com.lmzy.admin.po.AdminFbHelp;
import com.lmzy.admin.service.AdminFuBenService;
import com.lmzy.core.util.DateUtil;

@Controller
@RequestMapping("/admin/fuBen")
public class AdminFuBenController {
	@Autowired
	AdminFuBenService adminFuBenService;
	@RequestMapping("/selectFuBenHelpList.do")
	public ModelAndView selectFuBenHelpList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="fbid",defaultValue="0") int fbid,
			@RequestParam(value="state",defaultValue="2") int state,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage,
			@RequestParam(value="startTime",defaultValue="") String startTime,
			@RequestParam(value="endTime",defaultValue="") String endTime){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 10;
		List<Map<String, Object>> list = adminFuBenService.selectFuBenHelpList(gameId,fbid,state, "","",(nowPage-1)*maxLine, maxLine,"desc");
		int count = adminFuBenService.selectFuBenHelpCount(gameId,fbid,state);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		System.out.println(gameId+",fbid："+fbid);
		System.out.println(count+","+totalPage);
		for(int i=0;i<list.size();i++){
			Map<String, Object> map = list.get(i);
			int fd = (Integer) map.get("fbid");
			Map<String, Object> map1 =  adminFuBenService.selectFuBenContent(fd);
			String fbname = (String) map1.get("name");
			map.put("fbname", fbname);
			list.remove(i);
			list.add(i, map);
		}
		List<Map<String, Object>> list2 = adminFuBenService.selectFuBenList(gameId, 0, 100);
		modelAndView.addObject("fuBenHelpList", list);
		modelAndView.addObject("fuBenList", list2);
		modelAndView.addObject("state", state);
		modelAndView.addObject("gameId", gameId);
		modelAndView.addObject("fbid", fbid);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "fb");
		modelAndView.setViewName("admin/fuBenHelp");
		return modelAndView;
	}
	@RequestMapping("/updateFuBenHelpState")
	@ResponseBody 
	public Map<String, Object> updateFuBenHelpState(
			@RequestParam(value="fbhelpid",defaultValue="") int fbhelpid,
			@RequestParam(value="state",defaultValue="") int state){
		Map<String, Object> map = new HashMap<String, Object>();
		int count = adminFuBenService.updateFuBenHelpState(fbhelpid, state);
		System.out.println("count:"+count);
		if(count>0){
			map.put("errorCode", "0");

		}else{
			map.put("errorCode", "1");
		}
		return map;
	}
	@RequestMapping("/toInsertFuBenHelp.do")
	public ModelAndView toInsertFuBenHelp(){
		ModelAndView modelAndView  = new ModelAndView();
		List<Map<String, Object>> list2 = adminFuBenService.selectFuBenList(1, 0, 100);
		modelAndView.addObject("fuBenList", list2);
		modelAndView.addObject("selectType", "fb");
		modelAndView.setViewName("admin/addFuBenHelp");
		return modelAndView;
	}
	@RequestMapping("/insertFuBenHelp.do")
	public ModelAndView insertFuBenHelp(
			@RequestParam(value="gameid",defaultValue="1") int gameId,
			@RequestParam(value="fbid",defaultValue="") int fbid,
			@RequestParam(value="title",defaultValue="") String title,
			@RequestParam(value="source",defaultValue="") String source,
			@RequestParam(value="author",defaultValue="") String author,
			@RequestParam(value="content",defaultValue="") String content,
			@RequestParam(value="state",defaultValue="0") int state,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		AdminFbHelp adminFbHelp = new AdminFbHelp();
		adminFbHelp.setGameid(gameId);
		adminFbHelp.setFbId(fbid);
		adminFbHelp.setTitle(title);
		adminFbHelp.setSource(source);
		adminFbHelp.setAuthor(author);
		adminFbHelp.setContent(content);
		adminFbHelp.setState(state);
		adminFbHelp.setCreateTime(DateUtil.getDataFormatForDateTime(new Date(), ""));
		int count = adminFuBenService.insertFuBenHelp(adminFbHelp);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "添加成功");
		}else{
			modelAndView.addObject("message", "添加失败");
		}
		modelAndView.addObject("selectType", "fb");
		modelAndView.setViewName("admin/addFuBenResult");
		return modelAndView;

	}
	@RequestMapping("/updateFuBenHelp.do")
	public ModelAndView updateFuBenHelp(
			@RequestParam(value="gameid",defaultValue="1") int gameId,
			@RequestParam(value="fbhelpid",defaultValue="") int fbhelpid,
			@RequestParam(value="fbid",defaultValue="") int fbid,
			@RequestParam(value="title",defaultValue="") String title,
			@RequestParam(value="source",defaultValue="") String source,
			@RequestParam(value="author",defaultValue="") String author,
			@RequestParam(value="content",defaultValue="") String content,
			@RequestParam(value="state",defaultValue="0") int state,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		AdminFbHelp adminFbHelp = new AdminFbHelp();
		adminFbHelp.setGameid(gameId);
		adminFbHelp.setId(fbhelpid);
		adminFbHelp.setFbId(fbid);
		adminFbHelp.setTitle(title);
		adminFbHelp.setSource(source);
		adminFbHelp.setAuthor(author);
		adminFbHelp.setContent(content);
		adminFbHelp.setState(state);
		adminFbHelp.setCreateTime(DateUtil.getDataFormatForDateTime(new Date(), ""));
		int count = adminFuBenService.updateFuBenHelp(adminFbHelp);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "修改成功");
		}else{
			modelAndView.addObject("message", "修改失败");
		}
		modelAndView.addObject("selectType", "fb");
		modelAndView.setViewName("admin/addFuBenResult");
		return modelAndView;

	}
	@RequestMapping("/selectFuBenHelp.do")
	public ModelAndView selectFuBenHelp(
			@RequestParam(value="fbhelpid",defaultValue="") int fbhelpid){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminFuBenService.selectFuBenHelpContent(fbhelpid);
//		List<Map<String, Object>> list2 = adminFuBenService.selectFuBenList(1, 0, 100);
//		modelAndView.addObject("fuBenList", list2);
		Map<String, Object> map2 =  adminFuBenService.selectFuBenContent((Integer)map.get("fbid"));
		map.put("name", map2.get("name"));
		modelAndView.addObject("adminFuBenHelp", map);
		modelAndView.addObject("selectType", "fb");
		modelAndView.setViewName("admin/fuBenHelpContent");
		return modelAndView;
	}
	
	@RequestMapping("/selectFuBenList.do")
	public ModelAndView selectFuBenList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 10;
		List<Map<String, Object>> list = adminFuBenService.selectFuBenList(gameId,(nowPage-1)*maxLine, maxLine);
		int count = adminFuBenService.selectFuBenCount(gameId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("fuBenList", list);
		modelAndView.addObject("gameId", gameId);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "fb");
		modelAndView.setViewName("admin/fuBen");
		return modelAndView;
	}
	@RequestMapping("/insertFuBen.do")
	public ModelAndView insertFuBen(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="name",defaultValue="") String name,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		int count = adminFuBenService.insertFuBen(gameId,name);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "添加成功");
		}else{
			modelAndView.addObject("message", "添加失败");
		}
		modelAndView.addObject("selectType", "fb");
		modelAndView.setViewName("admin/addFuBenResult");
		return modelAndView;

	}
	@RequestMapping("/updateFuBen.do")
	public ModelAndView updateFuBen(
			@RequestParam(value="gameid",defaultValue="") int gameId,
			@RequestParam(value="fbid",defaultValue="") int fbid,
			@RequestParam(value="name",defaultValue="") String name,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView  = new ModelAndView();
		int count = adminFuBenService.updateFuBen(fbid,name);
		System.out.println("count="+count);
		if(count==1){
			modelAndView.addObject("message", "修改成功");
		}else{
			modelAndView.addObject("message", "修改失败");
		}
		modelAndView.addObject("selectType", "fb");
		modelAndView.setViewName("admin/addFuBenResult");
		return modelAndView;

	}
	@RequestMapping("/selectFuBen.do")
	public ModelAndView selectFuBen(
			@RequestParam(value="fbid",defaultValue="") int fbid){
		ModelAndView modelAndView  = new ModelAndView();
		Map<String, Object> map =  adminFuBenService.selectFuBenContent(fbid);
		modelAndView.addObject("adminFuBen", map);
		modelAndView.addObject("selectType", "fb");
		modelAndView.setViewName("admin/fuBenContent");
		return modelAndView;
	}
}

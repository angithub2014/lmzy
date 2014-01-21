package com.lmzy.core.controller;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.core.dao.SelectAllDao;
import com.lmzy.core.service.DuiYuanService;
import com.lmzy.core.service.NewsService;
import com.lmzy.core.service.SelectAllService;
import com.lmzy.core.service.ShiPinService;
import com.lmzy.core.util.ModelAndViewUtil;

@Controller
@RequestMapping("/")
public class MssjIndexController {
	@Autowired
	ModelAndViewUtil modelAndViewUtil;
	@Autowired
	NewsService newsService;
	@Autowired
	SelectAllService selectAllService;
	@Autowired
	ShiPinService shiPinService;
	@Autowired
	DuiYuanService duiYuanService;

	@RequestMapping("/mssjIndex")
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView();
		List<Map<String, Object>> imgNewsList = newsService.selectImgNewsList(1, 0, 3);
//		List<Map<String, Object>> indexTeamList = selectAllService.selectTeamList(1, 0, 5);
		List<Map<String, Object>> indexTeam1List = selectAllService.selectAllTeam(1, "yuan");
		List<Map<String, Object>> indexTeam2List = selectAllService.selectAllTeam(1, "jin");
		List<Map<String, Object>> indexShiPinList = shiPinService.selectShiPinListByGameId(1, 0, 3);
		List<Map<String, Object>> indexDuiYuanTypeList = duiYuanService.selectDuiYuanTypeList(1, 0, 1);
		JSONObject jsonObject = JSONObject.fromObject(indexDuiYuanTypeList.get(0)) ;
		String indexDuiYuanType = jsonObject.getString("name");
		int i = jsonObject.getInt("id");
		List<Map<String, Object>> indexDuiYuanList = duiYuanService.selectDuiYuanList(1, i);

		modelAndView.addObject("gameId", 1);
		modelAndView.addObject("imgNewsList", imgNewsList);
		modelAndView.addObject("indexTeam1List", indexTeam1List);
		modelAndView.addObject("indexTeam2List", indexTeam2List);
		modelAndView.addObject("indexShiPinList", indexShiPinList);
		modelAndView.addObject("indexDuiYuanList", indexDuiYuanList);
		modelAndView.addObject("indexDuiYuanType", indexDuiYuanType);
		modelAndView.addObject("selectType", "index");
		modelAndView.setViewName("mssjIndex");
		return modelAndView;
	}

}

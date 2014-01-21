package com.lmzy.core.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.core.service.DuiYuanService;
import com.lmzy.core.service.ShiPinService;

@Controller
@RequestMapping("/mssj/duiYuan")
public class MssjDuiYuanController {
	@Autowired
	DuiYuanService duiYuanService;

	@RequestMapping("/selectDuiYuanList")
	public ModelAndView selectDuiYuanList(
			@RequestParam(value="gameId",defaultValue="1") int gameId,
			@RequestParam(value="nowPage",defaultValue="1") int nowPage){
		ModelAndView modelAndView  = new ModelAndView();
		int maxLine = 3;
		List<Map<String, Object>> list = duiYuanService.selectDuiYuanTypeList(gameId, (nowPage-1)*maxLine, maxLine);
		for(int i=0;i<list.size();i++){
			List<Map<String, Object>> duiYuanList = duiYuanService.selectDuiYuanList(1, Integer.parseInt(list.get(i).get("id").toString()));
			modelAndView.addObject("duiYuanList"+i, duiYuanList);
		}
		int count = duiYuanService.selectDuiYuanTypeCount(gameId);
		int totalPage = count%maxLine==0?(count/maxLine):(count/maxLine+1);
		modelAndView.addObject("duiYuanTypeList", list);
		modelAndView.addObject("totalPage", totalPage);
		modelAndView.addObject("nowPage", nowPage);
		modelAndView.addObject("selectType", "dy");
		modelAndView.setViewName("mssj/team/teamMore");
		return modelAndView;
	}

}

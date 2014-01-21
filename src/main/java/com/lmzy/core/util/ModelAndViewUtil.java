package com.lmzy.core.util;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.lmzy.core.dao.SelectAllDao;
import com.lmzy.core.service.BbsSelectService;
import com.lmzy.core.service.FuBenService;
import com.lmzy.core.service.SelectAllService;
import com.lmzy.core.service.ZhiYeService;
@Component
public class ModelAndViewUtil {
	@Autowired
	FuBenService fuBenService;
	@Autowired
	ZhiYeService zhiYeService;
	@Autowired
	BbsSelectService bbsSelectService;
	@Autowired
	SelectAllService selectAllService;
	@Autowired
	SelectAllDao selectAllDao;
	public ModelAndView getPublicModelAndView(ModelAndView modelAndView,int gameid){
		List<Map<String, Object>> fuBenListRight = fuBenService.selectFuBenListByGameId(gameid, 0, 5);
		List<Map<String, Object>> zhiYeListRight = zhiYeService.selectZhiYeListByGameId(gameid, 0, 5);
		List<Map<String, Object>> bbsListRight = bbsSelectService.selectBbsTopbicDigest();
		List<Map<String, Object>> recruitListRight = selectAllService.selectRecruitList(gameid, 0, 5);
		List<Map<String, Object>> friendShipList = selectAllDao.selectFriendShipList(1, 1);
		Map<String, Object> aboutUs = selectAllDao.selectAboutUs();
		modelAndView.addObject("bbsListRight", bbsListRight);
		modelAndView.addObject("recruitListRight", recruitListRight);
		modelAndView.addObject("fuBenListRight", fuBenListRight);
		modelAndView.addObject("zhiYeListRight", zhiYeListRight);
		modelAndView.addObject("publicFriendShipList", friendShipList);
		modelAndView.addObject("aboutUs", aboutUs);
		return modelAndView;
	}
}

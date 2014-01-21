package com.lmzy.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.core.dao.FuBenDao;
import com.lmzy.core.service.FuBenService;
@Service
public class FuBenServiceImpl implements FuBenService {
	@Autowired
	FuBenDao fuBenDao;
	@Override
	public List<Map<String, Object>> selectFuBen(int gameid) {
		return fuBenDao.selectFuBen(gameid);
	}
	@Override
	public List<Map<String, Object>> selectFuBenList(int gameid, int fuBenId,int start,int max) {
		return fuBenDao.selectFuBenList(gameid, fuBenId,start,max);
	}
	@Override
	public int selectFuBenCount(int gameid, int fuBenId) {
		return fuBenDao.selectFuBenCount(gameid, fuBenId);
	}
	@Override
	public Map<String, Object> selectFuBenContent(int fuBenId) {
		return fuBenDao.selectFuBenContent(fuBenId);
	}
	@Override
	public List<Map<String, Object>> selectFuBenListByGameId(int gameid,
			int start, int max) {
		// TODO Auto-generated method stub
		return fuBenDao.selectFuBenListByGameId(gameid, start, max);
	}
	@Override
	public int selectFuBenCountByGameId(int gameid) {
		// TODO Auto-generated method stub
		return fuBenDao.selectFuBenCountByGameId(gameid);
	}
	@Override
	public int updateFuBenTotal(int fuBenHelpId, int total) {
		// TODO Auto-generated method stub
		return fuBenDao.updateFuBenTotal(fuBenHelpId, total);
	}

}

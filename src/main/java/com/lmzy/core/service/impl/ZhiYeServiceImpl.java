package com.lmzy.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.core.dao.ZhiYeDao;
import com.lmzy.core.service.ZhiYeService;
@Service
public class ZhiYeServiceImpl implements ZhiYeService {
	@Autowired
	ZhiYeDao zhiYeDao;
	@Override
	public List<Map<String, Object>> selectZhiYe(int gameid) {
		return zhiYeDao.selectZhiYe(gameid);
	}
	@Override
	public List<Map<String, Object>> selectZhiYeList(int gameid, int zhiYeId,
			int start, int max) {
		// TODO Auto-generated method stub
		return zhiYeDao.selectZhiYeList(gameid, zhiYeId, start, max);
	}
	@Override
	public int selectZhiYeCount(int gameid, int zhiYeId) {
		// TODO Auto-generated method stub
		return zhiYeDao.selectZhiYeCount(gameid, zhiYeId);
	}
	@Override
	public Map<String, Object> selectZhiYeContent(int zhiYeId) {
		// TODO Auto-generated method stub
		return zhiYeDao.selectZhiYeContent(zhiYeId);
	}
	@Override
	public List<Map<String, Object>> selectZhiYeListByGameId(int gameid,
			int start, int max) {
		// TODO Auto-generated method stub
		return zhiYeDao.selectZhiYeListByGameId(gameid, start, max);
	}
	@Override
	public int selectZhiYeCountByGameId(int gameid) {
		// TODO Auto-generated method stub
		return zhiYeDao.selectZhiYeCountByGameId(gameid);
	}
	@Override
	public int updateZhiYeTotal(int zhiYeGuideId, int total) {
		// TODO Auto-generated method stub
		return zhiYeDao.updateZhiYeTotal(zhiYeGuideId, total);
	}

}

package com.lmzy.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.core.dao.ShiPinDao;
import com.lmzy.core.service.ShiPinService;
@Service
public class ShiPinServiceImpl implements ShiPinService {
	@Autowired
	ShiPinDao shiPinDao;
	@Override
	public List<Map<String, Object>> selectShiPinType(int gameid) {
		// TODO Auto-generated method stub
		return shiPinDao.selectShiPinType(gameid);
	}

	@Override
	public List<Map<String, Object>> selectShiPinList(int gameid, int sptypeId,
			int start, int max) {
		// TODO Auto-generated method stub
		return shiPinDao.selectShiPinList(gameid, sptypeId, start, max);
	}

	@Override
	public int selectShiPinCount(int gameid, int sptypeId) {
		// TODO Auto-generated method stub
		return shiPinDao.selectShiPinCount(gameid, sptypeId);
	}

	@Override
	public Map<String, Object> selectShiPinContent(int spId) {
		// TODO Auto-generated method stub
		return shiPinDao.selectShiPinContent(spId);
	}

	@Override
	public List<Map<String, Object>> selectShiPinListByGameId(int gameid,
			int start, int max) {
		// TODO Auto-generated method stub
		return shiPinDao.selectShiPinListByGameId(gameid, start, max);
	}

	@Override
	public int selectShiPinCountByGameId(int gameid) {
		// TODO Auto-generated method stub
		return shiPinDao.selectShiPinCountByGameId(gameid);
	}

	@Override
	public int updateShiPinTotal(int spId, int total) {
		// TODO Auto-generated method stub
		return shiPinDao.updateShiPinTotal(spId, total);
	}

}

package com.lmzy.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.core.dao.DuiYuanDao;
import com.lmzy.core.service.DuiYuanService;
@Service
public class DuiYuanServiceImpl implements DuiYuanService {
	@Autowired
	DuiYuanDao duiYuanDao;
	@Override
	public List<Map<String, Object>> selectDuiYuanTypeList(int gameid,
			int start, int max) {
		// TODO Auto-generated method stub
		return duiYuanDao.selectDuiYuanTypeList(gameid, start, max);
	}

	@Override
	public List<Map<String, Object>> selectDuiYuanList(int gameid, int dytypeid) {
		// TODO Auto-generated method stub
		return duiYuanDao.selectDuiYuanList(gameid, dytypeid);
	}

	@Override
	public int selectDuiYuanTypeCount(int gameid) {
		// TODO Auto-generated method stub
		return duiYuanDao.selectDuiYuanTypeCount(gameid);
	}

	@Override
	public Map<String, Object> selectDuiYuanContent(int dyid) {
		// TODO Auto-generated method stub
		return duiYuanDao.selectDuiYuanContent(dyid);
	}

}

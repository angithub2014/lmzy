package com.lmzy.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.admin.dao.AdminZhiYeDao;
import com.lmzy.admin.po.AdminOccupationGuide;
import com.lmzy.admin.service.AdminZhiYeService;
@Service
public class AdminZhiYeServiceImpl implements AdminZhiYeService {
	@Autowired
	AdminZhiYeDao adminZhiYeDao;
	@Override
	public List<Map<String, Object>> selectZhiYeHelpList(int gameid, int zyid,
			int state, String startTime, String endTime, int start, int max,
			String orderBy) {
		// TODO Auto-generated method stub
		return adminZhiYeDao.selectZhiYeHelpList(gameid, zyid, state, startTime, endTime, start, max, orderBy);
	}

	@Override
	public int selectZhiYeHelpCount(int gameid, int zyid, int state) {
		// TODO Auto-generated method stub
		return adminZhiYeDao.selectZhiYeHelpCount(gameid, zyid, state);
	}

	@Override
	public Map<String, Object> selectZhiYeHelpContent(int zyhelpid) {
		// TODO Auto-generated method stub
		return adminZhiYeDao.selectZhiYeHelpContent(zyhelpid);
	}

	@Override
	public int insertZhiYeHelp(AdminOccupationGuide zy) {
		// TODO Auto-generated method stub
		return adminZhiYeDao.insertZhiYeHelp(zy);
	}

	@Override
	public int updateZhiYeHelp(AdminOccupationGuide zy) {
		// TODO Auto-generated method stub
		return adminZhiYeDao.updateZhiYeHelp(zy);
	}

	@Override
	public int deleteZhiYeHelp(int zyhelpid) {
		// TODO Auto-generated method stub
		return adminZhiYeDao.deleteZhiYeHelp(zyhelpid);
	}

	@Override
	public int updateZhiYeHelpState(int zyhelpid, int state) {
		// TODO Auto-generated method stub
		return adminZhiYeDao.updateZhiYeHelpState(zyhelpid, state);
	}

	@Override
	public List<Map<String, Object>> selectZhiYeList(int gameid, int start,
			int max) {
		// TODO Auto-generated method stub
		return adminZhiYeDao.selectZhiYeList(gameid, start, max);
	}

	@Override
	public int selectZhiYeCount(int gameid) {
		// TODO Auto-generated method stub
		return adminZhiYeDao.selectZhiYeCount(gameid);
	}

	@Override
	public Map<String, Object> selectZhiYeContent(int zyid) {
		// TODO Auto-generated method stub
		return adminZhiYeDao.selectZhiYeContent(zyid);
	}

	@Override
	public int insertZhiYe(int gameid, String zyname) {
		// TODO Auto-generated method stub
		return adminZhiYeDao.insertZhiYe(gameid, zyname);
	}

	@Override
	public int updateZhiYe(int zyid, String zyname) {
		// TODO Auto-generated method stub
		return adminZhiYeDao.updateZhiYe(zyid, zyname);
	}

}

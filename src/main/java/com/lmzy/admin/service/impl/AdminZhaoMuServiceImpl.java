package com.lmzy.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.admin.dao.AdminZhaoMuDao;
import com.lmzy.admin.po.AdminRecruit;
import com.lmzy.admin.service.AdminZhaoMuService;
@Service
public class AdminZhaoMuServiceImpl implements AdminZhaoMuService {
	@Autowired
	AdminZhaoMuDao adminZhaoMuDao;
	@Override
	public List<Map<String, Object>> selectZhaoMuList(int gameid, int state,
			String startTime, String endTime, int start, int max, String orderBy) {
		// TODO Auto-generated method stub
		return adminZhaoMuDao.selectZhaoMuList(gameid, state, startTime, endTime, start, max, orderBy);
	}

	@Override
	public int selectZhaoMuCount(int gameid, int state) {
		// TODO Auto-generated method stub
		return adminZhaoMuDao.selectZhaoMuCount(gameid, state);
	}

	@Override
	public Map<String, Object> selectZhaoMuContent(int zhaomuid) {
		// TODO Auto-generated method stub
		return adminZhaoMuDao.selectZhaoMuContent(zhaomuid);
	}

	@Override
	public int insertZhaoMu(AdminRecruit zhaomu) {
		// TODO Auto-generated method stub
		return adminZhaoMuDao.insertZhaoMu(zhaomu);
	}

	@Override
	public int updateZhaoMu(AdminRecruit zhaomu) {
		// TODO Auto-generated method stub
		return adminZhaoMuDao.updateZhaoMu(zhaomu);
	}

	@Override
	public int deleteZhaoMu(int zhaomuid) {
		// TODO Auto-generated method stub
		return adminZhaoMuDao.deleteZhaoMu(zhaomuid);
	}

	@Override
	public int updateZhaoMuState(int zhaomuid, int state) {
		// TODO Auto-generated method stub
		return adminZhaoMuDao.updateZhaoMuState(zhaomuid, state);
	}

}

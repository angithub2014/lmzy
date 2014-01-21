package com.lmzy.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.admin.dao.AdminFuBenDao;
import com.lmzy.admin.po.AdminFb;
import com.lmzy.admin.po.AdminFbHelp;
import com.lmzy.admin.service.AdminFuBenService;
@Service
public class AdminFuBenServiceImpl implements AdminFuBenService {
	@Autowired
	AdminFuBenDao adminFuBenDao;
	@Override
	public List<Map<String, Object>> selectFuBenHelpList(int gameid, int fbid,
			int state, String startTime, String endTime, int start, int max,
			String orderBy) {
		// TODO Auto-generated method stub
		return adminFuBenDao.selectFuBenHelpList(gameid, fbid, state, startTime, endTime, start, max, orderBy);
	}

	@Override
	public int selectFuBenHelpCount(int gameid, int fbid, int state) {
		// TODO Auto-generated method stub
		return adminFuBenDao.selectFuBenHelpCount(gameid, fbid, state);
	}

	@Override
	public Map<String, Object> selectFuBenHelpContent(int fbhelpid) {
		// TODO Auto-generated method stub
		return adminFuBenDao.selectFuBenHelpContent(fbhelpid);
	}

	@Override
	public int insertFuBenHelp(AdminFbHelp fb) {
		// TODO Auto-generated method stub
		return adminFuBenDao.insertFuBenHelp(fb);
	}

	@Override
	public int updateFuBenHelp(AdminFbHelp fb) {
		// TODO Auto-generated method stub
		return adminFuBenDao.updateFuBenHelp(fb);
	}

	@Override
	public int deleteFuBenHelp(int fbhelpid) {
		// TODO Auto-generated method stub
		return adminFuBenDao.deleteFuBenHelp(fbhelpid);
	}

	@Override
	public int updateFuBenHelpState(int fbhelpid, int state) {
		// TODO Auto-generated method stub
		return adminFuBenDao.updateFuBenHelpState(fbhelpid, state);
	}

	@Override
	public List<Map<String, Object>> selectFuBenList(int gameid, int start,
			int max) {
		// TODO Auto-generated method stub
		return adminFuBenDao.selectFuBenList(gameid, start, max);
	}

	@Override
	public int selectFuBenCount(int gameid) {
		// TODO Auto-generated method stub
		return adminFuBenDao.selectFuBenCount(gameid);
	}

	@Override
	public Map<String, Object> selectFuBenContent(int fbid) {
		// TODO Auto-generated method stub
		return adminFuBenDao.selectFuBenContent(fbid);
	}

	@Override
	public int insertFuBen(int gameid, String fbname) {
		// TODO Auto-generated method stub
		return adminFuBenDao.insertFuBen(gameid, fbname);
	}

	@Override
	public int updateFuBen(int fbid, String fbname) {
		// TODO Auto-generated method stub
		return adminFuBenDao.updateFuBen(fbid, fbname);
	}

}

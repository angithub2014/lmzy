package com.lmzy.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.admin.dao.AdminShiPinDao;
import com.lmzy.admin.po.AdminVideo;
import com.lmzy.admin.service.AdminShiPinService;
@Service
public class AdminShiPinServiceImpl implements AdminShiPinService {
	@Autowired
	AdminShiPinDao adminShiPinDao;
	@Override
	public List<Map<String, Object>> selectShiPinList(int gameid, int sptypeid,
			int state, String startTime, String endTime, int start, int max,
			String orderBy) {
		// TODO Auto-generated method stub
		return adminShiPinDao.selectShiPinList(gameid, sptypeid, state, startTime, endTime, start, max, orderBy);
	}

	@Override
	public int selectShiPinCount(int gameid, int sptypeid, int state) {
		// TODO Auto-generated method stub
		return adminShiPinDao.selectShiPinCount(gameid, sptypeid, state);
	}

	@Override
	public Map<String, Object> selectShiPinContent(int spid) {
		// TODO Auto-generated method stub
		return adminShiPinDao.selectShiPinContent(spid);
	}

	@Override
	public int insertShiPin(AdminVideo sp) {
		// TODO Auto-generated method stub
		return adminShiPinDao.insertShiPin(sp);
	}

	@Override
	public int updateShiPin(AdminVideo sp) {
		// TODO Auto-generated method stub
		return adminShiPinDao.updateShiPin(sp);
	}

	@Override
	public int deleteShiPin(int spid) {
		// TODO Auto-generated method stub
		return adminShiPinDao.deleteShiPin(spid);
	}

	@Override
	public int updateShiPinState(int spid, int state) {
		// TODO Auto-generated method stub
		return adminShiPinDao.updateShiPinState(spid, state);
	}

	@Override
	public List<Map<String, Object>> selectShiPinTypeList(int gameid,
			int start, int max) {
		// TODO Auto-generated method stub
		return adminShiPinDao.selectShiPinTypeList(gameid, start, max);
	}

	@Override
	public int selectShiPinTypeCount(int gameid) {
		// TODO Auto-generated method stub
		return adminShiPinDao.selectShiPinTypeCount(gameid);
	}

	@Override
	public Map<String, Object> selectShiPinTypeContent(int sptypeid) {
		// TODO Auto-generated method stub
		return adminShiPinDao.selectShiPinTypeContent(sptypeid);
	}

	@Override
	public int insertShiPinType(int gameid, String sptypename) {
		// TODO Auto-generated method stub
		return adminShiPinDao.insertShiPinType(gameid, sptypename);
	}

	@Override
	public int updateShiPinType(int sptypeid, String sptypename) {
		// TODO Auto-generated method stub
		return adminShiPinDao.updateShiPinType(sptypeid, sptypename);
	}

}

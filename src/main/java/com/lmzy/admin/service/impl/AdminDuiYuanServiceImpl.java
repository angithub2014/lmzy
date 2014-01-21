package com.lmzy.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.admin.dao.AdminDuiYuanDao;
import com.lmzy.admin.po.AdminDuiYuan;
import com.lmzy.admin.service.AdminDuiYuanService;
@Service
public class AdminDuiYuanServiceImpl implements AdminDuiYuanService {
	@Autowired
	AdminDuiYuanDao adminDuiYuanDao;
	@Override
	public List<Map<String, Object>> selectDuiYuanList(int gameid,
			int dytypeid, int state, String startTime, String endTime,
			int start, int max, String orderBy) {
		// TODO Auto-generated method stub
		return adminDuiYuanDao.selectDuiYuanList(gameid, dytypeid, state, startTime, endTime, start, max, orderBy);
	}

	@Override
	public int selectDuiYuanCount(int gameid, int dytypeid, int state) {
		// TODO Auto-generated method stub
		return adminDuiYuanDao.selectDuiYuanCount(gameid, dytypeid, state);
	}

	@Override
	public Map<String, Object> selectDuiYuanContent(int dyid) {
		// TODO Auto-generated method stub
		return adminDuiYuanDao.selectDuiYuanContent(dyid);
	}

	@Override
	public int insertDuiYuan(AdminDuiYuan dy) {
		// TODO Auto-generated method stub
		return adminDuiYuanDao.insertDuiYuan(dy);
	}

	@Override
	public int updateDuiYuan(AdminDuiYuan dy) {
		// TODO Auto-generated method stub
		return adminDuiYuanDao.updateDuiYuan(dy);
	}

	@Override
	public int deleteDuiYuan(int dyid) {
		// TODO Auto-generated method stub
		return adminDuiYuanDao.deleteDuiYuan(dyid);
	}

	@Override
	public int updateDuiYuanState(int dyid, int state) {
		// TODO Auto-generated method stub
		return adminDuiYuanDao.updateDuiYuanState(dyid, state);
	}

	@Override
	public List<Map<String, Object>> selectDuiYuanTypeList(int gameid,
			int start, int max) {
		// TODO Auto-generated method stub
		return adminDuiYuanDao.selectDuiYuanTypeList(gameid, start, max);
	}

	@Override
	public int selectDuiYuanTypeCount(int gameid) {
		// TODO Auto-generated method stub
		return adminDuiYuanDao.selectDuiYuanTypeCount(gameid);
	}

	@Override
	public Map<String, Object> selectDuiYuanTypeContent(int dytypeid) {
		// TODO Auto-generated method stub
		return adminDuiYuanDao.selectDuiYuanTypeContent(dytypeid);
	}

	@Override
	public int insertDuiYuanType(int gameid, String dytypename) {
		// TODO Auto-generated method stub
		return adminDuiYuanDao.insertDuiYuanType(gameid, dytypename);
	}

	@Override
	public int updateDuiYuanType(int dytypeid, String dytypename) {
		// TODO Auto-generated method stub
		return adminDuiYuanDao.updateDuiYuanType(dytypeid, dytypename);
	}

}

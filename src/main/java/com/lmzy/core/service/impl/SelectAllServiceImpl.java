package com.lmzy.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.core.dao.SelectAllDao;
import com.lmzy.core.service.SelectAllService;
@Service
public class SelectAllServiceImpl implements SelectAllService {
	@Autowired
	SelectAllDao selectAllDao;
	@Override
	public List<Map<String, Object>> selectTeamList(int gameid, int start,
			int max) {
		// TODO Auto-generated method stub
		return selectAllDao.selectTeamList(gameid, start, max);
	}

	@Override
	public int selectTeamCount(int gameid) {
		// TODO Auto-generated method stub
		return selectAllDao.selectTeamCount(gameid);
	}

	@Override
	public Map<String, Object> selectTeamContent(int teamId) {
		// TODO Auto-generated method stub
		return selectAllDao.selectTeamContent(teamId);
	}

	@Override
	public List<Map<String, Object>> selectRecruitList(int gameid, int start,
			int max) {
		// TODO Auto-generated method stub
		return selectAllDao.selectRecruitList(gameid, start, max);
	}

	@Override
	public int selectRecruitCount(int gameid) {
		// TODO Auto-generated method stub
		return selectAllDao.selectRecruitCount(gameid);
	}

	@Override
	public Map<String, Object> selectRecruitContent(int recruiId) {
		// TODO Auto-generated method stub
		return selectAllDao.selectRecruitContent(recruiId);
	}

	@Override
	public int updateTeamTotal(int teamId, int total) {
		// TODO Auto-generated method stub
		return selectAllDao.updateTeamTotal(teamId, total);
	}

	@Override
	public int updateRecruitTotal(int recruitId, int total) {
		// TODO Auto-generated method stub
		return selectAllDao.updateRecruitTotal(recruitId, total);
	}

	@Override
	public List<Map<String, Object>> selectAllTeam(int gameid, String teamtype) {
		// TODO Auto-generated method stub
		return selectAllDao.selectAllTeam(gameid, teamtype);
	}

}

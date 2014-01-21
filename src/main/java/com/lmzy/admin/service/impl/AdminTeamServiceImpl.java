package com.lmzy.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.admin.service.AdminTeamService;
import com.lmzy.admin.dao.AdminTeamDao;
import com.lmzy.admin.po.AdminTeam;
@Service
public class AdminTeamServiceImpl implements AdminTeamService {
	@Autowired
	AdminTeamDao adminTeamDao;
	@Override
	public List<Map<String, Object>> selectTeamList(int gameid, int state,
			String teamtype,int start, int max) {
		// TODO Auto-generated method stub
		return adminTeamDao.selectTeamList(gameid, state,teamtype , start, max);
	}

	@Override
	public int selectTeamCount(int gameid, int state,String teamtype) {
		// TODO Auto-generated method stub
		return adminTeamDao.selectTeamCount(gameid, state,teamtype);
	}

	@Override
	public Map<String, Object> selectTeamContent(int teamId) {
		// TODO Auto-generated method stub
		return adminTeamDao.selectTeamContent(teamId);
	}

	@Override
	public int insertTeam(AdminTeam team) {
		// TODO Auto-generated method stub
		return adminTeamDao.insertTeam(team);
	}

	@Override
	public int updateTeam(AdminTeam team) {
		// TODO Auto-generated method stub
		return adminTeamDao.updateTeam(team);
	}

	@Override
	public int deleteTeam(int teamId) {
		// TODO Auto-generated method stub
		return adminTeamDao.deleteTeam(teamId);
	}

	@Override
	public int updateTeamState(int teamid, int state) {
		// TODO Auto-generated method stub
		return adminTeamDao.updateTeamState(teamid, state);
	}

}

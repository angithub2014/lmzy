package com.lmzy.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lmzy.admin.po.AdminTeam;
@Service
public interface AdminTeamService {
	public List<Map<String, Object>> selectTeamList(int gameid,int state,String teamtype,int start,int max);
	public int selectTeamCount(int gameid,int state,String teamtype);
	public Map<String, Object> selectTeamContent(int teamId);
	public int insertTeam(AdminTeam team);
	public int updateTeam(AdminTeam team);
	public int deleteTeam(int teamId);
	public int updateTeamState(int teamid,int state);


}

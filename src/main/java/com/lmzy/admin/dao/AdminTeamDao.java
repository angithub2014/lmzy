package com.lmzy.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lmzy.admin.po.AdminTeam;

@Repository
public interface AdminTeamDao {
	public List<Map<String, Object>> selectTeamList(int gameid,int state,String teamtype,int start,int max);
	public int selectTeamCount(int gameid,int state,String teamtype);
	public Map<String, Object> selectTeamContent(int teamId);
	public int insertTeam(AdminTeam team);
	public int updateTeam(AdminTeam team);
	public int deleteTeam(int teamId);
	public int updateTeamState(int teamid,int state);

}

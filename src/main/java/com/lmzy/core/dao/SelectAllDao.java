package com.lmzy.core.dao;

import java.util.List;
import java.util.Map;

public interface SelectAllDao {
	public List<Map<String, Object>> selectTeamList(int gameid,int start,int max);
	public int selectTeamCount(int gameid);
	public int updateTeamTotal(int teamId,int total);
	public Map<String, Object> selectTeamContent(int teamId);
	public List<Map<String, Object>> selectRecruitList(int gameid,int start,int max);
	public int selectRecruitCount(int gameid);
	public int updateRecruitTotal(int recruitId,int total);
	public Map<String, Object> selectRecruitContent(int recruitId);
	public List<Map<String, Object>> selectAllTeam(int gameid,String teamtype);

	public List<Map<String, Object>> selectFriendShipList(int gameid,int state);
	public Map<String, Object> selectAboutUs();

}

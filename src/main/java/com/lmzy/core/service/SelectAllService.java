package com.lmzy.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public interface SelectAllService {
	public List<Map<String, Object>> selectTeamList(int gameid,int start,int max);
	public int selectTeamCount(int gameid);
	public Map<String, Object> selectTeamContent(int teamId);
	public List<Map<String, Object>> selectRecruitList(int gameid,int start,int max);
	public int selectRecruitCount(int gameid);
	public Map<String, Object> selectRecruitContent(int recruitId);
	public int updateTeamTotal(int teamId,int total);
	public int updateRecruitTotal(int recruitId,int total);
	public List<Map<String, Object>> selectAllTeam(int gameid,String teamtype);



}

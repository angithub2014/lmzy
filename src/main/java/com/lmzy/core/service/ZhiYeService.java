package com.lmzy.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public interface ZhiYeService {
	public List<Map<String, Object>> selectZhiYe(int gameid);
	public List<Map<String, Object>> selectZhiYeList(int gameid,int zhiYeId,int start,int max);
	public int selectZhiYeCount(int gameid,int zhiYeId);
	public Map<String, Object> selectZhiYeContent(int zhiYeId);
	public List<Map<String, Object>> selectZhiYeListByGameId(int gameid,int start,int max);
	public int selectZhiYeCountByGameId(int gameid);
	public int updateZhiYeTotal(int zhiYeGuideId,int total);
}

package com.lmzy.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lmzy.admin.po.AdminOccupationGuide;
@Service
public interface AdminZhiYeService {
	public List<Map<String, Object>> selectZhiYeHelpList(int gameid,int zyid,int state,String startTime,String endTime,int start,int max,String orderBy);
	public int selectZhiYeHelpCount(int gameid,int zyid,int state);
	public Map<String, Object> selectZhiYeHelpContent(int zyhelpid);
	public int insertZhiYeHelp(AdminOccupationGuide zy);
	public int updateZhiYeHelp(AdminOccupationGuide zy);
	public int deleteZhiYeHelp(int zyhelpid);
	public int updateZhiYeHelpState(int zyhelpid,int state);
	
	public List<Map<String, Object>> selectZhiYeList(int gameid,int start,int max);
	public int selectZhiYeCount(int gameid);
	public Map<String, Object> selectZhiYeContent(int zyid);
	public int insertZhiYe(int gameid,String zyname);
	public int updateZhiYe(int zyid,String zyname);
}

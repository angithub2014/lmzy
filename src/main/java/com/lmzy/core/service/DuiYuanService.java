package com.lmzy.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface DuiYuanService {
	public List<Map<String, Object>> selectDuiYuanTypeList(int gameid,int start,int max);
	public List<Map<String, Object>> selectDuiYuanList(int gameid,int dytypeid);
	public int selectDuiYuanTypeCount(int gameid);
	public Map<String, Object> selectDuiYuanContent(int dyid);

}

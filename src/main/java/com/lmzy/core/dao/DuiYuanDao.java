package com.lmzy.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public interface DuiYuanDao {
	public List<Map<String, Object>> selectDuiYuanTypeList(int gameid,int start,int max);
	public List<Map<String, Object>> selectDuiYuanList(int gameid,int dytypeid);
	public int selectDuiYuanTypeCount(int gameid);
	public Map<String, Object> selectDuiYuanContent(int dyid);

}

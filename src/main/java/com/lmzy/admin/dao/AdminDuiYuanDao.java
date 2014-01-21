package com.lmzy.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lmzy.admin.po.AdminDuiYuan;
@Repository
public interface AdminDuiYuanDao {
	public List<Map<String, Object>> selectDuiYuanList(int gameid,int dytypeid,int state,String startTime,String endTime,int start,int max,String orderBy);
	public int selectDuiYuanCount(int gameid,int dytypeid,int state);
	public Map<String, Object> selectDuiYuanContent(int dyid);
	public int insertDuiYuan(AdminDuiYuan dy);
	public int updateDuiYuan(AdminDuiYuan dy);
	public int deleteDuiYuan(int dyid);
	public int updateDuiYuanState(int dyid,int state);
	
	public List<Map<String, Object>> selectDuiYuanTypeList(int gameid,int start,int max);
	public int selectDuiYuanTypeCount(int gameid);
	public Map<String, Object> selectDuiYuanTypeContent(int dytypeid);
	public int insertDuiYuanType(int gameid,String dytypename);
	public int updateDuiYuanType(int dytypeid,String dytypename);

}

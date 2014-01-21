package com.lmzy.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lmzy.admin.po.AdminVideo;
@Repository
public interface AdminShiPinDao {
	public List<Map<String, Object>> selectShiPinList(int gameid,int sptypeid,int state,String startTime,String endTime,int start,int max,String orderBy);
	public int selectShiPinCount(int gameid,int sptypeid,int state);
	public Map<String, Object> selectShiPinContent(int spid);
	public int insertShiPin(AdminVideo sp);
	public int updateShiPin(AdminVideo sp);
	public int deleteShiPin(int spid);
	public int updateShiPinState(int spid,int state);
	
	public List<Map<String, Object>> selectShiPinTypeList(int gameid,int start,int max);
	public int selectShiPinTypeCount(int gameid);
	public Map<String, Object> selectShiPinTypeContent(int sptypeid);
	public int insertShiPinType(int gameid,String sptypename);
	public int updateShiPinType(int sptypeid,String sptypename);

}

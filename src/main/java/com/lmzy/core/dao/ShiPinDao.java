package com.lmzy.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public interface ShiPinDao {
	public List<Map<String, Object>> selectShiPinType(int gameid);
	public List<Map<String, Object>> selectShiPinList(int gameid,int sptypeId,int start,int max);
	public int selectShiPinCount(int gameid,int sptypeId);
	public Map<String, Object> selectShiPinContent(int spId);
	public List<Map<String, Object>> selectShiPinListByGameId(int gameid,int start,int max);
	public int selectShiPinCountByGameId(int gameid);
	public int updateShiPinTotal(int spId,int total);

}

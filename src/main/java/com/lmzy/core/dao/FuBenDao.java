package com.lmzy.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface FuBenDao {
	/**
	 * @param gameid
	 * @return
	 */
	public List<Map<String, Object>> selectFuBen(int gameid);
	public List<Map<String, Object>> selectFuBenList(int gameid,int fuBenId,int start,int max);
	public int selectFuBenCount(int gameid,int fuBenId);
	public Map<String, Object> selectFuBenContent(int fuBenId);
	public List<Map<String, Object>> selectFuBenListByGameId(int gameid,int start,int max);
	public int selectFuBenCountByGameId(int gameid);
	public int updateFuBenTotal(int fuBenHelpId,int total);
}

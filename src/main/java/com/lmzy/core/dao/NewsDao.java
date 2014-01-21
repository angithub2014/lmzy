package com.lmzy.core.dao;

import java.util.List;
import java.util.Map;

public interface NewsDao {
	public List<Map<String, Object>> selectNewsList(int gameid,int newstypeid,int start,int max);
	public int selectNewsCount(int gameid,int newstypeid);
	public Map<String, Object> selectNewsContent(int newsId);
	public int updateNewsTotal(int newsId,int total);
	public List<Map<String, Object>> selectImgNewsList(int gameid,int start,int max);
}

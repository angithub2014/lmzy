package com.lmzy.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lmzy.admin.po.AdminNews;

@Repository
public interface AdminNewsDao {
	public List<Map<String, Object>> selectNewsList(int gameid,int newstypeid,int state,String startTime,String endTime,int start,int max,String orderBy);
	public int selectNewsCount(int gameid,int newstypeid,int state);
	public Map<String, Object> selectNewsContent(int newsId);
	public int insertNews(AdminNews news);
	public int updateNews(AdminNews news);
	public int deleteNews(int newsId);
	public int updateNewsState(int newsid,int state);

	
	public List<Map<String, Object>> selectNewsTypeList(int gameid,int start,int max);
	public int selectNewsTypeCount(int gameid);
	public Map<String, Object> selectNewsTypeContent(int newstypeid);
	public int insertNewsType(int gameid,String newstypename);
	public int updateNewsType(int sptypeid,String newstypename);

}

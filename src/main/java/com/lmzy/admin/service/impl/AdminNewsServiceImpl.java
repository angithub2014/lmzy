package com.lmzy.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.admin.service.AdminNewsService;
import com.lmzy.admin.dao.AdminNewsDao;
import com.lmzy.admin.po.AdminNews;
@Service
public class AdminNewsServiceImpl implements AdminNewsService {
	@Autowired
	AdminNewsDao adminNewsDao;
	@Override
	public List<Map<String, Object>> selectNewsList(int gameid,int newstypeid, int state,
			String startTime, String endTime, int start, int max, String orderBy) {
		// TODO Auto-generated method stub
		return adminNewsDao.selectNewsList(gameid,newstypeid, state, startTime, endTime, start, max, orderBy);
	}

	@Override
	public int selectNewsCount(int gameid,int newstypeid, int state) {
		// TODO Auto-generated method stub
		return adminNewsDao.selectNewsCount(gameid,newstypeid, state);
	}

	@Override
	public Map<String, Object> selectNewsContent(int newsId) {
		// TODO Auto-generated method stub
		return adminNewsDao.selectNewsContent(newsId);
	}

	@Override
	public int insertNews(AdminNews news) {
		// TODO Auto-generated method stub
		return adminNewsDao.insertNews(news);
	}

	@Override
	public int updateNews(AdminNews news) {
		// TODO Auto-generated method stub
		return adminNewsDao.updateNews(news);
	}

	@Override
	public int deleteNews(int newsId) {
		// TODO Auto-generated method stub
		return adminNewsDao.deleteNews(newsId);
	}

	@Override
	public int updateNewsState(int newsid, int state) {
		// TODO Auto-generated method stub
		return adminNewsDao.updateNewsState(newsid, state);
	}

	@Override
	public List<Map<String, Object>> selectNewsTypeList(int gameid, int start,
			int max) {
		// TODO Auto-generated method stub
		return adminNewsDao.selectNewsTypeList(gameid, start, max);
	}

	@Override
	public int selectNewsTypeCount(int gameid) {
		// TODO Auto-generated method stub
		return adminNewsDao.selectNewsTypeCount(gameid);
	}

	@Override
	public Map<String, Object> selectNewsTypeContent(int newstypeid) {
		// TODO Auto-generated method stub
		return adminNewsDao.selectNewsTypeContent(newstypeid);
	}

	@Override
	public int insertNewsType(int gameid, String newstypename) {
		// TODO Auto-generated method stub
		return adminNewsDao.insertNewsType(gameid, newstypename);
	}

	@Override
	public int updateNewsType(int sptypeid, String newstypename) {
		// TODO Auto-generated method stub
		return adminNewsDao.updateNewsType(sptypeid, newstypename);
	}

}

package com.lmzy.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.core.dao.NewsDao;
import com.lmzy.core.service.NewsService;
@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	NewsDao newsDao;

	@Override
	public List<Map<String, Object>> selectNewsList(int gameid,int newstypeid,
			int start, int max) {
		// TODO Auto-generated method stub
		return newsDao.selectNewsList(gameid,newstypeid, start, max);
	}

	@Override
	public int selectNewsCount(int gameid,int newstypeid) {
		// TODO Auto-generated method stub
		return newsDao.selectNewsCount(gameid,newstypeid);
	}

	@Override
	public Map<String, Object> selectNewsContent(int newsId) {
		// TODO Auto-generated method stub
		return newsDao.selectNewsContent(newsId);
	}

	@Override
	public int updateNewsTotal(int newsId, int total) {
		// TODO Auto-generated method stub
		return newsDao.updateNewsTotal(newsId, total);
	}

	@Override
	public List<Map<String, Object>> selectImgNewsList(int gameid, int start,
			int max) {
		// TODO Auto-generated method stub
		return newsDao.selectImgNewsList(gameid, start, max);
	}


}

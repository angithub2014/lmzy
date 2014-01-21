package com.lmzy.core.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.core.dao.NewsDao;
@Repository
public class NewsDaoImpl implements NewsDao {
	Logger logger = Logger.getLogger(NewsDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectNewsList(int gameid,int newstypeid,
			int start, int max) {
		if(newstypeid==0){
			String sql = "select * from lmzy.news where gameid=? and state=1 order by createtime desc  limit ?,? ";
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
			return list;
		}else{
			String sql = "select * from lmzy.news where gameid=? and newstypeid=? and state=1 order by createtime desc  limit ?,? ";
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,newstypeid,start,max});
			return list;
		}

		
	}
	@Override
	public int selectNewsCount(int gameid,int newstypeid) {
		if(newstypeid==0){
			String sql = "select count(*) from lmzy.news where gameid=? and state=1";
			int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
			return count;
		}else{
			String sql = "select count(*) from lmzy.news where gameid=? and newstypeid= ? and state=1";
			int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,newstypeid});
			return count;
		}
	}
	@Override
	public Map<String, Object> selectNewsContent(int newsId) {
		String sql = "select * from lmzy.news where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{newsId});
		return map;
	}
	@Override
	public int updateNewsTotal(int newsId, int total) {
		String sql = "update lmzy.news set total = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{total,newsId});
		return count;
	}
	@Override
	public List<Map<String, Object>> selectImgNewsList(int gameid, int start,
			int max) {
		String sql = "select * from lmzy.news where gameid=? and state=1 and newstypeid=1 and LENGTH(imgurl)>0 order by createtime desc limit ?,? ";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});

		return list;
	}
	

}

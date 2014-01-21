package com.lmzy.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.admin.dao.AdminNewsDao;
import com.lmzy.admin.po.AdminNews;
import com.lmzy.core.dao.impl.NewsDaoImpl;
import com.lmzy.core.util.DateUtil;
@Repository
public class AdminNewsDaoImpl implements AdminNewsDao {
	Logger logger = Logger.getLogger(NewsDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectNewsList(int gameid,int newstypeid, int state,
			String startTime, String endTime, int start, int max, String orderBy) {
		System.out.println("start:"+start+",max:"+max);
//		String sql = "select n.* from  (select * from lmzy.news where createtime between ? and ?) as n where n.gameid=? and n.state=? order by n.createtime desc  limit ?,?";
//		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{startTime,endTime,gameid,state,start,max});
		if(state==2){
			if(newstypeid==0){
				String sql = "select * from lmzy.news where gameid=? order by createtime desc limit ?,? ";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
				return list;
			}else{
				String sql = "select * from lmzy.news where gameid=? and newstypeid = ? order by createtime desc  limit ?,? ";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,newstypeid,start,max});
				return list;
			}
			
		}else{
			if(newstypeid==0){
				String sql = "select * from lmzy.news where gameid=? and state=? order by createtime desc  limit ?,? ";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,state,start,max});
				return list;
			}else{
				String sql = "select * from lmzy.news where gameid=? and newstypeid = ? and state=? order by createtime desc  limit ?,? ";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,newstypeid,state,start,max});
				return list;
			}
			
		}

		
	}

	@Override
	public int selectNewsCount(int gameid, int newstypeid,int state) {
		if(state==2){
			if(newstypeid==0){
				String sql = "select count(*) from lmzy.news where gameid=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
				return count;
			}else{
				String sql = "select count(*) from lmzy.news where gameid=? and newstypeid=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,newstypeid});
				return count;
			}
			

		}else{
			if(newstypeid==0){
				String sql = "select count(*) from lmzy.news where gameid=? and state=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,state});
				return count;
			}else{
				String sql = "select count(*) from lmzy.news where gameid=? and newstypeid = ? and state=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,newstypeid,state});
				return count;
			}
			

		}
	}

	@Override
	public Map<String, Object> selectNewsContent(int newsId) {
		String sql = "select * from lmzy.news where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{newsId});
		return map;
	}

	@Override
	public int insertNews(AdminNews news) {
		String sql = "insert into lmzy.news (gameid,newstypeid,title,source,author,content,state,createtime,imgurl) values (?,?,?,?,?,?,?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[]{news.getGameId(),news.getNewstypeid(),news.getTitle(),news.getSource(),news.getAuthor(),news.getContent(),news.getState(),news.getCreateTime(),news.getImgurl()});
		return count;

	}

	@Override
	public int updateNews(AdminNews news) {
		// TODO Auto-generated method stub
		if(news.getImgurl()!=null&&!"".equals(news.getImgurl())){
			String sql = "update lmzy.news set title=?,source=?,author=?,content=?,imgurl=? where id=?";
			int count = jdbcTemplate.update(sql, new Object[]{news.getTitle(),news.getSource(),news.getAuthor(),news.getContent(),news.getImgurl(),news.getId()});
			return count;

		}else{
			String sql = "update lmzy.news set title=?,source=?,author=?,content=? where id=?";
			int count = jdbcTemplate.update(sql, new Object[]{news.getTitle(),news.getSource(),news.getAuthor(),news.getContent(),news.getId()});
			return count;

		}
	}

	@Override
	public int deleteNews(int newsId) {
		String sql = "delete from lmzy.news where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{newsId});
		return count;
	}

	@Override
	public int updateNewsState(int newsid, int state) {
		String sql = "update lmzy.news set state = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{state,newsid});
		return count;
	}

	@Override
	public List<Map<String, Object>> selectNewsTypeList(int gameid, int start,
			int max) {
		String sql = "select * from lmzy.newstype where gameid=? order by createtime desc  limit ?,? ";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
		return list;
	}

	@Override
	public int selectNewsTypeCount(int gameid) {
		String sql = "select count(*) from lmzy.newstype where gameid=?";
		int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
		return count;
	}

	@Override
	public Map<String, Object> selectNewsTypeContent(int newstypeid) {
		String sql = "select * from lmzy.newstype where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{newstypeid});
		return map;
	}

	@Override
	public int insertNewsType(int gameid, String newstypename) {
		String sql = "insert into lmzy.newstype (gameid,name,createtime) values (?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[]{gameid,newstypename,DateUtil.getDataFormatForDateTime(new Date(), "")});
		return count;
	}

	@Override
	public int updateNewsType(int sptypeid, String newstypename) {
		String sql = "update lmzy.newstype set name=? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{newstypename,sptypeid});
		return count;
	}

}

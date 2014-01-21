package com.lmzy.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.admin.dao.AdminFuBenDao;
import com.lmzy.admin.po.AdminFbHelp;
import com.lmzy.core.util.DateUtil;
@Repository
public class AdminFuBenDaoImpl implements AdminFuBenDao {
	Logger logger = Logger.getLogger(AdminFuBenDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectFuBenHelpList(int gameid, int fbid,
			int state, String startTime, String endTime, int start, int max,
			String orderBy) {
		if(state==2){
			if(fbid==0){
				String sql = "select * from lmzy.fb_help where gameid=?  order by createtime desc  limit ?,? ";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
				return list;

			}else{
				String sql = "select * from lmzy.fb_help where gameid=? and fbid=? order by createtime desc  limit ?,? ";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,fbid,start,max});
				return list;

			}
		}else{
			if(fbid==0){
				String sql = "select * from lmzy.fb_help where gameid=? and state=? order by createtime desc  limit ?,? ";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,state,start,max});
				return list;

			}else{
				String sql = "select * from lmzy.fb_help where gameid=? and fbid=? and state=? order by createtime desc  limit ?,? ";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,fbid,state,start,max});
				return list;

			}
		}
	}

	@Override
	public int selectFuBenHelpCount(int gameid, int fbid, int state) {
		if(state==2){
			if(fbid==0){
				String sql = "select count(*) from lmzy.fb_help where gameid=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
				return count;

			}else{
				String sql = "select count(*) from lmzy.fb_help where gameid=? and fbid=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,fbid});
				return count;

			}

		}else{
			if(fbid==0){
				String sql = "select count(*) from lmzy.fb_help where gameid=? and state=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,state});
				return count;

			}else{
				String sql = "select count(*) from lmzy.fb_help where gameid=? and fbid=? and state=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,fbid,state});
				return count;

			}

		}
	}

	@Override
	public Map<String, Object> selectFuBenHelpContent(int fbhelpid) {
		String sql = "select * from lmzy.fb_help where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{fbhelpid});
		return map;
	}

	@Override
	public int insertFuBenHelp(AdminFbHelp fb) {
		String sql = "insert into lmzy.fb_help (gameid,fbid,title,source,author,content,state,createtime) values (?,?,?,?,?,?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[]{fb.getGameid(),fb.getFbId(),fb.getTitle(),fb.getSource(),fb.getAuthor(),fb.getContent(),fb.getState(),fb.getCreateTime()});
		return count;
	}

	@Override
	public int updateFuBenHelp(AdminFbHelp fb) {
		String sql = "update lmzy.fb_help set title=?,source=?,author=?,content=? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{fb.getTitle(),fb.getSource(),fb.getAuthor(),fb.getContent(),fb.getId()});
		return count;
	}

	@Override
	public int deleteFuBenHelp(int fbhelpid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFuBenHelpState(int fbhelpid, int state) {
		String sql = "update lmzy.fb_help set state = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{state,fbhelpid});
		return count;
	}

	@Override
	public List<Map<String, Object>> selectFuBenList(int gameid, int start,
			int max) {
		String sql = "select * from lmzy.fb where gameid=? order by createtime desc  limit ?,? ";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
		return list;
	}

	@Override
	public int selectFuBenCount(int gameid) {
		String sql = "select count(*) from lmzy.fb where gameid=?";
		int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
		return count;
	}

	@Override
	public Map<String, Object> selectFuBenContent(int fbid) {
		String sql = "select * from lmzy.fb where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{fbid});
		return map;
	}

	@Override
	public int insertFuBen(int gameid, String fbname) {
		String sql = "insert into lmzy.fb (gameid,name,createtime) values (?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[]{gameid,fbname,DateUtil.getDataFormatForDateTime(new Date(), "")});
		return count;
	}

	@Override
	public int updateFuBen(int fbid, String fbname) {
		String sql = "update lmzy.fb set name=? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{fbname,fbid});
		return count;
	}

}

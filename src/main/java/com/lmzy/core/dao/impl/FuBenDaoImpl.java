package com.lmzy.core.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.core.dao.FuBenDao;
@Repository
public class FuBenDaoImpl implements FuBenDao {
	Logger logger = Logger.getLogger(FuBenDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectFuBen(int gameid) {
		String sql = "select * from lmzy.fb where gameid=?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid});
		return list;
	}
	@Override
	public List<Map<String, Object>> selectFuBenList(int gameid, int fuBenId,int start,int max) {
		String sql = "select * from lmzy.fb_help where gameid=? and fbid = ? and state=1 order by createtime desc limit ?,? ";
		System.out.println(jdbcTemplate.queryForList(sql, new Object[]{gameid,fuBenId,start,max}));
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,fuBenId,start,max});
		return list;
	}
	@Override
	public int selectFuBenCount(int gameid, int fuBenId) {
		String sql = "select count(*) from lmzy.fb_help where gameid=? and fbid = ? and state=1";
		int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,fuBenId});
		return count;
	}
	@Override
	public Map<String, Object> selectFuBenContent(int fuBenHelpId) {
		String sql = "select * from lmzy.fb_help where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{fuBenHelpId});
		return map;
	}
	@Override
	public List<Map<String, Object>> selectFuBenListByGameId(int gameid,
			int start, int max) {
		String sql = "select * from lmzy.fb_help where gameid=? and state=1 order by createtime desc limit ?,? ";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
		return list;

	}
	@Override
	public int selectFuBenCountByGameId(int gameid) {
		String sql = "select count(*) from lmzy.fb_help where gameid=? and state=1";
		int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
		return count;
	}
	@Override
	public int updateFuBenTotal(int fuBenHelpId, int total) {
		String sql = "update lmzy.fb_help set total = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{total,fuBenHelpId});
		return count;
	}

}

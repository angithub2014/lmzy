package com.lmzy.core.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.core.dao.ShiPinDao;
@Repository
public class ShiPinDaoImpl implements ShiPinDao {
	Logger logger = Logger.getLogger(ShiPinDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectShiPinType(int gameid) {
		String sql = "select * from lmzy.videotype where gameid=?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid});
		return list;
	}

	@Override
	public List<Map<String, Object>> selectShiPinList(int gameid, int sptypeId,
			int start, int max) {
		String sql = "select * from lmzy.video where gameid=? and videotypeid = ? and state=1 order by createtime desc limit ?,?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,sptypeId,start,max});

		return list;
	}

	@Override
	public int selectShiPinCount(int gameid, int sptypeId) {
		String sql = "select count(*) from lmzy.video where gameid=? and videotypeid = ? and state=1";
		long count = jdbcTemplate.queryForLong(sql, new Object[]{gameid,sptypeId});
		return (int)count;
	}

	@Override
	public Map<String, Object> selectShiPinContent(int spId) {
		String sql = "select * from lmzy.video where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{spId});
		return map;
	}

	@Override
	public List<Map<String, Object>> selectShiPinListByGameId(int gameid,
			int start, int max) {
		String sql = "select * from lmzy.video where gameid=? and state=1 order by createtime desc limit ?,?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});

		return list;
	}

	@Override
	public int selectShiPinCountByGameId(int gameid) {
		String sql = "select count(*) from lmzy.video where gameid=? and state=1";
		long count = jdbcTemplate.queryForLong(sql, new Object[]{gameid});
		return (int)count;
	}

	@Override
	public int updateShiPinTotal(int spId, int total) {
		String sql = "update lmzy.video set watchtotal = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{total,spId});
		return count;
	}

}

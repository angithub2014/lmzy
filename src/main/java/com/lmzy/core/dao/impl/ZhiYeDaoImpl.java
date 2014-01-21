package com.lmzy.core.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.core.dao.ZhiYeDao;
@Repository
public class ZhiYeDaoImpl implements ZhiYeDao {
	Logger logger = Logger.getLogger(ZhiYeDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectZhiYe(int gameid) {
		String sql = "select * from lmzy.occupation where gameid=?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid});
		return list;
	}
	@Override
	public List<Map<String, Object>> selectZhiYeList(int gameid, int zhiYeId,
			int start, int max) {
		String sql = "select * from lmzy.occupation_guide where gameid=? and occupationid = ? and state=1 order by createtime desc limit ?,?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,zhiYeId,start,max});

		return list;

	}
	@Override
	public int selectZhiYeCount(int gameid, int zhiYeId) {
		String sql = "select count(*) from lmzy.occupation_guide where gameid=? and occupationid = ? and state=1";
		long count = jdbcTemplate.queryForLong(sql, new Object[]{gameid,zhiYeId});
		return (int)count;
	}
	@Override
	public Map<String, Object> selectZhiYeContent(int zhiYeId) {
		String sql = "select * from lmzy.occupation_guide where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{zhiYeId});
		return map;
	}
	@Override
	public List<Map<String, Object>> selectZhiYeListByGameId(int gameid,
			int start, int max) {
		String sql = "select * from lmzy.occupation_guide where gameid=? and state=1 order by createtime desc limit ?,?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});

		return list;
	}
	@Override
	public int selectZhiYeCountByGameId(int gameid) {
		String sql = "select count(*) from lmzy.occupation_guide where gameid=? and state=1";
		long count = jdbcTemplate.queryForLong(sql, new Object[]{gameid});
		return (int)count;
	}
	@Override
	public int updateZhiYeTotal(int zhiYeGuideId, int total) {
		String sql = "update lmzy.occupation_guide set total = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{total,zhiYeGuideId});
		return count;
	}

}

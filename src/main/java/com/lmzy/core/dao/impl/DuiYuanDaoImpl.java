package com.lmzy.core.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.core.dao.DuiYuanDao;
@Repository
public class DuiYuanDaoImpl implements DuiYuanDao {
	Logger logger = Logger.getLogger(DuiYuanDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectDuiYuanTypeList(int gameid,
			int start, int max) {
		String sql = "select * from lmzy.teamtype where gameid=? order by createtime desc limit ?,?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
		return list;
	}

	@Override
	public List<Map<String, Object>> selectDuiYuanList(int gameid, int dytypeid) {
		String sql = "select * from lmzy.teammember where gameid=? and teamtypeid = ? and state=1 order by createtime desc";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,dytypeid});

		return list;

	}

	@Override
	public int selectDuiYuanTypeCount(int gameid) {
		String sql = "select count(*) from lmzy.teamtype where gameid=?";
		int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
		return count;
	}

	@Override
	public Map<String, Object> selectDuiYuanContent(int dyid) {
		String sql = "select * from lmzy.teammember where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{dyid});
		return map;
	}

}

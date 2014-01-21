package com.lmzy.core.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.core.dao.SelectAllDao;
@Repository
public class SelectAllDaoImpl implements SelectAllDao {

	Logger logger = Logger.getLogger(SelectAllDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectTeamList(int gameid, int start,
			int max) {
		String sql = "select * from lmzy.team where gameid=? and state=1 order by createtime desc  limit ?,? ";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
		return list;
	}

	@Override
	public int selectTeamCount(int gameid) {
		String sql = "select count(*) from lmzy.team where gameid=? and state=1";
		int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
		return count;
	}

	@Override
	public Map<String, Object> selectTeamContent(int teamId) {
		String sql = "select * from lmzy.team where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{teamId});
		return map;

	}

	@Override
	public List<Map<String, Object>> selectRecruitList(int gameid, int start,
			int max) {
		String sql = "select * from lmzy.recruit where gameid=? and state=1 order by createtime desc  limit ?,? ";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
		return list;
	}

	@Override
	public int selectRecruitCount(int gameid) {
		String sql = "select count(*) from lmzy.recruit where gameid=? and state=1";
		int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
		return count;
	}

	@Override
	public Map<String, Object> selectRecruitContent(int recruiId) {
		String sql = "select * from lmzy.recruit where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{recruiId});
		return map;
	}

	@Override
	public int updateTeamTotal(int teamId, int total) {
		String sql = "update lmzy.team set total = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{total,teamId});
		return count;
	}

	@Override
	public int updateRecruitTotal(int recruitId, int total) {
		String sql = "update lmzy.recruit set total = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{total,recruitId});
		return count;
	}

	@Override
	public List<Map<String, Object>> selectAllTeam(int gameid, String teamtype) {
		String sql = "select * from lmzy.team where gameid=? and state=1 and teamtype=? order by createtime desc";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,teamtype});
		return list;
	}

	@Override
	public List<Map<String, Object>> selectFriendShipList(int gameid, int state) {
		String sql = "select * from lmzy.friendship where gameid=? and state=? order by createtime desc";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,state});
		return list;
	}

	@Override
	public Map<String, Object> selectAboutUs() {
		String sql = "select * from lmzy.aboutus";
		try{
			Map<String, Object> map = jdbcTemplate.queryForMap(sql);

			return map;

		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

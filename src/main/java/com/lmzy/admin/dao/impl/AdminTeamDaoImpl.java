package com.lmzy.admin.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.admin.dao.AdminTeamDao;
import com.lmzy.admin.po.AdminTeam;
@Repository
public class AdminTeamDaoImpl implements AdminTeamDao {
	Logger logger = Logger.getLogger(AdminTeamDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectTeamList(int gameid, int state,
			String teamtype, int start, int max) {
		System.out.println("start:"+start+",max:"+max);
//		String sql = "select n.* from  (select * from lmzy.news where createtime between ? and ?) as n where n.gameid=? and n.state=? order by n.createtime desc  limit ?,?";
//		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{startTime,endTime,gameid,state,start,max});
		if(state==2){
			if("0".equals(teamtype)){
				String sql = "select * from lmzy.team where gameid=? order by createtime desc  limit ?,? ";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
				return list;

			}else{
				String sql = "select * from lmzy.team where gameid=? and teamtype=?  order by createtime desc  limit ?,? ";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,teamtype,start,max});
				return list;

			}
		}else{
			if("0".equals(teamtype)){
				String sql = "select * from lmzy.team where gameid=? and state=? order by createtime desc  limit ?,? ";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,state,start,max});
				return list;
			}else{
				String sql = "select * from lmzy.team where gameid=? and state=? and teamtype=? order by createtime desc  limit ?,? ";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,state,teamtype,start,max});
				return list;
			}

		}

		
	}

	@Override
	public int selectTeamCount(int gameid, int state,String teamtype) {
		if(state==2){
			if("0".equals(teamtype)){
				String sql = "select count(*) from lmzy.team where gameid=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
				return count;
			}else{
				String sql = "select count(*) from lmzy.team where gameid=? and teamtype=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,teamtype});
				return count;
			}
			

		}else{
			if("0".equals(teamtype)){
				String sql = "select count(*) from lmzy.team where gameid=? and state=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,state});
				return count;
			}else{
				String sql = "select count(*) from lmzy.team where gameid=? and state=? and teamtype=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,state,teamtype});
				return count;
			}
			

		}
	}

	@Override
	public Map<String, Object> selectTeamContent(int teamId) {
		String sql = "select * from lmzy.team where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{teamId});
		return map;
	}

	@Override
	public int insertTeam(AdminTeam team) {
		String sql = "insert into lmzy.team (gameid,nameid,teamtype,teamtypename,state,createtime) values (?,?,?,?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[]{team.getGameid(),team.getNameid(),team.getTeamtype(),team.getTeamtypename(),team.getState(),team.getCreatetime()});
		return count;

	}

	@Override
	public int updateTeam(AdminTeam team) {
		// TODO Auto-generated method stub
		String sql = "update lmzy.team set nameid=? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{team.getNameid(),team.getId()});
		return count;

	}

	@Override
	public int deleteTeam(int teamId) {
		String sql = "delete * from lmzy.team where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{teamId});
		return count;
	}

	@Override
	public int updateTeamState(int teamid, int state) {
		String sql = "update lmzy.team set state = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{state,teamid});
		return count;
	}

}

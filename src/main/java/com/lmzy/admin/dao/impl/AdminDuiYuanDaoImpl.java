package com.lmzy.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.admin.dao.AdminDuiYuanDao;
import com.lmzy.admin.po.AdminDuiYuan;
import com.lmzy.core.util.DateUtil;
@Repository
public class AdminDuiYuanDaoImpl implements AdminDuiYuanDao {
	Logger logger = Logger.getLogger(AdminDuiYuanDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectDuiYuanList(int gameid, int dytypeid,
			int state, String startTime, String endTime, int start, int max,
			String orderBy) {
		if(state==2){
			if(dytypeid==0){
				String sql = "select * from lmzy.teammember where gameid=? order by createtime desc limit ?,?";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
				return list;
			}else{
				String sql = "select * from lmzy.teammember where gameid=? and teamtypeid=? order by createtime desc limit ?,?";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,dytypeid,start,max});
				return list;
			}
			
		}else{
			if(dytypeid==0){
				String sql = "select * from lmzy.teammember where gameid=? and state=? order by createtime desc limit ?,?";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,state,start,max});
				return list;
			}else{
				String sql = "select * from lmzy.teammember where gameid=? and teamtypeid=? and state=? order by createtime desc limit ?,?";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,dytypeid,state,start,max});
				return list;
			}
			
		}
	}

	@Override
	public int selectDuiYuanCount(int gameid, int dytypeid, int state) {
		// TODO Auto-generated method stub
		if(state==2){
			if(dytypeid==0){
				String sql = "select count(*) from lmzy.teammember where gameid=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
				return count;
			}else{
				String sql = "select count(*) from lmzy.teammember where gameid=? and teamtypeid=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,dytypeid});
				return count;
			}
			

		}else{
			if(dytypeid==0){
				String sql = "select count(*) from lmzy.teammember where gameid=? and state=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,state});
				return count;

			}else{
				String sql = "select count(*) from lmzy.teammember where gameid=? and teamtypeid=? and state=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,dytypeid,state});
				return count;

			}
			
		}
	}

	@Override
	public Map<String, Object> selectDuiYuanContent(int dyid) {
		String sql = "select * from lmzy.teammember where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{dyid});
		return map;
	}

	@Override
	public int insertDuiYuan(AdminDuiYuan dy) {
		String sql = "insert into lmzy.teammember (gameid,teamtypeid,name,imgurl,role,herourl,detailurl,state,createtime) values (?,?,?,?,?,?,?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[]{dy.getGameid(),dy.getTeamtypeid(),dy.getName(),dy.getImgurl(),dy.getRole(),dy.getHerourl(),dy.getDetailurl(),dy.getState(),dy.getCreatetime()});
		return count;
	}

	@Override
	public int updateDuiYuan(AdminDuiYuan dy) {
		if(dy.getImgurl()!=null&&!"".equals(dy.getImgurl())){
			String sql = "update lmzy.teammember set name=?,imgurl=?,herourl=?,detailurl=? where id=?";
			int count = jdbcTemplate.update(sql, new Object[]{dy.getName(),dy.getImgurl(),dy.getHerourl(),dy.getDetailurl(),dy.getId()});
			return count;

		}else{
			String sql = "update lmzy.teammember set name=?,herourl=?,detailurl=? where id=?";
			int count = jdbcTemplate.update(sql, new Object[]{dy.getName(),dy.getHerourl(),dy.getDetailurl(),dy.getId()});
			return count;

		}
	}

	@Override
	public int deleteDuiYuan(int dyid) {
		String sql = "delete from lmzy.teammember where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{dyid});
		return count;
	}

	@Override
	public int updateDuiYuanState(int dyid, int state) {
		String sql = "update lmzy.teammember set state = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{state,dyid});
		return count;
	}

	@Override
	public List<Map<String, Object>> selectDuiYuanTypeList(int gameid,
			int start, int max) {
		String sql = "select * from lmzy.teamtype where gameid=? order by createtime desc  limit ?,? ";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
		return list;
	}

	@Override
	public int selectDuiYuanTypeCount(int gameid) {
		String sql = "select count(*) from lmzy.teamtype where gameid=?";
		int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
		return count;
	}

	@Override
	public Map<String, Object> selectDuiYuanTypeContent(int dytypeid) {
		String sql = "select * from lmzy.teamtype where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{dytypeid});
		return map;
	}

	@Override
	public int insertDuiYuanType(int gameid, String dytypename) {
		String sql = "insert into lmzy.teamtype (gameid,name,createtime) values (?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[]{gameid,dytypename,DateUtil.getDataFormatForDateTime(new Date(), "")});
		return count;
	}

	@Override
	public int updateDuiYuanType(int dytypeid, String dytypename) {
		String sql = "update lmzy.teamtype set name=? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{dytypename,dytypeid});
		return count;
	}

}

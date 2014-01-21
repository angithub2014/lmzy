package com.lmzy.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.admin.dao.AdminShiPinDao;
import com.lmzy.admin.po.AdminVideo;
import com.lmzy.core.util.DateUtil;
@Repository
public class AdminShiPinDaoImpl implements AdminShiPinDao {
	Logger logger = Logger.getLogger(AdminShiPinDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectShiPinList(int gameid, int sptypeid,
			int state, String startTime, String endTime, int start, int max,
			String orderBy) {
		if(state==2){
			if(sptypeid==0){
				String sql = "select * from lmzy.video where gameid=? order by createtime desc limit ?,?";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
				return list;
			}else{
				String sql = "select * from lmzy.video where gameid=? and videotypeid=? order by createtime desc limit ?,?";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,sptypeid,start,max});
				return list;
			}
			
		}else{
			if(sptypeid==0){
				String sql = "select * from lmzy.video where gameid=? and state=? order by createtime desc limit ?,?";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,state,start,max});
				return list;
			}else{
				String sql = "select * from lmzy.video where gameid=? and videotypeid=? and state=? order by createtime desc limit ?,?";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,sptypeid,state,start,max});
				return list;
			}
			
		}
	}

	@Override
	public int selectShiPinCount(int gameid, int sptypeid, int state) {
		// TODO Auto-generated method stub
		if(state==2){
			if(sptypeid==0){
				String sql = "select count(*) from lmzy.video where gameid=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
				return count;
			}else{
				String sql = "select count(*) from lmzy.video where gameid=? and videotypeid=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,sptypeid});
				return count;
			}
			

		}else{
			if(sptypeid==0){
				String sql = "select count(*) from lmzy.video where gameid=? and state=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,state});
				return count;

			}else{
				String sql = "select count(*) from lmzy.video where gameid=? and videotypeid=? and state=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,sptypeid,state});
				return count;

			}
			
		}
	}

	@Override
	public Map<String, Object> selectShiPinContent(int spid) {
		String sql = "select * from lmzy.video where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{spid});
		return map;
	}

	@Override
	public int insertShiPin(AdminVideo sp) {
		String sql = "insert into lmzy.video (gameid,videotypeid,name,imageurl,watchurl,state,createtime) values (?,?,?,?,?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[]{sp.getGameid(),sp.getVideotypeid(),sp.getName(),sp.getImageurl(),sp.getWatchurl(),sp.getState(),sp.getCreatetime()});
		return count;
	}

	@Override
	public int updateShiPin(AdminVideo sp) {
		if(sp.getImageurl()!=null&&!"".equals(sp.getImageurl())){
			String sql = "update lmzy.video set name=?,imageurl=?,watchurl=? where id=?";
			int count = jdbcTemplate.update(sql, new Object[]{sp.getName(),sp.getImageurl(),sp.getWatchurl(),sp.getId()});
			return count;

		}else{
			String sql = "update lmzy.video set name=?,watchurl=? where id=?";
			int count = jdbcTemplate.update(sql, new Object[]{sp.getName(),sp.getWatchurl(),sp.getId()});
			return count;

		}
	}

	@Override
	public int deleteShiPin(int spid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateShiPinState(int spid, int state) {
		String sql = "update lmzy.video set state = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{state,spid});
		return count;
	}

	@Override
	public List<Map<String, Object>> selectShiPinTypeList(int gameid,
			int start, int max) {
		String sql = "select * from lmzy.videotype where gameid=? order by createtime desc  limit ?,? ";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
		return list;
	}

	@Override
	public int selectShiPinTypeCount(int gameid) {
		String sql = "select count(*) from lmzy.videotype where gameid=?";
		int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
		return count;
	}

	@Override
	public Map<String, Object> selectShiPinTypeContent(int sptypeid) {
		String sql = "select * from lmzy.videotype where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{sptypeid});
		return map;
	}

	@Override
	public int insertShiPinType(int gameid, String sptypename) {
		String sql = "insert into lmzy.videotype (gameid,name,createtime) values (?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[]{gameid,sptypename,DateUtil.getDataFormatForDateTime(new Date(), "")});
		return count;
	}

	@Override
	public int updateShiPinType(int sptypeid, String sptypename) {
		String sql = "update lmzy.videotype set name=? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{sptypename,sptypeid});
		return count;
	}

}

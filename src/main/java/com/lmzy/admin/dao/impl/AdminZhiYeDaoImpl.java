package com.lmzy.admin.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.admin.dao.AdminZhiYeDao;
import com.lmzy.admin.po.AdminOccupationGuide;
import com.lmzy.core.util.DateUtil;
@Repository
public class AdminZhiYeDaoImpl implements AdminZhiYeDao {
	Logger logger = Logger.getLogger(AdminZhiYeDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectZhiYeHelpList(int gameid, int zyid,
			int state, String startTime, String endTime, int start, int max,
			String orderBy) {
		if(state==2){
			if(zyid==0){
				String sql = "select * from lmzy.occupation_guide where gameid=? order by createtime desc limit ?,?";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
				return list;
			}else{
				String sql = "select * from lmzy.occupation_guide where gameid=? and occupationid=? order by createtime desc limit ?,?";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,zyid,start,max});
				return list;
			}
			
		}else{
			if(zyid==0){
				String sql = "select * from lmzy.occupation_guide where gameid=? and state=? order by createtime desc limit ?,?";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,state,start,max});
				return list;
			}else{
				String sql = "select * from lmzy.occupation_guide where gameid=? and occupationid=? and state=? order by createtime desc limit ?,?";
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,zyid,state,start,max});
				return list;
			}
			
		}
	}

	@Override
	public int selectZhiYeHelpCount(int gameid, int zyid, int state) {
		if(state==2){
			if(zyid==0){
				String sql = "select count(*) from lmzy.occupation_guide where gameid=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
				return count;
			}else{
				String sql = "select count(*) from lmzy.occupation_guide where gameid=? and occupationid=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,zyid});
				return count;
			}
			

		}else{
			if(zyid==0){
				String sql = "select count(*) from lmzy.occupation_guide where gameid=? and state=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,state});
				return count;

			}else{
				String sql = "select count(*) from lmzy.occupation_guide where gameid=? and occupationid=? and state=?";
				int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,zyid,state});
				return count;

			}
			
		}
	}

	@Override
	public Map<String, Object> selectZhiYeHelpContent(int zyhelpid) {
		String sql = "select * from lmzy.occupation_guide where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{zyhelpid});
		return map;
	}

	@Override
	public int insertZhiYeHelp(AdminOccupationGuide zy) {
		String sql = "insert into lmzy.occupation_guide (gameid,occupationid,title,source,author,content,state,createtime) values (?,?,?,?,?,?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[]{zy.getGameid(),zy.getOccupationId(),zy.getTitle(),zy.getSource(),zy.getAuthor(),zy.getContent(),zy.getState(),zy.getCreateTime()});
		return count;
	}

	@Override
	public int updateZhiYeHelp(AdminOccupationGuide zy) {
		String sql = "update lmzy.occupation_guide set title=?,source=?,author=?,content=? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{zy.getTitle(),zy.getSource(),zy.getAuthor(),zy.getContent(),zy.getId()});
		return count;
	}

	@Override
	public int deleteZhiYeHelp(int zyhelpid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateZhiYeHelpState(int zyhelpid, int state) {
		String sql = "update lmzy.occupation_guide set state = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{state,zyhelpid});
		return count;
	}

	@Override
	public List<Map<String, Object>> selectZhiYeList(int gameid, int start,
			int max) {
		String sql = "select * from lmzy.occupation where gameid=? order by createtime desc  limit ?,? ";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
		return list;
	}

	@Override
	public int selectZhiYeCount(int gameid) {
		String sql = "select count(*) from lmzy.occupation where gameid=?";
		int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
		return count;
	}

	@Override
	public Map<String, Object> selectZhiYeContent(int zyid) {
		String sql = "select * from lmzy.occupation where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{zyid});
		return map;
	}

	@Override
	public int insertZhiYe(int gameid, String zyname) {
		String sql = "insert into lmzy.occupation (gameid,name,createtime) values (?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[]{gameid,zyname,DateUtil.getDataFormatForDateTime(new Date(), "")});
		return count;
	}

	@Override
	public int updateZhiYe(int zyid, String zyname) {
		String sql = "update lmzy.occupation set name=? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{zyname,zyid});
		return count;
	}

}

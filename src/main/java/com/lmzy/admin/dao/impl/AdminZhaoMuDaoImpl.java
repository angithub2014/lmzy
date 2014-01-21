package com.lmzy.admin.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.admin.dao.AdminZhaoMuDao;
import com.lmzy.admin.po.AdminRecruit;
@Repository
public class AdminZhaoMuDaoImpl implements AdminZhaoMuDao {
	Logger logger = Logger.getLogger(AdminZhaoMuDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectZhaoMuList(int gameid, int state,
			String startTime, String endTime, int start, int max, String orderBy) {
		System.out.println("start:"+start+",max:"+max);
//		String sql = "select n.* from  (select * from lmzy.news where createtime between ? and ?) as n where n.gameid=? and n.state=? order by n.createtime desc  limit ?,?";
//		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{startTime,endTime,gameid,state,start,max});
		if(state==2){
			String sql = "select * from lmzy.recruit where gameid=? order by createtime desc  limit ?,? ";
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
			return list;
		}else{
			String sql = "select * from lmzy.recruit where gameid=? and state=? order by createtime desc  limit ?,? ";
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,state,start,max});
			return list;
		}
	}

	@Override
	public int selectZhaoMuCount(int gameid, int state) {
		if(state==2){
			String sql = "select count(*) from lmzy.recruit where gameid=?";
			int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
			return count;

		}else{
			String sql = "select count(*) from lmzy.recruit where gameid=? and state=?";
			int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,state});
			return count;

		}
	}

	@Override
	public Map<String, Object> selectZhaoMuContent(int zhaomuid) {
		String sql = "select * from lmzy.recruit where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{zhaomuid});
		return map;
	}

	@Override
	public int insertZhaoMu(AdminRecruit zhaomu) {
		String sql = "insert into lmzy.recruit (gameid,title,source,author,content,state,createtime,imgurl) values (?,?,?,?,?,?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[]{zhaomu.getGameid(),zhaomu.getTitle(),zhaomu.getSource(),zhaomu.getAuthor(),zhaomu.getContent(),zhaomu.getState(),zhaomu.getCreatetime(),zhaomu.getImgurl()});
		return count;
	}

	@Override
	public int updateZhaoMu(AdminRecruit zhaomu) {
		if(zhaomu.getImgurl()!=null&&!"".equals(zhaomu.getImgurl())){
			String sql = "update lmzy.recruit set title=?,source=?,author=?,content=?,imgurl=? where id=?";
			int count = jdbcTemplate.update(sql, new Object[]{zhaomu.getTitle(),zhaomu.getSource(),zhaomu.getAuthor(),zhaomu.getContent(),zhaomu.getImgurl(),zhaomu.getId()});
			return count;

		}else{
			String sql = "update lmzy.recruit set title=?,source=?,author=?,content=? where id=?";
			int count = jdbcTemplate.update(sql, new Object[]{zhaomu.getTitle(),zhaomu.getSource(),zhaomu.getAuthor(),zhaomu.getContent(),zhaomu.getId()});
			return count;

		}
	}

	@Override
	public int deleteZhaoMu(int zhaomuid) {
		String sql = "delete * from lmzy.recruit where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{zhaomuid});
		return count;
	}

	@Override
	public int updateZhaoMuState(int zhaomuid, int state) {
		String sql = "update lmzy.recruit set state = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{state,zhaomuid});
		return count;
	}

}

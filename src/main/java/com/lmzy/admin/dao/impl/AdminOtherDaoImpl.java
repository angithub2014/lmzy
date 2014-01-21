package com.lmzy.admin.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.admin.dao.AdminOtherDao;
@Repository
public class AdminOtherDaoImpl implements AdminOtherDao {
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectFriendShipList(int gameid,
			 int state, String startTime, String endTime,
			int start, int max, String orderBy) {
		System.out.println("======state:"+state);
		if(state==2){
			System.out.println("======state1:"+state);
			String sql = "select * from lmzy.friendship where gameid=? order by createtime desc limit ?,? ";
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,start,max});
			System.out.println(list.size());
			return list;
			
		}else{
			System.out.println("======state2:"+state);
			String sql = "select * from lmzy.friendship where gameid=? and state=? order by createtime desc  limit ?,? ";
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{gameid,state,start,max});
			System.out.println(list.size());
			return list;
			
		}
	}

	@Override
	public int selectFriendShipCount(int gameid, int state) {
		if(state==2){
			String sql = "select count(*) from lmzy.friendship where gameid=?";
			int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid});
			return count;
		}else{
			String sql = "select count(*) from lmzy.friendship where gameid=? and state=?";
			int count = jdbcTemplate.queryForInt(sql, new Object[]{gameid,state});
			return count;
		}
	}

	@Override
	public int insertFriendShip(int gameid, int state, String name,String imgurl, String url,String createtime){
		if("".equals(imgurl)||imgurl==null){
			String sql = "insert into lmzy.friendship (gameid,state,name,url,createtime) values (?,?,?,?,?)";
			int count = jdbcTemplate.update(sql, new Object[]{gameid,state,name,url,createtime});
			return count;

		}else{
			String sql = "insert into lmzy.friendship (gameid,state,name,imgurl,url,createtime) values (?,?,?,?,?,?)";
			int count = jdbcTemplate.update(sql, new Object[]{gameid,state,name,imgurl,url,createtime});
			return count;

		}

	}

	@Override
	public int updateFriendShip(int friendShipId, String name,String imgurl, String url) {
		if("".equals(imgurl)||imgurl==null){
			String sql = "update lmzy.friendship set name=?,url=? where id=?";
			int count = jdbcTemplate.update(sql, new Object[]{name,url,friendShipId});
			return count;
		}else{
			String sql = "update lmzy.friendship set name=?,imgurl=?,url=? where id=?";
			int count = jdbcTemplate.update(sql, new Object[]{name,imgurl,url,friendShipId});
			return count;
		}
		
	}

	@Override
	public int deleteFriendShip(int friendShipId) {
		String sql = "delete from lmzy.friendship where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{friendShipId});
		return count;
	}

	@Override
	public int updateFriendShipState(int friendShipId, int state) {
		String sql = "update lmzy.friendship set state = ? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{state,friendShipId});
		return count;
	}

	@Override
	public Map<String, Object> selectFriendShip(int id) {
		String sql = "select * from lmzy.friendship where id = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{id});
		return map;
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

	@Override
	public int insertAboutUs(int gameid, String title, String content,
			String name, String email, String mobile, String createtime) {
		String sql = "insert into lmzy.aboutus (gameid,title,content,name,email,mobile,createtime) values (?,?,?,?,?,?,?)";
		int count = jdbcTemplate.update(sql, new Object[]{gameid,title,content,name,email,mobile,createtime});
		return count;
	}

	@Override
	public int updateAboutUs(int id, String title, String content, String name,
			String email, String mobile) {
		String sql = "update lmzy.aboutus set title=?,content=?,name=?,email=?,mobile=? where id=?";
		int count = jdbcTemplate.update(sql, new Object[]{title,content,name,email,mobile,id});
		return count;
	}

}

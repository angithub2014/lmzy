package com.lmzy.core.dao.impl;


import java.sql.Types;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lmzy.core.dao.UserInfoDao;
import com.lmzy.core.po.UserInfo;
import com.lmzy.core.util.DateUtil;
@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	Logger logger = Logger.getLogger(UserInfoDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Transactional
	public UserInfo register(String userName, String passWord,String email) {
		String sql = "insert into lmzy.userinfo (username,password,email,state,createtime) values (?,?,?,?,?)";
		int types[] = new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.VARCHAR};
		String createTime = DateUtil.getDataFormatForDateTime(new Date(), "");
		int count = jdbcTemplate.update(sql, new Object[]{userName, passWord,email, 1, createTime},types);
		if(count>0){
			String ssql = "select * from lmzy.userinfo where username=? and (select count(*) from lmzy.userinfo where username=?)=1";
			Map<String, Object> map = jdbcTemplate.queryForMap(ssql, new Object[]{userName,userName});
			UserInfo userInfo = new UserInfo();
			userInfo.setId(Integer.parseInt(""+map.get("id")));
			userInfo.setUserName(map.get("username")+"");
			userInfo.setPassWord(map.get("password")+"");
			userInfo.setNickName(map.get("nickname")+"");
			userInfo.setEmail(map.get("email")+"");
			userInfo.setState(Integer.parseInt(map.get("state")+""));
			userInfo.setSid(map.get("sid")+"");
			userInfo.setModifyTime(map.get("modifytime")+"");
			userInfo.setCreateTime(map.get("createtime")+"");
			return userInfo;
		}
		return null;
	}

	public UserInfo selectUserInfoByUserName(String userName) {
		System.out.println("userName=="+userName);
//		String sql = "select * from lmzy.userinfo where username=? and (select count(*) from lmzy.userinfo where username=? )=1";
		String sql = "select * from lmzy.userinfo where username=?";

		try{
			Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{userName});
			UserInfo userInfo = new UserInfo();
			userInfo.setId(Integer.parseInt(""+map.get("id")));
			userInfo.setUserName(map.get("username")+"");
			userInfo.setPassWord(map.get("password")+"");
			userInfo.setNickName(map.get("nickname")+"");
			userInfo.setEmail(map.get("email")+"");
			userInfo.setState(Integer.parseInt(map.get("state")+""));
			userInfo.setSid(map.get("sid")+"");
			userInfo.setModifyTime(map.get("modifytime")+"");
			userInfo.setCreateTime(map.get("createtime")+"");
			return userInfo;

		}catch (EmptyResultDataAccessException  e) {
			return null;
		}

	}

	public UserInfo selectUserInfoByEmail(String Email) {
//		String ssql = "select * from lmzy.userinfo where email=? and (select count(*) from lmzy.userinfo where email=? )=1";
		String ssql = "select * from lmzy.userinfo where email=?";

		try{
			Map<String, Object> map = jdbcTemplate.queryForMap(ssql, new Object[]{Email});
			UserInfo userInfo = new UserInfo();
			userInfo.setId(Integer.parseInt(""+map.get("id")));
			userInfo.setUserName(map.get("username")+"");
			userInfo.setPassWord(map.get("password")+"");
			userInfo.setNickName(map.get("nickname")+"");
			userInfo.setEmail(map.get("email")+"");
			userInfo.setState(Integer.parseInt(map.get("state")+""));
			userInfo.setSid(map.get("sid")+"");
			userInfo.setModifyTime(map.get("modifytime")+"");
			userInfo.setCreateTime(map.get("createtime")+"");
			return userInfo;
		}catch (EmptyResultDataAccessException  e) {
			return null;
		}
	}

	@Override
	@Transactional
	public UserInfo updateSidByUserName(String userName, String sid) {
		String sql = "update lmzy.userinfo set sid = ? ,modifyTime=? where username=?";
		String modifyTime = DateUtil.getDataFormatForDateTime(new Date(), "");
		int count = jdbcTemplate.update(sql, new Object[]{sid, modifyTime,userName});
		if(count>0){
			String ssql = "select * from lmzy.userinfo where username=? and (select count(*) from lmzy.userinfo where username=?)=1";
			Map<String, Object> map = jdbcTemplate.queryForMap(ssql, new Object[]{userName,userName});
			UserInfo userInfo = new UserInfo();
			userInfo.setId(Integer.parseInt(""+map.get("id")));
			userInfo.setUserName(map.get("username")+"");
			userInfo.setPassWord(map.get("password")+"");
			userInfo.setNickName(map.get("nickname")+"");
			userInfo.setEmail(map.get("email")+"");
			userInfo.setState(Integer.parseInt(map.get("state")+""));
			userInfo.setSid(map.get("sid")+"");
			userInfo.setModifyTime(map.get("modifytime")+"");
			userInfo.setCreateTime(map.get("createtime")+"");
			return userInfo;
		}
		return null;
	}

	@Override
	@Transactional
	public UserInfo updatePassWordByUserName(String userName, String passWord) {
		String sql = "update lmzy.userinfo set password = ? where username=?";
		int count = jdbcTemplate.update(sql, new Object[]{passWord,userName});
		if(count>0){
			String ssql = "select * from lmzy.userinfo where username=? and (select count(*) from lmzy.userinfo where username=?)=1";
			Map<String, Object> map = jdbcTemplate.queryForMap(ssql, new Object[]{userName,userName});
			UserInfo userInfo = new UserInfo();
			userInfo.setId(Integer.parseInt(""+map.get("id")));
			userInfo.setUserName(map.get("username")+"");
			userInfo.setPassWord(map.get("password")+"");
			userInfo.setNickName(map.get("nickname")+"");
			userInfo.setEmail(map.get("email")+"");
			userInfo.setState(Integer.parseInt(map.get("state")+""));
			userInfo.setSid(map.get("sid")+"");
			userInfo.setModifyTime(map.get("modifytime")+"");
			userInfo.setCreateTime(map.get("createtime")+"");
			return userInfo;
		}
		return null;
	}

}

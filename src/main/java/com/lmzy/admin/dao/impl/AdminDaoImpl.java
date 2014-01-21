package com.lmzy.admin.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.admin.dao.AdminDao;
import com.lmzy.admin.po.Admin;
import com.lmzy.core.dao.impl.UserInfoDaoImpl;
@Repository
public class AdminDaoImpl implements AdminDao {
	Logger logger = Logger.getLogger(UserInfoDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public Admin selectAdminByUserName(String userName) {
		String sql = "select * from lmzy.userinfo where username=? and manageflag='T' and (select count(*) from lmzy.userinfo where username=? and manageflag='T')=1";
		try{
			Map<String, Object> map = jdbcTemplate.queryForMap(sql, new Object[]{userName,userName});
			Admin admin = new Admin();
			admin.setId(Integer.parseInt(""+map.get("id")));
			admin.setUserName(map.get("username")+"");
			admin.setPassWord(map.get("password")+"");
			admin.setNickName(map.get("nickname")+"");
			admin.setEmail(map.get("email")+"");
			admin.setState(Integer.parseInt(map.get("state")+""));
			admin.setSid(map.get("sid")+"");
			admin.setManageflag(map.get("manageflag")+"");
			admin.setModifyTime(map.get("modifytime")+"");
			admin.setCreateTime(map.get("createtime")+"");
			return admin;

		}catch (EmptyResultDataAccessException  e) {
			return null;
		}
	}

}

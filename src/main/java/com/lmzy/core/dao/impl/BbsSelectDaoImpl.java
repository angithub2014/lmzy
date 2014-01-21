package com.lmzy.core.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lmzy.core.dao.BbsSelectDao;
@Repository
public class BbsSelectDaoImpl implements BbsSelectDao {
	Logger logger = Logger.getLogger(BbsSelectDaoImpl.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> selectBbsTopbicDigest() {
		String sql = "select * from lmzy.ejf_topic where isDigest='T' order by topicID desc limit 0,5";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}

}

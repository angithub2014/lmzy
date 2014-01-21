package com.lmzy.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public interface BbsSelectDao {
	public List<Map<String,Object>> selectBbsTopbicDigest();
}

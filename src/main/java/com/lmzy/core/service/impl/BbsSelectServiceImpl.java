package com.lmzy.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.core.dao.BbsSelectDao;
import com.lmzy.core.service.BbsSelectService;
@Service
public class BbsSelectServiceImpl implements BbsSelectService {
	@Autowired
	BbsSelectDao bbsSelectDao;
	@Override
	public List<Map<String, Object>> selectBbsTopbicDigest() {
		// TODO Auto-generated method stub
		return bbsSelectDao.selectBbsTopbicDigest();
	}

}

package com.lmzy.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.admin.dao.AdminDao;
import com.lmzy.admin.po.Admin;
import com.lmzy.admin.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDao adminDao;
	@Override
	public Admin selectAdminByUserName(String userName) {
		// TODO Auto-generated method stub
		return adminDao.selectAdminByUserName(userName);
	}

}

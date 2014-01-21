package com.lmzy.admin.dao;

import org.springframework.stereotype.Repository;

import com.lmzy.admin.po.Admin;

@Repository
public interface AdminDao {
	public Admin selectAdminByUserName(String userName);
}

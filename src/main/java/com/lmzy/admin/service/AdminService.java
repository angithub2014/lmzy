package com.lmzy.admin.service;

import org.springframework.stereotype.Service;

import com.lmzy.admin.po.Admin;
@Service
public interface AdminService {
	public Admin selectAdminByUserName(String userName);

}

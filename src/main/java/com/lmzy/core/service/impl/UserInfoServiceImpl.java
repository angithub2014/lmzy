package com.lmzy.core.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.core.dao.UserInfoDao;
import com.lmzy.core.po.UserInfo;
import com.lmzy.core.service.UserInfoService;
import com.lmzy.core.util.CommonUtil;
import com.lmzy.core.util.PaySign;
@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoDao userInfoDao;
	public UserInfo register(String userName, String passWord,String email) {
		try {
			return userInfoDao.register(userName, PaySign.EncoderByMd5(passWord),email);
//			return userInfoDao.register(userName, CommonUtil.MD5_SHA(passWord),email);
		} catch (Exception e) {
			return null;
		}
	}

	public UserInfo selectUserInfoByUserName(String userName) {
		return userInfoDao.selectUserInfoByUserName(userName);
	}

	public UserInfo selectUserInfoByEmail(String Email) {
		return userInfoDao.selectUserInfoByEmail(Email);
	}

	@Override
	public UserInfo updateSidByUserName(String userName, String sid) {
		// TODO Auto-generated method stub
		return userInfoDao.updateSidByUserName(userName, sid);
	}

	@Override
	public UserInfo updatePassWordByUserName(String userName, String passWord) {
		try {
			return userInfoDao.updatePassWordByUserName(userName, PaySign.EncoderByMd5(passWord));
		} catch (Exception e) {
			return null;
		}
	}

}

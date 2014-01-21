package com.lmzy.core.dao;

import org.springframework.stereotype.Repository;

import com.lmzy.core.po.UserInfo;
@Repository
public interface UserInfoDao {
	/**
	 * 用户注册
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public UserInfo register(String userName,String passWord,String email);
	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public UserInfo selectUserInfoByUserName(String userName);
	/**
	 * 根据邮箱查询用户信息
	 * @param Email
	 * @return
	 */
	public UserInfo selectUserInfoByEmail(String Email);
	public UserInfo updateSidByUserName(String userName,String sid);
	public UserInfo updatePassWordByUserName(String userName,String passWord);
}

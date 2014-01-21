package com.lmzy.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmzy.admin.dao.AdminOtherDao;
import com.lmzy.admin.service.AdminOtherService;
@Service
public class AdminOtherServiceImpl implements AdminOtherService {
	@Autowired
	AdminOtherDao adminOtherDao;
	@Override
	public List<Map<String, Object>> selectFriendShipList(int gameid,
			 int state, String startTime, String endTime,
			int start, int max, String orderBy) {
		// TODO Auto-generated method stub
		return adminOtherDao.selectFriendShipList(gameid, state, startTime, endTime, start, max, orderBy);
	}

	@Override
	public int selectFriendShipCount(int gameid, int state) {
		// TODO Auto-generated method stub
		return adminOtherDao.selectFriendShipCount(gameid, state);
	}

	@Override
	public int insertFriendShip(int gameid, int state, String name,String imgurl, String url,
			String createtime) {
		// TODO Auto-generated method stub
		return adminOtherDao.insertFriendShip(gameid, state, name,imgurl, url, createtime);
	}

	@Override
	public int updateFriendShip(int friendShipId, String name,String imgurl, String url) {
		// TODO Auto-generated method stub
		return adminOtherDao.updateFriendShip(friendShipId, name,imgurl, url);
	}

	@Override
	public int deleteFriendShip(int friendShipId) {
		// TODO Auto-generated method stub
		return adminOtherDao.deleteFriendShip(friendShipId);
	}

	@Override
	public int updateFriendShipState(int friendShipId, int state) {
		// TODO Auto-generated method stub
		return adminOtherDao.updateFriendShipState(friendShipId, state);
	}

	@Override
	public Map<String, Object> selectFriendShip(int id) {
		// TODO Auto-generated method stub
		return adminOtherDao.selectFriendShip(id);
	}

	@Override
	public Map<String, Object> selectAboutUs() {
		// TODO Auto-generated method stub
		return adminOtherDao.selectAboutUs();
	}

	@Override
	public int insertAboutUs(int gameid, String title, String content,
			String name, String email, String mobile, String createtime) {
		// TODO Auto-generated method stub
		return adminOtherDao.insertAboutUs(gameid, title, content, name, email, mobile, createtime);
	}

	@Override
	public int updateAboutUs(int id, String title, String content, String name,
			String email, String mobile) {
		// TODO Auto-generated method stub
		return adminOtherDao.updateAboutUs(id, title, content, name, email, mobile);
	}

}

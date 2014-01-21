package com.lmzy.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminOtherDao {
	public List<Map<String, Object>> selectFriendShipList(int gameid,int state,String startTime,String endTime,int start,int max,String orderBy);
	public int selectFriendShipCount(int gameid,int state);
	public int insertFriendShip(int gameid,int state,String name,String imgurl,String url,String createtime);
	public int updateFriendShip(int friendShipId,String name,String imgurl,String url);
	public int deleteFriendShip(int friendShipId);
	public int updateFriendShipState(int friendShipId,int state);
	public Map<String, Object> selectFriendShip(int id);
	
	
	public Map<String, Object> selectAboutUs();
	public int insertAboutUs(int gameid,String title,String content,String name,String email,String mobile,String createtime);
	public int updateAboutUs(int id,String title,String content,String name,String email,String mobile);

}

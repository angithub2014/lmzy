package com.lmzy.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lmzy.admin.po.AdminFb;
import com.lmzy.admin.po.AdminFbHelp;

@Service
public interface AdminFuBenService {
	public List<Map<String, Object>> selectFuBenHelpList(int gameid,int fbid,int state,String startTime,String endTime,int start,int max,String orderBy);
	public int selectFuBenHelpCount(int gameid,int fbid,int state);
	public Map<String, Object> selectFuBenHelpContent(int fbhelpid);
	public int insertFuBenHelp(AdminFbHelp fb);
	public int updateFuBenHelp(AdminFbHelp fb);
	public int deleteFuBenHelp(int fbhelpid);
	public int updateFuBenHelpState(int fbhelpid,int state);
	
	public List<Map<String, Object>> selectFuBenList(int gameid,int start,int max);
	public int selectFuBenCount(int gameid);
	public Map<String, Object> selectFuBenContent(int fbid);
	public int insertFuBen(int gameid,String fbname);
	public int updateFuBen(int fbid,String fbname);
}

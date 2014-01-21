package com.lmzy.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lmzy.admin.po.AdminRecruit;

@Repository
public interface AdminZhaoMuDao {
	public List<Map<String, Object>> selectZhaoMuList(int gameid,int state,String startTime,String endTime,int start,int max,String orderBy);
	public int selectZhaoMuCount(int gameid,int state);
	public Map<String, Object> selectZhaoMuContent(int zhaomuid);
	public int insertZhaoMu(AdminRecruit zhaomu);
	public int updateZhaoMu(AdminRecruit zhaomu);
	public int deleteZhaoMu(int zhaomuid);
	public int updateZhaoMuState(int zhaomuid,int state);

}

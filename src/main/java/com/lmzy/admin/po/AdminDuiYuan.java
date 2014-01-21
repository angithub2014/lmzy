package com.lmzy.admin.po;

import java.io.Serializable;

public class AdminDuiYuan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6342535079659124449L;
	private int id;
	private int gameid;
	private int teamtypeid;
	private String role;
	private String imgurl;
	private String name;
	private String detailurl;
	private String herourl;
	private int state;
	private String createtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGameid() {
		return gameid;
	}
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
	public int getTeamtypeid() {
		return teamtypeid;
	}
	public void setTeamtypeid(int teamtypeid) {
		this.teamtypeid = teamtypeid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetailurl() {
		return detailurl;
	}
	public void setDetailurl(String detailurl) {
		this.detailurl = detailurl;
	}
	public String getHerourl() {
		return herourl;
	}
	public void setHerourl(String herourl) {
		this.herourl = herourl;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

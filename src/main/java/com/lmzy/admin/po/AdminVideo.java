package com.lmzy.admin.po;

import java.io.Serializable;

public class AdminVideo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3776109904814583166L;
	private int id;
	private int gameid;
	private int videotypeid;
	private String videotype;
	private String name;
	private String imageurl;
	private String watchurl;
	private int watchtotal;
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
	public int getVideotypeid() {
		return videotypeid;
	}
	public void setVideotypeid(int videotypeid) {
		this.videotypeid = videotypeid;
	}
	public String getVideotype() {
		return videotype;
	}
	public void setVideotype(String videotype) {
		this.videotype = videotype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getWatchurl() {
		return watchurl;
	}
	public void setWatchurl(String watchurl) {
		this.watchurl = watchurl;
	}
	public int getWatchtotal() {
		return watchtotal;
	}
	public void setWatchtotal(int watchtotal) {
		this.watchtotal = watchtotal;
	}
	public String getCreatetime() {
		return createtime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

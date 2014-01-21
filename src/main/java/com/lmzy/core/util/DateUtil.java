package com.lmzy.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 时间格式化
	 * @param time时间
	 * @param formatType格式化类型
	 * @return
	 */
	public static String getDataFormatForLongTime(long time,String formatType){

		String dateTime = "";
		SimpleDateFormat dateFormat =null;
		if("".equals(formatType)){
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else{
			try{
				dateFormat = new SimpleDateFormat(formatType);
			}catch (Exception e) {
				return "";
			}
		} 
		dateTime = dateFormat.format(time);
		return dateTime;
	}
	/**
	 * @param date
	 * @param formatType格式化类型
	 * @return
	 */
	public static String getDataFormatForDateTime(Date date,String formatType){

		String dateTime = "";
		SimpleDateFormat dateFormat =null;
		if("".equals(formatType)){
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else{
			try{
				dateFormat = new SimpleDateFormat(formatType);
			}catch (Exception e) {
				return "";
			}
		} 
		dateTime = dateFormat.format(date);
		return dateTime;
	}
	public static void main(String[] args) {
		System.out.println(getDataFormatForDateTime(new Date(), ""));
	}
}

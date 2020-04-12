package com.kiki.comcom.utils;

import java.nio.channels.NonWritableChannelException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 
    * @ClassName: DateUtil
    * @Description: 日期处理类
    * @author lk
    * @date 2020年3月27日
    *
 */
public class DateUtil {

	/**
	 * 
	    * @Title: randomDate
	    * @Description: 随机生产一个在两个参数之前的随机日期
	    * @param @param startDate
	    * @param @param endDate
	    * @param @return    参数
	    * @return Date    返回类型
	    * @throws
	 */
	public static Date randomDate(Date startDate,Date endDate) {
		long startTime = startDate.getTime();//从1970年到startDate的毫秒数
		long endTime = endDate.getTime();//从1970年到endDate的毫秒数
		
		if(endTime<startTime) {
			throw new RuntimeException("参数异常");
		}
		//随机产生一个在两个毫秒数之间的数
		Random random = new Random();
		long t = (long)(Math.random()*(endTime-startTime+1)+startTime);
		
		return new Date(t);
		
	}
	
	/**
	 * 
	    * @Title: getInitMonth
	    * @Description: 返回传入日期的月初 2020/3/27  返回2020/3/01  0:0:0
	    * @param @param date
	    * @param @return    参数
	    * @return Date    返回类型
	    * @throws
	 */
	public static Date getInitMonth(Date date) {
		Calendar c = Calendar.getInstance();
		
		//用传入的日期做初始化日历类
		c.setTime(date);
		
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 
	    * @Title: getEndMonth
	    * @Description: 返回一个月的月末
	    * @param @param date
	    * @param @return    参数
	    * @return Date    返回类型
	    * @throws
	 */
	public static Date getEndMonth(Date date) {
		//获取日历类
		Calendar c = Calendar.getInstance();
		
		//用传入的日期做初始化日历类
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		//变成月初
		Date initMonth = getInitMonth(c.getTime());
		//更新一下日历类
		c.setTime(initMonth);
		//月初减1秒
		c.add(Calendar.SECOND, -1);
		return c.getTime();
	}
	/**
	 * 
	    * @Title: getAgeByBirthDay
	    * @Description: 根据出生日期计算年龄
	    * @param @param date
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	public static int getAgeByBirthDay(Date birthday) {
		Calendar c = Calendar.getInstance();
		
		int s_year = c.get(Calendar.YEAR);//获取系统的年
		int s_month = c.get(Calendar.MONTH);//获取系统的月
		int s_day = c.get(Calendar.DAY_OF_MONTH);//获取系统的日
		//出生日期初始化
		c.setTime(birthday);
		
		int b_year = c.get(Calendar.YEAR);//获取出生的年
		int b_month = c.get(Calendar.MONTH);//获取出生的月
		int b_day = c.get(Calendar.DAY_OF_MONTH);//获取出生的日
		
		int age = s_year-b_year;
		
		//系统月份小于出生月份
		if(s_month<b_year) {
			age--;
		}
		if(s_month == b_month && s_day < b_day) {
			age--;
		}
		return age;
	}
	
	/**
	 * 
	    * @Title: getDateByBefore
	    * @Description: 返回昨天的时间
	    * @param @return    参数
	    * @return Date    返回类型
	    * @throws
	 */
	public static Date getDateByBefore() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		return c.getTime();
	}
}

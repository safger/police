package com.sn.common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

	/**
	 * 把一个字符串变成 一个java.util.Date类型的对象
	 * 
	 * @param dateStr
	 *            日期字符串
	 * 
	 * @param format
	 *            格式字符串
	 * 
	 *            说明 这俩个参数必须相对应;
	 * @return 返回日期
	 */
	public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static java.util.Date parseDate(String dateStr, String format) {
		java.util.Date date = null;
		Locale locale = new Locale("en", "US"); // 美国人的习惯 要不然那种 zzz EEE 无法转过去
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, locale);
		// 必须捕获异常

		try {
			date = simpleDateFormat.parse(dateStr);
		} catch (ParseException px) {
			px.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * 一个java.util.Date类型的对象 变成一个字符串
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            格式
	 * @return String 返回字符型日期
	 */
	public static String format(java.util.Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				java.text.DateFormat df = new java.text.SimpleDateFormat(format);
				result = df.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 返回年份
	 * 
	 * @param date
	 *            日期
	 * @return 返回年份
	 */
	public static int getYear(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.YEAR);
	}

	/**
	 * 返回月份
	 * 
	 * @param date
	 *            日期
	 * @return 返回月份
	 */
	public static int getMonth(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.MONTH) + 1;
	}

	/**
	 * 返回日份
	 * 
	 * @param date
	 *            日期
	 * @return 返回日份
	 */
	public static int getDay(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.DAY_OF_MONTH);
	}

	/**
	 * 返回小时
	 * 
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.HOUR_OF_DAY);
	}

	/**
	 * 返回分钟
	 * 
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);

		return c.get(java.util.Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 *            日期
	 * @return 返回秒钟
	 */
	public static int getSecond(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.SECOND);
	}

	/**
	 * 返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 返回格式化的字符串日期yyyy/MM/dd
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符串日期
	 */
	public static String getStringDate(java.util.Date date) {
		return format(date, "yyyy/MM/dd");
	}

	/**
	 * 返回格式化的字符串时间HH:mm:ss
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符串时间
	 */
	public static String getStringTime(java.util.Date date) {
		return format(date, "HH:mm:ss");
	}

	/**
	 * 返回格式化的字符串时间yyyy/MM/dd HH:mm:ss
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符型日期时间
	 */
	public static String getStringDateTime(java.util.Date date) {
		return format(date, "yyyy/MM/dd HH:mm:ss");
	}

	/**
	 * 日期加天数
	 * 
	 * @param date
	 *            日期
	 * @param day
	 *            天数
	 * @return 返回相加后的日期
	 */
	public static java.util.Date addDate(java.util.Date date, int day) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}

	public static String addDate(String dateStr, int day) throws ParseException {
		try{
		SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd");
		long s=si.parse(dateStr).getTime();
		Date dt = DateUtil.addDate(new Date(s),1); 
		return getStringDateTime(dt); 
		}catch(Exception ex){
			return "";
		}
	}

	/**
	 * 日期减天数 求相差几天的问题
	 * 
	 * @param date
	 *            日期
	 * @param date1
	 *            日期
	 * @return 返回相减后的日期
	 */
	public static int diffDate(java.util.Date date, java.util.Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}

	public static java.util.Date parseDate(String dateStr) {
		return parseDate(dateStr, "yyyy/MM/dd");
	}

	/**
	 * 取得指定月份的第一天
	 * 
	 * @param strdate
	 *            String
	 * @return String
	 */

	public static String getMonthBegin(String strdate) {

		java.util.Date date = parseDate(strdate);// 注意这时候的格式 要按"yyyy/MM/dd"
		return format(date, "yyyy/MM") + "/01";// 最后得到的 本来是可以任意格式的;
												// 但是考虑到下一方法调用到这一方法的结果;
	} // 在parseDate 转的时候就 不是"yyyy/MM/dd"这种格式就转不了

	/**
	 * 取得指定月份的最后一天
	 * 
	 * @param strdate
	 *            String
	 * @return String
	 */
	public static String getMonthEnd(String strdate) {
		java.util.Date date = parseDate(getMonthBegin(strdate));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);// 加一个月
		calendar.add(Calendar.DAY_OF_YEAR, -1);// 减一天
		return getStringDate(calendar.getTime());
	}
	
	public static boolean valiDateTimeWithLongFormat(String timeStr) {
		String format = "((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) "
				+ "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
		Pattern pattern = Pattern.compile(format);
		Matcher matcher = pattern.matcher(timeStr);
		if (matcher.matches()) {
			pattern = Pattern.compile("(\\d{4})-(\\d+)-(\\d+).*");
			matcher = pattern.matcher(timeStr);
			if (matcher.matches()) {
				int y = Integer.valueOf(matcher.group(1));
				int m = Integer.valueOf(matcher.group(2));
				int d = Integer.valueOf(matcher.group(3));
				if (d > 28) {
					Calendar c = Calendar.getInstance();
					c.set(y, m-1, 1);
					int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
					return (lastDay >= d);
				}
			}
			return true;
		}
		return false;
	}

	 //获取当天的开始时间
    public static java.util.Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    //获取当天的结束时间
    public static java.util.Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }
    //获取昨天的开始时间
    public static Date getBeginDayOfYesterday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }
    //获取昨天的结束时间
    public static Date getEndDayOfYesterDay() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }
    //获取明天的开始时间
    public static Date getBeginDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, 1);

        return cal.getTime();
    }
    //获取明天的结束时间
    public static Date getEndDayOfTomorrow() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }
    //获取本周的开始时间
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }
    //获取本周的结束时间
    public static Date getEndDayOfWeek(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());  
        cal.add(Calendar.DAY_OF_WEEK, 6); 
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }
    //获取本月的开始时间
     public static Date getBeginDayOfMonth() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(getNowYear(), getNowMonth() - 1, 1);
            return getDayStartTime(calendar.getTime());
        }
    //获取本月的结束时间
     public static Date getEndDayOfMonth() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(getNowYear(), getNowMonth() - 1, 1);
            int day = calendar.getActualMaximum(5);
            calendar.set(getNowYear(), getNowMonth() - 1, day);
            return getDayEndTime(calendar.getTime());
        }
     //获取本年的开始时间
     public static java.util.Date getBeginDayOfYear() {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, getNowYear());
            // cal.set
            cal.set(Calendar.MONTH, Calendar.JANUARY);
            cal.set(Calendar.DATE, 1);

            return getDayStartTime(cal.getTime());
        }
     //获取本年的结束时间
     public static java.util.Date getEndDayOfYear() {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, getNowYear());
            cal.set(Calendar.MONTH, Calendar.DECEMBER);
            cal.set(Calendar.DATE, 31);
            return getDayEndTime(cal.getTime());
        }
    //获取某个日期的开始时间
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if(null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),    calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }
    //获取某个日期的结束时间
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if(null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),    calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }
    //获取今年是哪一年
     public static Integer getNowYear() {
             Date date = new Date();
            GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
            gc.setTime(date);
            return Integer.valueOf(gc.get(1));
        }
     //获取本月是哪一月
     public static int getNowMonth() {
             Date date = new Date();
            GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
            gc.setTime(date);
            return gc.get(2) + 1;
        }
     //两个日期相减得到的天数
     public static int getDiffDays(Date beginDate, Date endDate) {

            if (beginDate == null || endDate == null) {
                throw new IllegalArgumentException("getDiffDays param is null!");
            }

            long diff = (endDate.getTime() - beginDate.getTime())
                    / (1000 * 60 * 60 * 24);

            int days = new Long(diff).intValue();

            return days;
        }
    //两个日期相减得到的毫秒数
     public static long dateDiff(Date beginDate, Date endDate) {
            long date1ms = beginDate.getTime();
            long date2ms = endDate.getTime();
            return date2ms - date1ms;
        }
     //获取两个日期中的最大日期
     public static Date max(Date beginDate, Date endDate) {
            if (beginDate == null) {
                return endDate;
            }
            if (endDate == null) {
                return beginDate;
            }
            if (beginDate.after(endDate)) {
                return beginDate;
            }
            return endDate;
        }
     //获取两个日期中的最小日期
     public static Date min(Date beginDate, Date endDate) {
            if (beginDate == null) {
                return endDate;
            }
            if (endDate == null) {
                return beginDate;
            }
            if (beginDate.after(endDate)) {
                return endDate;
            }
            return beginDate;
        }
     //返回某月该季度的第一个月
     public static Date getFirstSeasonDate(Date date) {
             final int[] SEASON = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4 };
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int sean = SEASON[cal.get(Calendar.MONTH)];
            cal.set(Calendar.MONTH, sean * 3 - 3);
            return cal.getTime();
        }
     //返回某个日期下几天的日期
     public static Date getNextDay(Date date, int i) {
            Calendar cal = new GregorianCalendar();
            cal.setTime(date);
            cal.set(Calendar.DATE, cal.get(Calendar.DATE) + i);
            return cal.getTime();
        }
     //返回某个日期前几天的日期
     public static Date getFrontDay(Date date, int i) {
            Calendar cal = new GregorianCalendar();
            cal.setTime(date);
            cal.set(Calendar.DATE, cal.get(Calendar.DATE) - i);
            return cal.getTime();
        }
     //获取某年某月到某年某月按天的切片日期集合（间隔天数的集合）
     public static List getTimeList(int beginYear, int beginMonth, int endYear,
                int endMonth, int k) {
            List list = new ArrayList();
            if (beginYear == endYear) {
                for (int j = beginMonth; j <= endMonth; j++) {
                    list.add(getTimeList(beginYear, j, k));

                }
            } else {
                {
                    for (int j = beginMonth; j < 12; j++) {
                        list.add(getTimeList(beginYear, j, k));
                    }

                    for (int i = beginYear + 1; i < endYear; i++) {
                        for (int j = 0; j < 12; j++) {
                            list.add(getTimeList(i, j, k));
                        }
                    }
                    for (int j = 0; j <= endMonth; j++) {
                        list.add(getTimeList(endYear, j, k));
                    }
                }
            }
            return list;
        }
     //获取某年某月按天切片日期集合（某个月间隔多少天的日期集合）
     public static List getTimeList(int beginYear, int beginMonth, int k) {
            List list = new ArrayList();
            Calendar begincal = new GregorianCalendar(beginYear, beginMonth, 1);
            int max = begincal.getActualMaximum(Calendar.DATE);
            for (int i = 1; i < max; i = i + k) {
                list.add(begincal.getTime());
                begincal.add(Calendar.DATE, k);
            }
            begincal = new GregorianCalendar(beginYear, beginMonth, max);
            list.add(begincal.getTime());
            return list;
        }
}
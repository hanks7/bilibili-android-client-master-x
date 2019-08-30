package com.hanks.util.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 根据提供当前时间及给定的格式，返回时间字符串
 * @author hanks7
 */
public class UtilDate {

    /**
     * 获取当前的时间字符串
     *
     * @param format yy-MM-dd HH
     * @return 字符串形式的当前时间
     */
    public static String getNowDate(String format) {
        return new SimpleDateFormat(format, Locale.US).format(new Date());
    }

    /**
     * 判断时间是否大于当前时间 如果大于返回true 否则返回false
     *
     * @param DATE1
     * @return
     */
    public static boolean compare_date(String DATE1) {


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(getCurrentTime());
            if (dt1.getTime() > dt2.getTime()) {
                return true;
            } else if (dt1.getTime() < dt2.getTime()) {
                return false;
            } else {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }


    /**
     * 将给定时间转换成字符串
     *
     * @param date   时间戳
     * @param format 格式
     * @return str
     */
    public static String format(long date, String format) {
        return new SimpleDateFormat(format, Locale.CHINESE).format(new Date(date));
    }

    /**
     * 将给定时间转换成字符串
     *
     * @param date   long类型的字符串时间戳
     * @param format 格式
     * @return str
     */
    public static String format(String date, String format) {
        long s1 = 0;
        try {
            s1 = Long.parseLong(date);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (s1 <= 0) {
            return null;
        }
        return format(s1, format);
    }

    /**
     * 根据日期获取年龄
     *
     * @param year 1990
     * @return int;年龄
     */
    public static int getAge(String year) {
        int iAge;
        Calendar cal = Calendar.getInstance();
        int iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.valueOf(year);
        return iAge;
    }

    /**
     * 判断是否为合法的日期时间字符串
     *
     * @param strInput   时间字符串
     * @param dateFormat 格式
     * @return boolean;符合为true,不符合为false
     */
    public static boolean isDate(String strInput, String dateFormat) {
        boolean result = false;
        if (strInput != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.CHINESE);
            formatter.setLenient(false);
            try {
                formatter.format(formatter.parse(strInput));
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 验证小于当前日期 是否有效
     *
     * @param iYear  待验证日期(年)
     * @param iMonth 待验证日期(月 1-12)
     * @param iDate  待验证日期(日)
     * @return 符合为true, 不符合为false
     */
    public static boolean isDate(int iYear, int iMonth, int iDate) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int datePerMonth;
        if (iYear < 1900 || iYear >= year) {
            return false;
        }
        if (iMonth < 1 || iMonth > 12) {
            return false;
        }
        switch (iMonth) {
            case 4:
            case 6:
            case 9:
            case 11:
                datePerMonth = 30;
                break;
            case 2:
                boolean dm = ((iYear % 4 == 0 && iYear % 100 != 0) || (iYear % 400 == 0)) && (iYear > 1900 && iYear < year);
                datePerMonth = dm ? 29 : 28;
                break;
            default:
                datePerMonth = 31;
        }
        return (iDate >= 1) && (iDate <= datePerMonth);
    }


    /**
     * 返回当前日期时间字符串<br>
     * 默认格式:yyyy-mm-dd hh:mm:ss
     *
     * @return String 返回当前字符串型日期时间
     */
    public static String getCurrentTime() {
        String returnStr = null;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        returnStr = f.format(date);
        return returnStr;
    }
    /**
     * 返回当前日期时间字符串<br>
     * 默认格式:yyyy-mm-dd hh:mm:ss
     *
     * @return String 返回当前字符串型日期时间
     */
    public static String getCurrentTime(String dateFormat) {
        String returnStr = null;
        SimpleDateFormat f = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        returnStr = f.format(date);
        return returnStr;
    }
    /**
     * 返回当前日期时间字符串<br>
     * 默认格式:yyyy-mm-dd hh:mm:ss
     *
     * @return String 返回当前字符串型日期时间
     */
    public static String getMMss(long second) {
        String returnStr = null;
        SimpleDateFormat f = new SimpleDateFormat("mm:ss");
        Date date = new Date(second);
        returnStr = f.format(date);
        return returnStr;
    }
    /**
     * 返回当前日期时间字符串<br>
     * 默认格式:yyyy-mm-dd hh:mm:ss
     *
     * @return String 返回当前字符串型日期时间
     */
    public static String getSimpleDateFormatTime(Date date) {
        String returnStr = null;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        returnStr = f.format(date);
        return returnStr;
    }

    /**
     * 传入的时间距离现在多久
     *
     * @param date
     * @return String 返回类型
     * @Title: before
     * @Description: 传入的时间距离现在多久
     * @author bkw
     */
    public static String before(String date) {
        String text;
        long time = 0;
        try {
            time = Long.parseLong(date);
        } catch (Exception e) {
            return "";
        }
        time = date.length() == 10 ? time * 1000 : time;
        long now = System.currentTimeMillis();
        int timeChar = (int) (now / 1000 - time / 1000);// 秒
        if (timeChar < 60) {
            text = timeChar + "秒前";
        } else if (timeChar >= 60 && timeChar < 3600) {
            timeChar = timeChar / (60);
            text = timeChar + "分钟前";
        } else if (timeChar >= 3600 && timeChar < 86400) {
            timeChar = timeChar / (60 * 60);
            text = timeChar + "小时前";
        } else if (timeChar >= 86400 && timeChar < 2592000) {
            timeChar = timeChar / (60 * 60 * 24);
            text = timeChar + "天前";
        } else if (timeChar >= 2592000 && timeChar < 946080000) {
            timeChar = timeChar / (60 * 60 * 24 * 30);
            text = timeChar + "月前";
        } else {
            timeChar = timeChar / (60 * 60 * 24 * 30 * 365);
            text = timeChar + "年前";
        }
        return text;
    }

    /**
     * 将时间戳转为字符串 到日
     *
     * @param cc_time
     * @return
     * @author bkw
     */
    public static String getStrDate(String cc_time) {
        return getStrTime(cc_time, "yyyy-MM-dd");
    }

    private static String getStrTime(String cc_time, String format) {
        String re_StrTime = null;
        if (cc_time == null) {
            cc_time = System.currentTimeMillis() + "";
        }

        if (cc_time.length() == 10) { // 单位 秒
            cc_time += "000";// 单位 毫秒
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time));

        return re_StrTime;
    }

    /**
     * 时间得到时间戳
     *
     * @param time
     * @return
     * @author bkw 2014年7月18日 下午2:34:53
     */
    public static long getLongTime(String time) {
        SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sDate.parse(time);
            return date.getTime();// date转成毫秒
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 当前时间转为时间戳
     */
    public static long dataForLongTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = String.valueOf(sdf.format(new Date()));
        try {
            Date date = sdf.parse(time);
            return date.getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;

    }

    /**
     * @return yyyy-MM-dd
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 取得日期
     *
     * @return yyyy-MM-dd
     */
    public static String getStringForDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date time = formatter.parse(date);
            String dateString = formatter.format(time);
            return dateString;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 判断当前日期是星期几
     *
     * @param pTime 设置的需要判断的时间 //格式如2012-09-08
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
    // String pTime = "2012-03-12";
    public static String getWeek(String pTime) {
        String Week = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            Week += " 星期天";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            Week += " 星期一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            Week += " 星期二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            Week += " 星期三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            Week += " 星期四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            Week += " 星期五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            Week += " 星期六";
        }

        return Week;
    }

//    /**
//     * @return yyyy-MM-dd_HH:mm:ss
//     */
//    public static String getDataTime() {
//        String name = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date()) + "";
//        return name;
//    }
    /**
     * @return 返回指定格式的时间
     */
    public static String getDataTime(String fromat) {
        String name = new SimpleDateFormat(fromat).format(new Date()) + "";
        return name;
    }

    /**
     * eg:转换时间yyyy年MM月dd日 HH:mm 为 yyyy年MM月dd日
     * @param dateString
     * @return
     */
    public static String getDateFormat(String dateString, String dateFrom, String dateTo) {
        Date currentDate = null;
        SimpleDateFormat format1 = new SimpleDateFormat(dateFrom);
        SimpleDateFormat format2 = new SimpleDateFormat(dateTo);
        try {
            currentDate = format1.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format2.format(currentDate);
    }
}

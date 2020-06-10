package com.soft1851.springboot.smart.attendance.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Zeng
 * @ClassName TimeUtil
 * @Description 时间段工具类
 * @Date 2020/6/10
 * @Version 1.0
 **/
public class TimeUtil {

    /**
     * 判断时间是否处于某个时间段内
     * @param time 需要比较的时间
     * @param from 起始时间
     * @param to 结束时间
     * @return boolean
     */
    public static boolean belongCalendar(Date time, Date from, Date to) {
        Calendar date = Calendar.getInstance();
        date.setTime(time);
        Calendar after = Calendar.getInstance();
        after.setTime(from);
        Calendar before = Calendar.getInstance();
        before.setTime(to);
        if (date.after(after) && date.before(before)) {
            return true;
        } else {
            return false;
        }
    }

}

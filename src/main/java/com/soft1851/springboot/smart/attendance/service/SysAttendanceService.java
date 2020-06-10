package com.soft1851.springboot.smart.attendance.service;

import com.soft1851.springboot.smart.attendance.constant.ResponseResult;
import com.soft1851.springboot.smart.attendance.model.dto.AttendanceDto;

/**
 * @author Zeng
 * @ClassName SysAttendanceService
 * @Description 考勤服务类
 * @Date 2020/6/10
 * @Version 1.0
 **/
public interface SysAttendanceService  {

    /**
     * 学生归寝打卡
     * @param attendanceDto dto
     * @return String 用户id
     */
    ResponseResult checkIn(AttendanceDto attendanceDto);

}

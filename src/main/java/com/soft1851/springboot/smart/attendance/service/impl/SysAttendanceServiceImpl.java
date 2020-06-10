package com.soft1851.springboot.smart.attendance.service.impl;

import com.soft1851.springboot.smart.attendance.model.dto.AttendanceDto;
import com.soft1851.springboot.smart.attendance.model.entity.SysAttendance;
import com.soft1851.springboot.smart.attendance.repository.SysAttendanceRepository;
import com.soft1851.springboot.smart.attendance.service.SysAttendanceService;

import javax.annotation.Resource;

/**
 * @author Zeng
 * @ClassName SysAttendanceServiceImpl
 * @Description TOOD
 * @Date 2020/6/10
 * @Version 1.0
 **/
public class SysAttendanceServiceImpl implements SysAttendanceService {
    @Resource
    private SysAttendanceRepository attendanceRepository;

    @Override
    public String checkIn(AttendanceDto attendanceDto) {
        SysAttendance attendance = SysAttendance.builder()
                .userId(attendanceDto.getUserId())
                .longitude(attendanceDto.getLongitude())
                .latitude(attendanceDto.getLatitude())
                .build();
        //打卡记录表写入一条数据
        SysAttendance save = attendanceRepository.save(attendance);
        return save.getUserId();
    }
}

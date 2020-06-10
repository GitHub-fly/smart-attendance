package com.soft1851.springboot.smart.attendance.service.impl;

import com.soft1851.springboot.smart.attendance.constant.ResponseResult;
import com.soft1851.springboot.smart.attendance.model.dto.AttendanceDto;
import com.soft1851.springboot.smart.attendance.model.entity.SysAttendance;
import com.soft1851.springboot.smart.attendance.model.entity.SysUser;
import com.soft1851.springboot.smart.attendance.repository.SysAttendanceRepository;
import com.soft1851.springboot.smart.attendance.repository.SysUserRepository;
import com.soft1851.springboot.smart.attendance.service.SysAttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author Zeng
 * @ClassName SysAttendanceServiceImpl
 * @Description TOOD
 * @Date 2020/6/10
 * @Version 1.0
 **/
@Service
public class SysAttendanceServiceImpl implements SysAttendanceService {

    @Resource
    private SysUserRepository userRepository;
    @Resource
    private SysAttendanceRepository attendanceRepository;

    @Override
    public ResponseResult checkIn(AttendanceDto attendanceDto) {
        SysAttendance attendance = SysAttendance.builder()
                .userId(attendanceDto.getUserId())
                .longitude(attendanceDto.getLongitude())
                .latitude(attendanceDto.getLatitude())
                .build();
        //打卡记录表写入一条数据
        SysAttendance save = attendanceRepository.save(attendance);

        //用户表修改是否打卡字段
        Optional<SysUser> userOptional = userRepository.findById(attendanceDto.getUserId());
        SysUser user = userOptional.get();
        user.setIsAttendance(1);
        userRepository.save(user);
        return ResponseResult.success();
    }
}

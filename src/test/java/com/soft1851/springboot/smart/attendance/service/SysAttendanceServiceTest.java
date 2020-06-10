package com.soft1851.springboot.smart.attendance.service;

import com.soft1851.springboot.smart.attendance.model.dto.AttendanceDto;
import com.soft1851.springboot.smart.attendance.model.entity.SysUser;
import com.soft1851.springboot.smart.attendance.repository.SysUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Optional;


@SpringBootTest
class SysAttendanceServiceTest {
    @Resource
    private SysUserRepository userRepository;
    @Resource
    private SysAttendanceService attendanceService;

    @Test
    void test() {
        Optional<SysUser> userOptional = userRepository.findById("1");
        SysUser user = userOptional.get();
        user.setIsAttendance(1);
        userRepository.save(user);

    }

    @Test
    void name() {
        AttendanceDto dto = AttendanceDto.builder().userId("1")
                .latitude("123")
                .longitude("231")
                .build();
        attendanceService.checkIn(dto).getMsg();
    }

}
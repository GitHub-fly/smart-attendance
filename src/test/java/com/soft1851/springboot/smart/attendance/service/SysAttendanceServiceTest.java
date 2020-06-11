package com.soft1851.springboot.smart.attendance.service;

import com.soft1851.springboot.smart.attendance.model.dto.AttendanceDto;
import com.soft1851.springboot.smart.attendance.model.entity.SysAttendance;
import com.soft1851.springboot.smart.attendance.model.entity.SysUser;
import com.soft1851.springboot.smart.attendance.repository.SysAttendanceRepository;
import com.soft1851.springboot.smart.attendance.repository.SysUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Optional;


@SpringBootTest
@Slf4j
class SysAttendanceServiceTest {

    @Resource
    private SysUserRepository userRepository;

    @Resource
    private SysAttendanceService attendanceService;

    @Resource
    private SysAttendanceRepository attendanceRepository;

    @Test
    void test() {
        Optional<SysUser> userOptional = userRepository.findById("1");
        SysUser user = userOptional.get();
        user.setIsAttendance(0);
        userRepository.save(user);

    }

    @Test
    void name() {
        SysAttendance dto = SysAttendance.builder().userId("2")
                .latitude("123")
                .longitude("231")
                .build();
        SysAttendance save = attendanceRepository.save(dto);
        log.info(String.valueOf(save));

    }

    @Test
    void queryCheckInfo() {
        attendanceService.queryCheckInfo("1").forEach(System.out::println);
    }

}
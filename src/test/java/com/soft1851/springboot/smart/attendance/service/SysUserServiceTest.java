package com.soft1851.springboot.smart.attendance.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysUserServiceTest {

    @Resource
    private SysUserService sysUserService;

    @Test
    void findAllStudentNote() {
        sysUserService.findAllStudentNote("003").forEach(System.out::println);
    }
}
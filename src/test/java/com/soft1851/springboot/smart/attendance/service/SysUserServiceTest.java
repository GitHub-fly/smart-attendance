package com.soft1851.springboot.smart.attendance.service;


import com.soft1851.springboot.smart.attendance.model.dto.LoginDto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class SysUserServiceTest {

    @Resource
    private SysUserService sysUserService;

    @Test
    void login() {
        LoginDto loginDto = LoginDto.builder()
                .account("18851999738")
                .password("123456")
                .build();
        System.out.println(sysUserService.login(loginDto));
    }



}
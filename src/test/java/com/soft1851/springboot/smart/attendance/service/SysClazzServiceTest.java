package com.soft1851.springboot.smart.attendance.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysClazzServiceTest {

    @Resource
    private SysClazzService sysClazzService;

    @Test
    void findClazzNote() {
        sysClazzService.findClazzNote("软件1821").forEach(System.out::println);
    }
}
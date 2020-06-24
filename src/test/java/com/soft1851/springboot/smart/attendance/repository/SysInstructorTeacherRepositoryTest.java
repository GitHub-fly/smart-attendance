package com.soft1851.springboot.smart.attendance.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysInstructorTeacherRepositoryTest {

    @Resource
    private SysInstructorTeacherRepository sysInstructorTeacherRepository;

    @Test
    void findInstructorByTeacherIdEquals() {
        System.out.println(sysInstructorTeacherRepository.findInstructorByTeacherIdEquals("003"));
    }
}
package com.soft1851.springboot.smart.attendance.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysClazzRepositoryTest {

    @Resource
    private SysClazzRepository sysClazzRepository;

    @Test
    void findTeacherVoByInstructorId() {
        sysClazzRepository.findTeacherVoByInstructorId("004").forEach(System.out::println);
    }

    @Test
    void findByNameEquals() {
        sysClazzRepository.findByNameEquals("软件1821").forEach(System.out::println);
    }
}
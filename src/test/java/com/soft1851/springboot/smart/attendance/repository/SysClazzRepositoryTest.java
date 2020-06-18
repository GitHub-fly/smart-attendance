package com.soft1851.springboot.smart.attendance.repository;

import org.junit.jupiter.api.Test;
<<<<<<< HEAD
import org.springframework.boot.test.context.SpringBootTest;
=======
>>>>>>> 22d86ecccc883f4da8a6c7c8eef8c22cab7ce30b

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

<<<<<<< HEAD
@SpringBootTest
=======
>>>>>>> 22d86ecccc883f4da8a6c7c8eef8c22cab7ce30b
class SysClazzRepositoryTest {

    @Resource
    private SysClazzRepository sysClazzRepository;

    @Test
<<<<<<< HEAD
    void findTeacherVoByInstructorId() {
        sysClazzRepository.findTeacherVoByInstructorId("004").forEach(System.out::println);
=======
    void findAllByAcademyNameAndPkSysUserId() {

>>>>>>> 22d86ecccc883f4da8a6c7c8eef8c22cab7ce30b
    }
}
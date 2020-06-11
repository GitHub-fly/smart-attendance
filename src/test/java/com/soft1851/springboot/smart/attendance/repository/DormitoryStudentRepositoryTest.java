package com.soft1851.springboot.smart.attendance.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DormitoryStudentRepositoryTest {

    @Resource
    private DormitoryStudentRepository dormitoryStudentRepository;

    @Test
    void queryDormitoryId() {
        List<String> stuIds = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            stuIds.add(String.valueOf(i));
        }

        dormitoryStudentRepository.queryDormitoryId(stuIds).forEach(System.out::println);
    }
}
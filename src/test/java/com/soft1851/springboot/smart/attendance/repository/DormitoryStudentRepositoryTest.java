package com.soft1851.springboot.smart.attendance.repository;

import cn.hutool.core.util.RandomUtil;
import com.soft1851.springboot.smart.attendance.model.entity.DormitoryStudent;
import com.soft1851.springboot.smart.attendance.model.entity.StudentBuilding;
import com.soft1851.springboot.smart.attendance.model.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DormitoryStudentRepositoryTest {

    @Resource
    private DormitoryStudentRepository dormitoryStudentRepository;

    @Resource
    private StudentBuildingRepository studentBuildingRepository;

    @Test
    void queryDormitoryId() {
        List<String> stuIds = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            stuIds.add(String.valueOf(i));
        }
        dormitoryStudentRepository.queryDormitoryId(stuIds).forEach(System.out::println);
    }

    @Test
    void insertStudentBuilding() {
        List<StudentBuilding> list = new ArrayList<>(41);
        for (int i = 1; i < 42; i++) {
            StudentBuilding studentBuilding = StudentBuilding.builder()
                    .buildingId(1L)
                    .deleteFlag(0)
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .studentId((i + 100) + "")
                    .build();
            list.add(studentBuilding);
        }
        studentBuildingRepository.saveAll(list);
    }

    @Test
    void name() {
        List<DormitoryStudent> list = new ArrayList<>(41);
        for (int i = 1; i < 42; i++) {
            DormitoryStudent build = DormitoryStudent.builder()
                    .bedNumber(RandomUtil.randomInt(1, 7))
                    .deleteFlag(0)
                    .dormitoryId((long) RandomUtil.randomInt(1, 10))
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .userId((i + 100) + "")
                    .build();
            list.add(build);
        }
        dormitoryStudentRepository.saveAll(list);
    }

}
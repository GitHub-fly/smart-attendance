package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.vo.*;
import com.soft1851.springboot.smart.attendance.util.DataTypeChange;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysAttendanceRepositoryTest {

    @Resource
    private SysAttendanceRepository attendanceRepository;

    @Test
    void queryUnCheckInfo() {
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        List<Object> objects = attendanceRepository.queryUnCheckInfo(ids);
        List<EntityVo> entityVos = DataTypeChange.changeObj(objects, StuUnCheckVo.class);
        entityVos.forEach(System.out::println);
    }

    @Test
    void queryStuInfo() {
        List<Object> objects = attendanceRepository.queryStuInfo("2");
        List<EntityVo> entityVos = DataTypeChange.changeObj(objects, StudentVo.class);
        entityVos.forEach(System.out::println);
    }

    @Test
    void queryClassCheckIn() {
        List<Object> objects = attendanceRepository.queryClassCheckIn("003");
        List<EntityVo> entityVos = DataTypeChange.changeObj(objects, ClassStudentVo.class);
        entityVos.forEach(System.out::println);
    }

    @Test
    void queryIsAttendance() {
        System.out.println(attendanceRepository.queryIsAttendance("141"));
    }
}
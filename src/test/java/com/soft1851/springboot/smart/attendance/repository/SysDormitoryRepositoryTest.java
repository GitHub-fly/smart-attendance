package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.vo.DormitoryVo;
import com.soft1851.springboot.smart.attendance.model.vo.EntityVo;
import com.soft1851.springboot.smart.attendance.model.vo.StuCheckInVo;
import com.soft1851.springboot.smart.attendance.util.DataTypeChange;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysDormitoryRepositoryTest {

    @Resource
    private SysDormitoryRepository sysDormitoryRepository;

    @Test
    void findDormitoryByIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<Object> objects = sysDormitoryRepository.findDormitoryByIds(ids);
        List<EntityVo> entityVos = DataTypeChange.changeObj(objects, DormitoryVo.class);
        entityVos.forEach(System.out::println);
    }

    @Test
    void findStuCheckInfo() {

        List<Object> objects = sysDormitoryRepository.findStuCheckInfo(2L);
        List<EntityVo> entityVos = DataTypeChange.changeObj(objects, StuCheckInVo.class);
        entityVos.forEach(System.out::println);
    }
}
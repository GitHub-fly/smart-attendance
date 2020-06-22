package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.vo.ClassStudentVo;
import com.soft1851.springboot.smart.attendance.model.vo.EntityVo;
import com.soft1851.springboot.smart.attendance.model.vo.MsgVo;
import com.soft1851.springboot.smart.attendance.util.DataTypeChange;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysMsgRepositoryTest {

    @Resource
    private SysMsgRepository sysMsgRepository;

    @Test
    void  queryMsgById() {

        List<Object> objects = sysMsgRepository.queryMsgById("001");
        List<EntityVo> entityVos = DataTypeChange.changeObj(objects, MsgVo.class);
        entityVos.forEach(System.out::println);
    }
}
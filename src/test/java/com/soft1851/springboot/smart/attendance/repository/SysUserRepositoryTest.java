package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.vo.UserVo;
import com.soft1851.springboot.smart.attendance.util.DataTypeChange;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;


@SpringBootTest
class SysUserRepositoryTest {

    @Resource
    private SysUserRepository sysUserRepository;

    @Test
    void getSysUserBySysUserPhone() {
        List<Object> userInfoObj = sysUserRepository.getUserInfo("18851999738");
        DataTypeChange.changeObj(userInfoObj, UserVo.class).forEach(System.out::println);
    }

}
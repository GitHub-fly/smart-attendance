package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysUser;
import com.soft1851.springboot.smart.attendance.model.vo.UserVo;
import com.soft1851.springboot.smart.attendance.util.DataTypeChange;
import com.soft1851.springboot.smart.attendance.util.Md5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class SysUserRepositoryTest {

    @Resource
    private SysUserRepository sysUserRepository;

    @Test
    void getSysUserBySysUserPhone() {
        List<Object> userInfoObj = sysUserRepository.getUserInfo("18844515551");
        System.out.println(DataTypeChange.changeObj(userInfoObj, UserVo.class).size());
    }

    @Test
    void findSysClazzIdByPkSysUserIdEquals() {
        System.out.println(sysUserRepository.findSysClazzIdByPkSysUserIdEquals("003"));
    }

    @Test
    void findTeacherAuditNoteVoBySysUserNameAndRoleIdEquals() {
        sysUserRepository.findTeacherAuditNoteVoBySysClazzIdAndRoleIdEquals(1L).forEach(System.out::println);
    }

    @Test
    void getMenuUserId() {
        System.out.println(sysUserRepository.getMenuUserId("2"));
    }

    @Test
    void name() {
        List<SysUser> userList = new ArrayList<>(41);
        for (int i = 1; i < 42; i++) {
            SysUser user = SysUser.builder().pkSysUserId((i + 100) + "")
                    .sysUserNickname("昵称" + i)
                    .deleteFlag(0)
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .isAttendance(0)
                    .roleId(1L)
                    .salt("49ba59abbe56e057")
                    .status(0)
                    .sysClazzId(2L)
                    .sysJobNumber("18023431" + i + "")
                    .sysUserAcademyTeacherName("刘书记")
                    .sysUserAvatar("avatar.jpg")
                    .sysUserGender("男")
                    .sysUserInstructorName("解宇宁")
                    .sysUserName("学生" + i)
                    .sysUserPassword(Md5Util.getMd5("123456", true, 16))
                    .sysUserPhone("电话" + i)
                    .build();
            userList.add(user);
        }
        sysUserRepository.saveAll(userList);
    }

    @Test
    void updateIsAttendance() {
        int i = sysUserRepository.updateIsAttendance();
        System.out.println(i);
    }
}
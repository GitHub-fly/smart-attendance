package com.soft1851.springboot.smart.attendance.service.impl;

import com.soft1851.springboot.smart.attendance.constant.ResultCode;
import com.soft1851.springboot.smart.attendance.exception.CustomException;
import com.soft1851.springboot.smart.attendance.model.dto.LoginDto;

import com.soft1851.springboot.smart.attendance.model.vo.EntityVo;
import com.soft1851.springboot.smart.attendance.model.vo.MenuVo;
import com.soft1851.springboot.smart.attendance.model.vo.TeacherAuditNoteVo;

import com.soft1851.springboot.smart.attendance.model.vo.UserVo;
import com.soft1851.springboot.smart.attendance.repository.SysInstructorTeacherRepository;
import com.soft1851.springboot.smart.attendance.repository.SysUserRepository;
import com.soft1851.springboot.smart.attendance.service.SysUserService;
import com.soft1851.springboot.smart.attendance.util.DataTypeChange;
import com.soft1851.springboot.smart.attendance.util.Md5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xunmi
 * @ClassName SysUserServiceImpl
 * @Description TODO
 * @Date 2020/6/10
 * @Version 1.0
 **/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserRepository sysUserRepository;
    @Resource
    private SysInstructorTeacherRepository sysInstructorTeacherRepository;

    @Override
    public Map<String, Object> login(LoginDto loginDto) {
        Map<String, Object> map = new HashMap<>(3);
        List<Object> userInfoObj = sysUserRepository.getUserInfo(loginDto.getAccount());
        // 若此账号查找不存在，在返回账号不存在异常
        if (userInfoObj.size() == 0) {
            throw new CustomException("账号不存在", ResultCode.USER_ACCOUNT_ERROR);
        }
        // 得到用户的基本信息
        UserVo user = (UserVo) DataTypeChange.changeObj(userInfoObj, UserVo.class).get(0);
        // 开始比对密码是否正确
        String password = Md5Util.getMd5(loginDto.getPassword(), true, 32);
        if (user.getSysUserPassword().equals(password)) {
            user.setSysUserPassword(null);
            List<EntityVo> menuList = DataTypeChange.changeObj(sysUserRepository.getMenuUserId(user.getPkSysUserId()), MenuVo.class);
            map.put("user", user);
            map.put("menuList", menuList);
            return map;
        } else {
            throw new CustomException("密码有误", ResultCode.USER_PASSWORD_ERROR);
        }
    }

    /**
     * 老师查询本班学生所有假条
     */
    @Override
    public Map<String, Object> findAllStudentNote(String userId) {
        HashMap<String, Object> map = new HashMap<>(5);
        //第一步 根据老师id查询班级id
        Long clazzId = sysUserRepository.findSysClazzIdByPkSysUserIdEquals(userId);
        //第二步 根据班级id和角色id查询本班级所有学生假条
        map.put("noteList", sysUserRepository.findTeacherAuditNoteVoBySysClazzIdAndRoleIdEquals(clazzId));
        // 第三步，获取该班主任的辅导员id
        map.put("instructorId", sysInstructorTeacherRepository.findInstructorByTeacherIdEquals(userId));
        return map;
    }

}

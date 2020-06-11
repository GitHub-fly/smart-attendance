package com.soft1851.springboot.smart.attendance.service.impl;

import cn.hutool.system.UserInfo;
import com.soft1851.springboot.smart.attendance.model.dto.LoginDto;
import com.soft1851.springboot.smart.attendance.model.entity.SysUser;
import com.soft1851.springboot.smart.attendance.model.vo.TeacherAuditNoteVo;
import com.soft1851.springboot.smart.attendance.model.vo.UserVo;
import com.soft1851.springboot.smart.attendance.repository.SysUserRepository;
import com.soft1851.springboot.smart.attendance.service.SysUserService;
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

    @Override
    public Map<String, Object> login(LoginDto loginDto) {
        Map<String, Object> map = new HashMap<>(3);
//        UserVo userInfo = sysUserRepository.getUserInfo(loginDto.getAccount());
        String password = Md5Util.getMd5(loginDto.getPassword(), true, 32);
//        if (userInfo.getSysUserPassword().equals(password)) {
//            map.put("user", )
//        }
        return null;

    }

    /**
     * 老师查询本班学生所有假条
     */
    public List<TeacherAuditNoteVo> findAllStudentNote(String userId){
        //第一步 根据老师id查询班级id
        Long clazzId = sysUserRepository.findSysClazzIdByPkSysUserIdEquals(userId);
        //第二步 根据班级id和角色id查询本班级所有学生假条
        return sysUserRepository.findTeacherAuditNoteVoBySysClazzIdAndRoleIdEquals(clazzId);
    }

}

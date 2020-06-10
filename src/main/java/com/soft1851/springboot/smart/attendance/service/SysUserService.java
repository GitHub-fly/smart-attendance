package com.soft1851.springboot.smart.attendance.service;

import com.soft1851.springboot.smart.attendance.model.dto.LoginDto;

import java.util.Map;

/**
 * @author xunmi
 * @ClassName SysUserService
 * @Description TODO
 * @Date 2020/6/10
 * @Version 1.0
 **/
public interface SysUserService {

    /**
     * 用户登录的方法
     *
     * @param loginDto
     * @return 返回用户的基本信息和功能权限
     */
    Map<String, Object> login(LoginDto loginDto);
}

package com.soft1851.springboot.smart.attendance.controller;

import com.soft1851.springboot.smart.attendance.annotation.ControllerWebLog;
import com.soft1851.springboot.smart.attendance.constant.ResponseResult;
import com.soft1851.springboot.smart.attendance.constant.ResultCode;
import com.soft1851.springboot.smart.attendance.model.dto.LoginDto;
import com.soft1851.springboot.smart.attendance.service.SysUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author xunmi
 * @ClassName SysUserController
 * @Description TODO
 * @Date 2020/6/10
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 用户登录接口
     *
     * @param loginDto
     * @return
     */
    @PostMapping("/login")
    @ControllerWebLog(name = "login", isSaved = true)
    public Map<String, Object> login(@RequestBody LoginDto loginDto) {
        return sysUserService.login(loginDto);
    }
}

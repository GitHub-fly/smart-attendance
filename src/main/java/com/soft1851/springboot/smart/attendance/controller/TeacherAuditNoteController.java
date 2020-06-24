package com.soft1851.springboot.smart.attendance.controller;

import com.soft1851.springboot.smart.attendance.annotation.ControllerWebLog;
import com.soft1851.springboot.smart.attendance.model.entity.SysUser;
import com.soft1851.springboot.smart.attendance.model.vo.TeacherAuditNoteVo;
import com.soft1851.springboot.smart.attendance.service.SysUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ke
 * @ClassName TeacherAuditNoteController
 * @Description TOOD
 * @Date 2020/6/11
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "api/note")
public class TeacherAuditNoteController {

    @Resource
    private SysUserService sysUserService;

    @PostMapping("teacher/all")
    @ControllerWebLog(name = "getStudentAllNote", isSaved = true)
    public Map<String, Object> getStudentAllNote(@RequestBody SysUser sysUser) {
        return sysUserService.findAllStudentNote(sysUser.getPkSysUserId());
    }

}

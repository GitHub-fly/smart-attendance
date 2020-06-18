package com.soft1851.springboot.smart.attendance.controller;

import com.soft1851.springboot.smart.attendance.model.entity.SysClazz;
import com.soft1851.springboot.smart.attendance.model.vo.ClazzNoteVo;
import com.soft1851.springboot.smart.attendance.service.SysClazzService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ke
 * @ClassName ClazzNoteController
 * @Description TOOD
 * @Date 2020/6/18
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "api")
public class ClazzNoteController {

    @Resource
    private SysClazzService sysClazzService;

    /**
     *
     *  根据班级名称查询学生信息和假条状态
     */
    @PostMapping("clazz/noteAll")
    public List<ClazzNoteVo> getClazzNote(@RequestBody SysClazz sysClazz) {
        return sysClazzService.findClazzNote(sysClazz.getName());
    }
}

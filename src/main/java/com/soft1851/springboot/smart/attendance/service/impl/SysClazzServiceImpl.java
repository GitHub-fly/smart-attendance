package com.soft1851.springboot.smart.attendance.service.impl;

import com.soft1851.springboot.smart.attendance.model.vo.ClazzNoteVo;
import com.soft1851.springboot.smart.attendance.repository.SysClazzRepository;
import com.soft1851.springboot.smart.attendance.service.SysClazzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ke
 * @ClassName SysClazzServiceImpl
 * @Description TOOD
 * @Date 2020/6/18
 * @Version 1.0
 **/
@Service
public class SysClazzServiceImpl implements SysClazzService {

    @Resource
    private SysClazzRepository sysClazzRepository;

    /**
     * 根据班级名称查询学生信息和假条信息
     */
    @Override
    public List<ClazzNoteVo> findClazzNote(String clazzName) {
        return sysClazzRepository.findByNameEquals(clazzName);
    }
}

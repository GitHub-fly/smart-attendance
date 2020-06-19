package com.soft1851.springboot.smart.attendance.service;

import com.soft1851.springboot.smart.attendance.model.entity.SysClazz;
import com.soft1851.springboot.smart.attendance.model.vo.ClazzNoteVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ke
 * @ClassName SysClazzRepository
 * @Description TOOD
 * @Date 2020/6/18
 * @Version 1.0
 **/
public interface SysClazzService {

    /**
     *
     *  根据班级名称查询学生信息和假条信息
     */
    List<ClazzNoteVo> findClazzNote(String clazzName);
}

package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author ke
 * @ClassName SysNoteRepository
 * @Description TOOD
 * @Date 2020/6/8
 * @Version 1.0
 **/
public interface SysNoteRepository extends JpaRepository<SysNote, Integer> {

    /**
     * 插入学生请假记录
     */


}

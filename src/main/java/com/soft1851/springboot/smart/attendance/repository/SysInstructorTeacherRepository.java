package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysInstructorTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author ke
 * @ClassName SysInstructorTeacherRepository
 * @Description TOOD
 * @Date 2020/6/23
 * @Version 1.0
 **/
public interface SysInstructorTeacherRepository extends JpaRepository<SysInstructorTeacher, Integer> {

    /**
     * 根据班主任id查询辅导员id
     */
    @Query("SELECT i.instructorId FROM SysInstructorTeacher i WHERE i.teacherId = ?1")
    String findInstructorByTeacherIdEquals(String teacherId);
}

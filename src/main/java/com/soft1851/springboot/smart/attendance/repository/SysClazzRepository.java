package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysClazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ke
 * @ClassName SysClazzRepository
 * @Description TOOD
 * @Date 2020/6/17
 * @Version 1.0
 **/
public interface SysClazzRepository extends JpaRepository<SysClazz, Integer> {

    /**
     * 根据辅导员id和姓名查询所管理的班级
     */
    @Query("SELECT c FROM SysClazz c LEFT JOIN SysUser u " +
            "ON c.academyName = u.sysUserInstructorName " +
            "WHERE u.pkSysUserId = ?1 AND c.academyName = ?2 ")
    List<SysClazz> findAllByAcademyNameAndPkSysUserId(String userId, String academyName);
}

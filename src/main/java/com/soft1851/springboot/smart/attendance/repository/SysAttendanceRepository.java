package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysAttendance;
import com.soft1851.springboot.smart.attendance.model.vo.EntityVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ZENG
 */
public interface SysAttendanceRepository extends JpaRepository<SysAttendance, Long> {

    /**
     * 通过学生id查未打卡学生信息
     * @param userIds
     * @return
     */
    @Query(value = "SELECT u.pk_sys_user_id,u.sys_user_avatar,u.sys_user_name," +
            "u.sys_user_phone,c.teacher_name,c.teacher_phone " +
            "FROM sys_user u " +
            "LEFT JOIN sys_clazz c ON u.sys_clazz_id=c.pk_sys_clazz_id " +
            "WHERE u.pk_sys_user_id IN ?1 AND u.is_attendance=0", nativeQuery = true)
    List<Object> queryUnCheckInfo(List<String> userIds);

    /**
     * 根据id查看学生详情接口
     * @param userId
     * @return
     */
    @Query(value = "SELECT u.sys_user_name, u.sys_job_number, d.name " +
            "AS room_name, c.name AS clazz_name, c.academy_name, u.sys_user_phone, u.is_attendance " +
            "FROM sys_user u " +
            "RIGHT JOIN sys_clazz c ON u.sys_clazz_id=c.pk_sys_clazz_id " +
            "RIGHT JOIN dormitory_student ds ON ds.user_id=u.pk_sys_user_id " +
            "RIGHT JOIN sys_dormitory d ON d.pk_sys_dormitory_id=ds.dormitory_id " +
            "WHERE u.pk_sys_user_id=?1", nativeQuery = true)
    List<Object> queryStuInfo(String userId);
}

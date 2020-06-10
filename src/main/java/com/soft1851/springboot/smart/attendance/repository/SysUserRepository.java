package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysUser;
import com.soft1851.springboot.smart.attendance.model.vo.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author xunmi
 * @ClassName UserRepository
 * @Description TODO
 * @Date 2020/6/10
 * @Version 1.0
 **/
public interface SysUserRepository extends JpaRepository<SysUser, String> {

    /**
     * 通过用户手机号查找该用户的基本信息方法
     *
     * @param sysUserPhone
     * @return
     */
    @Query(value = "SELECT u.pk_sys_user_id, u.sys_user_name, u.sys_user_nickname, u.sys_user_gender, " +
            "u.sys_job_number, u.sys_user_instructor_name, u.sys_user_academy_teacher_name, u.is_attendance, " +
            "u.sys_user_phone, u.sys_user_password, u.sys_user_avatar, r.role_name, c.name AS clazz_name, c.teacher_name, " +
            "c.academy_name\n" +
            "FROM sys_user u\n" +
            "LEFT JOIN sys_clazz c\n" +
            "ON u.sys_clazz_id = c.pk_sys_clazz_id\n" +
            "LEFT JOIN sys_role r\n" +
            "ON r.pk_role_id = u.role_id\n" +
            "WHERE u.sys_user_phone = ?1", nativeQuery = true)
    List<Object> getUserInfo(String sysUserPhone);
}

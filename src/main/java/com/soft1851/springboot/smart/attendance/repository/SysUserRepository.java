package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysUser;
import com.soft1851.springboot.smart.attendance.model.vo.TeacherAuditNoteVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZENG
 */

public interface SysUserRepository extends JpaRepository<SysUser, String> {

    /**
     * 通过用户手机号查找该用户的基本信息方法
     *
     * @param sysUserPhone
     * @return
     */
    @Query(value = "SELECT u.pk_sys_user_id, u.sys_user_name, u.sys_user_nickname, u.sys_user_gender, " +
            "u.sys_job_number, u.sys_user_instructor_name, u.sys_user_academy_teacher_name, u.is_attendance, " +
            "u.sys_user_phone, u.sys_user_password, u.sys_user_avatar, r.pk_role_id, r.role_name, c.name AS clazz_name, " +
            "c.teacher_name, c.academy_name\n" +
            "FROM sys_user u\n" +
            "LEFT JOIN sys_clazz c\n" +
            "ON u.sys_clazz_id = c.pk_sys_clazz_id\n" +
            "LEFT JOIN sys_role r\n" +
            "ON r.pk_role_id = u.role_id\n" +
            "WHERE u.sys_user_phone = ?1", nativeQuery = true)
    List<Object> getUserInfo(String sysUserPhone);

    /**
     * 老师查看班级学生所有假条
     */
    @Query("SELECT NEW com.soft1851.springboot.smart.attendance.model.vo.TeacherAuditNoteVo(n.pkNoteId, u.sysUserName, u.sysUserAvatar, c.name, n.type, n.status, n.gmtCreate)"
            + "FROM SysUser u "
            + "LEFT JOIN SysClazz c "
            + "ON u.sysClazzId = c.pkSysClazzId "
            + "LEFT JOIN SysNote n "
            + "ON u.pkSysUserId = n.userId "
            + "WHERE u.sysClazzId = ?1 AND u.roleId = 1 ORDER BY n.pkNoteId DESC ")
    List<TeacherAuditNoteVo> findTeacherAuditNoteVoBySysClazzIdAndRoleIdEquals(Long clazzId);

    /**
     * 根据老师id查询班级id
     */
    @Query(value = "SELECT sysClazzId FROM SysUser WHERE pkSysUserId = ?1")
    Long findSysClazzIdByPkSysUserIdEquals(String userId);

    /**
     * 根据用户id 查找出该用户所拥有的资源权限
     *
     * @param userId
     * @return
     */
    @Query(value = "SELECT m.icon, m.name, m.path\n" +
            "FROM sys_user u\n" +
            "LEFT JOIN sys_role_menu rm\n" +
            "ON u.role_id = rm.role_id\n" +
            "LEFT JOIN sys_menu m\n" +
            "ON rm.menu_id = m.pk_menu_id\n" +
            "WHERE u.pk_sys_user_id = ?1\n", nativeQuery = true)
    List<Object> getMenuUserId(String userId);

    /**
     * 每日重置学生打卡字段为0
     *
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "UPDATE SysUser c SET c.isAttendance = 0 WHERE c.roleId = 1 ")
    int updateIsAttendance();
}

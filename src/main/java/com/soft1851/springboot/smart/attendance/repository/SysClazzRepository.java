package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysClazz;
<<<<<<< HEAD
import com.soft1851.springboot.smart.attendance.model.vo.TeacherVo;
=======
>>>>>>> 22d86ecccc883f4da8a6c7c8eef8c22cab7ce30b
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ke
<<<<<<< HEAD
 * @ClassName SysClazzRepoditory
 * @Description TOOD
 * @Date 2020/6/18
 * @Version 1.0
 **/
 public interface SysClazzRepository extends JpaRepository<SysClazz, Integer> {

    /**
     * 根据辅导员id查班级信息和班主任头像
     */
    @Query("SELECT NEW com.soft1851.springboot.smart.attendance.model.vo.TeacherVo(u.sysUserAvatar, c.teacherName, c.teacherPhone, c.name)"
            + "FROM SysClazz c "
            + "LEFT JOIN SysUser u "
            + "ON c.pkSysClazzId = u.sysClazzId "
            + "LEFT JOIN SysInstructorTeacher i "
            + "ON u.pkSysUserId = i.teacherId "
            + "WHERE i.instructorId = ?1")
    List<TeacherVo> findTeacherVoByInstructorId(String instructorId);
=======
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
>>>>>>> 22d86ecccc883f4da8a6c7c8eef8c22cab7ce30b
}

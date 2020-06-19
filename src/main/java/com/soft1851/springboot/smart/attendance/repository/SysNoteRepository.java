package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysNote;
import com.soft1851.springboot.smart.attendance.model.vo.NoteVo;
import com.soft1851.springboot.smart.attendance.model.vo.StudentNoteVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


/**
 * @author ke
 * @ClassName SysNoteRepository
 * @Description TOOD
 * @Date 2020/6/8
 * @Version 1.0
 **/
public interface SysNoteRepository extends JpaRepository<SysNote, Long> {

    /**
     * 假条信息查询接口
     */
    @Query("SELECT NEW com.soft1851.springboot.smart.attendance.model.vo.NoteVo(u.sysUserName, u.sysUserGender," +
            " n.userPhone, u.sysJobNumber, c.name, c.teacherName, n.type, n.dayCount, n.isDormitory, n.isSchool, " +
            "n.startTime, n.finishTime, n.reason, n.teacherOpinion, u.sysUserInstructorName, u.sysUserAcademyTeacherName," +
            " n.instructorOpinion, n.academyOpinion)"
            + "FROM SysNote n "
            + "LEFT JOIN SysUser u "
            + "ON n.userId = u.pkSysUserId "
            + "LEFT JOIN SysClazz c "
            + "ON c.pkSysClazzId = u.sysClazzId "
            + "WHERE n.pkNoteId = ?1")
    NoteVo findNoteVoByPkNoteId(Long NoteId);

    /**
     * 查询学生所有假条
     */
    @Query("SELECT NEW com.soft1851.springboot.smart.attendance.model.vo.StudentNoteVo(n.pkNoteId, n.type, n.status, n.gmtCreate)"+ "FROM SysNote n " +
            "WHERE n.userId = ?1")
    List<StudentNoteVo> findByUserIdEquals(String userId);

    /**
     * 添加班主任意见
     */
    @Transactional
    @Modifying
    @Query("UPDATE SysNote n SET n.teacherOpinion = ?2 WHERE n.pkNoteId = ?1 ")
    int updateTeacherOpinion(Long pkNoteId, String teacherOpinion);

    /**
     * 添加辅导员意见
     */
    @Transactional
    @Modifying
    @Query("UPDATE SysNote n SET n.instructorOpinion = ?2 WHERE n.pkNoteId = ?1 ")
    int updateInstructorOpinion(Long pkNoteId, String instructorOpinion);

    /**
     * 添加二级学院意见
     */
    @Transactional
    @Modifying
    @Query("UPDATE SysNote n SET n.academyOpinion = ?2 WHERE n.pkNoteId = ?1 ")
    int updateAcademyOpinion(Long pkNoteId, String academyOpinion);

    /**
     * 根据班级名称查班级假条状态
     */
    @Query("SELECT n.status FROM SysNote n " +
            "LEFT JOIN SysUser u " +
            "ON u.pkSysUserId = n.userId "
            + "LEFT JOIN SysClazz c "
            + "ON c.pkSysClazzId = u.sysClazzId "
            + "WHERE c.name = ?1 ")
    List<Integer> findStatusByClazzName(String clazzName);
}

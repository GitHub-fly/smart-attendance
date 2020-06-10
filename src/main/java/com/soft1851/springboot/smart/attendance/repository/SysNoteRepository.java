package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysNote;
import com.soft1851.springboot.smart.attendance.model.vo.NoteVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


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



}

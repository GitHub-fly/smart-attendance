package com.soft1851.springboot.smart.attendance.service;

import com.soft1851.springboot.smart.attendance.model.dto.NoteDto;
import com.soft1851.springboot.smart.attendance.model.dto.OpinionDto;
import com.soft1851.springboot.smart.attendance.model.entity.SysNote;
import com.soft1851.springboot.smart.attendance.model.vo.NoteIdVo;
import com.soft1851.springboot.smart.attendance.model.vo.NoteVo;
import com.soft1851.springboot.smart.attendance.model.vo.StudentNoteVo;
import com.soft1851.springboot.smart.attendance.model.vo.TeacherVo;

import java.util.List;
import java.util.Map;

/**
 * @author ke
 * @ClassName SysNoteService
 * @Description TOOD
 * @Date 2020/6/9
 * @Version 1.0
 **/
public interface SysNoteService {

    /**
     * 插入假条信息
     *
     * @param noteDto
     * @return
     */
    NoteIdVo insertByNoteId(NoteDto noteDto);

    /**
     * 返回假条id
     *
     * @param noteId
     * @return
     */
    NoteVo findNote(Long noteId);

    /**
     * 查询学生所有假条状态
     *
     * @param userId
     * @return
     */
    List<StudentNoteVo> findAllStatus(String userId);

    /**
     * 老师审核意见
     */
    int updateTeacherOpinoin(OpinionDto opinionDto);

    /**
     * 根据辅导员id查班级假条状态
     * @return
     */
    List<Map<String, Object>> findTeacherVo(String instructorId);
}
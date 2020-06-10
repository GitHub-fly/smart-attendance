package com.soft1851.springboot.smart.attendance.service;

import com.soft1851.springboot.smart.attendance.model.dto.NoteDto;

/**
 * @author ke
 * @ClassName SysNoteService
 * @Description TOOD
 * @Date 2020/6/9
 * @Version 1.0
 **/
public interface SysNoteService {
    /**
     * 插入学生请假记录
     */
    Long insertNote(NoteDto noteDto);
}

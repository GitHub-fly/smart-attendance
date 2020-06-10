package com.soft1851.springboot.smart.attendance.service;

import com.soft1851.springboot.smart.attendance.model.dto.NoteDto;
import com.soft1851.springboot.smart.attendance.model.entity.SysNote;
import com.soft1851.springboot.smart.attendance.model.vo.NoteIdVo;
import com.soft1851.springboot.smart.attendance.model.vo.NoteVo;

/**
 * @author ke
 * @ClassName SysNoteService
 * @Description TOOD
 * @Date 2020/6/9
 * @Version 1.0
 **/
public interface SysNoteService {

    /**
     * 返回假条id
     *
     * @param noteDto
     * @return
     */
    NoteIdVo findNoteId(NoteDto noteDto);

    /**
     * 返回假条id
     *
     * @param noteId
     * @return
     */
    NoteVo findNote(Long noteId);

}
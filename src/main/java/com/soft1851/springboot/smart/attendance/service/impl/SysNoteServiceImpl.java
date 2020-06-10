package com.soft1851.springboot.smart.attendance.service.impl;

import com.soft1851.springboot.smart.attendance.model.dto.NoteDto;
import com.soft1851.springboot.smart.attendance.model.entity.SysNote;
import com.soft1851.springboot.smart.attendance.model.vo.NoteVo;
import com.soft1851.springboot.smart.attendance.repository.SysNoteRepository;
import com.soft1851.springboot.smart.attendance.service.SysNoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ke
 * @ClassName SysNoteServiceImpl
 * @Description TOOD
 * @Date 2020/6/10
 * @Version 1.0
 **/
@Service
public class SysNoteServiceImpl implements SysNoteService {
    @Resource
    private SysNoteRepository sysNoteRepository;

    @Override
    public NoteVo findNoteId(NoteDto noteDto) {
        SysNote sysNote = SysNote.builder()
                .userId(noteDto.getUserId())
                .type(noteDto.getType())
                .userPhone(noteDto.getUserPhone())
                .dayCount(noteDto.getDayCount())
                .isDormitory(noteDto.getIsDormitory())
                .isSchool(noteDto.getIsSchool())
                .startTime(noteDto.getStartTime())
                .finishTime(noteDto.getFinishTime())
                .reason(noteDto.getReason())
                .build();

        return NoteVo.builder().noteId(sysNoteRepository.save(sysNote).getPkNoteId()).build();
    }

}

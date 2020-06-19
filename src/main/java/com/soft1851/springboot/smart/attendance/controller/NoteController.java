package com.soft1851.springboot.smart.attendance.controller;

import com.soft1851.springboot.smart.attendance.annotation.ControllerWebLog;
import com.soft1851.springboot.smart.attendance.model.dto.NoteDto;
import com.soft1851.springboot.smart.attendance.model.dto.OpinionDto;
import com.soft1851.springboot.smart.attendance.model.entity.SysNote;
import com.soft1851.springboot.smart.attendance.model.entity.SysUser;
import com.soft1851.springboot.smart.attendance.model.vo.NoteIdVo;
import com.soft1851.springboot.smart.attendance.model.vo.NoteVo;
import com.soft1851.springboot.smart.attendance.model.vo.StudentNoteVo;
import com.soft1851.springboot.smart.attendance.repository.SysNoteRepository;
import com.soft1851.springboot.smart.attendance.service.SysNoteService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ke
 * @ClassName InfoNote
 * @Description TOOD
 * @Date 2020/6/10
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/api/note")
public class NoteController {

    @Resource
    private SysNoteService sysNoteService;
    @Resource
    private SysNoteRepository sysNoteRepository;

    @PostMapping("/increase")
    @ControllerWebLog(name = "getPkNoteId", isSaved = true)
    public NoteIdVo getPkNoteId(@RequestBody NoteDto noteDto) {
        return sysNoteService.insertByNoteId(noteDto);
    }


    /**
     * 查询假条信息
     *
     * @param sysNote 假条 id
     * @return
     */
    @PostMapping("/info")
    @ControllerWebLog(name = "getNote", isSaved = true)
    public NoteVo getNote(@RequestBody SysNote sysNote) {
        return sysNoteService.findNote(sysNote.getPkNoteId());
    }

    /**
     * 查询假条信息
     *
     * @param sysNote 假条 id
     * @return
     */
    @PostMapping("/student/all")
    @ControllerWebLog(name = "getNoteStatus", isSaved = true)
    public List<StudentNoteVo> getNoteStatus(@RequestBody SysNote sysNote) {
        return sysNoteService.findAllStatus(sysNote.getUserId());
    }

    @PostMapping("teacher/advice")
    @ControllerWebLog(name = "updateNoteOpinoin", isSaved = true)
    public int updateNoteOpinoin(@RequestBody OpinionDto opinionDto) {
        return sysNoteService.updateTeacherOpinoin(opinionDto);
    }

    /**
     * 辅导员查看各班级请假情况
     */
    @PostMapping("insturctor/all")
    @ControllerWebLog(name = "getAllClazzNote", isSaved = true)
    public List<Map<String, Object>> getAllClazzNote(@RequestBody SysUser sysUser) {
        return sysNoteService.findTeacherVo(sysUser.getPkSysUserId());
    }
}

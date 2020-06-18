package com.soft1851.springboot.smart.attendance.service.impl;

import com.soft1851.springboot.smart.attendance.model.dto.NoteDto;
import com.soft1851.springboot.smart.attendance.model.dto.OpinionDto;
import com.soft1851.springboot.smart.attendance.model.entity.SysNote;
import com.soft1851.springboot.smart.attendance.model.vo.NoteIdVo;
import com.soft1851.springboot.smart.attendance.model.vo.NoteVo;
import com.soft1851.springboot.smart.attendance.model.vo.StudentNoteVo;
import com.soft1851.springboot.smart.attendance.model.vo.TeacherVo;
import com.soft1851.springboot.smart.attendance.repository.SysClazzRepository;
import com.soft1851.springboot.smart.attendance.repository.SysNoteRepository;
import com.soft1851.springboot.smart.attendance.service.SysNoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

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
    @Resource
    private SysClazzRepository sysClazzRepository;

    @Override
    public NoteIdVo insertByNoteId(NoteDto noteDto) {
        SysNote sysNote = SysNote.builder()
                .userId(noteDto.getUserId())
                .type(noteDto.getType())
                .userPhone(noteDto.getUserPhone())
                .dayCount(noteDto.getDayCount())
                .isDormitory(noteDto.getIsDormitory())
                .isSchool(noteDto.getIsSchool())
                .startTime(noteDto.getStartTime())
                .finishTime(noteDto.getFinishTime())
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                .reason(noteDto.getReason())
                .build();

        return NoteIdVo.builder().noteId(sysNoteRepository.save(sysNote).getPkNoteId()).build();
    }

    /**
     * 查询假条信息
     *
     * @param noteId
     * @return
     */
    @Override
    public NoteVo findNote(Long noteId) {
        return sysNoteRepository.findNoteVoByPkNoteId(noteId);
    }

    /**
     * 查询学生假条所有状态
     */
    @Override
    public List<StudentNoteVo> findAllStatus(String userId){
        return sysNoteRepository.findByUserIdEquals(userId);
    }

    /**
     * 老师审核意见
     */
    @Override
    public int updateTeacherOpinoin(OpinionDto opinionDto){
        if(opinionDto.getRoleId() == 2) {
            return sysNoteRepository.updateTeacherOpinion(opinionDto.getPkNoteId(), opinionDto.getApprovalOpinion());
        }else if (opinionDto.getRoleId() == 3) {
            return sysNoteRepository.updateInstructorOpinion(opinionDto.getPkNoteId(), opinionDto.getApprovalOpinion());
        }else {
            return sysNoteRepository.updateAcademyOpinion(opinionDto.getPkNoteId(), opinionDto.getApprovalOpinion());
        }
    }

    /**
     * 根据辅导员id查班级请假情况
     * @param instructorId
     * @return
     */
    @Override
    public List<Map<String, Object>> findTeacherVo(String instructorId){
        List<TeacherVo> teacherVos = sysClazzRepository.findTeacherVoByInstructorId(instructorId);
        System.out.println("正常");
        List<Map<String, Object>> getTeacherList = new ArrayList<Map<String, Object>>() ;
        teacherVos.forEach(teacherVo -> {
            Map<String, Object> map = new HashMap<>();
            System.out.println(teacherVo.getName());
            List<Integer> getStatus = sysNoteRepository.findStatusByClazzName(teacherVo.getName());
            System.out.println(teacherVo.getName()+"所管理班级请假状态"+getStatus);
            map.put("status", getStatus);
            map.put("teacher", teacherVo);
            getTeacherList.add(map);
        });
        return getTeacherList;
    }
}
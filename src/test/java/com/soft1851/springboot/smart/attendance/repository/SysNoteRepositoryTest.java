package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysNote;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;

@SpringBootTest
public class SysNoteRepositoryTest {

    @Resource
    private SysNoteRepository sysNoteRepository;

    @Test
    void insert() {
        SysNote sysNote = SysNote.builder()
                .userId("001")
                .type(1)
                .userPhone("18851998839")
                .dayCount(2)
                .isDormitory(1)
                .isSchool(0)
                .status(2)
                .startTime(new Timestamp(System.currentTimeMillis()))
                .finishTime(new Timestamp(System.currentTimeMillis()))
                .reason("我今天不舒服")
                .build();
        System.out.println(sysNoteRepository.save(sysNote));
        SysNote s = sysNoteRepository.save(sysNote);
        System.out.println(s.getPkNoteId());
    }

    @Test
    void findNoteVoByPkNoteIdEquals() {
        System.out.println(sysNoteRepository.findNoteVoByPkNoteId(1l));
    }

    @Test
    void findByUserIdEquals() {
        sysNoteRepository.findByUserIdEquals("001").forEach(System.out::println);
    }

    @Test
    void updateTeacherOpinion() {
        System.out.println(sysNoteRepository.updateTeacherOpinion(1L, "同意"));
    }

    @Test
    void updateInstructorOpinion() {
        System.out.println(sysNoteRepository.updateInstructorOpinion(1L, "同意"));
    }

    @Test
    void updateAcademyOpinion() {
        System.out.println(sysNoteRepository.updateAcademyOpinion(1L, "同意"));
    }

    @Test
    void findStatusByClazzName() {
        sysNoteRepository.findStatusByClazzName("软件1851").forEach(System.out::println);
    }
}
package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysNote;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SysNoteRepositoryTest {
    @Resource
    private SysNoteRepository sysNoteRepository;

    @Test
    void insert() {
        SysNote sysNote = SysNote.builder()
                .userId("001")
                .type(1)
                .dayCount(2)
                .isDormitory(1)
                .isSchool(0)
                .startTime(new Timestamp(System.currentTimeMillis()))
                .finishTime(new Timestamp(System.currentTimeMillis()))
                .reason("我今天不舒服")
                .build();
        System.out.println(sysNoteRepository.save(sysNote));
    }
}
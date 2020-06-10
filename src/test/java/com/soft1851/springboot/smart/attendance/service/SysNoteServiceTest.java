package com.soft1851.springboot.smart.attendance.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SysNoteServiceTest {
    @Resource
    private SysNoteService sysNoteService;

    @Test
    void findNote() {
        System.out.println(sysNoteService.findNote(1l));
    }
}
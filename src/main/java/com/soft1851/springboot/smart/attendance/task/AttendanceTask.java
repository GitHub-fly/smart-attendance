package com.soft1851.springboot.smart.attendance.task;

import com.soft1851.springboot.smart.attendance.repository.SysUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Zeng
 * @ClassName AttendanceTask
 * @Description 定时任务重置学生打卡
 * @Date 2020/6/19
 * @Version 1.0
 **/
@Slf4j
@Component
public class AttendanceTask {

    @Resource
    private SysUserRepository sysUserRepository;

    /**
     * 每日00：00重置打卡
     */
    @Scheduled(cron = "0 00 00 * * ?")
    private void setAttendance(){
        int row = sysUserRepository.updateIsAttendance();
        log.info("已重置"+row+"条学生打卡信息");
    }
}

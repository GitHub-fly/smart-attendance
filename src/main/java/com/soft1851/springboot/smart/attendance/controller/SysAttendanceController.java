package com.soft1851.springboot.smart.attendance.controller;

import cn.hutool.core.date.DateUtil;
import com.soft1851.springboot.smart.attendance.constant.ResponseResult;
import com.soft1851.springboot.smart.attendance.constant.ResultCode;
import com.soft1851.springboot.smart.attendance.model.dto.AttendanceDto;
import com.soft1851.springboot.smart.attendance.model.vo.EntityVo;
import com.soft1851.springboot.smart.attendance.service.SysAttendanceService;
import com.soft1851.springboot.smart.attendance.util.TimeUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Zeng
 * @ClassName SysAttendanceController
 * @Description TOOD
 * @Date 2020/6/10
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/attendance")
public class SysAttendanceController {

    /**
     * 今日日期
     */
    String now = DateUtil.today();

    /**
     * 打卡开始和结束时间
     */
    String starTime = now + " 13:00:00";
    String endTime = now + " 22:00:00";

    private Date start = DateUtil.parse(starTime, "yyyy-MM-dd HH:mm:ss");
    private Date end = DateUtil.parse(endTime, "yyyy-MM-dd HH:mm:ss");


    @Resource
    private SysAttendanceService attendanceService;

    @PostMapping("/increase")
    public ResponseResult checkIn(@RequestBody AttendanceDto attendanceDto) {
        // 判断当前时间是否在打卡时间段内
        if (!TimeUtil.belongCalendar(DateUtil.date(), start, end)) {
            return ResponseResult.failure(ResultCode.ATTENDANCE_TIME_OUT);
        }
        return attendanceService.checkIn(attendanceDto);
    }

    @PostMapping("/manager/info")
    public List<EntityVo> queryCheckInfo(@RequestParam("managerId") String managerId) {
        return attendanceService.queryCheckInfo(managerId);
    }

}

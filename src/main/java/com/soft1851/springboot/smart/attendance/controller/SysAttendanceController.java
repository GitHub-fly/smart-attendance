package com.soft1851.springboot.smart.attendance.controller;

import cn.hutool.core.date.DateUtil;
import com.cxytiandi.encrypt.springboot.annotation.Decrypt;
import com.cxytiandi.encrypt.springboot.annotation.Encrypt;
import com.soft1851.springboot.smart.attendance.constant.ResponseResult;
import com.soft1851.springboot.smart.attendance.constant.ResultCode;
import com.soft1851.springboot.smart.attendance.exception.CustomException;
import com.soft1851.springboot.smart.attendance.model.dto.AttendanceDto;
import com.soft1851.springboot.smart.attendance.model.entity.SysDormitory;
import com.soft1851.springboot.smart.attendance.model.entity.SysUser;
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
    String starTime = now + " 00:00:00";
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

    @Encrypt
    @PostMapping("/manager/info")
    public List<EntityVo> queryCheckInfo(@RequestBody SysUser sysUser) {
        // 当角色是宿管阿姨，执行宿管对应的业务逻辑
        if (sysUser.getRoleId() == 5) {
            return attendanceService.queryCheckInfo(sysUser.getPkSysUserId());
        }
        // 当角色是班主任
        if (sysUser.getRoleId() == 2) {
            return attendanceService.queryClassInfo(sysUser.getPkSysUserId());
        }
        else {
            throw new CustomException("用户权限不足", ResultCode.USER_NO_AUTH);
        }
    }

    @PostMapping("/info/number")
    public List<EntityVo> queryStuCheckInfo(@RequestBody SysDormitory sysDormitory) {
        return attendanceService.queryStuCheckInfo(sysDormitory.getPkSysDormitoryId());
    }

    @PostMapping("/info/not")
    public List<EntityVo> queryUnStuCheckInfo(@RequestBody SysUser sysUser) {
        return attendanceService.queryUnCheckInfo(sysUser.getPkSysUserId());
    }

    @PostMapping("/user/info")
    public EntityVo queryStuInfo(@RequestBody SysUser sysUser) {
        return attendanceService.queryStuInfo(sysUser.getPkSysUserId()).get(0);
    }

}

package com.soft1851.springboot.smart.attendance.service;

import com.soft1851.springboot.smart.attendance.constant.ResponseResult;
import com.soft1851.springboot.smart.attendance.model.dto.AttendanceDto;
import com.soft1851.springboot.smart.attendance.model.vo.DormitoryVo;
import com.soft1851.springboot.smart.attendance.model.vo.EntityVo;

import java.util.List;

/**
 * @author Zeng
 * @ClassName SysAttendanceService
 * @Description 考勤服务类
 * @Date 2020/6/10
 * @Version 1.0
 **/
public interface SysAttendanceService {

    /**
     * 学生归寝打卡
     *
     * @param attendanceDto dto
     * @return ResponseResult
     */
    ResponseResult checkIn(AttendanceDto attendanceDto);

    /**
     * 宿管查询宿舍打卡情况
     * @param managerId 宿管id
     * @return List
     */
    List<EntityVo> queryCheckInfo(String managerId);

    /**
     * 根据宿舍id查看宿舍内成员打卡信息
     * @param dormitoryId
     * @return
     */
    List<EntityVo> queryStuCheckInfo(Long dormitoryId);

    /**
     * 宿管查看所有未打卡的学生信息接口
     * @param managerId 宿管id
     * @return List
     */
    List<EntityVo> queryUnCheckInfo(String managerId);

    /**
     * 根据id查看学生详情接口
     * @param studentId
     * @return
     */
    List<EntityVo> queryStuInfo(String studentId);

    /**
     * 根据老师id查询所有学生打卡情况
     * @param teacherId
     * @return
     */
    List<EntityVo> queryClassInfo(String teacherId);

}

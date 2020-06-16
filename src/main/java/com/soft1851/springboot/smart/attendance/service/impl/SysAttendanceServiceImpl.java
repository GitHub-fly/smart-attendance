package com.soft1851.springboot.smart.attendance.service.impl;

import com.soft1851.springboot.smart.attendance.constant.ResponseResult;
import com.soft1851.springboot.smart.attendance.model.dto.AttendanceDto;
import com.soft1851.springboot.smart.attendance.model.entity.StudentBuilding;
import com.soft1851.springboot.smart.attendance.model.entity.SysAttendance;
import com.soft1851.springboot.smart.attendance.model.entity.SysUser;
import com.soft1851.springboot.smart.attendance.model.vo.*;
import com.soft1851.springboot.smart.attendance.repository.*;
import com.soft1851.springboot.smart.attendance.service.SysAttendanceService;
import com.soft1851.springboot.smart.attendance.util.DataTypeChange;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Zeng
 * @ClassName SysAttendanceServiceImpl
 * @Description TOOD
 * @Date 2020/6/10
 * @Version 1.0
 **/
@Service
public class SysAttendanceServiceImpl implements SysAttendanceService {

    @Resource
    private SysUserRepository userRepository;

    @Resource
    private SysAttendanceRepository attendanceRepository;

    @Resource
    private UserBuildingRepository userBuildingRepository;

    @Resource
    private StudentBuildingRepository studentBuildingRepository;

    @Resource
    private DormitoryStudentRepository dormitoryStudentRepository;

    @Resource
    private SysDormitoryRepository dormitoryRepository;

    @Override
    public ResponseResult checkIn(AttendanceDto attendanceDto) {
        SysAttendance attendance = SysAttendance.builder()
                .userId(attendanceDto.getUserId())
                .longitude(attendanceDto.getLongitude())
                .latitude(attendanceDto.getLatitude())
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                .deleteFlag(0)
                .build();
        //打卡记录表写入一条数据
        SysAttendance save = attendanceRepository.save(attendance);

        //用户表修改是否打卡字段
        Optional<SysUser> userOptional = userRepository.findById(attendanceDto.getUserId());
        SysUser user = userOptional.get();
        user.setIsAttendance(1);
        userRepository.save(user);
        return ResponseResult.success();
    }

    @Override
    public List<EntityVo> queryCheckInfo(String managerId) {
        // 查到楼栋id
        Long buildingId = userBuildingRepository.findUserBuildingByUserId(managerId).getBuildingId();
        List<StudentBuilding> studentBuildings = studentBuildingRepository.findStudentBuildingsByBuildingId(buildingId);
        // 查到所有学生Id
        List<String> stuIds = new ArrayList<>();
        for (StudentBuilding studentBuilding : studentBuildings) {
           stuIds.add(studentBuilding.getStudentId());
        }
        // 查到所有宿舍id
        List<Long> dormitoryIds = dormitoryStudentRepository.queryDormitoryId(stuIds);
        // 查到宿舍信息
        List<Object> objectList = dormitoryRepository.findDormitoryByIds(dormitoryIds);
        List<EntityVo> entityVos = DataTypeChange.changeObj(objectList, DormitoryVo.class);
        return entityVos;
    }

    @Override
    public List<EntityVo> queryStuCheckInfo(Long dormitoryId) {
        List<Object> objects = dormitoryRepository.findStuCheckInfo(dormitoryId);
        List<EntityVo> entityVos = DataTypeChange.changeObj(objects, StuCheckInVo.class);
        return entityVos;
    }

    @Override
    public List<EntityVo> queryUnCheckInfo(String managerId) {
        // 查到楼栋id
        Long buildingId = userBuildingRepository.findUserBuildingByUserId(managerId).getBuildingId();
        List<StudentBuilding> studentBuildings = studentBuildingRepository.findStudentBuildingsByBuildingId(buildingId);
        // 查到所有学生Id
        List<String> stuIds = new ArrayList<>();
        for (StudentBuilding studentBuilding : studentBuildings) {
            stuIds.add(studentBuilding.getStudentId());
        }
        //查未打卡学生信息
        List<Object> objects = attendanceRepository.queryUnCheckInfo(stuIds);
        List<EntityVo> entityVos = DataTypeChange.changeObj(objects, StuUnCheckVo.class);
        return entityVos;
    }

    @Override
    public List<EntityVo> queryStuInfo(String studentId) {
        List<Object> objects = attendanceRepository.queryStuInfo(studentId);
        List<EntityVo> entityVos = DataTypeChange.changeObj(objects, StudentVo.class);
        return entityVos;
    }

    @Override
    public List<EntityVo> queryClassInfo(String teacherId) {
        List<Object> objects = attendanceRepository.queryClassCheckIn(teacherId);
        List<EntityVo> entityVos = DataTypeChange.changeObj(objects, ClassStudentVo.class);
        return entityVos;
    }

}

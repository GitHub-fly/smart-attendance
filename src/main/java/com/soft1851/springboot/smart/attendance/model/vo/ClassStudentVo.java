package com.soft1851.springboot.smart.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zeng
 * @ClassName ClassStudentVo
 * @Description 班级学生Vo
 * @Date 2020/6/15
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClassStudentVo implements EntityVo {

    /**
     * 学生id
     */
    private String pkSysUserId;

    /**
     * 头像
     */
    private String sysUserAvatar;

    /**
     * 学生真实姓名
     */
    private String sysUserName;

    /**
     * 联系方式
     */
    private String sysUserPhone;

    /**
     * 是否打卡
     */
    private Integer isAttendance;

}

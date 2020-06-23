package com.soft1851.springboot.smart.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author xunmi
 * @ClassName UserVo
 * @Description TODO
 * @Date 2020/6/10
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVo implements EntityVo {

    /**
     * 用户id
     */
    private String pkSysUserId;

    /**
     * 用户真实名字
     */
    private String sysUserName;

    /**
     * 用户昵称
     */
    private String sysUserNickname;

    /**
     * 性别
     */
    private String sysUserGender;

    /**
     * 学号、教工号、职工号
     */
    @NotNull
    private String sysJobNumber;

    /**
     * 学生的辅导员姓名
     */
    private String sysUserInstructorName;

    /**
     * 学生的二级学院老师名
     */
    private String sysUserAcademyTeacherName;

    /**
     * 学生今日打卡
     */
    private Integer isAttendance;

    /**
     * 手机号
     */
    private String sysUserPhone;

    /**
     * 用户密码
     */
    private String sysUserPassword;

    /**
     * 头像
     */
    private String sysUserAvatar;

    /**
     * 角色 id
     */
    private Long roleId;

    /**
     * 所属角色名
     */
    private String roleName;

    /**
     * 学生所属班级名
     */
    private String clazzName;

    /**
     * 班主任姓名
     */
    private String teacherName;

    /**
     * 班级所属院系
     */
    private String academyName;

    /**
     * 班主任电话
     */
    private String teacherPhone;
}

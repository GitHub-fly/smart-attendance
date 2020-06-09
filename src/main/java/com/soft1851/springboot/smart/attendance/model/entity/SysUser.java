package com.soft1851.springboot.smart.attendance.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author ke
 * @ClassName SysUser
 * @Description TOOD
 * @Date 2020/6/8
 * @Version 1.0
 **/
@Entity
@Data
@Table(name = "sys_user", indexes = {@Index(name= "sys_job_numberIndex", columnList = "sys_job_number")})
public class SysUser {
    /**
     * 用户id
     */
    @Id
    @Column(name = "pk_sys_user_id", length = 32)
    @NotNull
    private String pkSysUserId;

    /**
     * 用户真实名字
     */
    @NotNull
    @Column(name = "sys_user_name", length = 60)
    private String sysUserName;

    /**
     * 用户昵称
     */
    @NotNull
    @Column(name = "sys_user_nickname", length = 60)
    private String sysUserNickname;

    /**
     * 性别
     */
    @NotNull
    @Column(name = "sys_user_gender", length = 10)
    private String sysUserGender;

    /**
     * 学号、教工号、职工号
     */
    @NotNull
    @Column(name = "sys_job_number", length = 60)
    private String sysJobNumber;

    /**
     * 阿姨所管楼层
     */
    @Column(name = "sys_room", length = 60)
    private String sysRoom;

    /**
     * 学生所属房间
     */
    @Column(name = "room_number", length = 60)
    private String roomNumber;

    /**
     * 学生的床位号
     */
    @Column(name = "room_bed_number", length = 11)
    private Integer roomBedNumber;

    /**
     * 班主任名称
     */
    @Column(name = "sys_user_teacher_name", length = 60)
    private String sysUserTeacherName;

    /**
     * 学生的辅导员姓名
     */
    @Column(name = "sys_user_instructor_name", length = 60)
    private String sysUserInstructorName;

    /**
     * 学生的二级学院老师名
     */
    @Column(name = "sys_user_academy_teacher_name", length = 60)
    private String sysUserAcademyTeacherName;


    /**
     * 学生所属班级或班主任管理班级
     */
    @Column(name = "sys_class_name", length = 60)
    private String sysClassName;

    /**
     * 学生所属院系
     */
    @Column(name = "sys_user_academy", length = 60)
    private String sysUserAcademy;

    /**
     * 学生今日打卡
     */
    @Column(name = "is_attendance", length = 0)
    private Integer isAttendance;

    /**
     * 用户密码
     */
    @NotNull
    @Column(name = "sys_user_password", length = 32)
    private String sysUserPassword;

    /**
     * 手机号
     */
    @NotNull
    @Column(name = "sys_user_phone", length = 30)
    private String sysUserPhone;

    /**
     * 头像
     */
    @NotNull
    @Column(name = "sys_user_avatar", length = 254)
    private String sysUserAvatar;

    /**
     * 所属角色id
     */
    @NotNull
    @Column(name = "role_id", length = 11)
    private Integer RoleId;

    /**
     * 加盐
     */
    @NotNull
    @Column(name = "salt", length = 60)
    private String salt;

    /**
     * 账户状态
     */
    @NotNull
    @Column(name = "status", length = 4)
    private Integer status;

    /**
     * 更新时间
     */
    @NotNull
    @Column(name = "gmt_modified", length = 0)
    private Date gmtModified;

    /**
     * 删除标志
     */
    @NotNull
    @Column(name = "delete_flag", length = 4)
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    @NotNull
    @Column(name = "gmt_create", length = 0)
    private Date gmtCreate;
}

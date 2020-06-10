package com.soft1851.springboot.smart.attendance.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
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
@Table(name = "sys_user", indexes = {@Index(name = "sys_job_numberIndex", columnList = "sys_job_number")})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    /**
     * 用户id
     */
    @Id
    @Column(name = "pk_sys_user_id", length = 32, nullable = false)
    private String pkSysUserId;

    /**
     * 用户真实名字
     */
    @Column(name = "sys_user_name", length = 60, nullable = false)
    private String sysUserName;

    /**
     * 用户昵称
     */
    @Column(name = "sys_user_nickname", length = 60)
    private String sysUserNickname;

    /**
     * 性别
     */
    @Column(name = "sys_user_gender", length = 10)
    private String sysUserGender;

    /**
     * 学号、教工号、职工号
     */
    @Column(name = "sys_job_number", length = 60, nullable = false)
    private String sysJobNumber;


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
     * 学生所属班级或班主任管理班级 id
     */
    @Column(name = "sys_class_id")
    private Long sysClassId;


    /**
     * 学生今日打卡
     */
    @Column(name = "is_attendance")
    private Integer isAttendance;

    /**
     * 用户密码
     */
    @Column(name = "sys_user_password", length = 32, nullable = false)
    private String sysUserPassword;

    /**
     * 手机号
     */
    @Column(name = "sys_user_phone", length = 30, nullable = false)
    private String sysUserPhone;

    /**
     * 头像
     */
    @Column(name = "sys_user_avatar", length = 254)
    private String sysUserAvatar;

    /**
     * 所属角色id
     */
    @Column(name = "role_id", length = 11, nullable = false)
    private Integer roleId;

    /**
     * 加盐
     */
    @Column(name = "salt", length = 60, nullable = false)
    private String salt;

    /**
     * 账户状态
     */
    @Column(name = "status", length = 4)
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    @CreatedDate
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    @LastModifiedDate
    private Timestamp gmtModified;

    /**
     * 是否删除（1 逻辑删除， 0 未删除）
     */
    @JsonIgnore
    @Column(name = "delete_flag", length = 4)
    private Integer deleteFlag = 0;
}

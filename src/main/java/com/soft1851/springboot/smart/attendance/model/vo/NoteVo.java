package com.soft1851.springboot.smart.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author ke
 * @ClassName NoteVo
 * @Description TOOD
 * @Date 2020/6/10
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteVo {
<<<<<<< HEAD
    private Long noteId;
=======
    /**
     * 学生姓名
     */
    private String sysUserName;

    /**
     * 学生性别
     */
    private String sysUserGender;

    /**
     * 学生电话
     */
    private String userPhone;

    /**
     * 学号、教工号、职工号
     */
    private String sysJobNumber;

    /**
     * 班级名
     */
    private String clazzName;

    /**
     * 班主任名称
     */
    private String teacherName;

    /**
     * 请假类型
     * 1 -> 事假
     * 2 -> 病假
     * 3 -> 休学
     * 4 -> 其它
     */
    private Integer type;

    /**
     * 请假天数
     */
    private Integer dayCount;

    /**
     * 是否归寝  0 -> 不归寝  1 -> 归寝
     */
    private Integer isDormitory;

    /**
     * 是否出校  0 -> 不出校  1 -> 出校
     */
    private Integer isSchool;

    /**
     * 请假开始时间
     */
    private Date startTime;

    /**
     * 请假结束时间
     */
    private Date finishTime;

    /**
     * 请假原因
     */
    private String reason;

    /**
     * 班主任意见  同意或者不同意
     */
    private String teacherOpinion;
    /**
     * 学生的辅导员姓名
     */
    private String sysUserInstructorName;

    /**
     * 学生的二级学院老师名
     */
    private String sysUserAcademyTeacherName;

    /**
     * 辅导员意见  同意或者不同意
     */
    private String instructorOpinion;

    /**
     * 二级学院意见
     * 同意或者不同意
     */
    private String academyOpinion;

>>>>>>> c46c7a8644e30670716ce39a50877393757e25d6
}

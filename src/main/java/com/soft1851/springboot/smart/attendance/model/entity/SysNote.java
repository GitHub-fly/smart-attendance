package com.soft1851.springboot.smart.attendance.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author Zeng
 * @ClassName SysNote
 * @Description TOOD
 * @Date 2020/6/8
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sys_note", indexes = {@Index(name = "user_idIndex", columnList = "user_id")})
public class SysNote {
    /**
     * 主键
     */
    @NotNull(message = "pkNoteId不能为空")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_note_id",length = 0, nullable = false)
    private Long pkNoteId;

    /**
     * 用户id
     */
    @Column(name = "user_id", length = 254, nullable = false)
    private String userId;

    /**
     * 请假类型
     * 1 -> 事假
     * 2 -> 病假
     * 3 -> 休学
     * 4 -> 其它
     */
    @Column(name = "type", length = 4, nullable = false)
    private Integer type;

    /**
     * 请假天数
     */
    @Column(name = "day_count", length = 11, nullable = false)
    private Integer dayCount;

    /**
     * 是否归寝  0 -> 不归寝  1 -> 归寝
     */
    @Column(name = "is_dormitory", length = 2, nullable = false)
    private Integer isDormitory;

    /**
     * 是否出校  0 -> 不出校  1 -> 出校
     */
    @Column(name = "is_school", length = 2, nullable = false)
    private Integer isSchool;

    /**
     * 请假开始时间
     */
    @Column(name = "start_time", nullable = false)
    private Timestamp startTime;

    /**
     * 请假结束时间
     */
    @Column(name = "finish_time", nullable = false)
    private Timestamp finishTime;

    /**
     * 请假原因
     */
    @Column(name = "reason", nullable = false)
    private String reason;

    /**
     * 班主任意见  同意或者不同意
     */
    @Column(name = "teacher_opinion", length = 255, nullable = false)
    private String teacherOpinion;

    /**
     * 辅导员意见  同意或者不同意
     */
    @Column(name = "instructor_opinion", length = 255, nullable = false)
    private String instructorOpinion;

    /**
     * 二级学院意见
     * 同意或者不同意
     */
    @Column(name = "academy_opinion", length = 255, nullable = false)
    private String academyOpinion;

    /**
     * 假条状态  0 -> 驳回  1 -> 未审核  2 -> 同意
     */
    @Column(name = "status", length = 2, nullable = false)
    private Integer status;

    /**
     * 创建时间
     */
    @JsonIgnore
    @NotNull(message = "gmtCreate不能为空")
    @Column(name = "gmt_create", nullable = false)
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    @JsonIgnore
    @NotNull(message = "gmtModified不能为空")
    @Column(name = "gmt_modified", nullable = false)
    private Timestamp gmtModified;

    /**
     * 是否删除（1 逻辑删除， 0 未删除）
     */
    @NotNull(message = "deleteFlag不能为空")
    @Column(name = "is_deleted", length = 4, nullable = false)
    private Integer deleteFlag;
}

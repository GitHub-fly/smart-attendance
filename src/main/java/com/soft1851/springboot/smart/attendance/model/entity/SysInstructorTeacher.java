package com.soft1851.springboot.smart.attendance.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


/**
 * @author ke
 * @ClassName SysInstructorTeacher
 * @Description TOOD
 * @Date 2020/6/18
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SysInstructorTeacher {

    /**
     * 流水id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_instructor_teacher", nullable = false)
    private Long pkInstructorTeacher;

    /**
     * 辅导员id
     */
    @NotNull
    @Column(name= "instructor_id", nullable = false)
    private String instructorId;

    /**
     * 班主任id
     */
    @NotNull
    @Column(name = "teacher_id", nullable = false)
    private String teacherId;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    @CreatedDate
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    @Column(name="gmt_modified")
    @CreatedDate
    private Timestamp gmtModified;
}

package com.soft1851.springboot.smart.attendance.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author ke
 * @ClassName SysClazz
 * @Description TOOD
 * @Date 2020/6/9
 * @Version 1.0
 **/
@Entity
@Data
public class SysClazz {
    /**
     * 班级id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkSysClazzId;
    /**
     * 班级名称
     */
    @NotNull
    @Column(name = "name", length = 254)
    private  String name;
    /**
     * 班主任名称
     */
    @Column(name = "teacher_name", length = 60)
    @NotNull
    private String teacherName;

    /**
     * 班级所属院系
     */
    @Column(name = "academy_name", length = 60)
    @NotNull
    private String academyName;


    /**
     * 创建时间
     */
    @JsonIgnore
//    @NotNull(message = "gmtCreate不能为空")
    @Column(name = "gmt_create")
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    @JsonIgnore

    @Column(name = "gmt_modified")
    private Timestamp gmtModified;

    /**
     * 是否删除（1 逻辑删除， 0 未删除）
     */
//    @NotNull(message = "deleteFlag不能为空")
    @Column(name = "is_deleted", length = 4)
    private Integer deleteFlag;

}

package com.soft1851.springboot.smart.attendance.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author Zeng
 * @ClassName sysDormitory
 * @Description 宿舍表
 * @Date 2020/6/9
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sys_dormitory", indexes = {@Index(name = "clazz_idIndex", columnList = "clazz_id")})
public class SysDormitory {

    /**
     * 主键
     */
//    @NotNull(message = "pkSysDormitoryId不能为空")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_sys_dormitory_id",length = 0, nullable = false)
    private Long pkSysDormitoryId;

    /**
     * 宿舍名
     * 例如：
     * 雪松苑A4二层223
     */
    @Column(name = "name", length = 60, nullable = false)
    private String name;

    /**
     * 班级id
     */
    @Column(name = "clazz_id", nullable = false)
    private Integer clazzId;

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



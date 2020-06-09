package com.soft1851.springboot.smart.attendance.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author smart-attendance
 * @Description 资源权限表
 * @Date 2020/5/25 21:29
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class SysRole {

    /**
     * 角色id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_role_id", nullable = false)
    private Long pkRoleId;

    /**
     * 角色名
     */
    @Column(name = "role_name", length = 32, nullable = false)
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "role_decoration", length = 254, nullable = false)
    private String roleDecoration;

    /**
     * 排序字段
     */
    @Column(name = "sort", length = 4, nullable = false)
    private Integer sort;

    /**
     * 创建时间
     */
    @JsonIgnore
    @Column(name = "gmt_create", nullable = false)
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    @JsonIgnore
    @LastModifiedDate
    @Column(name = "mgt_modified", nullable = false)
    private Timestamp gmtModified;

    /**
     * 是否删除（0 逻辑删除， 1 未删除）
     */
    @Column(name = "delete_flag", length = 4, nullable = false)
    private Integer deleteFlag;

}

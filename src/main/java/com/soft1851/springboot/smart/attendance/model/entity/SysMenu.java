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
public class SysMenu {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_menu_id", nullable = false)
    private Long pkMenuId;

    /**
     * 名称
     */
    @NotNull(message = "name不能为空")
    @Column(name = "name", length = 32, nullable = false)
    private String name;

    /**
     * 跳转路由
     */
    @Column(name = "path", length = 60, nullable = false)
    private String path;

    /**
     * 图标
     */
    @Column(name = "icon", length = 254)
    private String icon;

    /**
     * 排序号
     */
    @Column(name = "sort", length = 4)
    private Integer sort;

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

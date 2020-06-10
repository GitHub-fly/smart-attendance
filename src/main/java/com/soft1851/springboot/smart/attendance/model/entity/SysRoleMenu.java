package com.soft1851.springboot.smart.attendance.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author smart-attendance
 * @ClassName SysRoleMMenu
 * @Description TODO
 * @Date 2020/6/8
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SysRoleMenu {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Long pkId;

    /**
     * 角色id
     */
    @NotNull(message = "pkRoleId不能为空")
    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    /**
     * 权限id
     */
    @NotNull(message = "menuId不能为空")
    @Column(name = "menu_id", nullable = false)
    private Long menuId;

    /**
     * 创建时间
     */
    @NotNull(message = "gmtCreate不能为空")
    @Column(name = "gmt_create")
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    @NotNull(message = "gmtModified不能为空")
    @Column(name = "gmt_modified")
    private Timestamp gmtModified;

    /**
     * 是否删除（1 逻辑删除， 0 未删除）
     */
    @NotNull(message = "isDeleted不能为空")
    @Column(name = "deleted_flag", length = 4)
    private Integer deletedFlag;
}


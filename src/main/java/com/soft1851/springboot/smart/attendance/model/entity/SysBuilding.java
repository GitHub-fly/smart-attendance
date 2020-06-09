package com.soft1851.springboot.smart.attendance.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author ke
 * @ClassName SysBuilding
 * @Description TOOD
 * @Date 2020/6/9
 * @Version 1.0
 **/
@Entity
@Data
public class SysBuilding {
    /**
     * 楼层id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_sys_building_id", length = 20, nullable = false)
    private Long pkSysBuildingId;

    /**
     * 楼层名称
     */
    @Column(name = "sys_building_name", length = 254, nullable = false)
    @NotNull
    private String SysBuildingName;

    /**
     *删除标志
     */
    @NotNull
    @Column(name = "delete_flag", length = 4)
    private Integer deleteFlag;

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


}

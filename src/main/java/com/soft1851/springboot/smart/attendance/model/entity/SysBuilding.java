package com.soft1851.springboot.smart.attendance.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

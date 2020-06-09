package com.soft1851.springboot.smart.attendance.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author ke
 * @ClassName UserBuilding
 * @Description TOOD
 * @Date 2020/6/9
 * @Version 1.0
 **/
@Entity
@Data
public class UserBuilding {
    /**
     * 流水id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkId;
    /**
     * 学生id
     */
    @NotNull
    @Column(name ="user_id")
    private Integer userId;

    /**
     * 楼层id
     */
    @NotNull
    @Column(name = "building_id")
    private Integer buildingId;

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

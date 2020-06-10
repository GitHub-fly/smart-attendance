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
 * @author xunmi
 * @ClassName SysAttendance
 * @Description TODO
 * @Date 2020/6/8
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sys_attendance", indexes = {@Index(name = "user_idIndex", columnList = "user_id") })
public class SysAttendance {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id",length = 0, nullable = false)
    private Long pkId;

    /**
     * user_id
     */
    @NotNull(message = "userId不能为空")
    @Column(name = "user_id", length = 254, nullable = false)
    private String userId;

    /**
     * 经度
     */
    @NotNull(message = "longitude")
    @Column(name = "longitude", length = 254, nullable = false)
    private String longitude;

    /**
     * 纬度
     */
    @NotNull(message = "longitude")
    @Column(name = "latitude", length = 254, nullable = false)
    private String latitude;

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

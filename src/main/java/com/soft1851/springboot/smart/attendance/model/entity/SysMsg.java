package com.soft1851.springboot.smart.attendance.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * @author Zeng
 * @ClassName SysMsg
 * @Description TOOD
 * @Date 2020/6/22
 * @Version 1.0
 **/
public class SysMsg {

    /**
     * 消息id
     */
    private Long pkMessageId;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 是否已读
     */
    private Integer isRead;

    /**
     * 发起人id
     */
    private String fromId;

    /**
     * 接受人id
     */
    private String toId;

    /**
     * 创建时间`
     */
    @Column(name = "gmt_create")
    @CreatedDate
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    private Timestamp gmtModified;

    /**
     * 是否删除（1 逻辑删除， 0 未删除）
     */
    @JsonIgnore
    @Column(name = "delete_flag", length = 4)
    private Integer deleteFlag = 0;
}

package com.soft1851.springboot.smart.attendance.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Zeng
 * @ClassName SysMsg
 * @Description TOOD
 * @Date 2020/6/22
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SysMsg {

    /**
     * 消息id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_message_id", nullable = false)
    private Long pkMessageId;

    /**
     * 消息标题
     */
    @Column(name = "title", length = 32, nullable = false)
    private String title;

    /**
     * 消息内容
     */
    @Column(name = "content", length = 254, nullable = false)
    private String content;

    /**
     * 是否已读
     */
    @Column(name = "is_read", length = 4, nullable = false)
    private Integer isRead;

    /**
     * 发起人id
     */
    @Column(name = "from_id", length = 32, nullable = false)
    private String fromId;

    /**
     * 接受人id
     */
    @Column(name = "to_id", length = 32, nullable = false)
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

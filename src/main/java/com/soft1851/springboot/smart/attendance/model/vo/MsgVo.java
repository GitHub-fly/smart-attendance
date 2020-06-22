package com.soft1851.springboot.smart.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author Zeng
 * @ClassName MsgVo
 * @Description TOOD
 * @Date 2020/6/22
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MsgVo implements EntityVo {

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
     * 创建时间
     */
    private Timestamp gmtCreate;

    /**
     * 发送人
     */
    private String fromUser;
}

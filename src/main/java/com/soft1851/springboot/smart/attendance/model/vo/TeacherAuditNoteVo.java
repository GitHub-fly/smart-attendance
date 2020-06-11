package com.soft1851.springboot.smart.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author ke
 * @ClassName TeacherAuditNote
 * @Description TOOD
 * @Date 2020/6/11
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherAuditNoteVo {
    /**
     * 假条id
     */
    private Long pkNoteId;

    /**
     * 用户真实名字
     */
    private String sysUserName;

    /**
     * 头像
     */
    private String sysUserAvatar;

    /**
     * 班级名称
     */
    private  String name;

    /**
     * 请假类型
     * 1 -> 事假
     * 2 -> 病假
     * 3 -> 休学
     * 4 -> 其它
     */
    private Integer type;

    /**
     * 假条状态  0 -> 驳回  1 -> 未审核  2 -> 同意
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreate;
}

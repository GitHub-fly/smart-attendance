package com.soft1851.springboot.smart.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author ke
 * @ClassName ClazzNoteVo
 * @Description TOOD
 * @Date 2020/6/18
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClazzNoteVo {
    /**
     * 假条id
     */
    private Long pkNoteId;

    /**
     * 用户id
     */
    private String pkSysUserId;

    /**
     * 学生姓名
     */
    private String sysUserName;

    /**
     * 学号、教工号、职工号
     */
    private String sysJobNumber;

    /**
     * 类型
     */
    private Integer status;

    /**
     * 假条状态
     */
    private Integer type;

    /**
     * 创建时间
     */
    private Date gmtCreate;
}

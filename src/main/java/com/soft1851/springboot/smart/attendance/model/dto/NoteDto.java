package com.soft1851.springboot.smart.attendance.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author ke
 * @ClassName NoteDto
 * @Description TOOD
 * @Date 2020/6/8
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NoteDto {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 请假类型
     */
    private Integer type;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 请假天数
     */
    private Integer dayCount;

    /**
     * 是否归寝
     */
    private Integer isDormitory;

    /**
     * 是否出校
     */
    private Integer isSchool;
    /**
     * 请假开始时间
     */

    private Timestamp startTime;

    /**
     * 请假结束时间
     */
    private Timestamp finishTime;

    /**
     * 请假理由
     */
    private String reason;

}

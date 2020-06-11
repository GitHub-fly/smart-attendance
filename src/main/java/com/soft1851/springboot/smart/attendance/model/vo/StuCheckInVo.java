package com.soft1851.springboot.smart.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zeng
 * @ClassName StuCheckInVo
 * @Description 学生打卡信息Vo
 * @Date 2020/6/11
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StuCheckInVo implements EntityVo {

    /**
     * 学生床位号
     */
    private Integer bedNumber;

    /**
     * 学生id
     */
    private String userId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 是否打卡 0-未 1-已打
     */
    private Integer isAttendance;

}

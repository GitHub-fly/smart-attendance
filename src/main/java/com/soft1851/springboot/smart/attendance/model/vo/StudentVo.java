package com.soft1851.springboot.smart.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zeng
 * @ClassName StudentVo
 * @Description TOOD
 * @Date 2020/6/11
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentVo implements EntityVo {

    /**
     * 学生真实姓名
     */
    private String sysUserName;

    /**
     * 学号
     */
    private String sysJobNumber;

    /**
     * 学生房间名
     */
    private String roomName;

    /**
     * 学生班级名
     */
    private String clazzName;

    /**
     * 所属院系名
     */
    private String academyName;

    /**
     * 学生联系方式
     */
    private String sysUserPhone;

    /**
     * 学生是否打卡
     */
    private Integer isAttendance;
}

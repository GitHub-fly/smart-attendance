package com.soft1851.springboot.smart.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zeng
 * @ClassName StuUnCheckVo
 * @Description 未打卡学生页Vo
 * @Date 2020/6/11
 * @Version 1.0
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StuUnCheckVo implements EntityVo {

    /**
     * 学生id
     */
    private String pkUserId;

    /**
     * 学生头像
     */
    private String sysUserAvatar;

    /**
     * 学生真实姓名
     */
    private String sysUserName;

    /**
     * 学生联系方式
     */
    private String sysUserPhone;

    /**
     * 班主任姓名
     */
    private String teacherName;

    /**
     * 班主任联系方式
     */
    private String teacherPhone;

}

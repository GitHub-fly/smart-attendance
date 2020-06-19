package com.soft1851.springboot.smart.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xunmi
 * @ClassName TeacherVo
 * @Description TODO
 * @Date 2020/6/10
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherVo {

    /**
     * 班主任头像
     */
    private String sysUserAvatar;

    /**
     * 班主任姓名
     */
    private String teacherName;

    /**
     * 班主任联系方式
     */
    private String teacherPhone;

    /**
     * 班主任负责的班级
     */
    private  String name;

//    /**
//     * 假条状态  0 -> 驳回  1 -> 未审核  2 -> 同意
//     */
//    private Integer status;
}

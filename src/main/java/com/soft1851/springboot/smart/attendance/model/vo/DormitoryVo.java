package com.soft1851.springboot.smart.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zeng
 * @ClassName DormitoryVo
 * @Description 宿舍打卡Vo
 * @Date 2020/6/10
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DormitoryVo implements EntityVo {

    /**
     * 宿舍名
     */
    private String dormitoryName;

    /**
     * 宿舍id
     */
    private Long dormitoryId;

    /**
     * 班主任姓名
     */
    private String teacherName;

    /**
     * 班主任联系方式
     */
    private String teacherPhone;

    /**
     * 班级名
     */
    private String clazzName;

    /**
     * 是否全部打卡
     */
    private Boolean isAll;

}

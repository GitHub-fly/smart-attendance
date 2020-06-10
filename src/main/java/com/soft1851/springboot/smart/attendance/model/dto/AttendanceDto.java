package com.soft1851.springboot.smart.attendance.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zeng
 * @ClassName AttendanceDto
 * @Description 考勤信息传输dto
 * @Date 2020/6/10
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AttendanceDto {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

}

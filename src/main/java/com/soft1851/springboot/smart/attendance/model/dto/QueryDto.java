package com.soft1851.springboot.smart.attendance.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zeng
 * @ClassName QueryDto
 * @Description TOOD
 * @Date 2020/6/22
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QueryDto {

    private String field1;

    private Long field2;

    private Integer field3;
}

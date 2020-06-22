package com.soft1851.springboot.smart.attendance.model.dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ke
 * @ClassName OpinionDto
 * @Description TOOD
 * @Date 2020/6/11
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OpinionDto {

    /**
     * 假条id
     */
    private Long pkNoteId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 假条状态
     */
    private Integer status;
}

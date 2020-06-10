package com.soft1851.springboot.smart.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ke
 * @ClassName StudentNoteVo
 * @Description TOOD
 * @Date 2020/6/10
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentNoteVo {

    /**
     * 假条id
     */
    private Long pkNoteId;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 假条状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreate;


}

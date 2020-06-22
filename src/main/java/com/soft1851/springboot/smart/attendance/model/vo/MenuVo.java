package com.soft1851.springboot.smart.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Entity;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * @author xunmi
 * @ClassName MenuVo
 * @Description TODO
 * @Date 2020/6/19
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuVo implements EntityVo {

    /**
     * 图标
     */
    @Column(name = "icon", length = 254)
    private String icon;

    /**
     * 名称
     */
    @NotNull(message = "name不能为空")
    @Column(name = "name", length = 32, nullable = false)
    private String name;

    /**
     * 跳转路由
     */
    @Column(name = "path", length = 60, nullable = false)
    private String path;

}

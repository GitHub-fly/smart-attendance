package com.soft1851.springboot.smart.attendance.annotation;

import java.lang.annotation.*;

/**
 * @author ke
 * @ClassName ControllerWebLog
 * @Description TOOD
 * @Date 2020/6/19
 * @Version 1.0
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    //调用的接口名称
    String name();

    //该日志是否需要持久化存储*
    boolean isSaved() default false;

}


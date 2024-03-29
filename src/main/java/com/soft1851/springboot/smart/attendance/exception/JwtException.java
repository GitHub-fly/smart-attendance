package com.soft1851.springboot.smart.attendance.exception;


import com.soft1851.springboot.smart.attendance.constant.ResultCode;

/**
 * @ClassName JwtException
 * @Description 自定义异常
 * @Author smart-attendance
 * @Date 2020/6/10
 * @Version 1.0
 */
public class JwtException extends RuntimeException {

    protected ResultCode resultCode;

    public JwtException(String msg, ResultCode resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

}
package com.soft1851.springboot.smart.attendance.exception;


import com.soft1851.springboot.smart.attendance.constant.ResultCode;

/**
 * @Description TODO
 * @Author smart-attendance
 * @Date 2020/6/10
 * @Version 1.0
 */
public class CustomException extends RuntimeException {
    protected ResultCode resultCode;

    public CustomException(String msg, ResultCode resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

}

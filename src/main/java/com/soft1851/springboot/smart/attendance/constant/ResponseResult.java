package com.soft1851.springboot.smart.attendance.constant;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @author smart-attendance
 * @Date 2020/4/21
 * @Version 1.0
 */
@Data
public class ResponseResult implements Serializable {

    private static final long serialVersionUID = -3948389268046368059L;

    private Integer code;

    private String msg;

    private Object data;

    private ResponseResult() {
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseResult success() {
        ResponseResult result = new ResponseResult();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static ResponseResult failure() {
        ResponseResult result = new ResponseResult();
        result.setResultCode(ResultCode.FAILURE);
        return result;
    }

    public static ResponseResult success(Object data) {
        ResponseResult result = new ResponseResult();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static ResponseResult failure(Object data) {
        ResponseResult result = new ResponseResult();
        result.setResultCode(ResultCode.FAILURE);
        result.setData(data);
        return result;
    }

    public static ResponseResult failure(ResultCode resultCode) {
        ResponseResult result = new ResponseResult();
        result.setResultCode(resultCode);
        return result;
    }

    public static ResponseResult failure(ResultCode resultCode, Object data) {
        ResponseResult result = new ResponseResult();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }

}
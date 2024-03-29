package com.soft1851.springboot.smart.attendance.handler;

import com.soft1851.springboot.smart.attendance.constant.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author smart-attendance
 * @Description TODO
 * @Date 2020/6/10
 * @Version 1.0
 */
@RestControllerAdvice(annotations = RestController.class)
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    /**
     * 此处如果返回false , 则不执行当前Advice的业务
     *
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * 处理响应的具体方法
     *
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ResponseResult) {
            return body;
        } else {
            System.out.println(ResponseResult.success(body));
            return ResponseResult.success(body);
        }
    }

}

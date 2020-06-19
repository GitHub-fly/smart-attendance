package com.soft1851.springboot.smart.attendance.config;

import com.cxytiandi.encrypt.core.EncryptionConfig;
import com.cxytiandi.encrypt.core.EncryptionFilter;
import com.soft1851.springboot.smart.attendance.exception.CustomException;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @author Zeng
 * @ClassName FilterConfig
 * @Description TOOD
 * @Date 2020/6/16
 * @Version 1.0
 **/
@Configuration
public class FilterConfig {

    @ExceptionHandler(value = CustomException.class)
    @Bean
    public FilterRegistrationBean<EncryptionFilter> filterRegistration() {
            EncryptionConfig config = new EncryptionConfig();
            config.setKey("5F9AC4530C2A9C6D");
//        config.setRequestDecyptUriList(Arrays.asList("/*"));
//        config.setResponseEncryptUriList(Arrays.asList("/*"));
            FilterRegistrationBean<EncryptionFilter> registration = new FilterRegistrationBean<EncryptionFilter>();
            registration.setFilter(new EncryptionFilter(config));
            registration.addUrlPatterns("/*");
            registration.setName("EncryptionFilter");
            registration.setOrder(1);
            return registration;
    }

}

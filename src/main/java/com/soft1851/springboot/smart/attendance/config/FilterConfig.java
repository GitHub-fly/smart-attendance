package com.soft1851.springboot.smart.attendance.config;

import com.cxytiandi.encrypt.core.EncryptionConfig;
import com.cxytiandi.encrypt.core.EncryptionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author Zeng
 * @ClassName FilterConfig
 * @Description TOOD
 * @Date 2020/6/16
 * @Version 1.0
 **/
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<EncryptionFilter> filterRegistration() {
        EncryptionConfig config = new EncryptionConfig();
        config.setKey("abcdef0123456789");
        config.setRequestDecyptUriList(Arrays.asList("/api/attendance/manager/info"));
        config.setResponseEncryptUriList(Arrays.asList("/api/attendance/manager/info"));
        FilterRegistrationBean<EncryptionFilter> registration = new FilterRegistrationBean<EncryptionFilter>();
        registration.setFilter(new EncryptionFilter(config));
        registration.addUrlPatterns("/*");
        registration.setName("EncryptionFilter");
        registration.setOrder(1);
        return registration;
    }

}

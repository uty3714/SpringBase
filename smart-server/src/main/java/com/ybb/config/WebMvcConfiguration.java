package com.ybb.config;

import com.ybb.interceptor.JwtApiTokenInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private JwtApiTokenInterceptor jwtApiTokenInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义拦截器");
        //api的拦截
        registry.addInterceptor(jwtApiTokenInterceptor)
                .addPathPatterns("api/**")
                .excludePathPatterns("/api/login");

        //后台的拦截写这里
//        registry.addInterceptor(jwtAdminTokenInterceptor)
//                .addPathPatterns("admin/**")
//                .excludePathPatterns("/admin/login");
    }
}

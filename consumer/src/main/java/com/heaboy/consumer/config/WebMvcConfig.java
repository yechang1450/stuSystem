package com.heaboy.consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wangzhen
 * @title: WebMvcConfig
 * @projectName niua_easy_parent
 * @description: TODO
 * @date 2020/6/3 11:05 下午
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}

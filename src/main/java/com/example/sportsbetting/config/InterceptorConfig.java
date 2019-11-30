package com.example.sportsbetting.config;

import com.example.sportsbetting.interceptor.AuthInterceptor;
import com.example.sportsbetting.interceptor.LanguageInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // It works like a middleware
        registry.addInterceptor(new AuthInterceptor());
        // It manage the languages based on query.
        registry.addInterceptor(new LanguageInterceptor());
    }

}

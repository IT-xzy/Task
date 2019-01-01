
package com.mutesaid.bootdemo.interceptor;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class TokenConfig extends WebMvcConfigurationSupport {

    @Bean
    public TokenInterceptor myInterceptor() {
        return new TokenInterceptor();
    }

    // 拦截含有/u的接口信息
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/a/u/**");
        super.addInterceptors(registry);
    }
}


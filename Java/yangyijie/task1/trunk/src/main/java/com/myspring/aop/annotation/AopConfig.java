package com.myspring.aop.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Arike
 * Create_at 2017/12/7 15:11
 */
@Configuration()
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.myspring.aop.annotation"})
public class AopConfig {
}

package com.wyz.task5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//配置统一扫描包
@MapperScan("com.wyz.task5.domain.dao")
public class Task5Application {

    public static void main(String[] args) {
        SpringApplication.run(Task5Application.class, args);
    }
}

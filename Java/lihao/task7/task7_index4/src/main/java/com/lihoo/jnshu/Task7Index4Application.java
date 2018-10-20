package com.lihoo.jnshu;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @author lihoo
 */
@SpringBootApplication
@MapperScan("com.lihoo.jnshu.admin.dao")
public class Task7Index4Application {

    public static void main(String[] args) {
        SpringApplication.run(Task7Index4Application.class, args);
        System.out.println("**********spring boot success********");
    }
}

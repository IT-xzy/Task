package com.xiaobo.demo;

import com.github.pagehelper.PageHelper;
import com.xiaobo.demo.pojo.Book;
import com.xiaobo.demo.service.UserService;
import com.xiaobo.demo.service.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.xiaobo.demo.dao")
public class DemoApplication {
    @Autowired
    UserServiceImpl userService;
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname","106.12.103.127");
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public RmiServiceExporter rmiServiceExporter(UserService userService){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setRegistryPort(1191);
        rmiServiceExporter.setServicePort(1191);
        rmiServiceExporter.setServiceName("UserService");
        rmiServiceExporter.setService(userService);
        rmiServiceExporter.setServiceInterface(UserService.class);
        return rmiServiceExporter;
    }
    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }

}

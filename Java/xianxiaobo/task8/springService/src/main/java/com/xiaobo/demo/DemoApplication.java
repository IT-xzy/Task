package com.xiaobo.demo;

import com.github.pagehelper.PageHelper;
import com.xiaobo.demo.service.UserService;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Properties;

@RestController
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class, RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @GetMapping(value = "/home")
    public String start(){
        return "Hello SpringBoot!";
    }
    @Bean(name="UserService1")
    public RmiProxyFactoryBean rmiProxyFactoryBean1() throws BeanCreationException {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
            rmiProxyFactoryBean.setServiceUrl("rmi://106.12.103.127:1191/UserService");
        rmiProxyFactoryBean.setServiceInterface(UserService.class);
        return rmiProxyFactoryBean;
    }
//    @Bean(name="UserService2")
//    public RmiProxyFactoryBean rmiProxyFactoryBean2() throws BeanCreationException {
//        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
//        rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:1192/UserService");
//        rmiProxyFactoryBean.setServiceInterface(UserService.class);
//        return rmiProxyFactoryBean;
//    }
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

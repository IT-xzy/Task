package com.util;

import com.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
@ComponentScan
public class RmiConfig {
    @Bean(name = "rmiservice1199")
    @Lazy
    public RmiProxyFactoryBean studentService1(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://207.148.67.85:8080/RemoteService");
        rmiProxyFactoryBean.setServiceInterface(StudentService.class);
        //属性设置，不设置的话异常无法捕获。
        rmiProxyFactoryBean.afterPropertiesSet();
        return rmiProxyFactoryBean;
    }

    @Bean(name = "rmiservice1198")
    @Lazy
    public RmiProxyFactoryBean studentService2(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:1198/RemoteService");
        rmiProxyFactoryBean.setServiceInterface(StudentService.class);
        rmiProxyFactoryBean.afterPropertiesSet();
        return rmiProxyFactoryBean;
    }
}

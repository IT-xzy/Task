package com.jnshu;

import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class RmiDemoClient {
//    @Bean
//    public RmiProxyFactoryBean rmiProxyFactoryBean(){
//        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
//        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1199/RmiDemo");
//        rmiProxyFactoryBean.setServiceInterface(RmiInterface.class);
//
//
//
//
//
//        return rmiProxyFactoryBean;
//    }

    public static void main(String[] args) {
        RmiProxyFactoryBean rmiProxyFactoryBean  = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/RmiDemo");
        rmiProxyFactoryBean.setServiceInterface(RmiInterface.class);
        rmiProxyFactoryBean.afterPropertiesSet();
        RmiInterface rmiInterface = (RmiInterface) rmiProxyFactoryBean.getObject();
        rmiInterface.hello("rmi");

    }







}

package com.jnshuboot.configura;

import com.jnshuboot.pojo.Login;
import com.jnshuboot.pojo.User;
import com.jnshuboot.service.IUserService;
import com.jnshuboot.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.util.ArrayList;
import java.util.Random;

@Slf4j
@Configuration
public class RmiClient {

//    @Bean(name = "userService")
//    public RmiProxyFactoryBean getUserService() {
//        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
//        rmiProxyFactoryBean.setServiceInterface(IUserService.class);
////        String serviceUrl1="rmi://59.110.143.57:1090/userService";
//        String serviceUrl1="rmi://127.0.0.1:1090/userService";
////        String serviceUrl2="rmi://59.110.143.57:1091/userService";
//        String serviceUrl2="rmi://127.0.0.1:1091/userService";
//        String serviceUrl=serviceUrl2;
//        Random random=new Random();
//        int i=random.nextInt(2);
//
//        if(i==1){
//            serviceUrl=serviceUrl2;
//            log.info("rmi使用端口2成功");
//        }else {
//            log.info("rmi使用端口1成功");
//        }
//            rmiProxyFactoryBean.setServiceUrl(serviceUrl);
//            return rmiProxyFactoryBean;
//            }

    @Bean(name = "userService1")
    @Lazy
    public RmiProxyFactoryBean getUserService1() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(IUserService.class);
        //        String serviceUrl2="rmi://59.110.143.57:1090/userService";
        String serviceUrl = "rmi://127.0.0.1:1090/userService";
        rmiProxyFactoryBean.setServiceUrl(serviceUrl);
        return rmiProxyFactoryBean;
    }

    @Bean(name = "userService2")
    @Lazy
    public RmiProxyFactoryBean getUserService2() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(IUserService.class);
        //        String serviceUrl2="rmi://59.110.143.57:1091/userService";
        String serviceUrl = "rmi://127.0.0.1:1091/userService";
        rmiProxyFactoryBean.setServiceUrl(serviceUrl);
        return rmiProxyFactoryBean;
    }
}
//    @Bean(name = "loginService")
//    public RmiProxyFactoryBean getLoginService() {
//        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
//        rmiProxyFactoryBean.setServiceUrl("rmi://59.110.143.57:1090/loginService");
//        rmiProxyFactoryBean.setServiceInterface(LoginService.class);
//        rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
//        return rmiProxyFactoryBean;
//    }
//    @Bean(name = "serviceRMI")
//    public RmiProxyFactoryBean getUserService() {
//        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
//        rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:1099/serviceRMI");
//        rmiProxyFactoryBean.setServiceInterface(ServiceRMI.class);
//        return rmiProxyFactoryBean;
//    }


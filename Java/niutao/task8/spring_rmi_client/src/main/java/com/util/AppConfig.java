//package com.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.remoting.rmi.RmiProxyFactoryBean;
//import com.service.StudentService;
//
//@Configuration
//public class AppConfig {
//
//    private static final Logger logger = (Logger) LoggerFactory.getLogger(AppConfig.class);
//
//    @Bean(name="studentService")
//    public RmiProxyFactoryBean rmiProxyFactoryBean(){
//        String rmi = RandomService.getRandomServicermi();
//        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
//        rmiProxyFactoryBean.setServiceUrl(rmi);
//        rmiProxyFactoryBean.setServiceInterface(StudentService.class);
//        //连接错误自动重连
//        //rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
//        //不在容器启动的时候创建server端连接
////        rmiProxyFactoryBean.setLookupStubOnStartup(false);
//            try{
//                rmiProxyFactoryBean.afterPropertiesSet();
//            }catch (Exception e) {
////              throw new RemoteException("Error create rmi proxy");
//                RmiProxyFactoryBean rmiProxyFactoryBean1 = new RmiProxyFactoryBean();
//                rmiProxyFactoryBean1.setServiceUrl(RandomService.getanotherrmi(rmi));
//                rmiProxyFactoryBean1.setServiceInterface(StudentService.class);
//                logger.info("正在是用服务："+RandomService.getanotherrmi(rmi));
//                return rmiProxyFactoryBean1;
//            }
//        logger.info("正在是用服务："+rmi);
//        return rmiProxyFactoryBean;
//    }
//}

package com.jnshuboot.configure;

import com.jnshuboot.service.IUserService;
import com.jnshuboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class RmiServer {
    @Autowired
    private IUserService userService;
    @Autowired
    private LoginService loginService;

    @Bean(name = "userService")
    public RmiServiceExporter rmiServiceExporterUser() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("userService");
        rmiServiceExporter.setService(userService);
        rmiServiceExporter.setServiceInterface(IUserService.class);
//        rmiServiceExporter.setRegistryPort(1090);
        rmiServiceExporter.setRegistryPort(1091);
        return rmiServiceExporter;
    }
//    @Bean(name="loginService")
//    public RmiServiceExporter rmiServiceExporterLogin() {
//        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
//        rmiServiceExporter.setServiceName("loginService");
//        rmiServiceExporter.setService(loginService);
//        rmiServiceExporter.setServiceInterface(LoginService.class);
//        rmiServiceExporter.setRegistryPort(1090);
//        return rmiServiceExporter;
//    }
    //    @Autowired
//    private ServiceRMI serviceRMI;
//
//    @Bean
//    public RmiServiceExporter getRmiServiceExporter() {
//        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
//        rmiServiceExporter.setServiceName("serviceRMI");
//        rmiServiceExporter.setService(serviceRMI);
//        rmiServiceExporter.setServiceInterface(ServiceRMI.class);
//        rmiServiceExporter.setRegistryPort(1099);
//        return rmiServiceExporter;
//    }
}

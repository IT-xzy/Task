package com.jnshu.rmi.config;

import com.jnshu.rmi.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
@ComponentScan(basePackages = "com.jnshu.rmi.*")
public class MainConfig {

    @Bean
    public RmiServiceExporter rmiExporter(StudentService studentService) {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(studentService);
        //serviceName属性用来在RMI注册表中注册一个服务
        exporter.setServiceName("StudentService");
        exporter.setServiceInterface(StudentService.class);
        return exporter;
    }


}

package com.mutesaid.rmi_demo_service.config;

import com.mutesaid.rmi_demo_core.service.ExpertService;
import com.mutesaid.rmi_demo_core.service.ProfessionService;
import com.mutesaid.rmi_demo_core.service.StudentService;
import com.mutesaid.rmi_demo_core.service.UsrService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

import javax.annotation.Resource;

@Configuration
public class ServerConfig {
    @Resource
    private ExpertService expertService;

    @Resource
    private ProfessionService professionService;

    @Resource
    private StudentService studentService;

    @Resource
    private UsrService usrService;

    @Bean
    public RemoteExporter registerRMIExporter1() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("expertService");
        exporter.setServiceInterface(ExpertService.class);
        exporter.setService(expertService);
        exporter.setRegistryPort(1800);
        return exporter;
    }

    @Bean
    public RemoteExporter registerRMIExporter2() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("professionService");
        exporter.setServiceInterface(ProfessionService.class);
        exporter.setService(professionService);
        exporter.setRegistryPort(1800);
        return exporter;
    }

    @Bean
    public RemoteExporter registerRMIExporter3() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("studentService");
        exporter.setServiceInterface(StudentService.class);
        exporter.setService(studentService);
        exporter.setRegistryPort(1800);
        return exporter;
    }

    @Bean
    public RemoteExporter registerRMIExporter4() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("usrService");
        exporter.setServiceInterface(UsrService.class);
        exporter.setService(usrService);
        exporter.setRegistryPort(1800);
        return exporter;
    }
}

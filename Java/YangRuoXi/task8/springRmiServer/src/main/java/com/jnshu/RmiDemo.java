package com.jnshu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class RmiDemo {

    @Bean
    public RmiServiceExporter rmiServiceExporter( ){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(new RmiInterfaceImpl());
        rmiServiceExporter.setServiceName("RmiDemo");
        rmiServiceExporter.setServiceInterface(RmiInterface.class);
//        rmiServiceExporter.setRegistryPort(1199);
//        rmiServiceExporter.setpo
        return rmiServiceExporter;

    }
}

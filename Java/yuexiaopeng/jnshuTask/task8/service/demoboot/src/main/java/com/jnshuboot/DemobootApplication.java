package com.jnshuboot;

import com.jnshuboot.service.ServiceRMI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.remoting.caucho.HessianServiceExporter;

@EnableCaching
@SpringBootApplication
@MapperScan(basePackages = "com.jnshuboot.dao")
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class DemobootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemobootApplication.class, args);
        System.out.println("spring boot success");
    }
//        @Bean(name = "/whichever.service")
//    public HessianServiceExporter hessianServiceExporter(ServiceRMI service){
//        HessianServiceExporter exporter=new HessianServiceExporter();
//        exporter.setService(service);
//        exporter.setServiceInterface(ServiceRMI.class);
//        return exporter;
//    }

}

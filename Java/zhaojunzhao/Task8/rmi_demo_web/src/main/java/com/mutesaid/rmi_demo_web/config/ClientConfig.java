package com.mutesaid.rmi_demo_web.config;

import com.mutesaid.rmi_demo_core.service.ExpertService;
import com.mutesaid.rmi_demo_core.service.ProfessionService;
import com.mutesaid.rmi_demo_core.service.StudentService;
import com.mutesaid.rmi_demo_core.service.UsrService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class ClientConfig {

    @Bean(name = "expertService")
    public RmiProxyFactoryBean getExpertService(){
        RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
        proxy.setServiceUrl("rmi://localhost:1800/expertService");
        proxy.setServiceInterface(ExpertService.class);
        return proxy;
    }

    @Bean(name = "studentService")
    public RmiProxyFactoryBean getStudentService(){
        RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
        proxy.setServiceUrl("rmi://localhost:1800/studentService");
        proxy.setServiceInterface(StudentService.class);
        return proxy;
    }

    @Bean(name = "professionService")
    public RmiProxyFactoryBean getProfessionService(){
        RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
        proxy.setServiceUrl("rmi://localhost:1800/professionService");
        proxy.setServiceInterface(ProfessionService.class);
        return proxy;
    }

    @Bean(name = "usrService")
    public RmiProxyFactoryBean getUsrService(){
        RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
        proxy.setServiceUrl("rmi://localhost:1800/usrService");
        proxy.setServiceInterface(UsrService.class);
        return proxy;
    }
}

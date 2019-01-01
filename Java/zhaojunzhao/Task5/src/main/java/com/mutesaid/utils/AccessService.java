package com.mutesaid.utils;

import com.mutesaid.service.ExpertService;
import com.mutesaid.service.ProfessionService;
import com.mutesaid.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AccessService {
    private Map<String, String> serviceMap = new HashMap<>();

    private Long accessTime = 0L;

    private Logger logger = LogManager.getLogger(AccessService.class);

    public AccessService() {
        serviceMap.put("0", "rmi://211.159.167.172:1800/");
        serviceMap.put("1", "rmi://211.159.167.172:1801/");
    }

    private RmiProxyFactoryBean rmiFactory(Class serviceClass, String serviceName, Long currentTime, Long tryTime) {
        if (tryTime > serviceMap.size()) {
            logger.info("all of service already be tried");
            throw new RuntimeException("");
        }
        try {
            long accessAt = currentTime % serviceMap.size();
            String accessUrl = serviceMap.get(Long.toString(accessAt));
            RmiProxyFactoryBean rmiBean = new RmiProxyFactoryBean();
            rmiBean.setServiceUrl(accessUrl + serviceName);
            rmiBean.setServiceInterface(serviceClass);
            rmiBean.afterPropertiesSet();
            logger.info("Access service at" + accessUrl);
            return rmiBean;
        } catch (Exception e) {
            logger.info("Current service is break, try next service");
            return rmiFactory(serviceClass, serviceName, currentTime + 1, tryTime + 1);
        }
    }

    public ExpertService getExpertService() {
        RmiProxyFactoryBean rmiBean = rmiFactory(ExpertService.class, "expertService", accessTime++, 1L);
        return (ExpertService) rmiBean.getObject();
    }

    public ProfessionService getProfessionService() {
        RmiProxyFactoryBean rmiBean = rmiFactory(ProfessionService.class, "professionService", accessTime++, 1L);
        return (ProfessionService) rmiBean.getObject();
    }

    public StudentService getStudentService() {
        RmiProxyFactoryBean rmiBean = rmiFactory(StudentService.class, "studentService", accessTime++, 1L);
        return (StudentService) rmiBean.getObject();
    }
}

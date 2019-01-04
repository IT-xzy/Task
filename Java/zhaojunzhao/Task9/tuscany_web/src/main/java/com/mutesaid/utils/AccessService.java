package com.mutesaid.utils;

import com.mutesaid.service.ExpertService;
import com.mutesaid.service.ProfessionService;
import com.mutesaid.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
@Slf4j
public class AccessService {
    private Map<String, String> serviceMap = new HashMap<>();

    public AccessService() {
        serviceMap.put("0", "rmi://localhost:8099/");
        serviceMap.put("1", "rmi://localhost:8199/");
    }

    private Remote rmiFactory(String serviceName) throws NotBoundException, RemoteException, MalformedURLException {
        Random random = new Random();
        int index = random.nextInt(2);
        if(index == 1) {
            System.out.println(index);
            try{
                return Naming.lookup(serviceMap.get(Integer.toString(index)) + serviceName);
            }catch (Exception e){
                return Naming.lookup(serviceMap.get("0") + serviceName);
            }
        }else {
            System.out.println(index);
            try{
                return Naming.lookup(serviceMap.get(Integer.toString(index)) + serviceName);
            }catch (Exception e){
                return Naming.lookup(serviceMap.get("1") + serviceName);
            }
        }
    }

    public ExpertService getExpertService() {
        try{
            return (ExpertService) rmiFactory("ExpertService");
        }catch (Exception e) {
            return null;
        }
    }

    public ProfessionService getProfessionService() {
        try{
            return (ProfessionService) rmiFactory("ProfessionService");
        }catch (Exception e) {
            return null;
        }
    }

    public StudentService getStudentService() {
        try{
            return (StudentService) rmiFactory("StudentService");
        }catch (Exception e) {
            return null;
        }
    }
}

package task9;

import task9.service.JobService;
import task9.service.PositionService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Test {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
     JobService jobService = (JobService)Naming.lookup("//127.0.0.1:1087/JobService");
        System.out.println(jobService.queryService("前端开发"));
    }
}

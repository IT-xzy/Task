package com.jns.utils;

import com.jns.service.StudentService;
import com.jns.service.UsersService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiService {
    public StudentService getStudentService() throws RemoteException, NotBoundException, MalformedURLException {
        int rand=Math.random()>=0.5?1:0;
        if(rand==1){
            try {
                System.out.println("139.199.126.254的studentService");
                return (StudentService) Naming.lookup("rmi://139.199.126.254:8083/StudentServer");
            }catch (Exception e){
                System.out.println("39.105.66.68的studentService");
                return (StudentService) Naming.lookup("rmi://39.105.66.68:8083/StudentServer");
            }
        }else {
            try {
                System.out.println("39.105.66.68的studentService");
                return (StudentService) Naming.lookup("rmi://39.105.66.68:8083/StudentServer");
            } catch (Exception e) {
                System.out.println("139.199.126.254的studentService");
                return (StudentService) Naming.lookup("rmi://139.199.126.254:8083/StudentServer");
            }
        }
    }
    public UsersService getUsersService() throws RemoteException, NotBoundException, MalformedURLException {
        int rand=Math.random()>=0.5?1:0;
        if(rand==1){
            try{
                System.out.println("139.199.126.254的usersService");
                return (UsersService) Naming.lookup("rmi://139.199.126.254:8083/UsersServer");
            }catch (Exception e){
                System.out.println("39.105.66.68的usersService");
                return (UsersService) Naming.lookup("rmi://39.105.66.68:8083/UsersServer");
            }
        }else{
            try{
                System.out.println("39.105.66.68的usersService");
                return (UsersService) Naming.lookup("rmi://39.105.66.68:8083/UsersServer");
            }catch (Exception e){
                System.out.println("139.199.126.254的usersService");
                return (UsersService) Naming.lookup("rmi://139.199.126.254:8083/UsersServer");
            }
        }
    }
}

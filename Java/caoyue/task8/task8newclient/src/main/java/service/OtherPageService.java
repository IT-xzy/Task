package service;

import POJO.Company;
import POJO.Cooperation;
import POJO.GreatStudent;
import POJO.HowToStudy;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: 曹樾
 * @program: task8newclient
 * @description: the interface of first and third page
 * @create: 2018/6/7 下午2:52
 */

public interface OtherPageService extends Remote{
    List<GreatStudent> findStudentByName() throws RemoteException;
    List<Cooperation> findCooperation() throws RemoteException;
    List<HowToStudy> findStudy() throws RemoteException;
    List<Company> findCompany() throws RemoteException;
}

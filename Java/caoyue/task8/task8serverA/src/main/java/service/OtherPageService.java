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
 * @program: task8serverB
 * @description: the data of all pags export profession
 * @create: 2018/6/6 下午7:22
 */

public interface OtherPageService extends Remote{
    List<GreatStudent> findStudentByName() throws RemoteException;
    List<Cooperation> findCooperation() throws RemoteException;
    List<HowToStudy> findStudy() throws RemoteException;
    List<Company> findCompany() throws RemoteException;
}

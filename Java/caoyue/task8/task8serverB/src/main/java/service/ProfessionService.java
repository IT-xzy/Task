package service;

import POJO.Profession;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: 曹樾
 * @program: task8serverB
 * @description: the data of profession page
 * @create: 2018/6/6 下午7:24
 */

public interface ProfessionService extends Remote{
    List<Profession> findFront() throws RemoteException;
    List<Profession> findAfter() throws RemoteException;
    List<Profession> findOP() throws RemoteException;
    List<Profession> findPM() throws RemoteException;
}

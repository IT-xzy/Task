package service;

import POJO.Profession;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: 曹樾
 * @program: task8newclient
 * @description: the interface of second page
 * @create: 2018/6/7 下午2:54
 */

public interface ProfessionService extends Remote {
    List<Profession> findFront() throws RemoteException;
    List<Profession> findAfter() throws RemoteException;
    List<Profession> findOP() throws RemoteException;
    List<Profession> findPM() throws RemoteException;
}

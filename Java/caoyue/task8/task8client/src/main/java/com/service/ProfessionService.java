package com.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import com.POJO.Profession;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 职业操作实现接口
 * @create: 2018/5/7 下午5:40
 */

public interface ProfessionService extends Remote{
    List<Profession> findFront() throws RemoteException;
    List<Profession> findAfter() throws RemoteException;
    List<Profession> findOP() throws RemoteException;
    List<Profession> findPM() throws RemoteException;
}

package com.jnshu.services;
import com.jnshu.model.Students;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StudentsService extends Remote {
    int deleteById(Integer id) throws RemoteException;
    int insert(Students record) throws RemoteException;
    int insertSelective(Students record) throws RemoteException;
    Students selectById(Integer id) throws RemoteException;
    int updateByIdSelective(Students record) throws RemoteException;
    int updateById(Students record) throws RemoteException;
    List<Students> selectAll()throws RemoteException;
}

package com.jnshu.service;

import com.jnshu.model.ExcellentStudent;

import java.rmi.Remote;
import java.util.List;

public interface ESService  {
    public ExcellentStudent findById(Integer id) throws java.rmi.RemoteException;

    public List<ExcellentStudent> listAll() throws java.rmi.RemoteException;
    public String sayHello(String name) throws java.rmi.RemoteException;
}

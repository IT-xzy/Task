package com.jnshu.service.impl;

import com.jnshu.dao.ExcellentStudentMapper;
import com.jnshu.model.ExcellentStudent;
import com.jnshu.service.ESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

@Service("eSService")
public class ESServiceImpl extends UnicastRemoteObject implements ESService {
    // 这个实现必须有一个显式的构造函数，并且要抛出一个RemoteException异常
    public ESServiceImpl() throws RemoteException {
        super();
    }

    @Autowired
    private ExcellentStudentMapper ESDao;

    public ExcellentStudentMapper getESMapper() {
        return ESDao;
    }

    public void setESMapper(ExcellentStudentMapper ESDao) {
        this.ESDao = ESDao;
    }

    @Override
    public ExcellentStudent findById(Integer id) throws RemoteException {
        return ESDao.selectByPrimaryKey(id);
    }

    @Override
    public List<ExcellentStudent> listAll() throws RemoteException {
        return ESDao.listAll();
    }

    @Override
    public String sayHello(String name)  {
        return "Hello " + name + " ^_^ ";    }
}
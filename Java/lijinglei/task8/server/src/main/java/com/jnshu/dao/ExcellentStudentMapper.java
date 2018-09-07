package com.jnshu.dao;

import com.jnshu.model.ExcellentStudent;
import org.springframework.stereotype.Service;

import java.rmi.Remote;
import java.util.List;
@Service("ESDao")
public interface ExcellentStudentMapper  {

    ExcellentStudent selectByPrimaryKey(Integer id) throws java.rmi.RemoteException;
    List<ExcellentStudent> listAll() throws java.rmi.RemoteException;
}
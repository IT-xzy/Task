package com.ptteng.service;

import com.ptteng.model.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface StudentService extends Remote {

    List<Student> selectAll()throws RemoteException;
}

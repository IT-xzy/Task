package com.jnshu.service;

import com.jnshu.model.StudentNum;

import java.util.List;

public interface SNService {
  StudentNum findById(Integer id) throws java.rmi.RemoteException;
  List<StudentNum> listAll() throws java.rmi.RemoteException;
}

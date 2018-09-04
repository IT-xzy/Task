package com.jnshu.service;

import com.jnshu.model.StudentNum;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;
@Remotable
public interface SNService {
  StudentNum findById(Integer id) throws java.rmi.RemoteException;
  List<StudentNum> listAll() throws java.rmi.RemoteException;
}

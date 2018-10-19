package com.jnshu.service;

import com.jnshu.model.JobInfo;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;

@Remotable
public interface JIService {
  JobInfo findById(Integer id) throws java.rmi.RemoteException;
  List<JobInfo> listAll() throws java.rmi.RemoteException;
}

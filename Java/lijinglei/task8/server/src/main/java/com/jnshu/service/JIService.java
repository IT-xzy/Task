package com.jnshu.service;

import com.jnshu.model.JobInfo;

import java.util.List;


public interface JIService {
  JobInfo findById(Integer id) throws java.rmi.RemoteException;
  List<JobInfo> listAll() throws java.rmi.RemoteException;
}

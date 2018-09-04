package com.jnshu.service;

import com.jnshu.model.User;
import org.oasisopen.sca.annotation.Remotable;

@Remotable
public interface UserService {
  User findById(Integer id) throws java.rmi.RemoteException;
  String update(User addInfo) throws java.rmi.RemoteException;
  boolean login(User user) throws java.rmi.RemoteException;
  String addInfo(User addInfo) throws java.rmi.RemoteException;
  User selectByName(String userName) throws java.rmi.RemoteException;
  String addTime(User login) throws java.rmi.RemoteException;
  String uploadImage(String userName, String image) throws java.rmi.RemoteException;

}

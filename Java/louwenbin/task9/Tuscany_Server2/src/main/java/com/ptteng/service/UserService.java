package com.ptteng.service;

import org.oasisopen.sca.annotation.Remotable;

import java.rmi.RemoteException;
import java.util.List;

@Remotable
public interface UserService {
    List getAll() throws RemoteException;
}


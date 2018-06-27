package com.ptteng.service;

import java.rmi.RemoteException;
import java.util.List;

public interface UserService {
    List getAll() throws RemoteException;
}


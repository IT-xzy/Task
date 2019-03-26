package com.ptteng.service;


import com.ptteng.model.Student;
import org.oasisopen.sca.annotation.Remotable;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


@Remotable
public interface StudentService  {
    List<Student> selectAll();
}

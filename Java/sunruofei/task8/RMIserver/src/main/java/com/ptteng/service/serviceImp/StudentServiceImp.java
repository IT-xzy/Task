package com.ptteng.service.serviceImp;

import com.ptteng.mapper.StudentMapper;
import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * @ClassName StudentServiceImp
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/21  17:54
 * @Version 1.0
 **/

@Service
public class StudentServiceImp extends UnicastRemoteObject implements StudentService {

    private static final long serialVersionUID = -7457477705904227332L;
    @Autowired
    StudentMapper studentMapper;

    public StudentServiceImp() throws RemoteException{
        super();
    }

    @Override
    public List<Student> selectAll()throws RemoteException {
        System.out.println("有没有反应");
        System.out.println("============="+studentMapper.selectAll());
        List list = studentMapper.selectAll();
        System.out.println(list);
        return studentMapper.selectAll();
    }
}

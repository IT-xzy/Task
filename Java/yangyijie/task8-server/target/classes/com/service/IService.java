package com.service;

import com.bean.PageBean;
import com.bean.Student;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Arike
 * Create_at 2017/12/14 11:55
 */

public interface IService extends Remote {
    //通过ID查询
    Student getStudentById(Long id) throws RemoteException;
    
    //通过name模糊查询
    List<Student> getStudentByName(String name) throws RemoteException;
    
    //更新
    void updateStudent(Student student) throws RemoteException;
    
    //插入
    void insertStudent(Student student) throws RemoteException;
    
    //删除
    void deleteStudent(Long id) throws RemoteException;
    
    //查询所有
    List<Student> selectAll() throws RemoteException;
    
    //查询记录总数
    int selectCount() throws RemoteException;
    
    //分页查询
    PageBean<Student> findByPage(int currentPage) throws RemoteException;
}

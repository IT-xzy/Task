package service;

import dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;

import java.util.List;

@Service
public class ServiceIndexImpl implements ServiceIndex{
    @Autowired
    StudentDao studentDao;
    @Override
    public List<Student> listStudent(){
        return studentDao.listStudent();
    }
    @Override
public int count(){
        return studentDao.count();
    }
}

package com.service.impl;

import com.Dao.StudentDao;
import com.model.Student;
import com.model.zhiwei;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao ;
     @Override
    public List<Student> findAll(){
         return studentDao.findAll();
     }

     @Override
    public List<zhiwei> findAlls(){
         return studentDao.findAlls();
     }
     @Override
     public int findName(){
         return studentDao.findName();
     }
     public zhiwei addlist(zhiwei zhi){
         return studentDao.addlist(zhi);
         
     }

}

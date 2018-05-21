package com.fangyuyang.service.serviceImpl;

import com.fangyuyang.Dao.StudentDao;
import com.fangyuyang.model.Student;
import com.fangyuyang.service.StudentServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServcie {
    @Autowired
    private StudentDao studentDao;
    public void addStudent(Student student){
        studentDao.add(student);
    }
   public void updateStudent(Student student){
        studentDao.update(student);
    }
   public void deleteStudent(int id){
         studentDao.delete(id);
   }

   public Student findStudentById(int id){
        return studentDao.get(id);
   }

   public List<Student> findAll(){
        return studentDao.list();
   }
}

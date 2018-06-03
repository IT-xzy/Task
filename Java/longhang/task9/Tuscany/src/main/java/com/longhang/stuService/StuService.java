package com.longhang.stuService;

import com.longhang.model.Student;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;
@Remotable
public interface StuService {
 Student getStuById(Long id);
 void getInsert(Student student);
 boolean getDelete(Long id);
 List<Student> getGetAll();
 List<Student> getGetAllExcellent();
 boolean getUpdate(Student student);
 Student getStu(Student student);
 int getGetCount();
 int getGetCountG();
 int getGetMajor(String major);
 String[] getGetPicture();


}

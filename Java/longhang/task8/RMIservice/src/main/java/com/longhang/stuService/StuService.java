package com.longhang.stuService;

import com.longhang.model.Curriculum;
import com.longhang.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface StuService{
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

 void getInsertCu(Curriculum curriculum);
 boolean getUpdateCu(Curriculum curriculum);
 Curriculum getSelectCu(Long id);
 boolean getUpdateCuByName(String name, int onnum);
 boolean getDeleteCu(Long id);
 List<Curriculum> getGetAllCu();
 ArrayList<String> getGetAllCuName();

}

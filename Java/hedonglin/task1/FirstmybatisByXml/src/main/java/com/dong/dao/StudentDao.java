package com.dong.dao;

import com.dong.model.Student;


public interface StudentDao {
   Student selectStudentById(Integer id);

   Student selectStudentByStudentId(Integer studentId);

   Student selectStudentByStudentName(String studentName);

   int insertStudent(Student student);

   Integer deleteStudentById(Integer id);

   boolean updateStudent(Student student);



}

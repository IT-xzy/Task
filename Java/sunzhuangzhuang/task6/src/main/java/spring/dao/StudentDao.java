package spring.dao;

import spring.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getGood(); //荣耀学生
    int getOffer();  //找到工作
    int getAll();  //所有学习的人
    void addStudent(Student student);
    int getJava();
    int getWeb();
    int getPm();
}

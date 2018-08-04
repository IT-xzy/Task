package spring.service;

import spring.model.Student;

import java.util.List;

public interface IstudentService {
    List<Student> getGood(); //荣耀学生
    int getOffer();  //找到工作
    int getAll();  //所有学习的人
    void addStudent(Student student);
    int getJava();
    int getWeb();
    int getPm();
    Student getStudentByName(String name); //通过电话号码查询学生
    boolean selectByName(String name);  //通过用户名查看是否为内门
    void updateByName(Student student);  //通过用户名添加图片路径

}

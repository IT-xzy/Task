package spring.dao;

import spring.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getGood(); //荣耀学生
    int getOffer();  //找到工作
    int getAll();  //所有学习的人
    void addStudent(Student student); //添加学生
    int getJava();
    int getWeb();
    int getPm();
    boolean selectByName(String name);  //通过用户名查看是否为内门
    Student getStudentByName(String name); //通过用户名查询学生
    void updateByName(Student student);  //通过用户名添加图片路径
}

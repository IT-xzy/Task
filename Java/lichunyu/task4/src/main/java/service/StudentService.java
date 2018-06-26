package service;

import pojo.Student;


public interface StudentService {
    void insertStudent(Student student) throws Exception;//插入学员
    void deleteById(Integer id) throws Exception;//id删除
    Integer getLearningStudentCount() throws Exception;//查询在学学生数量
    Integer getGraduatedStudentCount() throws Exception;//查询工作学生数量
    Student getExcellentStudent(Integer studentNum) throws Exception;//学号查询优秀学生
    Integer getCareerTypeCount(String career) throws Exception;//查询职业人数
    void updateStudent(Student student) throws Exception;//修改学员
}

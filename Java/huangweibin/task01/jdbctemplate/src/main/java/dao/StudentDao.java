package dao;

import service.Student;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDao {

    //创建表格
    public void createTable();

    //输入数据来源
    public void setDateSource(DataSource dataSource);

    //插入学生的姓名和年龄
    public void insert(String name,Integer age);

    //获取学生的 id
    public Student getStudent(Integer id);

    //遍历学生信息
    public List<Student>listStudent();

    //更新学生的 id 和年龄
    public void update(Integer id,Integer age);


}

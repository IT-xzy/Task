package com;
import java.util.List;
import javax.sql.DataSource;
/**
 * @author: Arike
 * @program: springJDBC
 * @description: 访问对象接口文件
 * @create: 2018/3/13 下午2:10
 */

public interface StudentDAO {
    void setDataSource(DataSource ds);
    void create(String name, Integer ID);
    //    Student getStudent(Integer ID);
    List<Student> listStudents();
    void delete(Integer ID);
    void update(Integer ID,String name);
}

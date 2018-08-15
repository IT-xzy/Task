package dao;

import pojo.Student;
import java.util.ArrayList;
import java.util.List;

public interface StudentDao {
    List<Student> listStudent();
    //显示在学人数
    int count();
}

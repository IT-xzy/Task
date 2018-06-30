package spring.dao;

import spring.model.Student;
import java.util.List;

public interface StudentDao {
    List<Student> getGood();
    int getOffer();
    int getAll();
    void addStudent(Student student);
    int getJava();
    int getWeb();
    int getPm();
}

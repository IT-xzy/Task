package task4.dao;

import task4.pojo.Student;

public interface StudentDao {
     Integer count();
     Integer countJob();
     Integer savaStudent(Student student);
}

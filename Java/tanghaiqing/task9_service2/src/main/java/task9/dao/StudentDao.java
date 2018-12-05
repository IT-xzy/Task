package task9.dao;

import task9.pojo.Student;

public interface StudentDao {
     Integer count();
     Integer countJob();
     Integer savaStudent(Student student);
}

package task7.dao;

import task7.pojo.Student;

public interface StudentDao {
     Integer count();
     Integer countJob();
     Integer savaStudent(Student student);
}

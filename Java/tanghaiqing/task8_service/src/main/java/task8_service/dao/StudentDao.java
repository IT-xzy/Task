package task8_service.dao;

import task8_service.pojo.Student;

public interface StudentDao {
     Integer count();
     Integer countJob();
     Integer savaStudent(Student student);
}

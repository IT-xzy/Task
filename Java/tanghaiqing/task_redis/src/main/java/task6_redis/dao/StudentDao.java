package task6_redis.dao;

import task6_redis.pojo.Student;

public interface StudentDao {
     Integer count();
     Integer countJob();
     Integer savaStudent(Student student);
}

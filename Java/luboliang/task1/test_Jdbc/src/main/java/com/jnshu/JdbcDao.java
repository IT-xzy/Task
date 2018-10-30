package com.jnshu;

import java.sql.SQLException;
import java.util.List;

public interface JdbcDao {
    long add(Student student);

    boolean delete(long id) throws SQLException;

    boolean update(Student student);

    Student select(long id);

    List<Student> findStudents();

}

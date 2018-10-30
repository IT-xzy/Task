package com.jnshu.MyBatis;

import com.jnshu.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface StudentDao {
    List<Student> all();

    int count();

   int number();

  int java();

}

package com.mutesaid.service;
import com.mutesaid.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudent(String key,Object value);

    Long insert(Student stu);

    Boolean delete(String onlineId);

    Boolean update(String onlineId, String key, Object value, long currentTime);
}

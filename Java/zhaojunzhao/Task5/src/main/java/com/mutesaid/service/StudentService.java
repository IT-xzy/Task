package com.mutesaid.service;

import com.mutesaid.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAll(String name, String qq, String onlineId, String id);

    Long insert(Student stu);

    <T> Boolean update(Long id, String key, T value);

    Boolean delete(Long id);
}

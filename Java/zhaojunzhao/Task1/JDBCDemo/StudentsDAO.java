package com.mutesaid.DBDemo.JDBCDemo;

public interface StudentsDAO {
    void add(Students stu);

    void delete(String onlineId);

    void update(String online_id, String key, String value);

    Students getStudent(String onlineId);
}

package fourth.Dao;

import fourth.com.student;

public interface studentDao {
    public int addStudent(student student);
    public int updateStudent(String name);
    public int deleteStudent(String name);
    public student findStudent(student student);
}

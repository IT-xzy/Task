package org.jnshuDB.dao;

import org.jnshuDB.entity.Student;

import java.util.List;


public interface StudentDao {
   public int insert(Student student);
   public int update(Student student);
   public void delete(int s_id);
   public List<Student> selectAll();
    public int countAll();
    public Student findByS_id(int s_id);
}






package com.jnshu;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    public long insert(Student student) throws ClassNotFoundException, SQLException;
    public boolean delete(long id) throws ClassNotFoundException, SQLException;
    public boolean update(Student student) throws ClassNotFoundException, SQLException;
    public Student find(long id) throws ClassNotFoundException, SQLException;
    public List findAll() throws ClassNotFoundException, SQLException;

}


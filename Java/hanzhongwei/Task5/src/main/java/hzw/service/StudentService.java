package hzw.service;

import hzw.model.Student;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    public List<Student> findStudent() throws IOException;
}

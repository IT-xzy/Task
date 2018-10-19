package jnshu.service.impl;

import jnshu.dao.StudentMapper;
import jnshu.pojo.Student;
import jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    @Qualifier("StudentDAOBean")
    private StudentMapper studentMapper;

    Logger logger = Logger.getLogger(StudentServiceImpl.class);

    @Override
    public Student findByStudentID(int id) {
        try {
            return studentMapper.findByStudentID(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insertStudent(Student record) {
        return 0;
    }

    @Override
    public int insertSelectiveStudent(Student record) {
        return 0;
    }

    @Override
    public List<Student> listStudent() throws Exception {
        try {
            return studentMapper.listStudent();
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Student> listExcellent() throws Exception {
        try {
            return studentMapper.listExcellent();
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }
}

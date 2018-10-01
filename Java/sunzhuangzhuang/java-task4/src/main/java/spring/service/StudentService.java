package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.StudentDao;
import spring.model.Student;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public List<Student> getGood() {
        return studentDao.getGood() ;
    }

    public int getOffer() {
        return studentDao.getOffer();
    }

    public int getAll() {
        return studentDao.getAll();
    }

    public int getJava(){
        return studentDao.getJava();
    }

    public int getWeb(){
        return studentDao.getWeb();
    }

    public int getPm(){
        return studentDao.getPm();
    }
}

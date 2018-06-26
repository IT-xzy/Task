package hzw.service;

import hzw.DAO.ProfessionDao;
import hzw.DAO.StudentDao;
import hzw.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceManageImpl")
public class ServiceManageImpl implements ServiceManage{
    @Autowired
    StudentDao studentDao;
    @Autowired
    ProfessionDao professionDao;

    public Student findByIdStudent(Integer id) {
        return null;
    }

    public List<StundetCustom> findListStudent() {
        return studentDao.findListStudent();
    }

    public boolean insertStudent(Student student) {
        return false;
    }

    public boolean deleteStudent(Integer id) {
        return false;
    }

    public boolean updateStudent(Student student) {
        return false;
    }

    public StudentStatistics countStudent() {
        Integer countStudent = studentDao.countStudent();
        Integer countWork = studentDao.countWork();
        StudentStatistics studentStatistics = new StudentStatistics();
        studentStatistics.setCountStudent(countStudent);
        studentStatistics.setWorkStundet(countWork);
        return studentStatistics;
    }

    public List<Profession1> findByListProfession() {
        return professionDao.findByListProfession();
    }

}

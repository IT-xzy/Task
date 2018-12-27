package jnshu.service.impl;

import jnshu.dao.StudentInfoMapper;
import jnshu.pojo.Admin;
import jnshu.pojo.StudentInfo;
import jnshu.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoImpl implements StudentInfoService {

    @Autowired
    StudentInfoMapper studentDAO;

    @Override
    public Integer insertSTU(StudentInfo studentInfo) throws Exception {
        return studentDAO.insertSTU(studentInfo);
    }

    @Override
    public void deleteByID(Integer id) throws Exception {
        studentDAO.deleteByID(id);
    }

    /**
     *
     * @param pageCount
     * 获取表中第(pageCount后+每页展示数)条记录
     */
    @Override
    public List<StudentInfo> listTable(Integer pageCount) throws Exception {
        return studentDAO.listTable(pageCount);
    }

    @Override
    public List<StudentInfo> listAll() throws Exception {
        return studentDAO.listAll();
    }


    @Override
    public void updateByID(StudentInfo studentInfo) throws Exception {
        studentDAO.updateByID(studentInfo);
    }

    @Override
    public List<StudentInfo> findByLikeName(String studentName) throws Exception {
        return studentDAO.findByLikeName(studentName);
    }

    @Override
    public StudentInfo findByStudentID(Integer id) throws Exception {
        return studentDAO.findByStudentID(id);
    }

    @Override
    public Integer register(Admin admin) throws Exception {
        return studentDAO.register(admin);
    }

    @Override
    public Admin checkLogin(Admin admin) throws Exception {
        return studentDAO.checkLogin(admin);
    }

    /**
     *获取表记录总数
     */
    @Override
    public int allCount() throws Exception {
        return studentDAO.allCount();
    }
}

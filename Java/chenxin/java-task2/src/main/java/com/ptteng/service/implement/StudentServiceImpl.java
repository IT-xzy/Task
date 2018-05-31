package com.ptteng.service.implement;

import com.ptteng.dao.StudentDao;
import com.ptteng.model.PageBean;
import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public Student getStudentById(Long id) throws Exception {
        return studentDao.getStudentById(id);
    }
    @Override
    public List<Student> getStudentsListByName(String name) throws Exception {
        return studentDao.getStudentsListByName(name);
    }
    @Override
    public List<Student> getAllStudents() throws Exception {
        return studentDao.getAllStudents();
    }

    @Override
    public Boolean deleteStudentById(Long id) throws Exception {
        return studentDao.deleteStudentById(id);
    }

    @Override
    public Integer saveStudent(Student student) throws Exception {
        return studentDao.saveStudent(student);
    }

    @Override
    public Boolean updateStudent(Student student) throws Exception {
        return studentDao.updateStudent(student);
    }
    //分页查询
    @Override
    public PageBean<Student> getStudentsByPage(int currentPage) throws Exception {
        HashMap<String,Object> map=new HashMap<String, Object>();
        PageBean<Student> pageBean=new PageBean<Student>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据数
        int pageSize=15;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        pageBean.setTotalCount(studentDao.getCount());
        //封装总页数
        double totalCount=studentDao.getCount();
        Double pageNumber=Math.ceil(totalCount/pageSize);
        pageBean.setTotalPage(pageNumber.intValue());
        //设置查询的起始数和范围
        map.put("start",(currentPage-1)*pageSize);
        map.put("size",pageBean.getPageSize());
        //封装每页数据
        List<Student> list=studentDao.getStudentsListByPage(map);
        pageBean.setLists(list);
        return pageBean;
    }
}

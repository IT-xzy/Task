package com.service.impl;

import com.bean.PageBean;
import com.bean.Student;
import com.bean.StudentPut;
import com.dao.IStudentDao;
import com.service.IService;
import com.util.ChangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Arike
 * Create_at 2017/12/14 15:39
 */

@Service
public class ServiceImpl implements IService {
    @Autowired
    private IStudentDao iStudentDao;
   
    @Override
    public Student getStudentById(Long id) {
        return iStudentDao.getStudentById(id);
    }
    
    @Override
    public List<Student> getStudentByName(String name) {
        return iStudentDao.getStudentByName(name);
    }
    
    @Override
    public void updateStudent(Student student) {
        
        student.setUpdate_at(System.currentTimeMillis());
        iStudentDao.updateStudent(student);
    }
    
    @Override
    public void insertStudent(Student student) {
        student.setCreate_at(System.currentTimeMillis());
        iStudentDao.insertStudent(student);
    }
    
    @Override
    public void deleteStudent(Long id) {
        iStudentDao.deleteStudent(id);
    }
    
    @Override
    public List<Student> selectAll() {
        return iStudentDao.selectAll();
    }
    
    @Override
    public int selectCount() {
        return iStudentDao.selectCount();
    }
    
    @Override
    public PageBean<Student> findByPage(int currentPage) {
        
        HashMap<String, Object> map = new HashMap<>();
        PageBean<Student> pageBean = new PageBean<>();
        
        //封装当前页数
        pageBean.setCurrPage(currentPage);
       
        //每页显示数据
        int pageSize=8;
        pageBean.setPageSize(pageSize);
       
       //封装记录总数
        int totalCount = selectCount();
        pageBean.setTotalCount(totalCount);
       
        //封装总页数
        double tc = totalCount; //总记录数/每页显示数量 = 总页数 12.5 13
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
    
        map.put("start", (currentPage - 1) * pageSize); //你从第几个开始查
        map.put("size", pageBean.getPageSize());//查多少个
        
        //封装每页接收的数据
        List<Student> list = iStudentDao.findByPage(map);
        pageBean.setLists(list);
        
        //封装每页显示的数据
        List<StudentPut> list1 = new ArrayList<>();
        for (Student student : list) {
            list1.add(ChangeUtil.timeChange(student));
        }
        pageBean.setList(list1);
        return pageBean;
    }
    
    
}

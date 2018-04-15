package com.service;

import com.DAO.StudentMapper;
import com.POJO.ChangeType;
import com.POJO.DateTypeChange1;
import com.POJO.PageBean;
import com.POJO.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    private String name;
    
    public Student findUserById(int ID) throws Exception {
        return studentMapper.findUserById(ID);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public PageBean<DateTypeChange1> findUserByName(int currentPage, String name) throws IOException {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<DateTypeChange1> pageBean = new PageBean<DateTypeChange1>();
        //封装当前页数
        pageBean.setCurrentPage(currentPage);
        //每页显示的数据
        int pageSize=8;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = studentMapper.selectCount2(name);
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("name",name);
        //封装每页显示的数据时间转换
        List<Student> list = studentMapper.findUserByName(map);
        List<DateTypeChange1> lists=new ArrayList<DateTypeChange1>();
        for(Student student : list){
            lists.add(ChangeType.dateTypeChange1(student));
        }
        pageBean.setLists(lists);
        return pageBean;
        
//        HashMap<String,Object> map = new HashMap<String,Object>();
//        PageBean<DateTypeChange1> pageBean = new PageBean<DateTypeChange1>();
//        pageBean.setCurrentPage(currentPage);
//        int pageSize=8;
//        pageBean.setPageSize(pageSize);
//        int totalCount = studentMapper.selectCount();
//        pageBean.setTotalCount(totalCount);
//        double tc = totalCount;
//        Double num =Math.ceil(tc/pageSize);
//        pageBean.setTotalPage(num.intValue());
//        map.put("start",(currentPage-1)*pageSize);
//        map.put("size", pageBean.getPageSize());
//        List<Student> list = studentMapper.findAll(map);
//        List<DateTypeChange1> lists=new ArrayList<DateTypeChange1>();
//        for(Student student : list){
//            lists.add(ChangeType.dateTypeChange1(student));
//        }
//        pageBean.setLists(lists);
//        return pageBean;
    }
    
    
    public int insertUser(Student student) throws Exception {
        return studentMapper.insertUser(student);
    }
    
    public int deleteUser(int id) throws Exception {
        return studentMapper.deleteUser(id);
    }
    
    public int updateUser(Student student) throws Exception {
        return studentMapper.updateUser(student);
    }
    public int selectCount() {
        return studentMapper.selectCount();
    }
    
    public int selectCount2(String name) {
        return studentMapper.selectCount2(name);
    }
    
    public PageBean<DateTypeChange1> findAll(int currentPage){
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<DateTypeChange1> pageBean = new PageBean<DateTypeChange1>();
        //封装当前页数
        pageBean.setCurrentPage(currentPage);
        //每页显示的数据
        int pageSize=8;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = studentMapper.selectCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<Student> list = studentMapper.findAll(map);
        List<DateTypeChange1> lists=new ArrayList<DateTypeChange1>();
        for(Student student : list){
            lists.add(ChangeType.dateTypeChange1(student));
        }
        pageBean.setLists(lists);
        return pageBean;
    }
}

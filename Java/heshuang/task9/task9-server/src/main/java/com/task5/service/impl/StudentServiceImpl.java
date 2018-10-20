package com.task5.service.impl;

import com.task5.mapper.StudentMapper;
import com.task5.pojo.Page;
import com.task5.pojo.Student;
import com.task5.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService{
    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(long id) throws Exception {
        return studentMapper.getStudentById(id);
    }

    @Override
    public List<Student> getStudentsListByName(String name) throws Exception {
        return studentMapper.getStudentsListByName(name);
    }
    @Override
    public List<Student> getAllStudents() throws Exception {
        return studentMapper.getAllStudents();
    }

    @Override
    public Integer getCount() throws Exception {
        return studentMapper.getCount();
    }

    @Override
    public Integer deleteStudentById(Long id) throws Exception {
        return studentMapper.deleteStudentById(id);
    }

    @Override
    public int saveStudent(Student student) throws Exception {
        return studentMapper.saveStudent(student);
    }

    @Override
    public Integer updateStudent(Student student) throws Exception {
        return studentMapper.updateStudent(student);
    }
    //分页查询
    @Override
    public Page<Student> findByPage(int currentPage) throws Exception {
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        Page<Student> page=new Page<Student>();
        //封装当前页数
        page.setCurrPage(currentPage);
        //每页显示的数据数
        int pageSize=8;
        page.setPageSize(pageSize);
        //封装总记录数
        page.setTotalCount(studentMapper.getCount());
        //封装总页数
        double totalCount=studentMapper.getCount();
        Double pageNumber=Math.ceil(totalCount/pageSize);
        page.setTotalPage(pageNumber.intValue());
        //设置查询的起始数和范围
        hashMap.put("start",(currentPage-1)*pageSize);
        hashMap.put("size",page.getPageSize());
        //封装每页数据
        List<Student> list=studentMapper.findByPage(hashMap);
        page.setLists(list);
        return page;
    }

//    @Override
//    public List<Student> nameAndOnline_id(String name,String online_id) throws Exception {
//        return studentMapper.nameAndOnline_id(name,online_id);
//    }
}

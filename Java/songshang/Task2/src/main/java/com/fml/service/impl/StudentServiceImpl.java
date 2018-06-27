package com.fml.service.impl;

import com.fml.mapper.StudentMapper;
import com.fml.pojo.Student;
import com.fml.service.StudentService;
import com.fml.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @ClassName:
 * @author: fml<duanweikai>
 * @date: 2018/3/10 14:09
 * @version: [1.0]
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public int add(Student student) {
        return studentMapper.add(student);
    }

    @Override
    public int delete(int id) {
        return studentMapper.delete(id);
    }

    @Override
    public int deleteAll() {
        return studentMapper.deleteAll();
    }

    @Override
    public int update(Student student) {

        return studentMapper.update(student);
    }

    @Override
    public Student selectById(int id) {
        return studentMapper.selectById(id);
    }

    @Override
    public List<Student> selectByName(String name) {
        return studentMapper.selectByName(name);
    }

    @Override
    public Page<Student> selectAll(int currPage) {

        Page page = new Page();
        //设置当前页码
        page.setCurrPage(currPage);
        //设置总记录数
        page.setTotalCount(studentMapper.selectCount());
        //设置每页显示数量
        int count = 10;
        page.setCount(count);
        //设置总页数
        page.getTotalPage();


        Map map = new HashMap<>();
        map.put("start",(currPage - 1) * count);
        map.put("count",count);
        List<Student> lists = studentMapper.selectAll(map);
        //将查询结果保存在page对象找中
        page.setList(lists);
        return page;
    }

    @Override
    public int selectCount() {
        return studentMapper.selectCount();
    }
}

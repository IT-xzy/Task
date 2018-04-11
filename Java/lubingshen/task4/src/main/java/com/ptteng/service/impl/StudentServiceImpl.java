package com.ptteng.service.impl;

import com.ptteng.exception.StudentException;
import com.ptteng.bean.PageBean;
import com.ptteng.dao.StudentDao;
import com.ptteng.bean.Student;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    //查询所有在学学员的数量
    public int countStudent(){
        return studentDao.selectCount();
    }

    public PageBean<Student> findByPage(int currentPage) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        PageBean<Student> pageBean = new PageBean<Student>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize = 10;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = studentDao.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        int page = 0;
        if (totalCount % pageSize == 0)
            page = totalCount / pageSize;
        else
            page = totalCount / pageSize + 1;
        pageBean.setTotalPage(page);

        map.put("start", (currentPage - 1) * pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<Student> lists = studentDao.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

    //插入一个学员信息
    public long addAStudent(Student student) throws Exception {
        try {
            student.setCreateAt(System.currentTimeMillis());
            if(!studentDao.insertStudent(student))
                throw new StudentException("未知原因，插入信息失败！");
        } catch (DuplicateKeyException e) {
            //处理插入时重复学号引发的异常
            throw new StudentException("插入失败！该学号已经存在！");
        }
        return student.getId();
    }

    //删除一个学员信息
    public boolean deleteAStudent(Long primeKey) throws Exception {
        return studentDao.deleteStudent(primeKey);
    }

    //通过主键来查询一个学员
    public Student findByPrimeKey(Long primekey) throws Exception {
        return studentDao.findById(primekey);
    }

    //通过姓名模糊查询
    public List<Student> findStudentsByName(String name) throws Exception {
        return studentDao.findByName(name);
    }

    //通过学号精确查找
    public Student findAStudentByNum(String online_num) throws Exception {
        return studentDao.findByNum(online_num);
    }

    //更新信息
    public boolean updateInformation(Student student) throws Exception {
        student.setUpdateAt(System.currentTimeMillis());
        try {
            if(!studentDao.updateStudent(student))
                throw new StudentException("未知原因，更新信息失败！");
        } catch (DuplicateKeyException e) {
            //处理插入时重复学号引发的异常
            throw new StudentException("更新失败！该学号已经存在！");
        }
        return true;
    }
}


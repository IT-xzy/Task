package com.jnshu.service.Impl;
import com.jnshu.Utils.XMemcachedUtil;
import com.jnshu.dao.StudentDao;
import com.jnshu.model.Student;
import com.jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Resource
    private XMemcachedUtil xMemcachedUtil;
    private Logger logger = Logger.getLogger(StudentServiceImpl.class);

    @Override
    public List<Student> studentList() {
        List<Student> studentList = (List<Student>) xMemcachedUtil.getCache("studentList");
        if (null == studentList) {
            //todo List<Student> userList = 从数据库取
            studentList = studentDao.selectAll();
            xMemcachedUtil.addCache("studentList", 60 * 60, studentList);
        }
        //todo 业务逻辑
        return studentList;
    }
}

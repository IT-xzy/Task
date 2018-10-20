package com.lihoo.jnshu.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lihoo.jnshu.admin.domain.StudentList;
import com.lihoo.jnshu.admin.dao.StudentListMapper;
import com.lihoo.jnshu.admin.service.IStudentListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.lihoo.jnshu.common.util.encrypt.MD5Utils.getPwdHash;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihoo
 * @since 2018-09-28
 */
@Service
public class StudentListServiceImpl extends ServiceImpl<StudentListMapper, StudentList> implements IStudentListService {

    @Autowired
    StudentListMapper studentListMapper;

    @Override
    public Long updateLoginTimeById(StudentList studentList) {
        return studentListMapper.updateLoginTimeById(studentList);
    }

    @Override
    public Boolean verifyPwd(StudentList student) {
        QueryWrapper<StudentList> slqw = new QueryWrapper<>();
        slqw.eq("username", student.getUsername());
        StudentList stu = studentListMapper.selectOne(slqw);
        System.out.println(stu);
        String salt = stu.getSalt();
        String loginPwdHash = getPwdHash(student.getPwd(), salt);
        return stu.getPwd().equals(loginPwdHash);
    }
}

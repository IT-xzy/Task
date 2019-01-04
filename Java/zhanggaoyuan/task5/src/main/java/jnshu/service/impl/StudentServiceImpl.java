package jnshu.service.impl;

import jnshu.dao.ExcellentStudentMapper;
import jnshu.dao.RestUserMapper;
import jnshu.model.ExcellentStudent;
import jnshu.model.RestUser;
import jnshu.service.StudentService;
import jnshu.tool.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    ExcellentStudentMapper studentMapper;
    @Autowired
    RestUserMapper userMapper;

    @Override
    public int insertStudent(ExcellentStudent record) {
        return studentMapper.insert (record);
    }

    @Override
    public List<ExcellentStudent> selectStudent() {
        return studentMapper.selectStudent ();
    }

    @Override
    public int insertUser(RestUser record) {
        return userMapper.insert (record);
    }

    @Override
    public RestUser selectUserByName(String name) {
        return userMapper.selectByName (name);
    }

//    判断登录角色是否存在，密码是否正确
    @Override
    public Boolean exists(String name,String pwd) {
        RestUser rs= userMapper.selectByName (name);
        if (rs==null){return false;}//判断角色是否存在，空则返回false
        if (MD5.verify (rs.getPwd (), pwd, rs.getSalt ())) { return true;}//判断密码是否正确，正确则返回true
        return false;
    }

//    根据id查询盐
    @Override
    public String selectSalt(Long id) {
        return userMapper.selectSalt (id);
    }
}

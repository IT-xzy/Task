package com.service;

import com.DAO.GreatStudentMapper;
import com.POJO.Cooperation;
import com.POJO.GreatStudent;
import com.POJO.HowToStudy;
import com.POJO.Profession;
import com.POJO.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author: 曹樾
 * @program: task4
 * @description: 优秀学员实现类
 * @create: 2018/4/24 下午4:02
 */

@Service("GreatStudentService")
public class GreatStudentServiceImpl implements GreatStudentService{
    @Autowired
    private GreatStudentMapper greatStudentMapper;
    
  
    public List<GreatStudent> findUserByName() throws IOException {
        return greatStudentMapper.findUserByName();
    }
    public List<Cooperation> findCooperation() throws IOException {
        return greatStudentMapper.findCooperation();
    }
    public List<HowToStudy> findStudy() throws IOException {
        return greatStudentMapper.findStudy();
    }
    
    public List<Profession> findFront() throws IOException {
        return greatStudentMapper.findFront();
    }
    
    public List<Profession> findAfter() throws IOException {
        return greatStudentMapper.findAfter();
    }

    public List<Profession> findOP() throws IOException {
        return greatStudentMapper.findOP();
    }

    public List<Profession> findPM() throws IOException {
        return greatStudentMapper.findPM();
    }
    
    public List<Company> findCompany() throws IOException {
        return greatStudentMapper.findCompany();
    }
}

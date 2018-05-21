package com.student.service;

import com.aliyun.oss.model.ObjectListing;
import com.student.dao.StudentDao;
import com.student.model.Student;
import com.student.util.DesUtil;
import com.student.util.OSSUtil;
import com.student.util.QiNiuUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "studentServiceIpl")
public class StudentServiceIpl implements StudentService {

    @Resource
    private StudentDao studentDao;



    public int deleteByPrimaryKey(Long id) {
        return studentDao.deleteByPrimaryKey(id);
    }

    public int insert(Student student) {
        return studentDao.insert(student);
    }

    public int insertSelective(Student record) {
        return studentDao.insertSelective(record);
    }

    public Student selectByPrimaryKey(Long id) {
        return studentDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Student record) {
        return studentDao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Student student) {
        return studentDao.updateByPrimaryKey(student);
    }

    public List<Student> getAll() {
        return studentDao.getAll();
    }

    public List<Student> randomSelectStudent() {
        return studentDao.randomSelectStudent();
    }

    public Long selectIdByName(String name) {
        return studentDao.selectIdByName(name);
    }

    public Student selectByName(String name) {
        return studentDao.selectByName(name);
    }

    @Override
    public Long getIdByTokey(String token) throws Exception {
        DesUtil desUtil = new DesUtil();
        String s= desUtil.decrypt(token);
        String[] idAndTime = s.split(",");
        Long id = Long.valueOf(idAndTime[0]);
        return id;
    }

    public String getTokenByName(String account) throws Exception {
        Long longId = studentDao.selectIdByName(account);
        Long longTime = System.currentTimeMillis();
        String s = longId + "," + longTime;
        DesUtil des = new DesUtil();
        String token = des.encrypt(s);
        return token;

    }


    public void OSSToQiNiuYun() {

        //获取阿里云存储文件列表
//        ObjectListing objectList= OSSUtil.getObjectList();



    }




//    public Long smsVerification(String cellphone) {
//
//    }

}


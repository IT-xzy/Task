package com.service;

import com.DAO.LoginMapper;
import com.POJO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("studentService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    private String name;
    public Student findUserById(Long ID) throws IOException {
        return loginMapper.findUserById(ID);
    }

  /*  public List<Student> findUserByName(HashMap<String, Object> map) throws IOException {
        return null;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int insertUser(Student student) throws Exception {
        return loginMapper.insertUser(student);
    }

    public int deleteUser(int id) throws Exception {
        return loginMapper.deleteUser(id);
    }

    public int updateUser(Student student) throws Exception {
        return loginMapper.updateUser(student);
    }

    public int selectCount2(String name) {
        return loginMapper.selectCount2(name);
    }

    //task-4
    public List<GoodStudent> findGood(){
        return loginMapper.findGood();
    }
    public int selectCount() {
        return loginMapper.selectCount();
    }
    public int selectCountGraduate(){
        return loginMapper.selectCountGraduate();
    }

    public List<Images1> findImgaes1() {
        return loginMapper.findImgaes1();
    }

    public List<JobList> findJobList1() {
        return loginMapper.findJobList1();
    }

    public SignIn clientLogin(String account) {
        return loginMapper.clientLogin(account);
    }
    public int register(SignIn signIn){
        return loginMapper.register(signIn);
    }

}

package com.jnshu.service;

import com.jnshu.entity.profession;
import com.jnshu.entity.student;
/*import com.jnshu.entity.user;*/
import com.jnshu.entity.user;
import com.jnshu.mapper.StudentDao;
/*import com.jnshu.mapper.Userdao;*/
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentdao;
/*    @Autowired
    private Userdao userdao;*/

    @Override
    public List<student> findAll(){
        return studentdao.findAll();
    }

    @Override
    public List<profession> findAlls(){
        return studentdao.findAlls();
    }

    @Override
    public int findName(){
        return studentdao.findName();
    }
    @Override
    public profession addlist(profession profession){
        return studentdao.addlist(profession);
    }











    //登录和注册
    @Override
    public user login(String name){
        System.out.println("-----------------");
        return studentdao.login(name);
    }
    @Override
    public void register(user user){
        studentdao.register(user);
    }

    @Override
    public Boolean findUserByid(Integer id){
        return studentdao.findUserByid(id);
    }

    @Override
    public boolean AuUser(user user) {
        return studentdao.AuUser(user);
    }

    @Override
    public user findUserByname(String name){
        return studentdao.findUserByname(name);
    }

    /*
    @Override
    public void regist(user user){
        studentdao.addUser(user);
    }

    @Override
    public void login(String name,String password){
        studentdao.findUserByNameAndPwd(name,password);
    }*/

/*    //user
    @Override
    public boolean findUser(user user){
        return studentdao.findUser(user);
    }*/




/*
    //账户查找
    @Override
    public boolean userAll(user user){
        return userdao.userAll(user);
    }
    //账户姓名
    @Override
    public user findUserbyName(String name){
        return userdao.findUserbyName(name);
    }
    //账户id
    @Override
    public boolean findUserById(int id){
        return userdao.findUserByid(id);
    }

    public user getuserCountByNameAndPassword(user user){
        return userdao.getgetuserCountByNameAndPassword(user);
    }
*/


/*    @Override
    public List<student> queryName(String student) {
        return studentdao.findStudentByName(student);
    }

    @Override
    public boolean addUser(student student) {
        return studentdao.addStudent(student);
    }

    @Override
    public student queryId(int id) {
        return studentdao.findStudentById(id);
    }

    @Override
    public boolean deleteUser(int id) {
        return studentdao.deleteStuent(id);
    }

    @Override
    public boolean updateUser(student student) {
        return studentdao.updateStuent(student);
    }


    @Override
    public boolean updateId(int id, student student) {
        student.setId(id);
        return studentdao.updateStuent(student);
    }

    @Override
    public List<student> queryUser(student student) {
        return studentdao.findStudent(student);
    }*/
}

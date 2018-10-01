package com.service;

import com.DAO.StudentMapper;
import com.POJO.GoodStudent;
import com.POJO.Images1;
import com.POJO.JobList;
import com.POJO.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    private String name;
    public Student findUserById(Long ID) throws IOException {
        return studentMapper.findUserById(ID);
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
        return studentMapper.insertUser(student);
    }

    public int deleteUser(int id) throws Exception {
        return studentMapper.deleteUser(id);
    }

    public int updateUser(Student student) throws Exception {
        return studentMapper.updateUser(student);
    }

    public int selectCount2(String name) {
        return studentMapper.selectCount2(name);
    }

    //task-4
    public List<GoodStudent> findGood(){
        return studentMapper.findGood();
    }
    public int selectCount() {
        return studentMapper.selectCount();
    }
    public int selectCountGraduate(){
        return studentMapper.selectCountGraduate();
    }

    public List<Images1> findImgaes1() {
        return studentMapper.findImgaes1();
    }

    public List<JobList> findJobList1() {
        return studentMapper.findJobList1();
    }

}

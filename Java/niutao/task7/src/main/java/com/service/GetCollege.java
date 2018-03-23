package com.service;

import com.mapper.StudentMapper;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//从数据库查询优秀学员。
@Service
public class GetCollege {
    @Autowired
    StudentMapper studentMapper;

    public Map<Integer, String> GetCollegeMap(){
        List<Student> college = studentMapper.selectCollege();
        Map<Integer, String> studentName = new HashMap<Integer, String>();
        for(int i = 0;i<college.size();i++) {
            studentName.put(i, college.get(i).getName());
        }
        return studentName;
}

    public List<Student> GetCollegeList(){
        List<Student> college = studentMapper.selectCollege();
        return college;
    }

    public Map<String, String> GetCollegeStringMap(){
        List<Student> college = studentMapper.selectCollege();
        Map<String, String> studentName = new HashMap<String, String>();
        for(int i = 0;i<college.size();i++) {
            studentName.put(""+i+"", college.get(i).getName());
        }
        return studentName;
    }

}

package com.service;

import com.mapper.StudentMapper;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetCollegeStringMap {
    @Autowired
    StudentMapper studentMapper;

    public Map<String, String> GetCollegeMap(){
        List<Student> college = studentMapper.selectCollege();
        Map<String, String> studentName = new HashMap<String, String>();
        for(int i = 0;i<college.size();i++) {
            studentName.put(""+i+"", college.get(i).getName());
        }
        return studentName;
    }

}

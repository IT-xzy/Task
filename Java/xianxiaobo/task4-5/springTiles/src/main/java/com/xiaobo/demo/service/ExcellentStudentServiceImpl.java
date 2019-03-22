package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.ExcellentStudentMapper;
import com.xiaobo.demo.pojo.ExcellentStudent;
import com.xiaobo.demo.pojo.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExcellentStudentServiceImpl implements ExcellentStudentService {
    @Autowired
    private ExcellentStudentMapper excellentStudentMapper;
    @Override
    public ExcellentStudent get(Integer id){
        return excellentStudentMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<ExcellentStudent> selectBySalary(ExcellentStudent excellentStudent,Map<String,Object> pageData){
        return excellentStudentMapper.selectBySalary(excellentStudent,pageData);
    }
    @Override
    public Integer countData(ExcellentStudent excellentStudent){
        return excellentStudentMapper.countData(excellentStudent);
    }
    @Override
    public ArrayList createCountArrayList(List<Profession> professionList){
        ArrayList arrayList = new ArrayList();
        for(Profession professionItem:professionList){
            ExcellentStudent excellentStudent = new ExcellentStudent();
            excellentStudent.setProfessionName(professionItem.getProfessionName());
            excellentStudent.setStatus(ExcellentStudent.EXCELLENT_STUDENT_STATUS_STUDY);
            Integer count = excellentStudentMapper.countData(excellentStudent);
            arrayList.add(count);
        }
        return arrayList;
    }
}

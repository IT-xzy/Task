package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.ExcellentStudent;
import com.xiaobo.demo.pojo.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public interface ExcellentStudentService {
    public ExcellentStudent get(Integer id);
    public List<ExcellentStudent> selectBySalary(ExcellentStudent excellentStudent,Map<String,Object> pageData);
    public Integer countData(ExcellentStudent excellentStudent);
    public ArrayList createCountArrayList(List<Profession> professionList);
}

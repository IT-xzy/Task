package com.zyq.service.Impl;

import com.zyq.mapper.ExcellentStudentMapper;
import com.zyq.pojo.ExcellentStudent;
import com.zyq.service.ExcellentStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExcellentStudentImpl implements ExcellentStudentService {

    @Autowired
    ExcellentStudentMapper excellentStudentMapper;

    @Override
    public List<ExcellentStudent> selectByOrder() {
        Integer startNum = 0;
        Integer endNum = 16;
        List<ExcellentStudent> list = excellentStudentMapper.selectByOrder(startNum,endNum);
        return list;
    }

    @Override
    public List<ExcellentStudent> selectByOrder2() {
        Integer startNum = 12100;
        Integer endNum = 12116;
        List<ExcellentStudent> list = excellentStudentMapper.selectByOrder2(startNum,endNum);
        return list;
    }
}

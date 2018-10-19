package cn.wyq.service.impl;

import cn.wyq.mapper.OutstandingStudentMapper;
import cn.wyq.pojo.OutstandingStudent;
import cn.wyq.service.OutstandingStudentService;
import cn.wyq.util.PageForMain;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OutstandingStudentServiceImpl implements OutstandingStudentService {
    @Autowired
    OutstandingStudentMapper outstandingStudentMapper;

    @Override
    public List<OutstandingStudent> get(PageForMain page){
        return outstandingStudentMapper.get(page);
    }

    @Override
    public int total(){
        return outstandingStudentMapper.total();
    }
}

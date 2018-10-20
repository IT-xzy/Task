package com.jnshu.service;

import com.jnshu.entity.Workroom;
import com.jnshu.mapper.WorkroomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkroomService {
    @Autowired
    WorkroomDao workroomDao;
    public List select(Workroom workroom){ return  workroomDao.select(workroom);}
}

package com.ptteng.service;


import com.ptteng.dao.WorkroomDao;
import com.ptteng.entity.Workroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkroomService {

    @Autowired
    private WorkroomDao workroomDao;

    public List<Workroom> findWorkroom(String type) {
        return workroomDao.findWorkroom(type);
    }



    public Workroom findById(long id){
        return workroomDao.findById(id);
    }


    public Boolean deleteById(long id){
        return workroomDao.deleteById(id);
    }


    public Boolean updateWorkroom(Workroom workroom){
        return workroomDao.updateWorkroom(workroom);
    }

    public long insertWorkroom(Workroom workroom){
        return workroomDao.insertWorkroom(workroom);
    }





}

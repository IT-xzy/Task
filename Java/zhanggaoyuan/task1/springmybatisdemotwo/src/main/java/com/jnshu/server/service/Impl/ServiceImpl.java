package com.jnshu.server.service.Impl;

import com.jnshu.server.dao.daoImpl.DaoImpl;
import com.jnshu.server.po.Students;
import com.jnshu.server.service.BeanService;
import java.util.List;

public class ServiceImpl implements BeanService{
        DaoImpl daoImpl;
    public void setDaoImpl(DaoImpl daoImpl) {
        this.daoImpl = daoImpl;}

    @Override
    public long insertStudents(Students students) {
        return daoImpl.insertStudents (students);
    }
    @Override
    public boolean deleteStudents(long id) {
        if (daoImpl.deleteStudents (id)==1){return true;}
        else {return false;}
    }
    @Override
    public boolean updateStudents(Students students) {
        if (daoImpl.updateStudents (students)==1){return true;}
        else {return false;}
    }
    @Override
    public boolean updateOne(Students students) {
        if (daoImpl.updateOne (students)==1){return true;}
        else {return false;}
    }

    //    @Override
        public Students selectStudents(long id) {
            return daoImpl.selectStudents (id);
        }

    @Override
    public List selectIf(Students students) {
        return daoImpl.selectIf (students);
    }

    @Override
    public long batchInsert(Students[] students) {
        return daoImpl.insertBatch (students);
    }
}
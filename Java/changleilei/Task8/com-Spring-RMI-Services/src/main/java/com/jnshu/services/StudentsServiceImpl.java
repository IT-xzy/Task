package com.jnshu.services;
import com.jnshu.dao.StudentsDao;
import com.jnshu.model.Students;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.rmi.RemoteException;
import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {
    @Resource
    private StudentsDao studentsDao;

    public StudentsServiceImpl() throws RemoteException {
    }

    @Override
    public int deleteById(Integer id) throws RemoteException {
        return studentsDao.deleteById(id);
        //studentsDao.deleteById(id);
    }

    @Override
    public int insert(Students record) throws RemoteException {
        return studentsDao.insert(record);
    }

    @Override
    public int insertSelective(Students record) throws RemoteException {
        return studentsDao.insertSelective(record);
    }

    @Override
    public Students selectById(Integer id) throws RemoteException {
        return studentsDao.selectById(id);
    }

    @Override
    public int updateByIdSelective(Students record) throws RemoteException {
        return studentsDao.updateByIdSelective(record);
    }

    @Override
    public int updateById(Students record) throws RemoteException {
        return studentsDao.updateById(record);
    }

    @Override
    public List<Students> selectAll() throws RemoteException {
        return studentsDao.selectAll();
    }
}

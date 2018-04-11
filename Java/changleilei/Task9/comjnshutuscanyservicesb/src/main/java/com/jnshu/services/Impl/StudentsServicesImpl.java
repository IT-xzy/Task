package com.jnshu.services.Impl;
import com.jnshu.dao.StudentsDao;
import com.jnshu.model.Students;
import com.jnshu.services.StudentsServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentsServicesImpl implements StudentsServices {
    @Resource
    private StudentsDao studentsDao;

    public int deleteById(Long id) {
        return studentsDao.deleteById(id);
    }

    public int insert(Students record) {
        return studentsDao.insert(record);
    }

    public int insertSelective(Students record) {
        return studentsDao.insertSelective(record);
    }

    public Students selectById(Long id) {
        return studentsDao.selectById(id);
    }

    public int updateByIdSelective(Students record) {
        return studentsDao.updateByIdSelective(record);
    }

    public int updateById(Students record) {
        return studentsDao.updateById(record);
    }

    public List<Students> selectAll() {
        return studentsDao.selectAll();
    }

    public int updateByName(Students students) {
        return studentsDao.updateByName(students);
    }
}

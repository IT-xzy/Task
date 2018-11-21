package com.jnshu.serviceimpl;

import com.danga.MemCached.MemCachedClient;
import com.jnshu.entity.Student4;
import com.jnshu.mapper.Student4Mapper;
import com.jnshu.service.Student4Service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("MemcacheImpl")
public class Student4MemcacheServiceImpl implements Student4Service {

    Logger logger = Logger.getLogger(Student4MemcacheServiceImpl.class);
    @Autowired
    Student4Mapper student4Mapper;
    @Autowired
    MemCachedClient memCachedClient;

    @Override
    public long CountSelective(String job, boolean state) {
        return 0;
    }

    @Override
    public long SelectCountByState(boolean state) {
        return 0;
    }

    @Override
    public List<Student4> getOrderByKeyWords(Student4 student4) {
        return null;
    }

    @Override
    public List<Student4> findAll() {
        return null;
    }

    @Override
    public Student4 findStudent4ById(Long id) {
        logger.info("findStudent4ById:"+id);
        String key = String.valueOf(id);
        Student4 student4 = (Student4) memCachedClient.get("student4"+key);
        if(student4 !=null ){
            logger.info("缓存中有："+id);
            return student4;
        }else{
            logger.info("缓存中没有 ==="+ student4Mapper.findById(id));
            student4 = student4Mapper.findById(id);
           boolean success = memCachedClient.set("student4"+key, student4);
           if(success){
               return student4;
           }else {
               //设置失败
                return null;
           }
        }
    }

    @Override
    public Boolean batchSave(List<Student4> student4List) {
        return null;
    }

    @Override
    public long addStudent4(Student4 student4) {
        return 0;
    }

    @Override
    public int updateStudent4(Student4 student4) {
        return 0;
    }

    @Override
    public int deleteStudent4(Student4 student4) {
        return 0;
    }

    @Override
    public List<Student4> getStudent4ByPage(int pageIndex, int pageSize) {
        return null;
    }
}

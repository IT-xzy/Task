package com.jnshu.serviceimpl;

import com.jnshu.entity.Student4;
import com.jnshu.mapper.Student4Mapper;
import com.jnshu.myutils.MemCacheUtil;
import com.jnshu.service.Student4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;


@Service("Memcache")
public class MemcacheStudent4SeriviceImpl implements Student4Service {

    Logger logger = Logger.getLogger(MemcacheStudent4SeriviceImpl.class.getName());

    @Autowired
    Student4Mapper student4Mapper;
    @Autowired
    MemCacheUtil memCacheUtil;


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
        return student4Mapper.selectAll();
    }

    @Override
    public Student4 findStudent4ById(Long id) {
       logger.info("findStudent4ById:"+id);
        String key1 = String.valueOf(id);

        Student4 student4 =  memCacheUtil.get("student4"+key1,Student4.class);
        if(student4 !=null ){
           logger.info("缓存中有："+student4);
            return student4;
        }else{
           //logger.info("Memcache Service else ==="+ student4Mapper.findById(id));
            student4 = student4Mapper.findById(id);
            memCacheUtil.set("student4"+key1, student4);
            return student4;
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

package com.jnshu.serviceimpl;

import com.jnshu.entity.Student4;
import com.jnshu.mapper.Student4Mapper;
import com.jnshu.service.Student4Service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RedisImpl")
public class Student4RedisServiceImpl implements Student4Service {

    static final int FAILED = -1;
    static final int SUCCESS = 1;
    Logger logger = Logger.getLogger(Student4RedisServiceImpl.class);
    @Autowired
    Student4Mapper student4Mapper;
    @Autowired
    RedisTemplate redisTemplate;
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
    @SuppressWarnings("unchecked")
    public Student4 findStudent4ById(Long id) {
        logger.info("findStudent4ById:"+id);
        String key = String.valueOf(id);
        Student4 student4 = (Student4) redisTemplate.opsForValue().get("student4"+key);
        if(student4 !=null ){
            logger.info("缓存中有："+id);
            return student4;
        }else{
            logger.info("缓存中没有 ==="+ student4Mapper.findById(id));
            student4 = student4Mapper.findById(id);
            boolean flag = false;
            try{
                redisTemplate.opsForValue().set("student4"+key, student4);
                flag = true;
            }catch(RuntimeException e){
                e.printStackTrace();
            }
            if(flag){
                //添加成功
               return student4;
            }else{
                //添加失败
                return null;
            }
        }
    }

    @Override
    public Boolean batchSave(List<Student4> student4List) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public long addStudent4(Student4 student4) {
        logger.info("addStudent4"+student4);
        //插入时返回
        int row = student4Mapper.insertSelective(student4);
        if(row!=0){
            String key =String.valueOf(row);
            boolean flag = false;
            try{
                redisTemplate.opsForValue().set("student4"+key, student4);
                flag = true;
            }catch(RuntimeException e){
                e.printStackTrace();
                logger.info("set redis error"+e);
            }
            if(flag){
                //添加成功
                return row;
            }else{
                //添加失败
                return FAILED;
            }
        }else{
            return FAILED;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public int updateStudent4(Student4 student4) {
        logger.info("updateStudent4"+student4);
        int row = student4Mapper.updateByPrimaryKey(student4);
        if(row!=0){
            String key =String.valueOf(student4.getId());
            boolean flag = false;
            try{
                redisTemplate.opsForValue().set("student4"+key, student4);
                flag = true;
            }catch(RuntimeException e){
                e.printStackTrace();
            }
            if(flag){
                //添加成功
                return SUCCESS;
            }else{
                //添加失败
                return FAILED;
            }
        }else{
            return FAILED;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public int deleteStudent4(Student4 student4) {
        logger.info("deleteStudent4"+student4);
        String key =String.valueOf(student4.getId());
        int row = student4Mapper.delete(student4);
        if(row!=0){
            boolean flag = false;
            try{
                redisTemplate.delete("student4"+key);
                flag = true;
            }catch(RuntimeException e){
                logger.info("delete redis failed"+e);
                e.printStackTrace();
            }
            if(flag){
                //成功
                return SUCCESS;
            }else{
                //失败
                return FAILED;
            }
        }else{
            return FAILED;
        }
    }

    @Override
    public List<Student4> getStudent4ByPage(int pageIndex, int pageSize) {
        return null;
    }
}

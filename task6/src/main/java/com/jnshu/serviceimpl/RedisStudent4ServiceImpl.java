package com.jnshu.serviceimpl;

import com.jnshu.entity.Student4;
import com.jnshu.mapper.Student4Mapper;
import com.jnshu.myutils.Page;
import com.jnshu.myutils.RedisCache;
import com.jnshu.service.Student4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@Service("Redis")
public class RedisStudent4ServiceImpl implements Student4Service {
    Logger logger = Logger.getLogger(RedisStudent4ServiceImpl.class.getName());
    @Autowired
    Student4Mapper student4Mapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisCache redisCache;
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
    public Boolean batchSave(List<Student4> student4List) {
        return null;
    }

    @Override
    public Student4 findStudent4ById(Long id) {
        Student4 student4 = redisCache.getCache("student4"+id,Student4.class);
        if(student4 !=null ){
            logger.info("findStudent4ById==="+id);
        }else{
            student4 = student4Mapper.findById(id);
            redisCache.putCacheWithExpireTime("student4"+id,student4,(new Random().nextInt(10000)));
        }
        return student4;
    }

    @Override
    public long addStudent4(Student4 student4) {
        student4Mapper.insertSelective(student4);
        redisCache.putCacheWithExpireTime("student4"+student4.getId(), student4,(new Random().nextInt(10000)));
        return student4.getId();
    }
    @Override
    public int updateStudent4(Student4 student4) {
        redisCache.putCacheWithExpireTime("student4"+student4.getId(), student4,(new Random().nextInt(10000)));
        return student4Mapper.updateByPrimaryKeySelective(student4);
    }

    @Override
    public int deleteStudent4(Student4 student4) {
        return 0;
    }

    @Override
    public List<Student4> getStudent4ByPage(int pageIndex,int pageSize ) {
        Page page = new Page();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        List<Student4> student4List = ( List<Student4>)redisTemplate.opsForValue().get("student4"+page.getStartRow());
        if(student4List !=null ){
            System.out.println("getStudent4ByPage==="+page.getStartRow());
        }else{
            //System.out.println(page.getStartRow());
           // System.out.println(student4Mapper.getStudent4ByPage(1,10));
//            student4List = student4Mapper.getStudent4ByPage(page.getStartRow(),page.getEndRow());
            redisTemplate.opsForValue().set("student4"+page.getStartRow(),student4List);
        }
        return student4List;
    }
}

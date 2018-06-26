package com.fangyuyang.service.serviceImpl;

import com.fangyuyang.Dao.StudentDao;
import com.fangyuyang.memcache.MemcachedUtil;
import com.fangyuyang.model.Student;
import com.fangyuyang.service.StudentServcie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentServcie {
    @Autowired
    private StudentDao studentDao;
    @Resource
    private MemcachedUtil memcachedUtil;
    public void addStudent(Student student){
        studentDao.add(student);
    }
   public void updateStudent(Student student){
        studentDao.update(student);
    }
   public void deleteStudent(int id){
         studentDao.delete(id);
   }

   public Student findStudentById(int id){
        return studentDao.get(id);
   }

   public List<Student> findAll(){
        return studentDao.list();
   }
    public Object memCacheGet(String key){
        Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
        Object result = null;
        result =memcachedUtil.get(key);
        if(result!=null){
            //                logger.info("输出，{}",memcachedUtil.get(key));
//            }
//            if (memcachedUtil.cas(key, 36000, memcachedUtil.get(key))) {
            result = memcachedUtil.get(key);
            logger.info("缓存输出");
        } else {
            logger.info("需要调用数据库");
            result = studentDao.get(Integer.parseInt(key));
            memcachedUtil.set(key,result,3600);
            logger.info("输入后再取出,{}", result);
        }
        return result;

    }
}

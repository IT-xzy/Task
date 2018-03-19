package com.student.service;

import com.student.dao.StudentDao;
import com.student.model.Student;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service(value = "studentServiceIpl")
public class StudentServiceIpl implements StudentService {

    private  Logger logger = LoggerFactory.getLogger(StudentServiceIpl.class);

    @Resource
    private MemcachedClient memcachedClient;

    @Resource
    private StudentDao studentDao;

    public int deleteByPrimaryKey(Long id){
        return studentDao.deleteByPrimaryKey(id);
    }

    public int insert(Student student){
        return studentDao.insert(student);
    }

    public int insertSelective(Student record){
        return studentDao.insertSelective(record);
    }

    public Student selectByPrimaryKey(Long id){
        return studentDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Student record){
        return studentDao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Student student){
        return studentDao.updateByPrimaryKey(student);
    }

    public List<Student> getAll(){
        return studentDao.getAll();
    }

    public List<Student> useMemcacheGetStudentList()  {

        try {
            logger.error(memcachedClient.get("studentList")+"");
            if (null!= memcachedClient.get("studentList") ) {
                logger.info("直接从缓存拿的数据");
                return memcachedClient.get("studentList");

            } else {
                List<Student> studentList=studentDao.getAll();
                memcachedClient.set("studentList",3600000,studentList);
                logger.info("从数据库拿的数据");
                return studentList;
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        logger.info("不存在这种的");
        return null;
    }


}

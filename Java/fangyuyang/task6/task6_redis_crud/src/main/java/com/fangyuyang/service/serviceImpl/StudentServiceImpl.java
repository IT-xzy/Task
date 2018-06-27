package com.fangyuyang.service.serviceImpl;

import com.fangyuyang.Dao.StudentDao;
import com.fangyuyang.model.Student;
import com.fangyuyang.redis.RedisUtil;
import com.fangyuyang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Resource
    private RedisUtil redisUtil;
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
    public Object redisGet(String key){
        Object user = null;
         user = redisUtil.get(key);
            if(user== null){
                user = studentDao.get(Integer.parseInt(key));
                redisUtil.set(key,user);
            }
        return user;
        }

}

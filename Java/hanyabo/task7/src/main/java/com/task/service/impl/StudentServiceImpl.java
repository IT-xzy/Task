package com.task.service.impl;


import com.task.dao.StudentDao;
import com.task.entity.Student;
import com.task.service.StudentService;
import com.task.util.StudentPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    StudentDao studentDao;

//    @Autowired
//    RedisUtil redisUtil;
//    MemcachedClient memcachedClient;


    @Override
    public List<Student> findById(int id) {

        List<Student> students = studentDao.findById(id);
        if(students != null){

            return students;
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> students = studentDao.findByName(name);
        if(students != null){

            return students;
        }
        return null;
    }

    @Override
    public List<Student> findByNumber(int number) {

        List<Student> students = studentDao.findByNumber(number);
        if(students != null){

            return students;
        }
        return null;
    }

    @Override
    public void delete(Student student){
        studentDao.delete(student.getId());
    }

    @Override
    public List<Student> findByPage(StudentPage studentpage) {

        List<Student> students = null;

//        try {
//            String numStr = "Start";
//            numStr += studentpage.getStart();
//
//            students = memcachedClient.get(numStr);
//            students = (List<Student>)redisUtil.get(numStr);
//            if(null == students){
//
                students = studentDao.findByPage(studentpage);
//
//                memcachedClient.set(numStr,36000, students);
//                redisUtil.set(numStr, students,36000);
//            }
//            else{
//                logger.info("students1"+students);
//            }
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (MemcachedException e) {
//            e.printStackTrace();
//        }

        return students;
    }

    @Override
    public int total() {

//        String total = null;
        int realTotal = 0;
//        try {
//            String numStr = "Total";
//
//            total = memcachedClient.get(numStr);
//            total = (String) redisUtil.get(numStr);
//            if(null == total){
                realTotal = studentDao.total();

//                total = String.valueOf(realTotal);

//                memcachedClient.set(numStr,360000, total);
//                redisUtil.set(numStr, total,360000);
//            }
//            else{
//                realTotal = Integer.valueOf(total).intValue();
//                logger.info("total:"+realTotal);
//            }
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (MemcachedException e) {
//            e.printStackTrace();
//        }

        return realTotal;
    }
}

package com.tasktwo.service;

import com.tasktwo.controller.HomeController;
import com.tasktwo.dao.StudentMapper;
import com.tasktwo.model.Student;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 对student进行CRUD的服务层接口的实现
 * Created by Administrator on 25/7/2017.
 */

@Service("userService")
public class StudentServiceImpl implements StudentService{
    private static Logger loggerSSI = Logger.getLogger(StudentServiceImpl.class);
    @Resource
    private StudentMapper studyDao;
    public Student getUserId(String userId){
//        取得数据库连接前时间
//        long begin = System.currentTimeMillis();
        Student study =  this.studyDao.studySelect(userId);
//        取得数据库连接后时间
//        long end = System.currentTimeMillis();
//        sqlTime为数据库响应时间
//        int sqlTime = (int)(begin - end);
//        loggerSSI.info("查询单个学员数据库响应时间： "+ sqlTime);
        return study;
    }
    public int studyInsert(Student study){
        //当userId为不为空时，用户信息已经存在，不需要添加
        if(getUserId(study.getUserId())!=null) {
            return -1;
        }
        else {
            study.setentryData(System.currentTimeMillis());
            study.setCreateAt(System.currentTimeMillis());
            study.setUpdateAt(System.currentTimeMillis());
//            取得数据库响应时间
//            long begin = System.currentTimeMillis();
//            返回数据库的影响行数
            int i = this.studyDao.studyInsert(study);
//            long end = System.currentTimeMillis();
//            int sqlTime = (int) (begin - end);
//            loggerSSI.info("插入学员数据库响应时间： " + sqlTime);
            return i;
        }
    }
    public int studyUpdate(Student study){
        //当userId为为空时，用户信息不存在，不能进行修改操作
        //前面的getUserId是查询学生信息的方法
        if(getUserId(study.getUserId()) == null) {
            return -1;
        }
        else {
            Student user = new Student();
            user = getUserId(study.getUserId());
            user.setName(study.getName());
            //将数据库中的update_at改为当前时间
            user.setUpdateAt(System.currentTimeMillis());
//            取得数据库响应时间
//            long begin = System.currentTimeMillis();
//            返回数据库的影响行数
            int i = this.studyDao.studyUpdate(user);
//            long end = System.currentTimeMillis();
//            int sqlTime = (int) (begin - end);
//            loggerSSI.info("修改学员数据库响应时间： " + sqlTime);
            return i;
        }
    }
    public int studyDelete(String userId){
//        取得数据库响应时间
//        long begin = System.currentTimeMillis();
//        返回数据库的影响行数
        int i =  this.studyDao.studyDelete(userId);
//        long end = System.currentTimeMillis();
//        int sqlTime = (int)(begin - end);
//        loggerSSI.info("删除学员数据库响应时间： "+ sqlTime);
        return i;
    }
    public List<Student> studentAll(){
//        取得数据库响应时间
//        long begin = System.currentTimeMillis();
        List<Student> study = this.studyDao.studentAll();
//        long end = System.currentTimeMillis();
//        int sqlTime = (int)(begin - end);
//        loggerSSI.info("查询所有学员数据库响应时间： "+ sqlTime);
        return study;
    }
}

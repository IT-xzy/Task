package com.service.impl;

import com.Dao.StudentDao;
import com.memcached.Cached;
import com.memcached.MemcacheUtils;
import com.model.Login;
import com.model.Student;
import com.model.StudentCustom;
import com.model.zhiwei;
import com.service.StudentService;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
private static Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    //任务四
    @Override
    public List<Student> findAll(int id) {
        Object object = MemcacheUtils.get("All");
        //对象转 Json数组
        JSONArray array = JSONArray.fromObject(object);
        //数组转为List
        List<Student> list = (List<Student>) JSONArray.toList(JSONArray.fromObject(array), Student.class);
        if(object != null){
            log.info("加载的缓存里的数据  " + list);
            return list;
        }
       List<Student> students =  studentDao.findAll(id);
        MemcacheUtils.add("All",students,new Date(60*60*24));
        log.info("写入缓存成功 加载的数据库  数据" + students);
        return students;

    }
//页面二
    @Override
    public List<zhiwei> findAlls() {
        Object object = MemcacheUtils.get("Alls");
        JSONArray array = JSONArray.fromObject(object);
        //字符串转为List
        log.info("数组 ----------"      + array);
        List<zhiwei> list = (List<zhiwei>) JSONArray.toList(JSONArray.fromObject(array), zhiwei.class);
        if(object != null){
            log.info("加载的缓存里的数据  " + list);
            return list;
        }
        List<zhiwei> students =  studentDao.findAlls();
        MemcacheUtils.add("Alls",students,new Date(60*60*24));
        log.info("写入缓存成功 加载的数据库  数据" + students);
        return students;
    }

    @Override
    public int findName() {
        return studentDao.findName();
    }

    @Override
    public zhiwei addlist(zhiwei zhi) {
        return studentDao.addlist(zhi);
    }

    //任务五
    @Override
    public Login login(String username) {
        log.info("输出----------远程调用成功了----------"+ username);
        log.info("studentDao.login(username) + " + studentDao.login(username).toString());
       return studentDao.login(username);
    }

    @Override
    public void findTime(Login login) {
        studentDao.findTime(login);
    }


    // 任务六
    @Override
    public Cached findUserById(int id) {
        // 查找缓存
        Object object = MemcacheUtils.get("user" + id);
        // 当存在缓存时直接返回缓存数据
        if (object != null) {
            return (Cached) object;
        }
        Cached cache = studentDao.findUserById(id);

        // 当缓存为空时 添加 memcached 缓存
        MemcacheUtils.set("user" + id, cache, new Date(30000 * 60));
        return cache;
    }

    @Override
    public List<Cached> findAllId() {
        Object object = MemcacheUtils.get("user");
        // 对象转为字符串
        JSONArray array = JSONArray.fromObject(object);
        //字符串转为List
        List<Cached> list2 = (List<Cached>) JSONArray.toList(JSONArray.fromObject(array), Cached.class);
        if (object != null) {
            return list2;
        }
        List<Cached> cached = studentDao.findAllId();
        MemcacheUtils.add("user", cached, new Date(30000 * 60));
        return cached;
    }

    @Override
    public void updateById(Cached cached) {
        studentDao.updateById(cached);
    }

    // 任务七
    @Override
    public void addStudent(Student student){studentDao.addStudent(student);}

@Override
    public Login findstudentID(int studentID){return studentDao.findstudentID(studentID);}

    //邮件发送

    @Override
    public void insertdata(Login login){
        studentDao.insertData(login);
    }

    @Override
    public Login findemail(String email){return studentDao.findemail(email);}
    @Override
    public void updateState(Login login){studentDao.updateState(login);}
    @Override
    public void  deleteEmail(String email){studentDao.deleteEmail(email);}

    //存储的迁移
    @Override
    public boolean updateStudent(StudentCustom studentCustom){
        return studentDao.updateStudent(studentCustom);
    }
}


package com.service.impl;

import com.Dao.StudentDao;
import com.Xmemcached.Cached;
import com.Xmemcached.MemcacheUtils;
import com.model.Login;
import com.model.Student;
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
    public List<Student> findAll() {
        Object object = MemcacheUtils.get("All");
        //对象转 Json数组
        JSONArray array = JSONArray.fromObject(object);
        //数组转为List
        List<Student> list = (List<Student>) JSONArray.toList(JSONArray.fromObject(array), Student.class);
        if(object != null){
            log.info("加载的缓存里的数据  " + list);
            return list;
        }
       List<Student> students =  studentDao.findAll();
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
    public Login login() {
        return studentDao.login();
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





}

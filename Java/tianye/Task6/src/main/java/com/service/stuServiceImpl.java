package com.service;

import com.Memcached.MemcachedUtil;
import com.Redis.RedisCacheUtil;
import com.Redis.redisTool;
import com.dao.UserDao;
import com.pojo.UserList;
import com.dao.StuInformation;
import com.dao.Student;
import com.dao.StudentPro;
import com.pojo.t_information;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.taglibs.standard.lang.jstl.NullLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.stereotype.Service;
import com.pojo.t_student;
import com.pojo.t_studentPro;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("ALL")
@Service
public class stuServiceImpl implements stuService {
    @Autowired
    private Student student;
    private redisTool redis;
    @Autowired
    private RedisCacheUtil redisCacheUtil;
    @Override
    public List<t_student> selectAll() {
        return this.student.findAll();
    }

    @Autowired
    private StudentPro studentPro;

    @Override
    public List<t_studentPro> selectAlls() {
        return this.studentPro.findAlls();
    }

    @Autowired
    private StuInformation stuInformation;

    @Override
    public t_information select(String userId) {
        return stuInformation.findById(userId);
    }

    @Override
    public void insert(t_information t_information) {
        this.stuInformation.doInsert(t_information);
    }



    @Override
    public void update(t_information t_information) {
        this.stuInformation.doUpdate(t_information);
    }

    @Autowired
    private UserDao userDao;
    private static Logger logger = Logger.getLogger(stuServiceImpl.class);

    @Override
    public  List<t_studentPro> listUser() {
//        UserList userClass = (UserList) MemcachedUtil.get("userList");
//        logger.info("这是" + userClass);
//        if (userClass != null) {
//            logger.info("缓存有数据");
//            return userClass.getUserList();
//        } else {
//            logger.info("缓存没有数据");
//            List<t_studentPro> userList = userDao.findAlls();
//            UserList userList1 = new UserList();
//            userList1.setUserList(userList);
//            logger.info(userList1 + "列表里的内容");
//            logger.info(MemcachedUtil.add("userList", userList1));
//            return userList;
//        }
//    }



        String data=null;
        List<t_studentPro> studentList=new ArrayList<>();
        try {
            data= (String) redisCacheUtil.get("studentList");
            studentList = (List<t_studentPro>) JSONArray.toCollection(JSONArray.fromObject(data),t_studentPro.class);
        }catch (Exception e){
            logger.error("没有数据");
            e.printStackTrace();
        }

//       if (studentList.isEmpty()) {
//
//           logger.info("缓存没有数据");
//           List<t_studentPro> userList = userDao.findAlls();
//           System.out.println(userList+"edadffq");
//           JSONArray listJson=JSONArray.fromObject(userList);
//           String strListJson=listJson.toString();
//           System.out.println(strListJson+"daadafaawf");
//           try{
//               redisCacheUtil.set("studentList",listJson.toString());
//           }catch (Exception e){
//               logger.info("错误");
//           }
//           return userList;
//        } else {
//           logger. info("缓存中有数据"+studentList);
//           return studentList;
//        }
        if (studentList.get(0) != null) {
            logger.info("缓存 中有数据" + studentList);
            return studentList;
        }
        else {
            logger.info("缓存没有数据");
           List<t_studentPro> userList = userDao.findAlls();
           JSONArray listJson=JSONArray.fromObject(userList);
           String strListJson=listJson.toString();
           System.out.println(strListJson+"daadafaawf");
           try{
               redisCacheUtil.set("studentList",listJson.toString());
           }catch (Exception e){
               logger.info("错误");
           }
           return userList;
        }
    }
}



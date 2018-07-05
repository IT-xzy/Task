package com.opt.service.impl;


import com.alibaba.fastjson.JSON;
import com.opt.dao.mapper.StudentMapper;
import com.opt.model.Page;
import com.opt.model.Student;
import com.opt.service.StudentService;
import com.opt.util.MemcacheUtil;
import com.whalin.MemCached.MemCachedClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {


    private static Logger logger = Logger.getLogger(StudentServiceImpl.class);

    @Autowired
    JedisPool jedisPool;

    @Autowired
    MemCachedClient memCachedClient;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int findAllCount(){
        return studentMapper.findAllCount();
    }

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }


    @Override
    public Student findByID(int id) {
        return studentMapper.findByID(id);
    }

    @Override
    public List<Student> findByStudent(Student student) {
        return studentMapper.findByStudent(student);
    }

    @Override
    public int insertOne(Student student){
        return studentMapper.insertOne(student);
    };

    @Override
    public Page<Student> findByPage(int nowpage, int pagesize) {

        HashMap<String,Object> hashMap = new HashMap();
        Page<Student> page = new Page<>();

        /*每页记录数*/
        int pageSize = pagesize;

        /*封装当前页*/
        page.setCurrPage(nowpage);

        /*封装每页记录数*/
        page.setPageSize(pageSize);

        /*获取总记录数封装*/
        int totalC = studentMapper.findAllCount();
        page.setTotalConut(totalC);

        /*向上取整 获取总页数*/
        double totalP = totalC;
        Double dbc = Math.ceil(totalP/pageSize);
        page.setTotalPage(dbc.intValue());

        /*设置页面limit start size*/
        logger.info(hashMap.put("start",(nowpage-1)*pageSize));

        logger.info(hashMap.put("size",page.getPageSize()));

        logger.info(hashMap.toString());
        page.setPages( studentMapper.findByPage(hashMap));
        logger.info("\n page setPages:" + page.getPages().size());
        return page;
    }




//    redis

//    @Override
//    public Page<Student> findByPage(int nowpage, int pagesize) {
//
//        logger.info("\nimpl + ----------function-------\n");
//
//        //不使用配置 直接设置
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxIdle(20);
//        config.setMaxTotal(500);
//        config.setMinIdle(10);
//
//
//        jedisPool = new JedisPool(config, "127.0.0.1", 6379, 1000,"foobared");
//        logger.info(jedisPool);
////        使用池
//        Jedis jedis = jedisPool.getResource();
//
////        不使用池
////        Jedis jedis = new Jedis("127.0.0.1",6379,1000);
////        jedis.auth("foobared");
//
//        String key = "jsonPage" + nowpage+"pagesize" + pagesize;
//        String JsonPageInfo = jedis.get(key);
//        logger.info("\n获取到的key："+key+":"+JsonPageInfo);
//        Page<Student> pageInfo = JSON.parseObject(JsonPageInfo,Page.class);
////
////        if (JsonPageInfo.equals("") && JsonPageInfo==null){
////            jedis.setnx(key,1, 3 * 60);
////        }else {
////            pageInfo = JSON.parseObject(JsonPageInfo,Page.class);
////        }
//        logger.info("\n"+ key +":"+pageInfo);
//
//        Page<Student> page;
//
////        如果有缓存读取缓存，如果没有就查询数据库，在用户修改之后在更新操作里同步更新/删除cache
//        if (pageInfo!=null && pageInfo.getCurrPage() == nowpage && pageInfo.getPageSize() == pagesize){
//            logger.info("\n查询到有缓存，使用缓存\n");
//            page = pageInfo;
//
//        }else {
//
//            logger.info("\n未查询到缓存内容，查询数据库内容\n");
//
//
////            设置成功，返回 1 。 设置失败，返回 0 。
//
//
//            HashMap<String,Object> hashMap = new HashMap();
//            page = new Page<>();
//
//        /*每页记录数*/
//            int pageSize = pagesize;
//
//        /*封装当前页*/
//            page.setCurrPage(nowpage);
//
//        /*封装每页记录数*/
//            page.setPageSize(pageSize);
//
//        /*获取总记录数封装*/
//            int totalC = studentMapper.findAllCount();
//            page.setTotalConut(totalC);
//
//        /*向上取整 获取总页数*/
//            double totalP = totalC;
//            Double dbc = Math.ceil(totalP/pageSize);
//            page.setTotalPage(dbc.intValue());
//
//        /*设置页面limit start size*/
//            logger.info(hashMap.put("start",(nowpage-1)*pageSize));
//            logger.info(hashMap.put("size",page.getPageSize()));
//            page.setPages( studentMapper.findByPage(hashMap));
//
//            String jsonPage = JSON.toJSONString(page);
//
//            jedis.set("jsonPage"+nowpage+"pagesize"+pagesize,jsonPage);
//
//
//        }
//
//
//        return page;
//    }



//    memcache
//    @Override
//    public Page<Student> findByPage(int nowpage, int pagesize) {
//
//        logger.info("\nimpl + ----------function-------\n");
//
//        String key = "jsonPage"+nowpage+"pagesize"+pagesize;
//
//        String JsonPageInfo = (String) memCachedClient.get(key);
//
//        logger.info("\n获取到的key："+key+":"+JsonPageInfo);
//        Page<Student> pageInfo = JSON.parseObject(JsonPageInfo,Page.class);
//
//        logger.info("\n"+ key +":"+pageInfo);
//
//        Page<Student> page;
//
////        如果有缓存读取缓存，如果没有就查询数据库，在用户修改之后在更新操作里同步更新/删除cache
//        if (pageInfo!=null && pageInfo.getCurrPage() == nowpage && pageInfo.getPageSize() == pagesize){
//            logger.info("\n查询到有缓存，使用缓存\n");
//            page = pageInfo;
//
//        }else {
//
//            logger.info("\n未查询到缓存内容，查询数据库内容\n");
//
//
////            设置成功，返回 1 。 设置失败，返回 0 。
//
//
//            HashMap<String,Object> hashMap = new HashMap();
//            page = new Page<>();
//
//        /*每页记录数*/
//            int pageSize = pagesize;
//
//        /*封装当前页*/
//            page.setCurrPage(nowpage);
//
//        /*封装每页记录数*/
//            page.setPageSize(pageSize);
//
//        /*获取总记录数封装*/
//            int totalC = studentMapper.findAllCount();
//            page.setTotalConut(totalC);
//
//        /*向上取整 获取总页数*/
//            double totalP = totalC;
//            Double dbc = Math.ceil(totalP/pageSize);
//            page.setTotalPage(dbc.intValue());
//
//        /*设置页面limit start size*/
//            logger.info(hashMap.put("start",(nowpage-1)*pageSize));
//            logger.info(hashMap.put("size",page.getPageSize()));
//            page.setPages( studentMapper.findByPage(hashMap));
//
//            String jsonPage = JSON.toJSONString(page);
//
//            memCachedClient.set("jsonPage"+nowpage+"pagesize"+pagesize,jsonPage);
//
//        }
//
//
//        return page;
//    }

    @Override
    public int updateOne(Student student) {
        return studentMapper.updateOne(student);
    }


    @Override
    public int updateHeadIcoById(Map<String, Object> map){
        return studentMapper.updateHeadIcoById(map);
    };

}

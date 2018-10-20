package com.lihoo.ssm.service.impl;

import com.danga.MemCached.MemCachedClient;
import com.lihoo.ssm.dao.StudentListMapper;
import com.lihoo.ssm.model.StudentList;
import com.lihoo.ssm.service.StudentListService;
import com.lihoo.ssm.util.cache.RedisUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * #Title: StudentListServiceImpl
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/10-18:27
 * @author lihoo
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class StudentListServiceImpl implements StudentListService {
//    @Cacheable(key = "getJavaList", value = javaList)

    public static Logger logger = LogManager.getLogger(StudentListServiceImpl.class);

    @Autowired
    StudentListMapper studentListMapper;

//    @Autowired
//    private MemCachedClient memCachedClient;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentListMapper.deleteByPrimaryKey(id);
    }

    @Override
    public StudentList selectByPrimaryKey(Long id) {
        return studentListMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<StudentList> selectAll() {
        List<StudentList> allStudents;
        if (redisUtil.get("allStudents") != null) {
            logger.info("从缓存中取出学员List");
            allStudents = (List<StudentList>) redisUtil.get("allStudents");
            logger.info(allStudents);
        } else {
            allStudents = studentListMapper.selectAll();
            redisUtil.set("allStudents", allStudents, 3600L);
        }
        return allStudents;
    }

    @Override
    public int updateByPrimaryKey(StudentList record) {
        return studentListMapper.updateByPrimaryKey(record);
    }


//    redis
    @Override
    public List<StudentList> getJavaList() {
        List<StudentList> javaList;
        if (redisUtil.get("javaList") != null) {
            logger.info("从缓存中取出java学员List");
            javaList = (List<StudentList>) redisUtil.get("javaList");
            logger.info(javaList);
        } else {
            javaList = studentListMapper.getJavaList();
            redisUtil.set("javaList", javaList, 3600L);
        }
        return javaList;
    }

    @Override
    public List<StudentList> getWebList() {
        List<StudentList> webList;
        if (redisUtil.get("webList") != null) {
            logger.info("从缓存中取出web学员List");
            webList = (List<StudentList>) redisUtil.get("webList");
            logger.info(webList);
        } else {
            webList = studentListMapper.getWebList();
            redisUtil.set("webList", webList, 3600L);
        }
        return webList;
    }


    @Override
    public int insert(StudentList record) {
        int oneStu = studentListMapper.insert(record);
        if (oneStu > 0) {
            logger.info("成功插入一条缓存数据");
            if ("java".equals(record.getStudyType())) {
                List<StudentList> javaLists = studentListMapper.getJavaList();
                logger.info("取出Java学员List：" + javaLists);
                redisUtil.set("javaList", javaLists, 3600L);
                logger.info("缓存中的Java学员List：" + redisUtil.get("javaList"));
            }
            if ("web".equals(record.getStudyType())) {
                List<StudentList> webLists = studentListMapper.getWebList();
                logger.info("取出Web学员List：" + webLists);
                redisUtil.set("webList", webLists, 3600L);
                logger.info("缓存中的Web学员List：" + redisUtil.get("webList"));
            }
        } else {
            logger.info("插入缓存失败");
        }
        return oneStu;
    }

}

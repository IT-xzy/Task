package jnshu.tasksix.service;

import com.alibaba.fastjson.JSON;
import jnshu.tasksix.dao.StudentMapper;
import jnshu.tasksix.model.Profession;
import jnshu.tasksix.model.Student;
import jnshu.tasksix.util.MemcachedUtil;
import jnshu.tasksix.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-10-20
 * @Time: 下午 6:51
 * Description:
 **/

@Service("countNumberService")
public class CountNumberServiceImpl implements CountNumberService {

    @Autowired
    Student student;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private StudentMapper studentMapper;

    private static Logger logCouNumSerImpl = LoggerFactory.getLogger(CountNumberServiceImpl.class);


    public Integer[] countProfessionStudy(List<Profession> professions) {
        Integer[] professionStudyNumber = new Integer[professions.size()];

        String deserialization = redisUtil.getValue("countProfessionStudy");
        if(deserialization != null){
            professionStudyNumber =  JSON.parseObject(deserialization,Integer[].class);
            logCouNumSerImpl.info("从缓存获取 professionStudyNumber");
            return professionStudyNumber;
        }
        else {

            //根据职业表从学生表查询职业的学习人数
            for (int i = 0; i < professions.size(); i++) {
                String profession = professions.get(i).getProfession();
//                logCouNumSerImpl.info("this profession : " + profession);
                student.setProfession(profession);
                try {
                    professionStudyNumber[i] = studentMapper.countStudentUser(student);
//                    logCouNumSerImpl.info("study " + profession + " number: " + professionStudyNumber[i]);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    logCouNumSerImpl.error(e.getMessage());
                }
            }
        }


        String serialization = JSON.toJSONString(professionStudyNumber);
        boolean success = redisUtil.setCacheValue("professionStudyNumber",serialization,1000*60*5);
        logCouNumSerImpl.info("是否成功存入缓存： "+ success);
        return professionStudyNumber;
    }

}
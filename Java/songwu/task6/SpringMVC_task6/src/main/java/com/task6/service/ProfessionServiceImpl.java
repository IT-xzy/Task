package com.task6.service;

import com.task6.mapper.ProfessionMapper;
import com.task6.pojo.Profession;
import com.task6.util.RedisUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfessionServiceImpl implements ProfessionService {

    Logger logger = Logger.getLogger(ProfessionServiceImpl.class);

    @Autowired
    ProfessionMapper professionMapper;
@Autowired
private RedisUtil redisUtil;
    public ProfessionServiceImpl() {
        super();
    }




    @Override
//    查询职业页面所有数据
    public List<Profession> selectProfession() {

        if (redisUtil.get("ProfessionList") == null) {

            List<Profession> list = professionMapper.selectProfession();
           redisUtil.set("ProfessionList", list,60*1000L );
            logger.info("数据库");
            return list;
        } else {
            List<Profession>  professionList=  (List<Profession>) redisUtil.get("ProfessionList");
            logger.info("缓存");
            return professionList;
        }

    }

    @Override
//    根据职业方向删除
    public boolean deleteByDirection(String direction) {
        if (redisUtil.get("profession") != null) {
            redisUtil.remove("profession");
        }
        return professionMapper.deleteByDirection(direction);
    }
}

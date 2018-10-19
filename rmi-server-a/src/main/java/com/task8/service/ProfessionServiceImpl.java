package com.task8.service;

import com.task8.mapper.ProfessionMapper;
import com.task8.pojo.Profession;
import com.task8.util.MemcacheUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfessionServiceImpl implements ProfessionService {

    Logger logger = Logger.getLogger(ProfessionServiceImpl.class);

    @Autowired
    ProfessionMapper professionMapper;
@Autowired
private MemcacheUtil memcacheUtil;
    public ProfessionServiceImpl() {
        super();
    }




    @Override
    public List<Profession> selectProfession() {

        if (memcacheUtil.getCache("ProfessionList") == null) {

            List<Profession> list = professionMapper.selectProfession();
            memcacheUtil.setCache("ProfessionList", 60 * 1000, list);
            logger.info("数据库");
            return list;
        } else {
            List<Profession>  professionList=  (List<Profession>) memcacheUtil.getCache("ProfessionList");
            logger.info("缓存");
            return professionList;
        }

    }


}

package com.suger.service.impl;

import com.suger.dao.ProfessionDao;
import com.suger.pojo.Profession;
import com.suger.util.MemcacheUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suger.service.ProfessionService;

import java.util.List;

/**
 * @author suger
 * @date 2018/11/16 23:32
 * 职业service 的实现
 */
@Service(value = "MemcacheService")
public class ProfessionServiceImpl implements ProfessionService {

    @Autowired
    ProfessionDao professionDao;

    private static Logger logger = Logger.getLogger(ProfessionServiceImpl.class);

    /**
     * 查询各个职业
     * @return
     */
    @Override
    public List<Profession> listProfession() {

        List<Profession> professionList;
        logger.info("查询各个职业");


        if(MemcacheUtils.get("listProfession")==null){
            logger.info("缓存不存在数据，准备设置缓存");
            professionList = professionDao.listProfession();
            MemcacheUtils.set("listProfession",professionList);
        }else {
            logger.info("缓存已经存在,准备读取缓存数据");
            professionList = (List<Profession>) MemcacheUtils.get("listProfession");
        }
        return professionList;
    }

    /**
     * 各个职业在学弟子人数
     *
     * @return
     */
    @Override
    public int getOnlineCount() {

        logger.info("查询各个职业在学人数");
        int count;
        if(MemcacheUtils.get("professionCount")==null){
            logger.info("缓存不存在数据，准备设置缓存");
            count = professionDao.getCount();
            MemcacheUtils.set("professionCount",count);
        }else {
            logger.info("缓存已经存在,准备读取缓存数据");
            count = (int) MemcacheUtils.get("professionCount");
        }
        return count;
    }

}

package com.artist.service;

import com.artist.dao.TouristDao;
import com.artist.pojo.Tourist;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TouristServiceImpl implements TouristService {
    private Logger logger=Logger.getLogger(TouristServiceImpl.class);
    @Resource(name="touristDao")
    private TouristDao touristDao;
    @Override
    public String saveTourist(Tourist tourist) {
        logger.info("saveTourist()");
        logger.info(tourist);
        String str =null;
        Integer number =touristDao.saveTourist(tourist);
        if (number<=0){
            str="保存失败！";
        }else {
            str="保存成功！";
        }
        logger.info(str);
        return str;
    }
}

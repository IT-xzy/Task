package com.artist.service;

import com.artist.dao.ProductionDao;
import com.artist.pojo.Production;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductionServiceImpl implements ProductionService {
    private Logger logger=Logger.getLogger(ProductionServiceImpl.class);
    @Resource(name = "productionDao")
    private ProductionDao productionDao;
    @Override
    public Production idparticulars(Integer productionId) {
        logger.info("idparticulars()");
        logger.info(productionId);
        Production production=null;
        production=productionDao.queryProduction(productionId );
        if(production==null){
            throw new ApplicationException("该作品以下架");
        }
        logger.info(production);
        return production;
    }
}

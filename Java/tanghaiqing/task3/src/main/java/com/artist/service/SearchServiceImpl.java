package com.artist.service;

import com.artist.dao.ProductionDao;
import com.artist.pojo.Production;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    private Logger logger =Logger.getLogger(SearchServiceImpl.class);
    @Resource(name = "productionDao")
    private ProductionDao productionDao;
    @Override
    public List<Production> keywordSearch(String word) {
        logger.info("keywordSearch()");
        logger.info(word);
        List<Production> productions=null;
        productions=productionDao.queryProductions(word);
        if(productions.size()==0){
            throw new ApplicationException("没有搜索到关键字所包含的内容");
        }
        logger.info(productions);
        return productions;
    }
    @Override
    public List<Production> categorySearch(String category) {
        logger.info("categorySearch()");
        logger.info(category);
        List<Production> productions=null;
        productions=productionDao.queryProductions1(category);
        if (productions.size()==0){
            throw new ApplicationException("该类别或者主题没有作品，请换别的类别查看");
        }
        logger.info(productions);
        return productions;
    }
}

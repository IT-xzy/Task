package com.artist.controller;

import com.artist.pojo.Production;
import com.artist.pojo.StatusCode;
import com.artist.service.ProductionService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ProductionController {
    private Logger logger=Logger.getLogger(ProductionController.class);
    @Resource(name = "productionServiceImpl")
    private ProductionService productionService;
    @RequestMapping(value = "/production/{productionId}",method = RequestMethod.GET)
    @ResponseBody
    public StatusCode searchProduction(@PathVariable("productionId") Integer productionId){
        logger.info("searchProduction()");
        logger.info(productionId);
        Production production =productionService.idparticulars(productionId);
        logger.info(production);
        return new StatusCode(200, "搜索作品详情成功！", production);
    }
}

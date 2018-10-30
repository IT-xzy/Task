package com.artist.controller;
import com.artist.pojo.StatusCode;import com.artist.pojo.Tourist;
import com.artist.service.TouristService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;


@Controller
public class TouristController {
    private Logger logger =Logger.getLogger(TouristController.class);
    @Resource(name = "touristServiceImpl")
    private TouristService touristService;
    @RequestMapping(value = "/tourist",method = RequestMethod.POST)
    @ResponseBody
    public StatusCode saveTourist(@RequestBody Tourist tourist){
        logger.info("saveTourist()");
        logger.info(tourist);
        String str =touristService.saveTourist(tourist);
        logger.info(str);
        StatusCode statusCode = new StatusCode();
        statusCode.setCode(200);
        statusCode.setMessage(str);
        return statusCode;
    }
}

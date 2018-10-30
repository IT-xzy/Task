package com.artist.controller;

import com.artist.pojo.Production;
import com.artist.pojo.StatusCode;
import com.artist.service.SearchService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SearchController {
    private Logger logger = Logger.getLogger(SearchController.class);
    @Resource(name = "searchServiceImpl")
    private SearchService searchService;
    private StatusCode statusCode = null;

    @RequestMapping(value = "/productions/{word}", method = RequestMethod.GET)
    @ResponseBody
    public StatusCode wordSearch(@PathVariable("word") String word){
        logger.info("wordSearch()");
        logger.info(word);
        List<Production> productions;
        productions = searchService.keywordSearch(word);
        logger.info(productions);
        statusCode = new StatusCode(200, "搜索成功！", productions);
        return statusCode;
    }

    @RequestMapping(value = "/category/productions/{category}", method = RequestMethod.GET)
    @ResponseBody
    public StatusCode categorySearch(@PathVariable("category") String category) {
        logger.info("categorySearch()");
        logger.info(category);
        List<Production> productions = searchService.categorySearch(category);
        logger.info(productions);
        statusCode = new StatusCode(200, "搜索成功！", productions);
        return statusCode;
    }

}

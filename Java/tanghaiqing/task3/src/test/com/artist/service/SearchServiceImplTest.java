package com.artist.service;

import com.artist.pojo.Production;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchServiceImplTest {
    @Resource(name = "searchServiceImpl")
    private SearchService searchService;

    @Test
    public void keywordSearch() {
       List<Production> productions= searchService.keywordSearch(".");
        System.out.println(productions);
    }
    @Test
    public void categorySearch() {
        List<Production> productions=searchService.categorySearch("");
        System.out.println(productions);
    }
}
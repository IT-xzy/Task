package com.client;

import dao.PaperDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Paper;
import service.PaperService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/rmi-server.xml")
public class PaperDaoTest {
    @Autowired
    private PaperService paperService;
    @Test
    public void getAllPaper(){
        System.out.println(paperService);
        System.out.println(paperService.queryAllPaper().toString());

    }

}

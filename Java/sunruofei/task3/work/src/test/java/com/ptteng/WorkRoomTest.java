package com.ptteng;


import com.ptteng.model.WorkRoom;
import com.ptteng.service.WorkRoomService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkRoomTest {
    @Autowired
    WorkRoomService workRoomService;
    WorkRoom workRoom =new WorkRoom();
    Logger logger =Logger.getLogger(WorkRoomTest.class);
    @Test
    public void insert(){
        workRoom.setCreateAt(2121L);
        workRoom.setCreateBy(2L);
        workRoom.setName("乌拉乌拉");
        workRoom.setPicture("/asd/asd");
        workRoom.setState((byte)2);
        workRoom.setUpdateAt(1233L);
        workRoom.setWord("sadasd");
        workRoom.setUpdateBy(2L);
        logger.info(workRoomService.insert(workRoom));
    }
    @Test
    public void deleteByPrimaryKey(){
        logger.info(workRoomService.deleteByPrimaryKey(3L));
    }
    @Test
    public void updateByPrimaryKey(){
        workRoom.setCreateAt(2121L);
        workRoom.setCreateBy(2L);
        workRoom.setName("乌拉乌拉");
        workRoom.setPicture("/asd/asd");
        workRoom.setState((byte)2);
        workRoom.setUpdateAt(1233L);
        workRoom.setWord("dsasadadsasdsadasd");
        workRoom.setUpdateBy(2L);
        workRoom.setId(4L);
        logger.info(workRoomService.updateByPrimaryKey(workRoom));
    }
    @Test
    public void selectByPrimaryKey(){
        logger.info(workRoomService.selectByPrimaryKey(1L));
    }
    @Test
    public void selectAll(){
        logger.info(workRoomService.selectAll());
    }
    @Test
    public void selectByDynamicCondition(){
        logger.info(workRoomService.selectByDynamicCondition("工作室简介",2L));
    }

}

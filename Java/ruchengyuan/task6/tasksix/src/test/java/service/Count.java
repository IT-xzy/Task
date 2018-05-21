package service;

import jnshu.tasksix.model.Profession;
import jnshu.tasksix.service.CountNumberService;
import jnshu.tasksix.service.ProfessionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-10-20
 * @Time: 下午 7:08
 * Description:
 **/


@RunWith(SpringJUnit4ClassRunner.class)

//value = true 则测试完毕自动回滚，无法看到数据库是否插入数据，测试环境应该设置为false
// 否则无法确定是否成功提交事务
//value = false
@Rollback(value = true)
//标记，使事务管理器来管理识别
@Transactional(transactionManager = "transactionManager")


@ContextConfiguration(locations = {"classpath:conf/spring-mybatis.xml"})
public class Count {

    @Autowired
    ProfessionService professionService;

    @Autowired
    CountNumberService countNumberService;
    private static Logger logCount= LoggerFactory.getLogger(Count.class);


    @Test
    public void CountProfession(){

        List<Profession> professions = professionService.listProfession();
        logCount.info("list professions number: "+ professions.size());
        Integer[] professionStudyNumber = countNumberService.countProfessionStudy(professions);
        logCount.info(" professionStudyNumber number: "+ professionStudyNumber.length);
    }


}

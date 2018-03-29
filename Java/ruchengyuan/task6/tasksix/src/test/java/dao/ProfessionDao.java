package dao;

import jnshu.tasksix.dao.ProfessionMapper;
import jnshu.tasksix.model.Profession;
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
 * @author: cehngyaun·ru
 * @date: 2017-10-17
 * @Time: 下午 3:23
 * Description: test Profession mapper
 **/


//value = true 则测试完毕自动回滚，无法看到数据库是否插入数据，测试环境应该设置为false
// 否则无法确定是否成功提交事务
//value = false
@Rollback(value = true)
//标记，使事务管理器来管理识别
@Transactional(transactionManager = "transactionManager")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring-mybatis.xml"})
public class ProfessionDao {

    private static final Logger logProDAO = LoggerFactory.getLogger(ProfessionDao.class);

    @Autowired
    private ProfessionMapper ProfessionMapper;

    @Test
    public void testListProfession(){
        List<Profession> professions = ProfessionMapper.listProfession();
        logProDAO.info("list profession information: "+ professions);
    }
}
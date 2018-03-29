package dao;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task.jnshu.dao.ProfessionMapper;
import task.jnshu.model.Profession;

import java.util.List;

/**
 * Created by Administrator on 11/8/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class ProfessionDao {

    private static Logger loggerProTest = Logger.getLogger(ProfessionDao.class);

    @Autowired
    ProfessionMapper professionMapper;

    @BeforeClass
    public static void begin(){
        loggerProTest.info("测试开始");
    }

    @AfterClass
    public static void end(){
        loggerProTest.info("测试结束");
    }

    @Test
    public void selectProfessionAll(){
        try{
            loggerProTest.info("profession全体查询开始");
            List<Profession> professions = professionMapper.selectProfessionAll();
            loggerProTest.info("返回全体profession信息： "+professions);
        }catch (Exception e){
            e.printStackTrace();
            loggerProTest.error(e.getMessage());
        }

    }

    @Test
    public void selectProfession(){
        try{
            loggerProTest.info("查询职业");
            Profession profession = professionMapper.selectByPrimaryKey("JAVA");
            loggerProTest.info("profession: "+profession);
        }catch (Exception e){
            e.printStackTrace();
            loggerProTest.error(e.getMessage());
        }

    }

}

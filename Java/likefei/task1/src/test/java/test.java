import java.util.List;

import mapper.StudentMapper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration ("classpath:applicationContext.xml")

public  class  test{
   private Logger logger  =  Logger.getLogger(test. class );
    @Before
            public  void addlog4j(){
        PropertyConfigurator.configure("E:/java/task1/src/main/resources/log4j.properties");
    }
@Autowired
private  StudentMapper studentMapper;
    Student student = new Student();
@Test
    public  void testad()throws  Exception{
    student.setName("1");
    logger.debug("插入测试开始");
    try {
        studentMapper.add(student);
        logger.debug("插入成功");
    }
    catch (Exception e)
    {
        logger.debug("插入失败");
    }
logger.debug("插入测试结束");
}
    @Test
    public  void testget()throws  Exception{
        logger.debug(" 查询测试开始");
        try {
            studentMapper.get(1);
            logger.debug("查询成功");
        }
        catch (Exception e)
        {
            logger.debug("查询失败");
        }
        logger.debug("查询结束");
    }
    @Test
    public  void testdelete()throws  Exception{
        logger.debug(" 删除测试开始");
        try {
            studentMapper.get(1);
            logger.debug("删除成功");
        }
        catch (Exception e)
        {
            logger.debug("删除失败");
        }
        logger.debug("删除结束");
    }
}
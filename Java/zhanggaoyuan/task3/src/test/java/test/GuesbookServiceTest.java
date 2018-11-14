package test;


import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import jnshu.model.Author;
import jnshu.model.Visitor;
import jnshu.service.GuestbookService;

//@RunWith就是一个运行器，@RunWith(JUnit4.class)就是指用JUnit4来运行
//@RunWith(SpringJUnit4ClassRunner.class)是指让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//Spring整合JUnit4测试时，使用注解@ContextConfiguration引入一个或多个配置文件
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class GuesbookServiceTest {

    private static Logger logger = Logger.getLogger(GuesbookServiceTest.class);
    @Autowired
    GuestbookService guestbookService;
    Author author=new Author ();
    Visitor visitor=new Visitor ();

    long timeStamp = System.currentTimeMillis();  //获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)

//    新增数据
    @Test
    public void testInsertAuthor(){
        author.setAuthorCreatTime (timeStamp);
        author.setUpdateTime (timeStamp);
        author.setAuthorName ("张三");
        author.setAuthorComment ("谢谢您的好评。");
        author.setVisitorId (1);
        author.setProductionId (1);
       int rs= guestbookService.insertAuthor (author);
       logger.info (rs);
    }
    @Test
    public void testInsertVisitor(){
        visitor.setVisitorCreatTime (timeStamp);
        visitor.setUpdateTime (timeStamp);
        visitor.setVisitorName ("哪吒7");
        visitor.setVisitorComment ("77这幅画很好看，不错。");
        visitor.setVisitorChoiceness (true);
        visitor.setProductionId (2);
        int rs=guestbookService.insertVisitor (visitor);
        logger.info (rs);
    }
//    删除数据
    @Test
    public void testDeleteAuthor(){
       int rs= guestbookService.deleteAuthorByPrimaryKey (1);
        logger.info (rs);
    }
    @Test
    public void testDeleteVisitor(){
        int rs= guestbookService.deleteVisitorByPrimaryKey (1);
        logger.info (rs);
    }
//    更新数据
    @Test
    public void testUpdateAuthor(){
        author.setAuthorId (2);
        author.setUpdateTime (timeStamp);
        author.setAuthorComment ("谢谢您的建议，我们会更努力的。");
       int rs= guestbookService.updateAuthorByPrimaryKey (author);
       logger.info (rs);
    }
    @Test
    public void testUpdateVisitor(){
        visitor.setVisitorId (2);
        visitor.setVisitorComment ("好喜欢这幅画哦");
        int rs= guestbookService.updateVisitorByPrimaryKey (visitor);
        logger.info (rs);
    }

    //    查询数据
    @Test
    public void testSelectAuthor() {
       author= guestbookService.selectAuthorByPrimaryKey (2);
       logger.info (JSON.toJSONString (author));
    }
    @Test
    public void testSelectVisitor() {
        visitor= guestbookService.selectVisitorByPrimaryKey (2);
        logger.info (JSON.toJSONString (visitor));
    }
}

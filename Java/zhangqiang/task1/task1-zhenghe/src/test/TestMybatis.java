import mybatis.mapper.PersonMapper;
import mybatis.model.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/*
 *  测试类，mybatis'spring简单测试
 *  其它测试在 java / action / mybatisAction
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mybatis/springmybatis.xml"})
public class TestMybatis {

    static Logger logger;

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void test(){

        logger = Logger.getLogger(TestMybatis.class);
//
//            Reader reader = null;


//            reader = Resources.getResourceAsReader("mybatis/springmybatis.xml");
////          InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream("jdbctemplate/applicationcontext.xml");

//            logger.debug(new SqlSessionFactoryBuilder().build(reader));
//
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

//            SqlSession sqlSession = sqlSessionFactory.openSession();
//
//            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);


//            logger.info("\n" + personMapper.selectById(1).toString() + "\n");

//            logger.info("\n" + personMapper.findAll().toString() + "\n");

              Person person = new Person();
              person.setName("大师兄");

//              根据对象传参数查找
              logger.info("\n 123 === " + personMapper.selectByPerson(person).toString() + "\n" );

//              根据参数直接查找
              logger.info("\n" + personMapper.selectByColumn("三师兄",2456).toString() + "\n" );


    }




}

package com.artist.dao;

import com.artist.pojo.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:spring-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthorDaoTest {
    @Autowired
    private AuthorDao authorDao;

    @Test
    public void queryAuthors() {
       List<Author> list= authorDao.queryAuthors();
        System.out.println(list);
    }

    @Test
    public void queryAuthor() {
        Author author =authorDao.queryAuthor("魏天");
        System.out.println(author);
    }

    @Test
    public void saveAuthor() {
        Author a =new Author();
        a.setAuthorName("像海一样清澈");
        a.setTelephone("17688432366");
        a.setIntro("作者来自湖南，发动机盖拉萨大家光临DKADGL大莱卡布鲁克的感觉啊了解阿娇DLJG，啊的发送斯蒂芬多放点");
        a.setCreateTime(System.currentTimeMillis());
        a.setUpdateTime(System.currentTimeMillis());
        authorDao.saveAuthor(a);
    }

    @Test
    public void delAuthor() {
        authorDao.delAuthor(1);
    }

    @Test
    public void updateAuthor() {
        Author a =new Author();
        a.setAuthorId(2);
        a.setAuthorName("清澈");
        a.setTelephone("17688432366");
        a.setIntro("作者来自湖南，发动机盖拉萨大家光临DKADGL大莱卡布鲁克的感觉啊了解阿娇DLJG，啊的发送斯蒂芬多放点,adfadfdafe阿凡达add别人");
        a.setCreateTime(System.currentTimeMillis());
        a.setUpdateTime(System.currentTimeMillis());
        authorDao.updateAuthor(a);
    }
}
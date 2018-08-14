package org.alien.mybatis.samples.service.impl;

import org.alien.mybatis.samples.model.Author;
import org.alien.mybatis.samples.service.AuthorService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lihoo
 * @Title: AuthorServiceImplTest
 * @ProjectName myBatisDemo_4
 * @Description: TODO
 * @date 2018/7/1112:44
 */


public class AuthorServiceImplTest {
    private AuthorService authorService;

    private static Logger logger = Logger.getLogger(AuthorServiceImplTest.class);

    @Before
    public void addProperties() {
        PropertyConfigurator.configure("C:\\Users\\lihoo\\Documents\\back_item\\myBatisDemo_4\\src\\main\\resources\\log4j.properties");
    }

    @Before
    public void setUp() throws Exception {
        authorService = new AuthorServiceImpl();
    }

    @Test
    public void testGetAllAuthors() throws Exception {
        logger.debug("开始查询作者总人数");
        authorService.getAllAuthors();
//        Assert.assertEquals(true,authorService.getAllAuthors().size() > 0);
//        System.out.println(authorService.getAllAuthors());
        logger.debug("查询作者人数成功");
        logger.debug(authorService.getAllAuthors());
    }

    @Test
    public void getAllAuthorsCount() throws Exception {
        authorService.getAllAuthorsCount();
        logger.debug("作者一共有" + authorService.getAllAuthorsCount() + "人。");
//        System.out.println(authorService.getAllAuthorsCount());
//        Assert.assertEquals(true,authorService.getAllAuthorsCount() > 0);
        System.out.println("查询所有作者成功");
    }

    @Test
    public void testAddAuthor() throws Exception {
        logger.debug("插入测试开始");
        Assert.assertEquals(true,authorService.addAuthor(new Author(10, "死亡之翼")) > 0);
//        logger.debug(authorService.addAuthor(new Author(10,"在线")));
        logger.debug("插入测试结束");
    }

    @Test
    public void testDeleteAuthor() throws Exception {
        Assert.assertEquals(true,authorService.deleteAuthor(103) > 0);
    }

    @Test
    public void testUpdateAuthor() throws Exception {
        Assert.assertEquals(true,authorService.updateAuthor(new Author(77, "沙德沃克")) > 0);
    }

    @Test
    public void testGetAuthorById() throws Exception {
        String adc  = String.valueOf(authorService.getAuthorById(1).getUsername()) ;
        logger.debug(adc);
    }

}

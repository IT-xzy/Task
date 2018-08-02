package org.alien.mybatis.samples.service;

import org.alien.mybatis.samples.model.Author;

import java.util.List;

/**
 * @author lihoo
 * @Title: AuthorService
 * @ProjectName myBatisDemo_4
 * @Description: TODO
 * @date 2018/7/1112:48
 */


public interface AuthorService {

    int addAuthor(Author author);

    int deleteAuthor(int id);

    int updateAuthor(Author author);

    List<Author> getAllAuthors();

    int getAllAuthorsCount();

    Author getAuthorById(int id);
}

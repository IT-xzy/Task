/**
 * @Title: AuthorMapper
 * @ProjectName myBatisDemo_4
 * @Description: TODO
 * @author lihoo
 * @date 2018/7/1110:14
 */

package org.alien.mybatis.samples.mapper;

import org.alien.mybatis.samples.model.Author;

import java.util.List;

public interface AuthorMapper {

    int addAuthor(Author author);

    int deleteAuthor(int id);

    int updateAuthor(Author author);


    List<Author> getAllAuthors();

    int getAllAuthorsCount();

    Author getAuthorById (int id);
}

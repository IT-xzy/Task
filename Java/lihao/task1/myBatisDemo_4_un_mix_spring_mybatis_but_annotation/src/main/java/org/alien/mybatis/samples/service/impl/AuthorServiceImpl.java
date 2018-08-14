package org.alien.mybatis.samples.service.impl;

import org.alien.mybatis.samples.mapper.AuthorMapper;
import org.alien.mybatis.samples.model.Author;
import org.alien.mybatis.samples.service.AuthorService;
import org.alien.mybatis.samples.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author lihoo
 * @Title: AuthorServiceImpl
 * @ProjectName myBatisDemo_4
 * @Description: TODO
 * @date 2018/7/1112:40
 */


public class AuthorServiceImpl implements AuthorService {


    /**
     * Add author info.
     *
     * @param author author instance
     * @return The key of current record in database.
     */
    @Override
    public int addAuthor(Author author) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
            int authorId = authorMapper.addAuthor(author);
            sqlSession.commit();
            return authorId;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    /**
     * Delete author info by author's id.
     *
     * @param authorId author id
     * @return int The number of rows affected by the delete.
     */
    @Override
    public int deleteAuthor(int authorId) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
            int result = authorMapper.deleteAuthor(authorId);
            sqlSession.commit();
            return result;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * update author info
     *
     * @param author Author instance
     * @return int The number of rows affected by the update.
     */
    @Override
    public int updateAuthor(Author author) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
            int result = authorMapper.updateAuthor(author);
            sqlSession.commit();
            return result;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * Query all authors
     *
     * @return all authors
     */
    @Override
    public List<Author> getAllAuthors(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
            return authorMapper.getAllAuthors();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * Query all authors count
     *
     * @return all authors count
     */
    @Override
    public int getAllAuthorsCount() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
            return authorMapper.getAllAuthorsCount();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Override
    public Author getAuthorById(int id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
            return authorMapper.getAuthorById(id);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}





























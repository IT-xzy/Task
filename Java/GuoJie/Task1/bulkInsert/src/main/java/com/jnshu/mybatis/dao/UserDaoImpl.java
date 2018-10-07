package com.jnshu.mybatis.dao;

import com.jnshu.mybatis.user.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao{
    public UserDaoImpl() {
        super();
    }

    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;
    }
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", id);
        //释放资源
        sqlSession.close();
        return user;
    }

    public List<User> findUserByName(String name) throws Exception {
        return null;
    }


}

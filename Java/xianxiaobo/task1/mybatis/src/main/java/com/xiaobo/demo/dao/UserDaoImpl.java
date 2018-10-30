package com.xiaobo.demo.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.xiaobo.demo.dto.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    // 需要向dao实现类中注入SqlSessionFactory
    // 这里通过构造方法注入
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super();
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User selectUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();//获取sqlSession
        User user = sqlSession.selectOne("selectUserById", id);
        sqlSession.close();//关闭资源
        return user;
    }
    @Override
    public List<User> selectUserByName(String name) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();//获取sqlSession
        List<User> userList = sqlSession.selectList("selectUserByName", name);
        sqlSession.close();//关闭资源
        return userList;
    }
    @Override
    public void deleteUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();//获取sqlSession
        sqlSession.delete("deleteUserById", id);
        sqlSession.commit();
        sqlSession.close();//关闭资源
    }
    @Override
    public void insertUser(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();//获取sqlSession
        sqlSession.delete("insertUser", user);
        sqlSession.commit();
        sqlSession.close();//关闭资源
    }
    @Override
    public void updateUserById(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();//获取sqlSession
        sqlSession.update("updateUserById", user);
        sqlSession.commit();
        sqlSession.close();//关闭资源
    }

}

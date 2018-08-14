package com.lihoo.sm.service.Impl;

import com.lihoo.sm.service.UserService;
import com.lihoo.sm.model.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author lihoo
 * @Title: UserServiceImpl
 * @ProjectName spring_mybatis_1
 * @Description: TODO
 * @date 2018/8/2-18:35
 */


public class UserServiceImpl extends SqlSessionDaoSupport implements UserService {

    @Override
    public User findUserByName(String username) {
        SqlSession sqlSession = this.getSqlSession();
        return sqlSession.selectOne("com.lihoo.sm.mapper.findUserByName", username);
    }

    @Override
    public List<User> findUserList() {
        SqlSession sqlSession = this.getSqlSession();
        return sqlSession.selectList("com.lihoo.sm.mapper.findUserList");
    }

    @Override
    public User findUserById(int id) {
        // 继承 SqlSessionDaoSupport 类，通过 this.getSqlSession() 得到 sqlSession
        SqlSession sqlSession = this.getSqlSession();
        return sqlSession.selectOne("com.lihoo.sm.mapper.findUserById", id);
    }

    @Override
    public int addUser(User user) {
        // 继承 SqlSessionDaoSupport 类，通过 this.getSqlSession() 得到 sqlSession
        SqlSession sqlSession = this.getSqlSession();
        return sqlSession.insert("com.lihoo.sm.mapper.addUser", user);
    }

    @Override
    public int deleteUser(int id) {
        SqlSession sqlSession = this.getSqlSession();
        return sqlSession.delete("com.lihoo.sm.mapper.deleteUser", id);
    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = this.getSqlSession();
        sqlSession.update("com.lihoo.sm.mapper.updateUser",user);
    }

}

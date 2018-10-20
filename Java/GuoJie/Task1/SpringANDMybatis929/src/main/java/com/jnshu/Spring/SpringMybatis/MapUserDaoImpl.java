package com.jnshu.Spring.SpringMybatis;

import com.jnshu.Spring.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MapUserDaoImpl extends SqlSessionDaoSupport implements MapUserDao{

    public User findById(int id) {
        SqlSession sqlSession=this.getSqlSession();
        User user=sqlSession.selectOne("test.findById",id);
        return user;
    }
}

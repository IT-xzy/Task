package cn.jnshu.ssm.dao;

import cn.jnshu.ssm.po.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;


public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    @Resource
    private UserDao userDao;

    //查询用户
    @Override
    public User findUserById(int id) throws Exception {
        //继承SqlSessionDaoSupport,通过this.getSqlSession()得到sqlSession
        SqlSession sqlSession = this.getSqlSession();
        User user = sqlSession.selectOne("test.findUserById", id);
       //交给spring去管理了
        // sqlSession.close();
        return user;
    }

    //增加用户
    @Override
    public void insertUser(User user) throws Exception {
        //继承SqlSessionDaoSupport,通过this.getSqlSession()得到sqlSession
        SqlSession sqlSession = this.getSqlSession();
        sqlSession.insert("test.insertUser",user);

    }

    //删除用户
    @Override
    public void deleteUser(int id) throws Exception {
        //继承SqlSessionDaoSupport,通过this.getSqlSession()得到sqlSession
        SqlSession sqlSession = this.getSqlSession();
        sqlSession.delete("test.deleteUser", id);
    }


}

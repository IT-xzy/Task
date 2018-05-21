package Implements;

import Dao.Dao1;
import POJO.User;
import POJO.User3;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class UserDaoImpl implements Dao1 {
    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws IOException {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=sqlSession.selectOne("test.findUserById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUserByname(String name) throws IOException {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<User> list=sqlSession.selectList("test.findUserByname",name);
        return list;
    }

    @Override
    public void insertUser(User3 user) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUser", id);
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public void updateUser(User user) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.update("test.updateUser", user);
        sqlSession.commit();
        sqlSession.close();

    }
}

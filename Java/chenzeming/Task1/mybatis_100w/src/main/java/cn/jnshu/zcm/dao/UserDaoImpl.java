package cn.jnshu.zcm.dao;


import cn.jnshu.zcm.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao {

    //需要向dao实现类注入SqlSessionFactory
    //这里需要构造方法注入
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user= sqlSession.selectOne("test.findUserById",id);
        sqlSession.close();
        return user;

    }
    @Override
    public void insertUser(User user) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();
        sqlSession.close();

    }
    @Override
    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.insert("test.deleteUser",id);
        sqlSession.close();
    }
}
